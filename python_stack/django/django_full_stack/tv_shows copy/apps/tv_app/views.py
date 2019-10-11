from django.shortcuts import render, redirect
from .models import shows
from django.contrib import messages

def index(request):
    shows_list = shows.objects.all()
    shows_list_dict = {
        'list': shows_list
    }
    return render(request,"tv_app/show_all.html", shows_list_dict)

def new_show(request):
    return render(request,"tv_app/add.html")

def add_show(request):
    if request.method == "POST":
        errors = shows.objects.basic_validator(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect('/shows/new')
        else:
            show_title=request.POST["title"]
            networks =request.POST["network"]
            date=request.POST["date"]
            desc=request.POST["desc"]
    added_show = shows.objects.create( title = show_title , network = networks, release_date = date, description = desc )
    added_show_id = added_show.id
    messages.success(request, "TV show successfully added")
    return redirect(f"/shows/{added_show_id}")

def display_show(request, added_show_id):
    show_to_display = shows.objects.get(id=added_show_id)
    show_to_dispaly_dict = {
        'this_show': show_to_display
    }
    return render(request,"tv_app/show_info.html", show_to_dispaly_dict)

def all_shows(request):
    shows_list = shows.objects.all()
    shows_list_dict = {
        'list': shows_list
    }
    return render(request,"tv_app/show_all.html", shows_list_dict)

def edit_show(request, show_edit_id):
    show_to_edit = shows.objects.get(id = show_edit_id)
    show_to_edit_dict = {
        'this_show': show_to_edit
    }
    return render(request,"tv_app/edit.html", show_to_edit_dict)

def update_show(request, show_update_id):
    if request.method == "POST":
        errors = shows.objects.basic_validator(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect('/shows/'+show_update_id+'/edit')
        else:
            show_title1=request.POST["title"]
            networks1 =request.POST["network"]
            date1=request.POST["date"]
            desc1=request.POST["desc"]
    updated = shows.objects.filter(id =  show_update_id).update(title = show_title1 , network = networks1, release_date = date1, description = desc1)
    return redirect(f"/shows/{show_update_id}")

def delete_show(request, show_delete_id):
    show_to_delete = shows.objects.get(id=show_delete_id)
    deleted = show_to_delete.delete()
    return redirect('/shows')
