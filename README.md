# Student Web Application with Spring Boot | Angular | Fullstack | Demo 
![student-frontend](https://user-images.githubusercontent.com/86077654/140656251-312feb56-826c-4129-8928-db3de4e2f85c.png)

## Description
I made this project based on Spring Boot | Angular | fullstack  web application with Spring Boot on backend and Angular on frontend. Basically, this is just a demo project to understand architecture of Angular, Spring Boot and how they communicate with each other to perform a fullstack web development
![springboot-angular-fullstack](https://user-images.githubusercontent.com/86077654/139099716-8975a4f7-67c3-4d8a-a21b-d202119af096.png)

## Angular
![angular](https://user-images.githubusercontent.com/86077654/139235800-ecf841b2-52b3-4211-b271-cd479941ba9e.png)

## Spring Boot
![spring-boot-3-player](https://user-images.githubusercontent.com/86077654/138086348-6cb23128-f9ec-4e20-9f36-0aac9006e7ac.png)

## Run project
To run the project, make sure you have installed
- MySQL database
- NodeJS

![Screenshot 2021-10-28 170156](https://user-images.githubusercontent.com/86077654/139234298-500e4647-5b8c-4dea-bfd6-5d4cc96cc986.png)

First, open the project and follow path "\src\main\resources\application.properties" to configuation application.properties to connect database.

Make sure you created database "student" and change username and password with your MySQL account, then go to pom.xml file -> Maven -> Reload project.

Second, go to DemoApplication and Run. After the program has finished running. Open your browser "http://localhost:8080/api/spring-boot/student"  to see API of backend

Finally, open terminal at "\src\angular-frontend", then run command "npm install" to install node_modules folder. Once done, run command "ng serve" then open "http://localhost:4200" in your browser to see the frontend.

Run the backend first, then run the frontend later. Good luck




