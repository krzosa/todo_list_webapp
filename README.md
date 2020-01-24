# Todo list webapp in Spring
## Technology used:
* Spring-Boot
* Spring data JPA
* H2 Database
* Spring security
* Thymeleaf
* Bootstrap

## Features:
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
Bootstrap. CSS used only to tweak login page

![img](https://github.com/krzosa/todo_list_webapp/blob/master/img.PNG)


## How to run
1. Clone or download this repository
1. cd into the repository
1. mvnw spring-boot:run
1. Type 'localhost:8080' into your browser
1. Login in with one of these accounts:
    * login: aaaa password: pas
    * login: bbbb password: pass
    * login: cccc password: passs


