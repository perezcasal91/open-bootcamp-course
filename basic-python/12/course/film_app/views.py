from django.shortcuts import render
from .models import Director, Movie

def index(request):
    movieList = Movie.objects.all()
    directorList = Director.objects.all()
    context = {
        'movieList': movieList,
        'directorList': directorList
    }
    return render(request, 'index.html', context)
