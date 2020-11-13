package ua.edu.ucu.tempseries;
import java.lang.Math;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] tempArr;
    private int tempArrSize;
    static final int ABSOLUTE_ZERO = -273;

    public TemperatureSeriesAnalysis() {
        tempArr = new double[]{};
        tempArrSize = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double temperature : temperatureSeries) {
            if (temperature < ABSOLUTE_ZERO) {
                throw new InputMismatchException("Value is less than -273C");
            }
        }
        tempArr = temperatureSeries;
        tempArrSize = temperatureSeries.length;
    }

    public double average() {
        if (tempArrSize == 0) {
            throw new IllegalArgumentException();
        }
        double tempSum = 0;
        for (double temperature : tempArr) {
            tempSum += temperature;
        }
        return tempSum / tempArrSize;
    }

    public double deviation() {
        if (tempArrSize == 0) {
            throw new IllegalArgumentException();
        }
        double mean = average();
        double deavSum = 0;
        for (double temperature : tempArr) {
            deavSum += Math.pow(temperature - mean, 2) ;
        }
        return Math.pow(deavSum / tempArrSize, 0.5);
    }

    public double min() {
        if (tempArrSize == 0) {
            throw new IllegalArgumentException();
        }
        double minTemp = tempArr[0];
        for (double temperature : tempArr) {
            minTemp = Math.min(minTemp, temperature);
        }
        return minTemp;
    }

    public double max() {
        if (tempArrSize == 0) {
            throw new IllegalArgumentException();
        }
        double maxTemp = tempArr[0];
        for (double temperature : tempArr) {
            maxTemp = Math.min(maxTemp, temperature);
        }
        return maxTemp;
    }

    public double findTempClosestToZero() {
        if (tempArrSize == 0) {
            throw new IllegalArgumentException();
        }
        double closestToZeroTemp = tempArr[0];
        for (double temperature : tempArr) {
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
        if (tempArrSize == 0) {
            throw new IllegalArgumentException();
        }
        double closestToValueTemp = tempArr[0];
        for (double temperature : tempArr) {
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
        if (tempArrSize == 0) {
            throw new IllegalArgumentException();
        }
        int ltArrLength = 0;
        for (double temperature : tempArr) {
            if (temperature < tempValue) {
                ltArrLength += 1;
            }
        }
        double[] ltArr = new double[ltArrLength];
        int i = 0;
        for (double temperature : tempArr) {
            if (temperature < tempValue) {
                ltArr[i] = temperature;
                i += 1;
            }
        }
        return ltArr;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (tempArrSize == 0) {
            throw new IllegalArgumentException();
        }
        int gtArrLength = 0;
        for (double temperature : tempArr) {
            if (temperature > tempValue) {
                gtArrLength += 1;
            }
        }
        double[] gtArr = new double[gtArrLength];
        int i = 0;
        for (double temperature : tempArr) {
            if (temperature > tempValue) {
                gtArr[i] = temperature;
                i += 1;
            }
        }
        return gtArr;
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {

        for (double temp : temps) {
            if (temp < ABSOLUTE_ZERO) {
                throw new InputMismatchException();
            } else if (tempArrSize == tempArr.length) {
                double[] newTempArr = new double[tempArrSize*2];
                System.arraycopy(tempArr,0 , newTempArr, 0, tempArrSize);
                tempArr = newTempArr;

            }
            tempArr[tempArrSize++] = temp;
        }
        return tempArrSize;
    }
}
