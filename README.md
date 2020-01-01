#Todo list webapp in Spring
##Technology used:
* Spring-Boot
* Spring data JPA
* H2 Database
* Spring security
* Thymeleaf
* Bootstrap
##Features:
* Login page that validates logins based on the information
from database
* Core website features are secured which means that user
needs to log in before accessing them
* Users are able to add, delete and edit notes and only they
can see them
* All the users and their notes are stored in the H2 database
and are retrieved when needed
* Custom error page handling
* Nice and very responsive website design created 98% using
Bootstrap. CSS used to tweak login page
##How to run
1. Clone or download this repository
1. cd into the repository
1. mvnw spring-boot:run
1. Type 'localhost:8080' into your browser
1. Login in with one of these accounts:
    * login: aaaa password: pas
    * login: bbbb password: pass
    * login: cccc password: passs

###Things to remember
1. When working with spring security its important to remember to allow access to webjars, css files, js scripts etc. 
cause these cause many issues like css not loading
    * Indicators: Site is not working properly when logged out, when you login webapp outputs contents of blocked css, js... file 
1. When working with Thymeleaf its important to remember to import thymeleaf tags into the html file. 
    * Indicators: Not being able to access model variables in html file in intelij suggestions.
1. When working with html files its important to have proper meta tags
cause not having proper tags causes many unforeseen issues that
are hard to debug.
PHaving a ready template in the future is probably a good idea.
    * Indicators: Bootstrap layout not working properly on 
    mobile devices.
1. Using data.sql sheet in spring is really helpful for debugging.