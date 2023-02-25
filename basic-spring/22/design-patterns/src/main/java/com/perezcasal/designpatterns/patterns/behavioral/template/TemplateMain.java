package com.perezcasal.designpatterns.patterns.behavioral.template;

public class TemplateMain {
    public static void main(String[] args) {
        HTMLHomePage homePage = new HTMLHomePage();
        System.out.println(homePage.render());

        HTMLAboutUsPage aboutUsPage = new HTMLAboutUsPage();
        System.out.println(aboutUsPage.render());
    }
}

abstract class HTMLTemplate {

    public String render() {
        return String.format("%s%s%s"
                ,header() ,body(), footer());
    }

    public abstract String header();
    public abstract String body();

    public String footer() {
        return """
                <footer>
                    <spam>Footer</spam>
                </footer>
                </html>
                """;
    }
}

class HTMLHomePage extends HTMLTemplate {
    @Override
    public String header() {
        return """
                <!doctype html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Home Page</title>
                </head>
                """;
    }
    @Override
    public String body() {
        return """
                <body>
                    <h1>Hello, world!</h1>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" 
                    integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous">
                    </script>
                </body>
                """;
    }
}

class HTMLAboutUsPage extends HTMLTemplate {
    @Override
    public String header() {
        return """
                <!doctype html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>About us...</title>
                </head>
                """;
    }
    @Override
    public String body() {
        return """
                <body>
                    <h1>Hi this is me.</h1>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" 
                    integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous">
                    </script>
                </body>
                """;
    }
}
