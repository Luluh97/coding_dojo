from django.db import models

class usersModel(models.Model):
    col = models.CharField(max_length=10)

