from django.shortcuts import render
from .models import Genre, Book, BookInstance, Author


def index(request):
    num_genre = Genre.objects.all().count()
    num_book = Book.objects.all().count()
    num_book_instances = BookInstance.objects.all().count()
    num_author = Author.objects.all().count()

    availables = BookInstance.objects.filter(status__exact='a').count()

    return render(
        request,
        'index.html',
        context={
            'num_genre': num_genre,
            'num_book': num_book,
            'num_book_instances': num_book_instances,
            'num_author': num_author,
            'availables': availables
        }
    )
