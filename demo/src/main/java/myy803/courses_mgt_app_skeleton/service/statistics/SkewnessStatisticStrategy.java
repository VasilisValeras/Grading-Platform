package myy803.courses_mgt_app_skeleton.service.statistics;


public class SkewnessStatisticStrategy extends TemplateStatisticStrategy implements StatisticStrategy {
	
	
	public double calculateStatistic() {
		return descriptiveStatistics.getSkewness();
	}
}
