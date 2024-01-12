package myy803.courses_mgt_app_skeleton.service;

import java.util.List;

import myy803.courses_mgt_app_skeleton.entity.Course;
import myy803.courses_mgt_app_skeleton.entity.StudentRegistration;

public interface CourseService {
	// private List<StatisticStrategy> statCalculationStrategies;
	public List<Course> findCourseByInstructorLogin(String theLogin);
	public void delete(int theId);
	public void save(Course theCourse);
	public void addStudentRegistrationToCourseList(Course theCourse, StudentRegistration theStudentRegistration);
	public Course findById(int theId);
	public List<Course> findAll();
}
