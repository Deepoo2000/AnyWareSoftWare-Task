-- delete the database if exists 
drop schema if exists StudentManagmentSystem;

-- create new database 
create database StudentManagmentSystem;

-- using this database for creating tables
use StudentManagmentSystem;

-- Create the Student table
CREATE TABLE student (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);


-- Create the Quiz table
CREATE TABLE quiz (
    quiz_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);


-- Create the Teacher table
CREATE TABLE teacher (
    teacher_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

-- Create the Course table
CREATE TABLE course (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    teacher_id INT,
    quiz_id INT,
    FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id),
    FOREIGN KEY (quiz_id) REFERENCES quiz(quiz_id)
);


-- Create the Student-Course linking tables
-- relation is @ManyToMany
CREATE TABLE student_course (
    student_id INT,
    course_id INT,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES student(student_id),
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);


