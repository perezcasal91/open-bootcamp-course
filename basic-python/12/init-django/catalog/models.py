from django.db import models
from django.urls import reverse
import uuid


class Genre(models.Model):
    name = models.CharField(
        max_length=64, help_text='Put the name of the Genre')

    def __str__(self):
        return self.name


class Book(models.Model):
    title = models.CharField(max_length=50)
    author = models.ForeignKey('Author', on_delete=models.SET_NULL, null=True)
    summary = models.TextField(
        max_length=100, help_text='Put what this Book it is about')
    isbn = models.CharField('ISBN', max_length=13,
                            help_text="ISBN has to be 13 characteres")
    genre = models.ManyToManyField(Genre)

    def __str__(self):
        return self.title

    def get_absolute_url(self):
        return reverse('book-deatil', args=[str(self.id)])


class BookInstance(models.Model):
    uuid = models.UUIDField(
        primary_key=True, default=uuid.uuid4, help_text='Unique Id for the Book')
    book = models.ForeignKey('Book', on_delete=models.SET_NULL, null=True)
    imprint = models.CharField(max_length=200)
    due_back = models.DateField(null=True, blank=True)

    LOAN_STATUS = (
        ('m', 'Maintenance'),
        ('o', 'On loan'),
        ('a', 'Available'),
        ('r', 'Reserved'),
    )

    status = models.CharField(max_length=1, choices=LOAN_STATUS,
                            blank=True, default='a', help_text="Book Status")

    class Meta:
        ordering = ['due_back']

    def __str__(self):
        return '%s (%s)' % (self.uuid, self.book)


class Author(models.Model):
    first_name = models.CharField(max_length=100)
    last_name = models.CharField(max_length=100)
    date_of_birth = models.DateField(null=True, blank=True)
    date_of_death = models.DateField('Died', null=True, blank=True)

    def get_absolute_url(self):
        return reverse('author-detal', args=[str(self.id)])

    def __str__(self):
        return '%s (%s)' % (self.first_name, self.last_name)
