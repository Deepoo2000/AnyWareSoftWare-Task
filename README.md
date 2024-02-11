I will start my explaining from Z-A, from creating (databse) to (rest ontroller)

1)##DataBase 
   1) created student table
   2) created course table
   3) created teacher table
   4) created quiz table
     # relation between student and course is @ManyToMany 
     # relation between teacher and course is @OneToMany 
     # relation between quiz and course is @OneToOne
-> see StudentManagenestSystem.sql that included all info with comments.
......................
2)##entity package
   1) created class student (@entity) with attributes for connect with database table
   2) created class course (@entity) with attributes for connect with database table
   3) created class teacher (@entity) with attributes for connect with database table
   4) created class quiz (@entity) with attributes for connect with database table 
......................
3)##dao package
  1) created an interface student and class implentation to get data and make inple to give it to controller.
  2) created an interface course and class implentation to get data and make inple to give it to controller.
  3) created an interface teacher and class implentation to get data and make inple to give it to controller.
  4) created an interface quiz and class implentation to get data and make inple to give it to controller.
    # I make that to split function about its implementation
......................
4)##service package
   --> inject dao database class into service @Autowired
  1) created StudentService class (@Service) to impl database from and to dao
  2) created CourseService class (@Service) to impl database from and to dao
  3) created TescherService class (@Service) to impl database from and to dao
  4) created QuizService class (@Service) to impl database from and to dao 
......................
5)##Controller package
  --> inject service class into controller @Autowired
     1) created a student @RestController api for student with crud operation (Get, Post, Delete, Update)
     2) created a course @RestController api for course with crud operation (Get, Post, Delete, Update)
     3) created a teacher @RestController api for teacher with crud operation (Get, Post, Delete, Update)
     4) created a quiz @RestController api for quiz with crud operation (Get, Post, Delete, Update)
     
......................
6)## api 
   // http://localhost:8088/
  -- using postman, attach photo see it.
  ![postMan](https://github.com/Deepoo2000/AnyWareSoftWare-Task/assets/104589126/b7c8dd99-4639-420b-9edc-b550819d5a42)

......................
7)## swagger
  // http://localhost:8088/v2/api-docs
  1) created swaggerConfig
  2) created swaggerController
-- see swagger.json in tast
![Swagger](https://github.com/Deepoo2000/AnyWareSoftWare-Task/assets/104589126/982a73a3-f3aa-4b06-a75f-ac5b97985fd8)

