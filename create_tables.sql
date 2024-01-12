CREATE DATABASE grading_platform;
USE grading_platform;


DROP TABLE IF EXISTS `student_registration`;
DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `course`;



CREATE TABLE users (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;;



CREATE TABLE course
(id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
syllabus VARCHAR(255) NOT NULL,
instructor_login VARCHAR(50) NOT NULL, 
year INT NOT NULL,
semester INT NOT NULL,
project_grade_weight DOUBLE NOT NULL,
final_exams_grade_weight DOUBLE NOT NULL,
foreign key(instructor_login) REFERENCES users(username) ON DELETE CASCADE,
primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;;

CREATE TABLE student_registration
(
id INT NOT NULL AUTO_INCREMENT,
idC INT NOT NULL,
name VARCHAR(255) NOT NULL,
year_of_registration INT NOT NULL,
semester INT NOT NULL,
project_grade DOUBLE DEFAULT NULL,
final_exams_grade DOUBLE DEFAULT NULL,
final_grade DOUBLE DEFAULT NULL,
foreign key(idC) REFERENCES course(id) ON DELETE CASCADE,
primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;;




CREATE TABLE authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username) ON DELETE CASCADE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;;


INSERT INTO users(username, password, enabled)VALUES('christos','{noop}heygoodlookin',true);
INSERT INTO users(username, password, enabled)VALUES('makis','{noop}whatyougotcookin',true);
INSERT INTO users(username, password, enabled)VALUES('nikos','{noop}howsaboutcookinsomethingupwithme',true);
 
INSERT INTO authorities(username,authority)VALUES('christos','ROLE_ADMIN');
INSERT INTO authorities(username,authority)VALUES('nikos','ROLE_ADMIN');
INSERT INTO authorities(username,authority)VALUES('makis','ROLE_USER');


INSERT INTO `course` VALUES 
	(1,'course1','syllabus','christos', 2022, 5, 0.3, 0.7),
	(2,'course2','syllabus','christos', 2022, 5, 0.4, 0.6),
	(3,'course3','syllabus','makis', 2022, 5, 0.5, 0.5);
  
INSERT INTO `student_registration` VALUES 
	(1, 1,'christos', 2021,5, 0.0, 0.0, 0.0),
	(2, 2,'nikos',1993,5, 0.0, 0.0,0.0),
	(3, 3,'giannhs',1994, 5, 0.0, 0.0,0.0),
	(4, 1,'christos1', 2021,5, 0.0, 0.0, 0.0),
	(5, 2,'nikos1',1993,5, 0.0, 0.0,0.0),
	(6, 3,'giannhs1',1994, 5, 0.0, 0.0,0.0),
	(7, 1,'christos2', 2021,5, 0.0, 0.0, 0.0),
	(8, 2,'nikos2',1993,5, 0.0, 0.0,0.0),
	(9, 3,'giannhs2',1994, 5, 0.0, 0.0,0.0),
	(10, 1,'christos3', 2021,5, 0.0, 0.0, 0.0),
	(11, 2,'nikos3',1993,5, 0.0, 0.0,0.0),
	(12, 3,'giannhs3',1994, 5, 0.0, 0.0,0.0);
  




