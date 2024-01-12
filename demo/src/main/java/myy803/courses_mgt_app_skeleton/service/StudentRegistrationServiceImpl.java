package myy803.courses_mgt_app_skeleton.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import myy803.courses_mgt_app_skeleton.dao.StudentRegistrationDAO;
import myy803.courses_mgt_app_skeleton.entity.Course;
import myy803.courses_mgt_app_skeleton.entity.StudentRegistration;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {
	@Autowired
	private StudentRegistrationDAO studentRegistrationRepository;
	
	public StudentRegistrationServiceImpl() {
		super();
	}

	@Autowired
	public StudentRegistrationServiceImpl(StudentRegistrationDAO theStudentRegistrationRepository) {
		studentRegistrationRepository = theStudentRegistrationRepository;
	}
	

	
	@Override
	@Transactional
	public List<StudentRegistration> findAll() {
		return studentRegistrationRepository.findAll();
	}
	
	

	
	@Override
	@Transactional
	public List<StudentRegistration> findRegistrationByCourseId(int theId) {
		List<StudentRegistration> result = studentRegistrationRepository.findRegistrationByCourseId(theId);
		
		if (result != null )
			return result;
		else
			return null;
	}

	@Override
	@Transactional
	public void delete(int theId) {
		studentRegistrationRepository.deleteById(theId);
		
	}

	@Override
	@Transactional
	public void save(StudentRegistration theStudentRegistration) {
		studentRegistrationRepository.save(theStudentRegistration);
		
	}
	
	
	
	public void setStudentRegistrationGrades(StudentRegistration theStudentRegistration, double projectGrade, double finalExamsGrade) {
		theStudentRegistration.setProjectGrade(projectGrade);
		theStudentRegistration.setFinalExamsGrade(finalExamsGrade);
	}

	@Override
	@Transactional
	public StudentRegistration findById(int theId) {
		StudentRegistration result = studentRegistrationRepository.findById(theId);
		
		if (result != null )
			return result;
		else
			return null;
	}
	
		
	
	
	
	
	
	
	

}
