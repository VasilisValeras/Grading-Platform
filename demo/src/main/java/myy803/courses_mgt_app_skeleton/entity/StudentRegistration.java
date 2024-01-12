package myy803.courses_mgt_app_skeleton.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;
import java.lang.Math;

@Entity
@Table(name="student_registration")
public class StudentRegistration {
	// define fields
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NonNull
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	
	private String name;
		
	@Column(name="year_of_registration ")
	
	private int yearOfRegistration;
		
	@Column(name="semester")

	private int semester;
	
	@Column(name="project_grade")
	private double projectGrade;
	
	@Column(name="final_exams_grade")
	private double finalExamsGrade;
	
	@Column(name="final_grade")
	private double finalGrade;
	
	@ManyToOne
	@JoinColumn(name = "idC")
	private Course course;
	
	

	public StudentRegistration() {
	}
	
	public StudentRegistration(int id, String name, int yearOfRegistration, int semester, double projectGrade, 
			double finalExamsGrade, Course course) {
		this.id = id;
		this.name = name;
		this.yearOfRegistration = yearOfRegistration;
		this.semester = semester;
		this.projectGrade = projectGrade;
		this.finalExamsGrade = finalExamsGrade;
		this.course = course;
	}


	public StudentRegistration(String name, int yearOfRegistration, int semester, double projectGrade, 
			double finalExamsGrade, Course course) {
		this.name = name;
		this.yearOfRegistration = yearOfRegistration;
		this.semester = semester;
		this.projectGrade = projectGrade;
		this.finalExamsGrade = finalExamsGrade;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getYearOfRegistration() {
		return yearOfRegistration;
	}

	public int getSemester() {
		return semester;
	}

	public double getProjectGrade() {
		return projectGrade;
	}

	public double getFinalExamsGrade() {
		return finalExamsGrade;
	}

	public double getFinalGrade() {
		return finalGrade;
	}

	public Course getCourse() {
		return course;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setYearOfRegistration(int yearOfRegistration) {
		this.yearOfRegistration = yearOfRegistration;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public void setProjectGrade(double projectGrade) {
		this.projectGrade = projectGrade;
	}

	public void setFinalExamsGrade(double finalExamsGrade) {
		this.finalExamsGrade = finalExamsGrade;
	}

	public void setFinalGrade(double finalGrade) {
		this.finalGrade = finalGrade;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "StudentRegistration [id=" + id + ", name=" + name + ", yearOfRegistration=" + yearOfRegistration
				+ ", semester=" + semester + ", projectGrade=" + projectGrade + ", finalExamsGrade=" + finalExamsGrade
				+ ", finalGrade=" + finalGrade + "]";
	}
	
	
	
	
	



	
	
	
	
	
	
	

		
}
