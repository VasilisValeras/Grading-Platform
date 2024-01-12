package myy803.courses_mgt_app_skeleton.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myy803.courses_mgt_app_skeleton.entity.Course;
import myy803.courses_mgt_app_skeleton.entity.StudentRegistration;


@Repository
public interface CourseDAO extends JpaRepository<Course, Integer> {
	public List<Course> findCourseByInstructorLogin(String theLogin);
	public List<Course> findAll();
	public Course findById(int theId);
}
