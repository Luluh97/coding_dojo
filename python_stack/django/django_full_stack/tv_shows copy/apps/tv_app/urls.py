from django.conf.urls import url
from . import views

urlpatterns = [
        url(r'^$', views.index),
        url(r'^shows$', views.all_shows),
		url(r'^shows/new$', views.new_show),
        url(r'^shows/create$', views.add_show),
        url(r'^shows/(?P<added_show_id>\d+)$', views.display_show, name='show1'),
        url(r'^shows/(?P<show_edit_id>\d+)/edit$', views.edit_show, name ='show'),
        url(r'^shows/(?P<show_update_id>\d+)/update$', views.update_show, name='show4'),
        url(r'^shows/(?P<show_delete_id>\d+)/destroy$', views.delete_show, name ='show2'),
	]

 