from django.shortcuts import render
from django.utils.crypto import get_random_string
    
def index(request):
    context = {
        "time": strftime("%Y-%m-%d %H:%M %p", gmtime())
       
    }
    return render(request,'time_app/index.html', context)