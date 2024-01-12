package myy803.courses_mgt_app_skeleton.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myy803.courses_mgt_app_skeleton.entity.Course;
import myy803.courses_mgt_app_skeleton.entity.Statistic;
import myy803.courses_mgt_app_skeleton.service.CourseService;
import myy803.courses_mgt_app_skeleton.service.statistics.KurtosisStatisticStrategy;
import myy803.courses_mgt_app_skeleton.service.statistics.MaxStatisticStrategy;
import myy803.courses_mgt_app_skeleton.service.statistics.MeanStatisticStrategy;
import myy803.courses_mgt_app_skeleton.service.statistics.MedianStatisticStrategy;
import myy803.courses_mgt_app_skeleton.service.statistics.MinStatisticStrategy;
import myy803.courses_mgt_app_skeleton.service.statistics.SkewnessStatisticStrategy;
import myy803.courses_mgt_app_skeleton.service.statistics.StatisticStrategy;
import myy803.courses_mgt_app_skeleton.service.statistics.StatisticStrategyFactory;
import myy803.courses_mgt_app_skeleton.service.statistics.StdDeviationStatisticStrategy;
import myy803.courses_mgt_app_skeleton.service.statistics.TemplateStatisticStrategy;
import myy803.courses_mgt_app_skeleton.service.statistics.VarianceStatisticStrategy;



@Controller
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	CourseService courseService;

	private String username;
	
	public CourseController(CourseService theCourseService) {
		courseService = theCourseService;
	}
	
	
	public Statistic getStatsForCourse(Course theCourse) {
		StatisticStrategy statSniffer;
	
		Statistic stat = Statistic.getInstance();
		
        statSniffer = StatisticStrategyFactory.getStatisticStrategy("mean");
        statSniffer.prepareDataSet(theCourse);
        stat.setMean(statSniffer.calculateStatistic());
       
           
        statSniffer = StatisticStrategyFactory.getStatisticStrategy("max");
        statSniffer.prepareDataSet(theCourse);
        stat.setMax(statSniffer.calculateStatistic());
            
        statSniffer = StatisticStrategyFactory.getStatisticStrategy("min");
        statSniffer.prepareDataSet(theCourse);
        stat.setMin(statSniffer.calculateStatistic());
            
        statSniffer = StatisticStrategyFactory.getStatisticStrategy("std_deviation");
        statSniffer.prepareDataSet(theCourse);
        stat.setStd_deviation(statSniffer.calculateStatistic());
            
        statSniffer = StatisticStrategyFactory.getStatisticStrategy("variance");
        statSniffer.prepareDataSet(theCourse);
        stat.setVariance(statSniffer.calculateStatistic());
            
        statSniffer = StatisticStrategyFactory.getStatisticStrategy("median");
        statSniffer.prepareDataSet(theCourse);
        stat.setMedian(statSniffer.calculateStatistic());
            
        statSniffer = StatisticStrategyFactory.getStatisticStrategy("kurtosis");
        statSniffer.prepareDataSet(theCourse);
        stat.setKurtosis(statSniffer.calculateStatistic());
            
        statSniffer = StatisticStrategyFactory.getStatisticStrategy("skewness");
        statSniffer.prepareDataSet(theCourse);
        stat.setSkewness(statSniffer.calculateStatistic());
          
        return stat;
	}
	
	@RequestMapping("/list")
	public String listCourses(Model theModel) {
		
		
		username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		// get employees from db
		List<Course> theCourses = courseService.findCourseByInstructorLogin(username);
				
		theModel.addAttribute("courses", theCourses);
		
		return "courses/list-courses";
	}
	
	@RequestMapping("/showCourseStats")
	public String courseStats(@RequestParam("courseId") int theId, Model theModel) {
		Course theCourse = courseService.findById(theId);
		
		Statistic courseStat = getStatsForCourse(theCourse);
		
	
		theModel.addAttribute("stats", courseStat);
		return "courses/list-course-stats";
	}
	
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Course theCourse = new Course();
		
		theModel.addAttribute("course", theCourse);
		
		return "courses/course-save-form";
	}
	
	@RequestMapping("/save")
	public String saveCourse(@ModelAttribute("course") Course theCourse, Model theModel) {
		
		// save the employee
		courseService.save(theCourse);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/courses/list";
	}
	
	@RequestMapping("/showFormForUpdate")
	// actual parameter "registrationId" corresponds to <a th:href="@{/registrations/showFormForUpdate(registrationId=${tempRegistration.id})}"
	// "registrationId" of template list-registrations.html.
	public String showFormForUpdate(@RequestParam("courseId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Course theCourse = courseService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("course", theCourse);
		
		// send over to our form
		return "courses/course-save-form";			
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("courseId") int theId) {
		// delete the registration
		courseService.delete(theId);
		// redirect to /registrations/list
		return "redirect:/courses/list";
	}
	
	
	
	
	

}
