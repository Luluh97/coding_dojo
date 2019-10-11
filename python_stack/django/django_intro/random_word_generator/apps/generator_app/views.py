from django.shortcuts import render, redirect
from  django.utils.crypto import get_random_string
    
def index(request):
    context = {
        "rand_s": get_random_string(length=14)
    }
    request.session['counter'] += 1
    return render(request,'generator_app/index.html', context)

def reset(request):
    request.session['counter'] = 0
    return redirect('/random_word')
