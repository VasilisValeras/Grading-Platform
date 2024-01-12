package myy803.courses_mgt_app_skeleton.service.statistics;

public class StatisticStrategyFactory{
	
	public static  StatisticStrategy getStatisticStrategy(String statisticStrategyName) throws IllegalArgumentException { 
		
		if (statisticStrategyName == null || statisticStrategyName.isEmpty())
	        return null;
		
	    if (statisticStrategyName.equalsIgnoreCase("mean"))
	        return new MeanStatisticStrategy();
	    
	    if (statisticStrategyName.equalsIgnoreCase("max"))
	        return new MaxStatisticStrategy();
	    
	    if (statisticStrategyName.equalsIgnoreCase("min"))
	        return new MinStatisticStrategy();
	    
	    if (statisticStrategyName.equalsIgnoreCase("std_deviation"))
	        return new StdDeviationStatisticStrategy();
	    
	    if (statisticStrategyName.equalsIgnoreCase("variance"))
	        return new VarianceStatisticStrategy();
	    
	    if (statisticStrategyName.equalsIgnoreCase("median"))
	        return new MedianStatisticStrategy();
	    
	    if (statisticStrategyName.equalsIgnoreCase("kurtosis"))
	        return new KurtosisStatisticStrategy();
	    
	    if (statisticStrategyName.equalsIgnoreCase("skewness"))
	        return new SkewnessStatisticStrategy();
	    
	    else 
	    	throw new IllegalArgumentException();  
	}
}
