package myy803.courses_mgt_app_skeleton.entity;



public class Statistic {
	
	private static Statistic singleInstance = null;
	
	private double mean;
	private double max;
	private double min;
	private double std_deviation;
	private double variance;
	private double median;
	private double kurtosis;
	private double skewness;
	
	
	public static Statistic getInstance() {
		if (singleInstance == null)
			singleInstance = new Statistic();
		return singleInstance;
	}
	
	 
	public Statistic() {}


	public Statistic(double mean, double max, double min, double std_deviation, double variance, double median,
			double kurtosis, double skewness) {
		super();
		this.mean = mean;
		this.max = max;
		this.min = min;
		this.std_deviation = std_deviation;
		this.variance = variance;
		this.median = median;
		this.kurtosis = kurtosis;
		this.skewness = skewness;
	}


	public double getMean() {
		return mean;
	}


	public double getMax() {
		return max;
	}


	public double getMin() {
		return min;
	}


	public double getStd_deviation() {
		return std_deviation;
	}


	public double getVariance() {
		return variance;
	}


	public double getMedian() {
		return median;
	}


	public double getKurtosis() {
		return kurtosis;
	}


	public double getSkewness() {
		return skewness;
	}


	public void setMean(double mean) {
		this.mean = mean;
	}


	public void setMax(double max) {
		this.max = max;
	}


	public void setMin(double min) {
		this.min = min;
	}


	public void setStd_deviation(double std_deviation) {
		this.std_deviation = std_deviation;
	}


	public void setVariance(double variance) {
		this.variance = variance;
	}


	public void setMedian(double median) {
		this.median = median;
	}


	public void setKurtosis(double kurtosis) {
		this.kurtosis = kurtosis;
	}


	public void setSkewness(double skewness) {
		this.skewness = skewness;
	}


	@Override
	public String toString() {
		return "Statistic [mean=" + mean + ", max=" + max + ", min=" + min + ", std_deviation=" + std_deviation
				+ ", variance=" + variance + ", median=" + median + ", kurtosis=" + kurtosis + ", skewness=" + skewness
				+ "]";
	}
	
	
	 
	 
	 
	 
	 
	 
	 

}
