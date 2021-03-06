package com.terminal;

public class Utils {

    public Utils() {
    }

    public int countOccurences(
            String someString, char searchedChar) {

        int count = 0;

        for (int i = 0; i < someString.length(); i++) {
            if (someString.charAt(i) == searchedChar) {
                count++;
            }
        }
        return count;
    }

    public String getIndexOfLargest(long[][] array) {
        if (array == null || array.length == 0) return "-1"; // null or empty

        int largestR = 0;
        int largestC = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {


                if (array[i][j] > array[largestR][largestC]) {
                    largestR = i;
                    largestC = j;
                }
            }
        }
        return largestR + "," + largestC; // position of the first largest found
    }
}
