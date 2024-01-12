package myy803.courses_mgt_app_skeleton.service;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import myy803.courses_mgt_app_skeleton.dao.CourseDAO;
import myy803.courses_mgt_app_skeleton.entity.Course;
import myy803.courses_mgt_app_skeleton.entity.StudentRegistration;

@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
public class TestStudentRegistrationService {
	@Autowired 
	StudentRegistrationService studentRegistrationService;
	@Autowired 
	CourseService courseService;
	
	@Test
	void testStudentRegistrationServiceJpaImplIsNotNull() {
		Assertions.assertNotNull(studentRegistrationService);
	}
	
	@Test
	void testFindByIdReturnsStudentRegistrationService() {
		StudentRegistration storedStudentRegistration = studentRegistrationService.findById(14);
		Assertions.assertNotNull(storedStudentRegistration);
		Assertions.assertEquals(1, storedStudentRegistration.getCourse().getId());
		Assertions.assertEquals("Operating Systems", storedStudentRegistration.getCourse().getName());
		Assertions.assertEquals("christos", storedStudentRegistration.getCourse().getInstructor_login());
		Assertions.assertEquals("Makis Triantafullopoulos", storedStudentRegistration.getName());
		Assertions.assertEquals(2017, storedStudentRegistration.getYearOfRegistration());
		Assertions.assertEquals(7.5, storedStudentRegistration.getProjectGrade());
		Assertions.assertEquals(8.5, storedStudentRegistration.getFinalExamsGrade());
		Assertions.assertEquals(8.5, storedStudentRegistration.getFinalGrade());
		
		storedStudentRegistration = studentRegistrationService.findById(22);
		Assertions.assertNotNull(storedStudentRegistration);
		Assertions.assertEquals(3, storedStudentRegistration.getCourse().getId());
		Assertions.assertEquals("Calculus", storedStudentRegistration.getCourse().getName());
		Assertions.assertEquals("makis", storedStudentRegistration.getCourse().getInstructor_login());
		Assertions.assertEquals("Octavian Oliver Godji", storedStudentRegistration.getName());
		Assertions.assertEquals(2018, storedStudentRegistration.getYearOfRegistration());
		Assertions.assertEquals(6.5, storedStudentRegistration.getProjectGrade());
		Assertions.assertEquals(3.5, storedStudentRegistration.getFinalExamsGrade());
		Assertions.assertEquals(4, storedStudentRegistration.getFinalGrade());
	}
	
	@Test
	void testFindAllService() {
		List<StudentRegistration> storedStudentRegistrations = studentRegistrationService.findAll();
		Assertions.assertNotNull(storedStudentRegistrations);
		Assertions.assertEquals(7, storedStudentRegistrations.size());
		Assertions.assertEquals(3, storedStudentRegistrations.get(5).getCourse().getId());
		Assertions.assertEquals("Calculus", storedStudentRegistrations.get(5).getCourse().getName());
		Assertions.assertEquals("makis", storedStudentRegistrations.get(5).getCourse().getInstructor_login());
		Assertions.assertEquals("Octavian Oliver Godji", storedStudentRegistrations.get(5).getName());
		Assertions.assertEquals(2018, storedStudentRegistrations.get(5).getYearOfRegistration());
		Assertions.assertEquals(6.5, storedStudentRegistrations.get(5).getProjectGrade());
		Assertions.assertEquals(3.5, storedStudentRegistrations.get(5).getFinalExamsGrade());
		Assertions.assertEquals(4, storedStudentRegistrations.get(5).getFinalGrade());
	}
	
	
	@Test
	void testFindRegistrationByCourseIdService() {
		List<StudentRegistration> storedStudentRegistrations = studentRegistrationService.findRegistrationByCourseId(3);
		Assertions.assertNotNull(storedStudentRegistrations);
		Assertions.assertEquals(3, storedStudentRegistrations.size());
		Assertions.assertNotNull(storedStudentRegistrations);
		Assertions.assertEquals(3, storedStudentRegistrations.get(1).getCourse().getId());
		Assertions.assertEquals("Calculus", storedStudentRegistrations.get(1).getCourse().getName());
		Assertions.assertEquals("makis", storedStudentRegistrations.get(1).getCourse().getInstructor_login());
		Assertions.assertEquals("Octavian Oliver Godji", storedStudentRegistrations.get(1).getName());
		Assertions.assertEquals(2018, storedStudentRegistrations.get(1).getYearOfRegistration());
		Assertions.assertEquals(6.5, storedStudentRegistrations.get(1).getProjectGrade());
		Assertions.assertEquals(3.5, storedStudentRegistrations.get(1).getFinalExamsGrade());
		Assertions.assertEquals(4, storedStudentRegistrations.get(1).getFinalGrade());
	}
	
	
	@Test
	void testSaveService() {
		Course course = courseService.findById(1);
		
		StudentRegistration studentRegistration = new StudentRegistration(1, "Nikos Poutestaroume", 2017, 10, 
				8.0, 6.5, course);
		
		studentRegistrationService.save(studentRegistration);
		StudentRegistration storedStudentRegistration = studentRegistrationService.findById(1);
		Assertions.assertNotNull(storedStudentRegistration);
		Assertions.assertEquals(1, storedStudentRegistration.getCourse().getId());
		Assertions.assertEquals("Operating Systems", storedStudentRegistration.getCourse().getName());
		Assertions.assertEquals("Nikos Poutestaroume", storedStudentRegistration.getName());
		Assertions.assertEquals(2017, storedStudentRegistration.getYearOfRegistration());
		Assertions.assertEquals(10, storedStudentRegistration.getSemester());
		Assertions.assertEquals(8, storedStudentRegistration.getProjectGrade());
		Assertions.assertEquals(6.5, storedStudentRegistration.getFinalExamsGrade());
	}
	
	
	@Test
	void testDeleteService() {
		Course course = courseService.findById(1);
		StudentRegistration studentRegistration = new StudentRegistration(1, "Nikos Poutestaroume", 2017, 10, 
				8.0, 6.5, course);
		
		studentRegistrationService.save(studentRegistration);
		StudentRegistration storedStudentRegistration = studentRegistrationService.findById(1);
		Assertions.assertNotNull(storedStudentRegistration);
		studentRegistrationService.delete(1);
		storedStudentRegistration = studentRegistrationService.findById(1);
		Assertions.assertNull(storedStudentRegistration);
	}
	
	@Test
	void testUpdateService() {
		Course course = courseService.findById(1);
		StudentRegistration storedStudentRegistration = new StudentRegistration(1, "Giannhs Poutestaroume", 2018, 8, 
				6.0, 6.0, course);
		studentRegistrationService.save(storedStudentRegistration);
		storedStudentRegistration = studentRegistrationService.findById(1);
		Assertions.assertEquals("Giannhs Poutestaroume", storedStudentRegistration.getName());
		storedStudentRegistration = new StudentRegistration(1, "Nikos Poutestaroume", 2017, 10,
				8.0, 6.5, course);
		Assertions.assertNotNull(storedStudentRegistration);
		Assertions.assertEquals("Nikos Poutestaroume", storedStudentRegistration.getName());
		studentRegistrationService.delete(1);
	}
	
	
}
