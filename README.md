🎵 TuneHub – Music Streaming Web Application

📖 Overview

TuneHub is a Java Full Stack Music Streaming Application built using Spring Boot, MySQL, and HTML/CSS/React (optional frontend).
The application allows users to register, log in, browse, and listen to songs. Admins can upload and manage music tracks, while users can create playlists and stream songs online.


🏗 Tech Stack

Backend:

Java 17,
Spring Boot,
Spring MVC,
Spring Data JPA,
Spring Security (for authentication),
MySQL

Frontend (optional depending on your setup):

HTML, CSS, Bootstrap, JSP
OR React JS

Tools Used:
Spring Tool Suite ,
MySQL Workbench ,
Postman (for API testing) ,
Maven (dependency management) 

How to Run the Project

🖥 Backend (Spring Boot)

1. Open in Spring Tool Suite (STS) 

2. Update application.properties with your MySQL credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/tunehub
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


4. Run the Spring Boot application (TuneHubApplication.java)

5. Access the app at http://localhost:8080



 Project Architecture

TuneHub/
├── src/
│   ├── main/
│   │   ├── java/com/tunehub/
│   │   │   ├── controller/
│   │   │   ├── entity/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── serviceImpl/
│   │   └── resources/
│   │       ├── templates/
│   │       ├── static/
│   │       └── application.properties
├── pom.xml
└── README.md




