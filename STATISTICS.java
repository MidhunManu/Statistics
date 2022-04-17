package Statistics;

import java.util.Arrays;
import java.lang.Math;

public class STATISTICS {
    public double mean(double[] array) {
        int length = array.length;
        double sum = 0;

        for (int i = 0; i < length; i++) {
            sum += array[i];
        }

        return sum / length;
    }

    public double median(double[] array) {
        Arrays.sort(array);
        int length = array.length;

        if (length % 2 == 0) {
            double ans = (double) (array[(length - 1) / 2] + array[length / 2]);
            return ans / 2.0;
        } else
            return array[length / 2];
    }

    public double mode(double[] array) {
        double maxValue = 0, maxCount = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = 0; j < length; j++) {
                if (array[j] == array[i])
                    count++;
            }

            if (count > maxCount) {
                maxCount = count;
                maxValue = array[i];
            }

        }

        return maxValue;
    }

    public double summation(double[] array) {
        int length = array.length;
        double sum = 0;

        for (int i = 0; i < length; i++)
            sum += array[i];
        return sum;

    }

    public double squareSummation(double[] array) {
        int length = array.length;
        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum += array[i] * array[i];
        }

        return sum;
    }

    public double squareMean(double[] array) {
        int length = array.length;
        double ans = squareSummation(array); // ans = sum of all elements of the array ,
        // actually I couldn't come with a good name
        return ans / length;
    }

    public double standardDaviation(double[] array) {
        double std = 0.0;
        for (int i = 0; i < array.length; i++) {
            std = std + Math.pow(array[i] - mean(array), 2);
        }
        double sq = std / array.length;
        return Math.sqrt(sq);
    }

    public double variance(double[] array) {
        return Math.pow(standardDaviation(array), 2);
    }

    public double sumofProducts(double[] array1, double[] array2) {
        int length1 = array1.length;
        double sum = 0.0;
        for (int i = 0; i < length1; i++) {
            sum += array1[i] * array2[i];
        }
        return sum;
    }

    public double covariance(double[] array1, double[] array2) {
        double sumOfXY = sumofProducts(array1, array2);
        double length = array1.length;
        double mean1 = mean(array1);
        double mean2 = mean(array2);

        return (sumOfXY / length) - mean1 * mean2;
    }

    public double correlationCoefficient(double[] array1, double[] array2) {
        return covariance(array1, array2) / (standardDaviation(array1) * standardDaviation(array2));
    }

    // public double spearmansRank(double [] array1 , double [] array2){

    // }
}