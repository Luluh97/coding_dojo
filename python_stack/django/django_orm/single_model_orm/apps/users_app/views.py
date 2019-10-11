from django.shortcuts import render, redirect
from .models import User
# show all of the data from a table
def index(request):
    context = {
    	"new_user": User.objects.create(first_name="Luluh",last_name="Alsalamah",email_address="lulu@site.com",age=21)
    }
    return render(request, "users_app/index.html", context)
