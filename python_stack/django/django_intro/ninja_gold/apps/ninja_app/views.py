from django.shortcuts import render, redirect
import random



def index(request):
    if 'gold' in request.session:
        request.session['gold'] = request.session['gold']
    else:
        request.session['gold'] = 0
    return render(request, 'ninja_app/index.html')

def process_money(request):
    if request.method == "POST":
        if "activity" not in request.session:
            request.session['activity'] = []

        if request.POST['place'] == 'farm':
            request.session['random'] = random.randrange(10, 21)
            request.session['gold'] += request.session['random']
            request.session['activity'].append("Earned "+str(request.session['random'])+" from the farm")

        if request.POST['place'] == 'cave':
            request.session['random'] = random.randrange(5, 11)
            request.session['gold'] += request.session['random']
            request.session['activity'].append("Earned "+str(request.session['random'])+" from the cave")

        if request.POST['place'] == 'house':
            request.session['random'] = random.randrange(2, 6)
            request.session['gold'] += request.session['random']
            request.session['activity'].append("Earned "+str(request.session['random'])+" from the house")

        if request.POST['place'] == 'casino':
            request.session['random'] = random.randrange(-50, 51)
            request.session['gold'] += request.session['random']
            if request.session['random'] < 0:
                request.session['activity'].append("Lost "+str(-1*request.session['random'])+" from the casino")
            else:
                request.session['activity'].append("Earned "+str(request.session['random'])+" from the casino")   
        
        return redirect('/')

def reset(request):
    if request.method == "POST":
        request.session['gold'] = 0
        request.session['activity'] = []
        return redirect ('/')