package myy803.courses_mgt_app_skeleton.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import myy803.courses_mgt_app_skeleton.dao.CourseDAO;
import myy803.courses_mgt_app_skeleton.entity.Course;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
@AutoConfigureMockMvc
public class TestCourseController {
	@Autowired
    private WebApplicationContext context;

	@Autowired
	CourseDAO courseDAO;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	CourseController courseController;

	@BeforeEach
    public void setup() {
		mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .build();
    }
	
	@Test
	void testCourseControllerIsNotNull() {
		Assertions.assertNotNull(courseController);
	}
	
	@Test
	void testMockMvcIsNotNull() {
		Assertions.assertNotNull(mockMvc);
	}
	
	
	@WithMockUser(value = "christos")
	@Test 
	void testListCourseReturnsPage() throws Exception {
		mockMvc.perform(get("/courses/list")).
		andExpect(status().isOk()).
		andExpect(model().attributeExists("courses")).
		andExpect(view().name("courses/list-courses"));		
		
		/*
		 * A way to check stuff that are in the model
		 * andExpect(MockMvcResultMatchers.model().attribute("msg", "Hi there, Joe."))
		 */
	}
	
	@WithMockUser(value = "christos")
	@Test 
	void testSaveCourseReturnsPage() throws Exception {
		
		Course course = new Course(4, "Databases", "ER and relational schemas, relational algebra and calculus, SQL, normalization, B and B+ trees, database indices.", "nikos", 2021, 6, 0.3, 0.7);
		
	    	    
	    MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
	   
	    
	    multiValueMap.add("id", Integer.toString(course.getId()));
	    multiValueMap.add("name", course.getName());
	    multiValueMap.add("instructorLogin", course.getInstructorLogin());
	    multiValueMap.add("syllabus", course.getSyllabus());
	    multiValueMap.add("year", Integer.toString(course.getYear()));
	    multiValueMap.add("semester", Integer.toString(course.getSemester()));
	    multiValueMap.add("projectGradeWeight", Double.toString(course.getProjectGradeWeight()));
	    multiValueMap.add("finalExamsGradeWeight", Double.toString(course.getFinalExamsGradeWeight()));
	 
	    
		mockMvc.perform(
				post("/courses/save").
			    params(multiValueMap)).
				andExpect(status().isFound()).
				andExpect(view().name("redirect:/courses/list"));	
	}
	
	@WithMockUser(value = "christos")
	@Test 
	void testDeleteCourseReturnsPage() throws Exception {
		
		Course course = new Course(4, "Databases", "ER and relational schemas, relational algebra and calculus, SQL, normalization, B and B+ trees, database indices.", "nikos", 2021, 6, 0.3, 0.7);
		
	    	    
	    MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
	    
	    multiValueMap.add("id", Integer.toString(course.getId()));
	    multiValueMap.add("name", course.getName());
	    multiValueMap.add("instructorLogin", course.getInstructorLogin());
	    multiValueMap.add("syllabus", course.getSyllabus());
	    multiValueMap.add("year", Integer.toString(course.getYear()));
	    multiValueMap.add("semester", Integer.toString(course.getSemester()));
	    
		mockMvc.perform(
				post("/courses/delete?courseId=4").
			    params(multiValueMap)).
				andExpect(status().isFound()).
				andExpect(view().name("redirect:/courses/list"));	
	}
	
	@WithMockUser(value = "christos")
	@Test 
	void testUpdateCourseReturnsPage() throws Exception {
		
		Course course = new Course(4, "Databases", "ER and relational schemas, relational algebra and calculus, SQL, normalization, B and B+ trees, database indices.", "nikos", 2021, 6, 0.3, 0.7);
		
	    	    
	    MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
	   
	    
	    multiValueMap.add("id", Integer.toString(course.getId()));
	    multiValueMap.add("name", course.getName());
	    multiValueMap.add("instructorLogin", course.getInstructorLogin());
	    multiValueMap.add("syllabus", course.getSyllabus());
	    multiValueMap.add("year", Integer.toString(course.getYear()));
	    multiValueMap.add("semester", Integer.toString(course.getSemester()));
	    multiValueMap.add("projectGradeWeight", Double.toString(course.getProjectGradeWeight()));
	    multiValueMap.add("finalExamsGradeWeight", Double.toString(course.getFinalExamsGradeWeight()));
	 
	    
		mockMvc.perform(
				post("/courses/save").
			    params(multiValueMap)).
				andExpect(status().isFound()).
				andExpect(view().name("redirect:/courses/list"));	
		
		
		course = new Course(4, "Databases2", "ER and relational schemas, relational algebra and calculus, SQL, normalization, B and B+ trees, database indices.", "christos", 2020, 8, 0.2, 0.8);
		
	    
	    multiValueMap = new LinkedMultiValueMap<>();
	   
	    
	    multiValueMap.add("id", Integer.toString(course.getId()));
	    multiValueMap.add("name", course.getName());
	    multiValueMap.add("instructorLogin", course.getInstructorLogin());
	    multiValueMap.add("syllabus", course.getSyllabus());
	    multiValueMap.add("year", Integer.toString(course.getYear()));
	    multiValueMap.add("semester", Integer.toString(course.getSemester()));
	    multiValueMap.add("projectGradeWeight", Double.toString(course.getProjectGradeWeight()));
	    multiValueMap.add("finalExamsGradeWeight", Double.toString(course.getFinalExamsGradeWeight()));
	    
	    mockMvc.perform(
				post("/courses/save").
			    params(multiValueMap)).
				andExpect(status().isFound()).
				andExpect(view().name("redirect:/courses/list"));	
	    
	    Assertions.assertEquals("Databases2", courseDAO.findById(4).getName());
	    Assertions.assertEquals("christos", courseDAO.findById(4).getInstructor_login());
	    Assertions.assertEquals(2020, courseDAO.findById(4).getYear());
	    Assertions.assertEquals(8, courseDAO.findById(4).getSemester());
	    Assertions.assertEquals(0.2, courseDAO.findById(4).getProjectGradeWeight());
	    Assertions.assertEquals(0.8, courseDAO.findById(4).getFinalExamsGradeWeight());
	    
	    
	    mockMvc.perform(
				post("/courses/delete?courseId=4").
			    params(multiValueMap)).
				andExpect(status().isFound()).
				andExpect(view().name("redirect:/courses/list"));
	}
	
	
	
	

	
	
	
}
