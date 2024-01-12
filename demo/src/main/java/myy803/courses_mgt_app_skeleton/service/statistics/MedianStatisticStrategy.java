package myy803.courses_mgt_app_skeleton.service.statistics;



public class MedianStatisticStrategy extends TemplateStatisticStrategy implements StatisticStrategy {
	
	public double calculateStatistic() {
		return descriptiveStatistics.getPercentile(50);
	}
	
}
