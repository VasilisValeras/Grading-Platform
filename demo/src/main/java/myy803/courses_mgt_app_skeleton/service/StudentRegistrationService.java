package myy803.courses_mgt_app_skeleton.service;

import java.util.List;

import myy803.courses_mgt_app_skeleton.entity.Course;
import myy803.courses_mgt_app_skeleton.entity.StudentRegistration;

public interface StudentRegistrationService {
	public List<StudentRegistration> findRegistrationByCourseId(int theId);
	public void delete(int theId);
	public void save(StudentRegistration theStudentRegistration);
	public void setStudentRegistrationGrades(StudentRegistration theStudentRegistration, double projectGrade, double finalExamsGrade);
	public List<StudentRegistration> findAll();
	public StudentRegistration findById(int theId);
}
