# Open Authorization

It is an authorization framework, open source and build with IETF standards and 
licensed under the Open Web Foundation.

It is a delegation protocol:
* Allow to someone who controls a resource allow to a software application, access
to that resource on their own behalf without going through it.
* With the help of OAuth, users can allow third-party applications to access their
data or perform certain operations without having to provide usernames and passwords.

## Workflow with OAuth

1. An application requests authorization.
2. Login through Google.
3. The application communicates with Google where it uses the Google credentials
without the application can be able to see them.
4. The Google server asks the user if he wants to grant the X permissions.
5. The user accept the permissions.
6. Google generate a access token like response.
7. The application uses that token.

## Scenarios where OAuth can be use.

1. HTTP Authentication in which do not require the uses of username and password
all the time.  
2. Multiples applications inside the same company and in consequence multiples
account using the same username and password.
3. Architecture of Microservices.
4. Integration of Third Part Application.

## OAuth in Spring Security

Initially there was a project call Spring Security OAuth.

In 2018, it is overwritten to make it more efficient, with a simpler codebase.

Deprecate the old (http://spring.io/projects/spring-security-oauth) and now OAuth
is integrated on the Spring Security itself.

Include: 

* Client Support
* Resource Server
* Authorization Server: 

## Action flow of OAuth 

* Authorization code
* Implicit
* Resource Owner password credentials
* Client Credentials
* Refresh Token

## OpenID Connect

* OpenId Connect --> Authentication 
* OAuth 2.0 --> Authorization
* HTTP

