package myy803.courses_mgt_app_skeleton.service.statistics;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import myy803.courses_mgt_app_skeleton.entity.Course;
import myy803.courses_mgt_app_skeleton.entity.Statistic;
import myy803.courses_mgt_app_skeleton.entity.StudentRegistration;

public abstract class TemplateStatisticStrategy implements StatisticStrategy {
	
	protected DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
	
	
	public abstract double calculateStatistic();
	
	
	public void prepareDataSet(Course theCourse) {
			
		for (StudentRegistration studentReg : theCourse.getStudent_registration()) {
			double value = studentReg.getFinalGrade();
			this.descriptiveStatistics.addValue(value);
		}
	
	}
	
	
	
	
}
