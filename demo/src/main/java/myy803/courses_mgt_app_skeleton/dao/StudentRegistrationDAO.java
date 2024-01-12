package myy803.courses_mgt_app_skeleton.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myy803.courses_mgt_app_skeleton.entity.Course;
import myy803.courses_mgt_app_skeleton.entity.StudentRegistration;

@Repository
public interface StudentRegistrationDAO extends JpaRepository<StudentRegistration, Integer> {
	public List<StudentRegistration> findRegistrationByCourseId(int theId);
	public List<StudentRegistration> findAll();
	public StudentRegistration findById(int theId);
	
}
