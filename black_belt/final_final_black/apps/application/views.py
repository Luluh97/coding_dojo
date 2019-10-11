from django.shortcuts import render, redirect,HttpResponse
from .models import *
from django.contrib import messages
import bcrypt
from django.shortcuts import render
import pandas as pd
from django.conf import settings
from django.core.files.storage import FileSystemStorage
# import request
import requests
import json
from twilio.rest import Client
account_sid = 'ACe33ce4555fd5e675d1dd75f7c91d32e3'
auth_token = '063ad718dee15174294a04dd05451e24'
client = Client(account_sid, auth_token)


############## Move to Main Page ##############
def index(request):
    return render(request, 'application/home_page.html')

def logged (request):
    return render(request, 'application/login.html')

def login(request):
    if request.method == "POST":
        #login validator will check if the username and passwords are matching a record in the database 
        errors = user_admin.objects.login_validator(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect('/log_in')
        else:
            #get the user record from the database 
            userName = request.POST['username']
            password = request.POST['password']
            user = user_admin.objects.get(username=userName)
            #check the user_type to redirect to specific page accordingly 
            request.session['id'] = user.id
            if user.user_type == 'admin':
                return redirect('/user_page', id=user.id)
            else:
                realF = files.objects.filter(id=user.submitted_URL).values()
                for data in realF:
                    for key, val in data.items():
                        if key == 'phoneNo':
                            request.session['phone'] = val
                        if key == 'name':
                            request.session['name'] = val
                return redirect(f'{user.id}/edit')

############## Move to Registration Page ##############
def register(request):
    return render(request, 'application/register.html')

############## Move to Upload License Page ##############
def check_license(request):
    return render(request, 'application/upload_file.html')


def add_user(request):
    if request.method == "POST":
        #basic_validator will ensure registeration form is filled as required
        errors = user_admin.objects.basic_validator(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect('/register')
        else:
            username = request.POST["username"]
            email = request.POST["email"]
            password = request.POST["password"]
            userType = request.POST['userType']
            #get the user registration info and add it to the database
        added_user = user_admin.objects.create(username=username, email=email, password=password,
                                               user_type=userType, submitted_URL=request.session['fileID'])


        request.session['id'] = added_user.id
        #send a sms to the lawyer that they have been registered in the website
        message = client.messages \
            .create(
            body="You have been registerd successfuly in MyLawyer.com,if this message comes for no reason please contact us on mylawyercd @ gmail.com",
            from_='+12562697350',
            to='+966505402555' #currently we fixed the recieving phone number to our phone number, however the lawyers number will be set as the reciever for authentication
        )

        #get the file id to show the phone number of the user associated automatically in the user_dashboard
        current_file = user_admin.objects.get(submitted_URL=request.session['fileID'])
        strid = int(request.session['fileID'])
        phone = ''
        realF = files.objects.filter(id=strid).values()
        for data in realF:

            for key, val in data.items():
                if key == 'phoneNo':
                    phone = val
        context = {
            'user_data': user_admin.objects.get(id=request.session['id']),
            'user_phone': phone
        }
        request.session['phone'] = phone
        return render(request, "application/edit_profile.html", context)

def user_page(request):
    #this is the admin dashboard, it will display all the messages and all the files added to the database
    mess_dic= {
           'all_files': files.objects.all(),
            'count': feedback.objects.filter(read=False).count(),
        
    }

    return render(request, 'application/admin_home.html' , mess_dic )

def upload_file(request):
    try:
        if request.method == 'POST' and request.FILES['myfile']:
            #The request.FILES will hold the uploaded file
            myfile = request.FILES['myfile']
            fs = FileSystemStorage() #store uploaded file
            filename = fs.save(myfile.name, myfile) #save the name of uploaded file
            fileURL = fs.url(filename) #conver the name of uploaded file to URL
            test_file = ocr_space_file(filename=filename, language='ara') #call the API function
            file = open('parssing.txt', 'a')
            print(test_file)
            file.write(test_file)
            obj = json.loads(test_file)
            if (obj['IsErroredOnProcessing'] == True):
                #if the image format is not supported
                messages.info(request, 'NOT VALID IMG')
            myres = ''
            for keyF in list(obj.values())[0]:
                for key, result in keyF.items():
                    if key == 'ParsedText': #the key of the object that return the detected info as a text
                        myres = result #hold the result we got from the API, which is the card info as a text 
                        file = pd.ExcelFile('ksa_lawyers.xlsx') #specify the excel sheet to read from, if it's not in the same directory specify the path
                        lawyers_list = file.parse(0)#first page of the excel sheet, return list of all the lawyers  
                        lawyer_names = lawyers_list['Name'] #get the name column in excel sheet
                        a = lawyer_names.values #return an array of all the values of name column in excel sheet, which is all the lawyers names
                        for i in range(len(a)): #iterate through the lawyers names
                            if a[i] in myres: #check if the lawyer name matches the detected text
                                full_name = a[i] #hold the lawyer full name from excel shee
                                lawyer_phone = lawyers_list['PhonneNo'] #get the PhonneNo column in excel sheet
                                phone = lawyer_phone[i] #hold the lawyer phone number from excel sheet
                                #add the uploaded file to the database
                                added_file = files.objects.create( submitted_URL = fileURL , result = myres, phoneNo = phone, name = full_name)
                                request.session['fileID'] = added_file.id #store the id of new added file in session
                                request.session['name'] = full_name
                                messages.info(request, 'Your license has been detected successfully!')
                                return redirect('/register')
                        messages.info(request, " this lawyer doesn't exit try again later with clear image")
                        return redirect("/check_license")
    except Exception as e:
        print ("HAHA dalal")
        print (e)
        messages.info(request, " Upload Image please") #error message if the user presses upload without uploading an image
        return redirect("/check_license")


def ocr_space_file(filename, overlay=False, api_key='307a63ae1788957', language='ara'):
#this the API function, it will take the uploaded file and scan information on the card. 
#Then, it will return the detected infromation in the form of text 
    payload = {'isOverlayRequired': overlay,
               'apikey': api_key,
               'language': language,
               }
               
    with open(filename, 'rb') as f:
        r = requests.post('https://api.ocr.space/parse/image',
                          files={filename: f},
                          data=payload,
                          )
    return r.content.decode()




############## Move to USER DASHBOARD ##############
def user_dashboard(request):
    #diplay the user dashboard with the lawyer's infromation #the phone number is got from the database directly
    current_user = user_admin.objects.get(id=request.session['id'])
    realF = files.objects.filter(id=current_user.id).values()
    phone = ''
    for data in realF:
        for key, val in data.items():
            if key == 'phoneNo':
                request.session['phone'] = val  # phone session  
            if key == 'name':
                request.session['name'] = val  #name session  

    context = {
        'user_data': current_user,
        'user_phone': phone
    }
    return render(request, "application/edit_profile.html", context)

############## Edit User Profile  ##############

def edit_user(request,id):
    current_user = user_admin.objects.get(id = id)
    realF = files.objects.filter(id= current_user.id).values()
    phone = ''
    name = ''
    for data in realF:
        for key,val in data.items():
            if key == 'phoneNo':
                phone = val
                request.session['phone']= phone  ##################### phone session  #####################
            if key == 'name':
                name = val
                request.session['name'] =name     ##################### name session  #####################
    context = {
        'user_data': user_admin.objects.get(id = id),
        'user_phone': phone,
        'full_name' : name
         }
    return render(request, "application/lawyer_profile.html", context)



# def update_user(request):
#     if request.method == "POST":
#             errors = user_admin.objects.user_validator(request.POST)
#             if len(errors) > 0:
#                 for key, value in errors.items():
#                     messages.error(request, value)
#             return redirect(f'/{request.POST["userID"]}/edit')
#             userID =  request.POST["userID"]
#             userName = request.POST['username']
#             email = request.POST['email']

#             current_user = user_admin.objects.get(id = userID)

#             current_user.username = userName
#             current_user.email = email
#             current_user.save()
#     return redirect(f'/{ request.POST["userID"]}/edit')


############## Update User Password  ##############
def update_password(request):
    if request.method == "POST":
            #the password_validator will ensure the new password is on the correct format 
            errors = user_admin.objects.password_validator(request.POST)
            if len(errors) > 0:
                for key, value in errors.items():
                    messages.success(request, value)
                return redirect('/user_dashboard')

            new_password = request.POST['new_password'] #store the new password 
            current_user = user_admin.objects.get(id = request.session ['id']) #get the current user id 
            current_user.password = new_password #set the password of current user to new password 
            current_user.save() #save pdates 
    return redirect('/user_dashboard')

############## Get User Feedback  ##############
def feedback_form(request,):
    if request.method == 'POST':
        #store the info of the user that sent feedback, and their message
        formId = request.POST['formID']
        user_name=request.POST['name']
        email = request.POST['email']
        message = request.POST['message']
        read=False
        feedback.objects.create(user_name=user_name,email=email,message=message , read=False) #add message to the database 
        if 'id' in request.session:
            if formId == "1":
                return render(request, "application/edit_profile.html")
            else:
                return render(request, "application/lawyer_profile.html")
    return redirect('/')



############## Fucntion to delete message from record  ##############

def delete_msgs(request,id):
    msg_to_delete = feedback.objects.get(id=id)
    msg_to_delete.delete()
    return redirect('/feedback_table')

############## Fucntion to display all the feedback sent from users  ##############

def show_feedback(request, id):
    msg = feedback.objects.get(id= id)
    msgs = msg.message
    msg.read=True #mark message as read
    msg.save()
    msgs = {
        'msg' : msgs
    }
    return render(request, 'application/feedbacks.html',msgs)

############## Fucntion to display all the lawyers registered for the guests ##############

def lawyers(request):
    context = {
        'all_users': user_admin.objects.filter(user_type='user')
    }
    return render(request, "application/lawyers.html", context)

############## Update User Profile  ##############
def update_profile (request):
    if request.method == 'POST':
        #store the new entred records
        about_me = request.POST['about_me']
        experience = request.POST['experience']
        catogray = request.POST['category']
        #get the current user id to update their record
        id = str(request.session['id'])
        current_user = user_admin.objects.get(id=id)
        #update their record into the new entered values
        current_user.about_me=about_me
        current_user.experience=experience
        current_user.catogray=catogray
        current_user.save()
        return redirect('/user_dashboard')

############## Logout Function Return to Main Page ##############
def logout (request):
    del request.sessions['id']
    return redirect("/")


def feedback_table (request):
    mess_dic = {
        'all_messages': feedback.objects.all().order_by("-created_at"),
        'count': feedback.objects.filter(read=False).count(),

    }
    return render(request, "application/feedback_admin.html",mess_dic)

############## Fucntion to information of a specific lawyer to the admin or guest  ##############
def show_lawyer_profile(request,id):
   current_user = user_admin.objects.get(submitted_URL = id) #get lawyere id as a user
   realF = files.objects.filter(id= current_user.submitted_URL).values() #get the lawyer files info
   phone = ''
   name = ''
   for data in realF:
       for key,val in data.items():
           if key == 'phoneNo':
               phone = val
           if key == 'name':
               name = val
   context = {
       'user_data': user_admin.objects.get(submitted_URL = id),
       'user_phone': phone,
       'full_name' : name
        }
   return render(request, "application/show_lawyer_profile.html", context)

def show_lawyer_profile_g(request,id):
   current_user = user_admin.objects.get(id = id) #get lawyere id as a user
   realF = files.objects.filter(id= current_user.submitted_URL).values() #get the lawyer files info
   phone = ''
   name = ''
   for data in realF:
       for key,val in data.items():
           if key == 'phoneNo':
               phone = val
           if key == 'name':
               name = val
   context = {
       'user_data': current_user,
       'user_phone': phone,
       'full_name' : name
        }
   return render(request, "application/show_lawyer_profile_gs.html", context)

############## Fucntion to delete a user it's file from admin dashboard  and database##############
def delete_files(request,id):
   user_to_delete = user_admin.objects.get(submitted_URL = id)
   file_to_delete = files.objects.get(id=id)
   user_to_delete.delete()
   file_to_delete.delete()
   id =  str( request.session ['id'] )
   return redirect('/user_page')
