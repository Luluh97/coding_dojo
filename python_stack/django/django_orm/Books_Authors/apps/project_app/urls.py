from django.conf.urls import url
from . import views
		                    
urlpatterns = [
	    url(r'^$', views.index),
    	url(r'^add_books$', views.add_books),
		url(r'^authors$', views.all_authors),
		url(r'^add_authors$', views.add_authors),
		url(r'^books/(?P<id>\d+)$', views.show_books , name ='show2'),
		url(r'^authors/(?P<id>\d+)$', views.show_authors, name ='show'),
		url(r'^add_author_to_book/(?P<id>\d+)$', views.add_author_to_book , name='show3'),
]


