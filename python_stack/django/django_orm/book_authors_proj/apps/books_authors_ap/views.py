

from django.shortcuts import render, redirect
from .models import Book, Author
# show all of the data from a table
def index(request):
    context = {
    	"first_book_name": Book.objects.first()
    }
    return render(request, "books_authors_ap/index.html", context)
