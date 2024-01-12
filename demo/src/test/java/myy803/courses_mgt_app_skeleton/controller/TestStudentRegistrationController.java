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
import org.springframework.web.context.WebApplicationContext;


import myy803.courses_mgt_app_skeleton.dao.StudentRegistrationDAO;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
@AutoConfigureMockMvc
public class TestStudentRegistrationController {
	@Autowired
    private WebApplicationContext context;

	@Autowired
	StudentRegistrationDAO studentRegistrationDAO;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Autowired
	private StudentRegistrationController studentRegistrationController;

	@BeforeEach
    public void setup() {
		mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .build();
    }
	
	@Test
	void testCourseControllerIsNotNull() {
		Assertions.assertNotNull(studentRegistrationController);
	}
	
	@Test
	void testMockMvcIsNotNull() {
		Assertions.assertNotNull(mockMvc);
	}
	
	
	@WithMockUser(value = "christos")
	@Test 
	void testListStudentRegistrationReturnsPage() throws Exception {
		mockMvc.perform(get("/registrations/list")).
		andExpect(status().isOk()).
		andExpect(model().attributeExists("registrations")).
		andExpect(view().name("registrations/list-registrations"));		
		
		/*
		 * A way to check stuff that are in the model
		 * andExpect(MockMvcResultMatchers.model().attribute("msg", "Hi there, Joe."))
		 */
	}
	
	
	
	
	

}
