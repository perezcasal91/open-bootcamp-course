# Generated by Django 4.1.7 on 2023-03-15 21:46

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('film_app', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='movie',
            name='summary',
            field=models.TextField(help_text='Put what this Movie it all about', max_length=100),
        ),
        migrations.AlterField(
            model_name='movie',
            name='title',
            field=models.CharField(help_text='Title of the Movie', max_length=100),
        ),
    ]
