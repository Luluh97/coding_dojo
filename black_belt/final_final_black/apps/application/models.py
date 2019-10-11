from django.db import models
import re


emailRegex = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
passwordRegex = re.compile(r'\d.*[A-Z]|[A-Z].*\d')
class validator(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        # The email should have a valid format
        if not emailRegex.match(postData['email']):
            errors['email'] = "The email should be in valid format"

        temp = postData['email']
        email_exists = user_admin.objects.filter(email=temp)
        if len(email_exists) != 0:
            errors['email'] = " email is already exist"

        # Name fields should be alphabetic
        if postData['username'].isalpha() == False:
            errors["username"] = "Name fields should be alphabetic"

        # Validate registration
        temp = postData['username']
        username_exists = user_admin.objects.filter(username=temp)
        if len(username_exists) != 0:
            errors['username'] = " user name is already registered"

        # Password should be a minimum of 8 chars with at least one special char and 1 number
        if len(postData['password']) < 8:
            errors['password'] = "Password should be a minimum of 8 characters"
        elif not passwordRegex.match(postData['password']):
            errors[
                'password'] = "Invalid Password, must have at least one Capital letter, at least one lower case letter and at least one number or special character"

        # Validate Confrim Password
        if postData['password'] != postData['password_confirm']:
            errors['password_confirm'] = "Passwords do not match"

        return errors


    def login_validator(self, postData):
        errors = {}
        # Validate login
        temp = postData['username']
        tempPass = postData['password']
        username_exists = user_admin.objects.filter(username=temp)
        if len(username_exists) == 0:
            errors['username'] = "Username is incorrect"
        elif postData['password'] != username_exists[0].password:
            errors['password'] = "Password is incorrect"
        if len(temp) < 1:
            errors['username'] = "Username field cannot be blank"
        if len(tempPass) < 1:
            errors['password'] = "password field cannot be blank"
        return errors


    def user_validator(self, postData):
        errors = {}
        # The email should have a valid format

        if len(postData['email']) < 1:
            errors['email'] = "email field cannot be blank"
        elif not emailRegex.match(postData['email']):
            errors['email'] = "The email should be in valid format"


        if len(postData['username']) < 1:
            errors['username'] = "Username field cannot be blank"
        elif postData['username'].isalpha() ==  False:
            errors["username"] = "Name fields should be alphabetic"

        #Validate registration 
        temp = postData['username']
        username_exists = user_admin.objects.filter(username=temp)
        if len(username_exists) != 0:
            errors['username'] = " user name is already registered"

        return errors

    def password_validator(self, postData):
        passwordRegex = re.compile(r'\d.*[A-Z]|[A-Z].*\d')
        errors = {}
         # Password should be a minimum of 8 chars with at least one special char and 1 number
        if len(postData['new_password']) < 8:
            errors['new_password'] = "Password should be a minimum of 8 characters"
        elif not passwordRegex.match(postData['new_password']):
            errors['new_password'] = "Invalid Password, must have at least one Capital letter, at least one lower case letter and at least one number or special character"

        # Validate Confrim Password
        if postData['new_password'] != postData['new_password_confirm']:
            errors['new_password_confirm'] = "Passwords do not match"
        return errors
        
class user_admin(models.Model):
    username = models.CharField(max_length=255)
    submitted_URL = models.TextField(null=False)
    about_me=models.TextField(default='')
    experience=models.TextField(default='')
    catogray=models.TextField(default='')
    email = models.CharField(max_length=255)
    password = models.CharField(max_length=255)
    user_type = models.CharField(max_length=45)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = validator()

class files(models.Model):
    submitted_URL = models.TextField()
    result = models.TextField()
    phoneNo = models.CharField(max_length=45)
    name = models.CharField(max_length=45)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class feedback(models.Model):
    user_name = models.CharField(max_length=120)
    email = models.EmailField()
    message = models.TextField()
    read=models.BooleanField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)