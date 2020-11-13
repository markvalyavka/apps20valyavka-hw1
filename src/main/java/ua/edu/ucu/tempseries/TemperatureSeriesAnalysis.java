package ua.edu.ucu.tempseries;
import java.lang.Math;

public class TemperatureSeriesAnalysis {
    double [] temperatureSeries;

    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
    }

    public double average() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double tempSum = 0;
        for (double temperature : temperatureSeries) {
            tempSum += temperature;
        }
        return tempSum / temperatureSeries.length;
    }

    public double deviation() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double mean = average();
        double deavSum = 0;
        for (double temperature : temperatureSeries) {
            deavSum += Math.pow(temperature - mean, 2) ;
        }
        return Math.pow(deavSum / temperatureSeries.length, 0.5);
    }

    public double min() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double minTemp = temperatureSeries[0];
        for (double temperature : temperatureSeries) {
            minTemp = Math.min(minTemp, temperature);
        }
        return minTemp;
    }

    public double max() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double maxTemp = temperatureSeries[0];
        for (double temperature : temperatureSeries) {
            maxTemp = Math.min(maxTemp, temperature);
        }
        return maxTemp;
    }

    public double findTempClosestToZero() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double closestToZeroTemp = temperatureSeries[0];
        for (double temperature : temperatureSeries) {
            double toZeroValue = Math.abs(temperature);
            if (toZeroValue < Math.abs(closestToZeroTemp)) {
                closestToZeroTemp = temperature;
            } else if (toZeroValue == Math.abs(closestToZeroTemp)) {
                closestToZeroTemp = Math.max(closestToZeroTemp, temperature);
            }
        }
        return closestToZeroTemp;
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double closestToValueTemp = temperatureSeries[0];
        for (double temperature : temperatureSeries) {
            double toValue = Math.abs(temperature - tempValue);
            if (toValue < Math.abs(closestToValueTemp - tempValue)) {
                closestToValueTemp = temperature;
            } else if (toValue == Math.abs(closestToValueTemp - tempValue)) {
                closestToValueTemp = Math.max(closestToValueTemp, temperature);
            }
        }
        return closestToValueTemp;
    }

    public double[] findTempsLessThen(double tempValue) {
        return null;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return null;
    }

    public TempSummaryStatistics summaryStatistics() {
        return null;
    }

    public int addTemps(double... temps) {
        return 0;
    }
}
