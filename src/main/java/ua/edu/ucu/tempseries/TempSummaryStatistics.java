package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private final double avgTemperature;
    private final double devTemperature;
    private final double minTemperature;
    private final double maxTemperature;


    public TempSummaryStatistics(double avgTemperature, double devTemperature,
                                 double minTemperature, double maxTemperature) {
        this.avgTemperature = avgTemperature;
        this.devTemperature = devTemperature;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public double getAvgTemperature() { return avgTemperature; }

    public double getDevTemperature() { return devTemperature; }

    public double getMinTemperature() { return minTemperature; }

    public double getMaxTemperature() { return maxTemperature; }
}
