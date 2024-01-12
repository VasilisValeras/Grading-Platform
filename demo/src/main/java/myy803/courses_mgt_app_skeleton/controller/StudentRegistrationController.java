package myy803.courses_mgt_app_skeleton.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myy803.courses_mgt_app_skeleton.entity.Course;
import myy803.courses_mgt_app_skeleton.entity.StudentRegistration;
import myy803.courses_mgt_app_skeleton.service.CourseService;
import myy803.courses_mgt_app_skeleton.service.CourseServiceImpl;
import myy803.courses_mgt_app_skeleton.service.StudentRegistrationService;

@Controller
@RequestMapping("/registrations")
public class StudentRegistrationController {
	private String username;
	
	@Autowired
	private StudentRegistrationService studentRegistrationService;
	
	public StudentRegistrationController(StudentRegistrationService theStudentRegistrationService) {
		studentRegistrationService = theStudentRegistrationService;
	}
	
	@RequestMapping("/list")
	public String listStudentRegistrations(Model theModel) {
		
		
		username = SecurityContextHolder.getContext().getAuthentication().getName();
		// get employees from db
		List<StudentRegistration> tempTheRegistrations = studentRegistrationService.findAll();
		
		List<StudentRegistration> theRegistrations = new ArrayList<>();
		
		for (StudentRegistration studentReg: tempTheRegistrations) {
			if (studentReg.getCourse().getInstructor_login().equalsIgnoreCase(username))
				theRegistrations.add(studentReg);
		}
		
		
		for (StudentRegistration studentReg: theRegistrations) {
			
			
			// set final grade calculated from the weighted average of 
			// final exams grade and project grade.
			double finalGrade = calculateFinalGrade(studentReg);
			studentReg.setFinalGrade(finalGrade);
			
			
			
			// save the updated student registration, now with final grade calculated.
			studentRegistrationService.save(studentReg);
		}
		
		theModel.addAttribute("registrations", theRegistrations);
		
		return "registrations/list-registrations";
	}
	
	@RequestMapping("/listStudentsByCourse")
	public String listStudentsByCourse(@RequestParam("courseId") int theId, Model theModel) {
		
		// get employees from db
		List<StudentRegistration> registeredStudents = studentRegistrationService.findRegistrationByCourseId(theId);
		theModel.addAttribute("registrations", registeredStudents);
		
		return "registrations/list-registrations-by-course";
	}
	
	
	


	@RequestMapping("/save")
	public String saveStudentRegistration(@ModelAttribute("registration") StudentRegistration theStudentRegistration, Model theModel) {
		
		
		double finalGrade = calculateFinalGrade(theStudentRegistration);
		theStudentRegistration.setFinalGrade(finalGrade);
		
		
		// save the employee
		studentRegistrationService.save(theStudentRegistration);
		
		
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/registrations/list";
	}
	
	@RequestMapping("/showFormForUpdate")
	// actual parameter "registrationId" corresponds to <a th:href="@{/registrations/showFormForUpdate(registrationId=${tempRegistration.id})}"
	// "registrationId" of template list-registrations.html.
	public String showFormForUpdate(@RequestParam("registrationId") int theId,
									Model theModel, ModelMap theModelMap) {
		
		// get the employee from the service
		StudentRegistration theStudentRegistration = studentRegistrationService.findById(theId);
	
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("registration", theStudentRegistration);
		
		
		
		// send over to our form
		return "registrations/registration-save-form";			
	}
	
	public double calculateFinalGrade(StudentRegistration theStudentRegistration) {
		Course course = theStudentRegistration.getCourse();
	
		double finalExamsGrade = theStudentRegistration.getFinalExamsGrade();
		double projectGrade = theStudentRegistration.getProjectGrade();
		
		double finalGrade = (course.getFinalExamsGradeWeight() * finalExamsGrade) + 
				(course.getProjectGradeWeight() * projectGrade);
				
		int decimal = (int) finalGrade; 
		double fractional = finalGrade - decimal; 
		
		if (fractional > 0.75)
			return Math.ceil(finalGrade);
		else if (fractional > 0.25)
			return decimal + 0.5;
		
		return Math.floor(finalGrade);
	}
	
	
	
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		StudentRegistration theStudentRegistration = new StudentRegistration();
		
		theModel.addAttribute("registration", theStudentRegistration);
		
				
		return "registrations/registration-save-form";
	}
	
	

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentRegId") int theId) {
		// delete the registration
		studentRegistrationService.delete(theId);
		// redirect to /registrations/list
		return "redirect:/registrations/list";
	}
	
	
	
	
	
	
	
	
}
