package myy803.courses_mgt_app_skeleton.service.statistics;


public class KurtosisStatisticStrategy extends TemplateStatisticStrategy implements StatisticStrategy {

	public double calculateStatistic() {
		return descriptiveStatistics.getKurtosis();
	}

}
