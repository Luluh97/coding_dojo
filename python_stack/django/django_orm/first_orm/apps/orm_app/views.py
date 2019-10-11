from django.shortcuts import render, redirect
from .models import Movies
# show all of the data from a table
def index(request):
    context = {
    	"newly_created_movie": Movies.objects.create(title="The Princess Bride",description="the best movie ever",release_date="1987-09-25",duration=98)
    }
    return render(request, "orm_app/index.html", context)