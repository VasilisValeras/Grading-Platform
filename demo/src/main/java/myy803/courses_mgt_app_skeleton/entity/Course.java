package myy803.courses_mgt_app_skeleton.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="course")
public class Course {
	// define fields
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@NonNull
	private int id;
		
	@Column(name="name")
	private String name;
	
	@Column(name="instructor_login")
	private String instructorLogin;
		
	@Column(name="syllabus")
	private String syllabus;
		
	@Column(name="year")
	private int year;
	
	@Column(name="semester")
	private int semester;
	
	@Column(name="project_grade_weight")
	private double projectGradeWeight;
	
	@Column(name="final_exams_grade_weight")
	private double finalExamsGradeWeight;
	
	@OneToMany(mappedBy = "course",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	
	private List<StudentRegistration> student_registration = new ArrayList<>(); 

	
	
	public Course() {
	}
	
	public Course(int id, String name, String syllabus, String instructorLogin, int year, int semester, 
			double projectGradeWeight, double finalExamsGradeWeight) {
		this.id = id;
		this.name = name;
		this.instructorLogin = instructorLogin;
		this.syllabus = syllabus;
		this.year = year;
		this.semester = semester;
		this.projectGradeWeight = projectGradeWeight;
		this.finalExamsGradeWeight = finalExamsGradeWeight;
	}


	public Course(String name, String syllabus, String instructorLogin, int year, int semester, 
			double projectGradeWeight, double finalExamsGradeWeight) {
		this.name = name;
		this.instructorLogin = instructorLogin;
		this.syllabus = syllabus;
		this.year = year;
		this.semester = semester;
		this.projectGradeWeight = projectGradeWeight;
		this.finalExamsGradeWeight = finalExamsGradeWeight;
	}
	
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSyllabus() {
		return syllabus;
	}

	public int getYear() {
		return year;
	}

	public int getSemester() {
		return semester;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public String getInstructor_login() {
		return instructorLogin;
	}

	public void setInstructor_login(String instructorLogin) {
		this.instructorLogin = instructorLogin;
	}
	
	public String getInstructorLogin() {
		return instructorLogin;
	}

	

	public void setInstructorLogin(String instructorLogin) {
		this.instructorLogin = instructorLogin;
	}


	public List<StudentRegistration> getStudent_registration() {
		return student_registration;
	}

	public void setStudent_registration(List<StudentRegistration> student_registration) {
		this.student_registration = student_registration;
	}

	public double getProjectGradeWeight() {
		return projectGradeWeight;
	}

	public double getFinalExamsGradeWeight() {
		return finalExamsGradeWeight;
	}


	public void setProjectGradeWeight(double projectGradeWeight) {
		this.projectGradeWeight = projectGradeWeight;
	}

	public void setFinalExamsGradeWeight(double finalExamsGradeWeight) {
		this.finalExamsGradeWeight = finalExamsGradeWeight;
	}



	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", instructorLogin=" + instructorLogin + ", syllabus=" + syllabus
				+ ", year=" + year + ", semester=" + semester + ", projectGradeWeight=" + projectGradeWeight
				+ ", finalExamsGradeWeight=" + finalExamsGradeWeight + "]";
	}

	
	




	
	
	
	
	
	

		
}
