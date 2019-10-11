from django.shortcuts import render, redirect
from .models import books, author
def index(request):
    book=books.objects.all()
    b= {'bo':book}
    return render(request,"project_app/index.html",b)

def all_authors(request):
    authors = author.objects.all()
    a = {'auth': authors}
    return  render(request, "project_app/authors.html", a)


def add_books (request):
    if request.method == "POST":
        title=request.POST["title"]
        dis=request.POST["disc"]
    added= books.objects.create(title=title , desc=dis)
    return redirect('/')

def add_authors (request):
    if request.method == "POST":
        fname=request.POST["first_name"]
        lname=request.POST["last_name"]
        notes = request.POST["notes"]
    added_auth= author.objects.create(first_name=fname , last_name=lname, notes = notes)
    return redirect('/authors')

def show_books (request,id):

    book_to_show = books.objects.get(id=id)
    all=author.objects.all()
    sp=book_to_show.authors.all()
    book_to_show_dic= {
        'display': book_to_show,
        'all_authors':all,
        'sp':sp

    }
    return render(request,"project_app/books.html", book_to_show_dic)

def show_authors (request,id):
    author_to_show = author.objects.get(id=id)
    all =  books.objects.all()
    tb = author_to_show.book.all()

    author_to_show_dic= {
        'display': author_to_show,
        'all_books': all,
        'tb': tb
    }
    return render(request, "project_app/authors_show.html", author_to_show_dic )

def add_author_to_book (request,id):
    if request.method == "POST":
        book_authors=books.objects.get(id=id)
        this_book=request.POST['books_list']
        book_authors.authors.add(this_book)

    return redirect('/authors/'+id)

def add_book_to_author (request,id):
    if request.method == "POST":
        book_authors=books.objects.get(id=id)
        this_author=request.POST['authors_list']
        book_authors.authors.add(this_author)

    return redirect('/books/'+id)