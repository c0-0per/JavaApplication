GoogleDoc: https://docs.google.com/document/d/1nkPtpos8bq99AGOoiK3xQWGbcjk64ZMUxedieLWDzr8/edit?pli=1


SRS Document for project “Private Library”

Content
Introduction
1.1 Purpose of document
1.2 Intended audience
1.3 Project Scope
Overall Description
2.1 Product Perspective
2.2 Project constraints
2.3 User Class and characteristics
3. UML Class Diagram


Introduction

1.1. Purpose of document
The purpose of this document is to build an online Library system to manage books reservations to make it easier for library customers.

1.2 Intended audience
This project serves as a prototype for an online library reservation system designed for exclusive use within the institution. The project's utility extends to library staff managing reservations and library patrons who wish to reserve materials online.

1.3 Project Scope
Our primary goal is to create a web-based platform that empowers library patrons to easily search the library catalog, check item availability, make reservations, and manage their accounts from any location with an internet connection. We aim to provide library staff with a powerful tool to efficiently manage reservations and user accounts.

2.   Overall Description

2.1 Product Perspective
A distributed library database system stores the following information:
♦ Books and details of them, such as title, authors, genre, publication date, description and rating.
♦ Availability status of items, indicating the number of copies available and those currently checked out.
♦ User/Admin profiles: the system maintains customer profiles, recording details such as user identification codes and user names.
♦ Reservation records: includes user details (userId), bookId, date of reservation, its own id, etc.
♦ Loan records: once the reservation is confirmed, the user must come to pick up the book. After the user picks up the book, the librarian records it in the system and the time report starts. The loan includes: userId + taken books + due date, etc.

2.2 Project constraints
	The system won't:
1) Allow unregistered users to make reservations, leave reviews and rate books.
2) The user will not be able to delete a reservation already made by him. He also cannot edit it.

2.3 User Class and characteristics
The system will support two types of user privileges, User, and Admin. User will have access to user functions, and the Admin will have access to both user and management functions of Library.
The User should be able to do the following functions:
- reserve books
- write comments and rate books
- get notifications
The Admin should be able to do the following functions:
- approve/cancel reservations
- add/remove books








Guide how to install and start program
 - You need to install this project on your computer and just start it.
 - For testing requests you need to open Postman and write url and sometimes some data and/or jwt token for authentification
    - POST http://localhost:8080/users/register - register user - u can use these data
    {
        "username": "username",
        "password": "password",
        "email": "cvut@cvut.cz"
    }
    register admin - u need to have @admin.edu email to be an admin


    - POST http://localhost:8080/users/authenticate - login - request will give you token that later you will use to send request
    - GET http://localhost:8080/users/adminping or http://localhost:8080/users/userping - pings for login user or admin
    - http://localhost:8080/api/titles
        - GET - get all titles
        - GET /{id} - get title by id
        - POST /create - create title
        (send
                  "nameOfBook": String,
                  "descriptionOfBook": String,
                  "publishier": String,
                  "numbersOfItems": int,
                  "numbersOfFreeItems": int,
                  "publicationYear":  1000 < int < 2024,
                  "genreId": (int),
                  "authorIds": List<int> )
        - DELETE /delete/{id} - delete title
    - http://localhost:8080/api/authors
        - GET - get all authors
        - POST /{id}/titles - add title to author ("name" (String))
        - POST /create - create an author
        - DELETE /{authorId}/titles/{titleId} - delete title from author
    - http://localhost:8080/api/genres
        - GET - get all genres
        - POST - create genre (send "nameOfGenre" (String) )
        - POST /{genreId}/title/{titleId} - add title to genre
        - DELETE {genreId}/title/{titleId} - delete title from genre
        - GET /{genreId}/genres - get genre by id
    - http://localhost:8080/api/cart
        - POST /book_items - add book to cart ("name" (String))
        - PUT //book_items - remove book from cart
    - http://localhost:8080/api/reservations
        - POST /create - create a reservation
        - GET /{id} - get reservation by ID
        - DELETE /{id} - delete reservation
    - http://localhost:8080/api/loans
        - POST /make/{id} - make a loan
        - PUT /close/{id} - close a loan
        - GET /{id} - get a loan



 1) Vyzkoušeli jsme dto - je pohodlnějsí pro větší Entity.
 2) Taky web security -  Během vývoje jsme se věnovali zabezpečení webových služeb.
 Využili jsme různé mechanismy, jako je autentizace a autorizace, aby se zajistilo,
 že přístup k určitým zdrojům a funkcím je omezený a chráněný.
 To zahrnovalo použití JWT (JSON Web Tokens) pro autentizaci uživatelů,
 což nám poskytlo robustní způsob ověřování identity. Nemůžeme však říci, že to bylo snadné.
 Přestože je na internetu spousta návodů, ne všechny nám pomohly.
 3) Pro jednoduchost a efektivitu jsme použili specializovanou utilitu pro ověření identity uživatele.
 Tato utilita se ukázala jako velmi užitečná,
 protože umožňovala snadný a rychlý způsob zjištění, který uživatel provádí konkrétní požadavek nebo akci v systému.
 4)  Při implementaci API jsme se naučili, jak správně navrhovat a strukturovat koncové body API tak,
 aby byly srozumitelné a snadno použitelné pro vývojáře.
 Představení různých metod (POST, GET, DELETE atd.)
 pro různé operace nám umožnilo efektivně komunikovat s databází a poskytovat potřebné funkcionality uživatelům.

