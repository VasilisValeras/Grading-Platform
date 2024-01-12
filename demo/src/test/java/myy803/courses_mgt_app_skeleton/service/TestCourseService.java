package myy803.courses_mgt_app_skeleton.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import myy803.courses_mgt_app_skeleton.entity.Course;

@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
public class TestCourseService {
	
	@Autowired 
	CourseService courseService;
	
	@Test
	void testCourseServiceJpaImplIsNotNull() {
		Assertions.assertNotNull(courseService);
	}
	
	
	@Test
	void testFindByIdReturnsCourseService() {
		Course storedCourse = courseService.findById(1);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("christos", storedCourse.getInstructor_login());
		Assertions.assertEquals("Operating Systems", storedCourse.getName());
		Assertions.assertEquals("Concurrency, processes and threads, context switching, synchronization, scheduling, deadlock, memory management, linking, dynamic memory allocation, dynamic address translation, virtual memory, demand paging, storage devices.", storedCourse.getSyllabus());
		
		storedCourse = courseService.findById(3);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("makis", storedCourse.getInstructor_login());
		Assertions.assertEquals("Calculus", storedCourse.getName());
		Assertions.assertEquals("Introduction to differential calculus of functions of one variable. Review of elementary functions (including exponentials and logarithms), limits, rates of change, the derivative and its properties, applications of the derivative.", storedCourse.getSyllabus());
		Assertions.assertNotEquals(6, storedCourse.getSemester());
		Assertions.assertEquals(5, storedCourse.getSemester());
	}
	
	
	
	@Test
	void testFindAllService() {
		List<Course> storedCourses = courseService.findAll();
		Assertions.assertNotNull(storedCourses);
		Assertions.assertEquals(3, storedCourses.size());
		Assertions.assertEquals("Operating Systems", storedCourses.get(0).getName());
		Assertions.assertEquals("Machine Learning", storedCourses.get(1).getName());
		Assertions.assertEquals(2022, storedCourses.get(0).getYear());
		Assertions.assertEquals(2022, storedCourses.get(1).getYear());
		Assertions.assertNotEquals(2022, storedCourses.get(2).getYear());
		Assertions.assertEquals(2020, storedCourses.get(2).getYear());
	}
	
	@Test
	void testFindByInstructorLoginService() {
		List<Course> storedCourses = courseService.findCourseByInstructorLogin("christos");
		Assertions.assertNotNull(storedCourses);
		Assertions.assertEquals(2, storedCourses.size());
		Assertions.assertEquals("Operating Systems", storedCourses.get(0).getName());
		Assertions.assertEquals("Machine Learning", storedCourses.get(1).getName());
		Assertions.assertEquals(2022, storedCourses.get(0).getYear());
		Assertions.assertEquals(2022, storedCourses.get(1).getYear());
		Assertions.assertEquals(0.2, storedCourses.get(0).getProjectGradeWeight());
		Assertions.assertEquals(0.8, storedCourses.get(0).getFinalExamsGradeWeight());
		Assertions.assertEquals(0.4, storedCourses.get(1).getProjectGradeWeight());
		Assertions.assertEquals(0.6, storedCourses.get(1).getFinalExamsGradeWeight());
		
		storedCourses = courseService.findCourseByInstructorLogin("makis");
		Assertions.assertNotNull(storedCourses);
		Assertions.assertEquals(1, storedCourses.size());
		Assertions.assertEquals("Calculus", storedCourses.get(0).getName());
		Assertions.assertNotEquals(2021, storedCourses.get(0).getYear());
		Assertions.assertEquals(2020, storedCourses.get(0).getYear());
		Assertions.assertNotEquals(0.4, storedCourses.get(0).getProjectGradeWeight());
		Assertions.assertNotEquals(0.6, storedCourses.get(0).getFinalExamsGradeWeight());
		Assertions.assertEquals(0.2, storedCourses.get(0).getProjectGradeWeight());
		Assertions.assertEquals(0.8, storedCourses.get(0).getFinalExamsGradeWeight());
	}
	
	@Test
	void testSaveService() {
		Course course = new Course(4, "Databases", "ER and relational schemas, relational algebra and calculus, SQL, normalization, B and B+ trees, database indices.", "nikos", 2021, 6, 0.3, 0.7);
		courseService.save(course);
		Course storedCourse = courseService.findById(4);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("Databases", storedCourse.getName());
		Assertions.assertNotEquals("databases", storedCourse.getName());
		Assertions.assertEquals(6, storedCourse.getSemester());
		Assertions.assertNotEquals(5, storedCourse.getSemester());
		Assertions.assertEquals("nikos", storedCourse.getInstructor_login());
		Assertions.assertNotEquals("makis", storedCourse.getInstructor_login());
		Assertions.assertNotEquals("christos", storedCourse.getInstructor_login());
		Assertions.assertEquals("ER and relational schemas, relational algebra and calculus, SQL, normalization, B and B+ trees, database indices.", storedCourse.getSyllabus());
		Assertions.assertNotEquals("ER and relational schemas, relational algebra and calculus, SQL, normalization, \"\r\n" + 
				"				+ \"B and B+ trees, database indices", storedCourse.getSyllabus());
	}
	
	@Test
	void testUpdateService() {
		Course course = new Course(4, "Databases", "ER and relational schemas, relational algebra and calculus, SQL, normalization, B and B+ trees, database indices.", "nikos", 2021, 6, 0.3, 0.7);
		courseService.save(course);
		Course storedCourse = courseService.findById(4);
		Assertions.assertEquals("Databases", storedCourse.getName());
		course = new Course(4, "Databases2", "ER and relational schemas, relational algebra and calculus, SQL, normalization, B and B+ trees, database indices.", "nikos", 2021, 6, 0.3, 0.7);
		courseService.save(course);
		storedCourse = courseService.findById(4);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("Databases2", storedCourse.getName());
		courseService.delete(4);
	}
	
	
	@Test
	void testDeleteService() {
		Course course = new Course(4, "Databases", "ER and relational schemas, relational algebra and calculus, SQL, normalization, B and B+ trees, database indices.", "nikos", 2021, 6, 0.3, 0.7);
		courseService.save(course);
		Course storedCourse = courseService.findById(4);
		Assertions.assertNotNull(storedCourse);
		courseService.delete(4);
		storedCourse = courseService.findById(4);
		Assertions.assertNull(storedCourse);
	}
	
	
	

	

}
