from django.db import models
from django.urls import reverse

class Director(models.Model):
    name = models.CharField(max_length=50, help_text="Director Name")
    description = models.TextField(
        max_length=100, help_text='About the Director')
    
    def __str__(self):
        return self.name


class Movie(models.Model):
    title = models.CharField(max_length=100, help_text="Title of the Movie")
    summary = models.TextField(
        max_length=500, help_text='Put what this Movie it all about')
    director = models.ManyToManyField(Director)

    def __str__(self):
        return self.title

    def get_absolute_url(self):
        return reverse('movie-deatil', args=[str(self.id)])