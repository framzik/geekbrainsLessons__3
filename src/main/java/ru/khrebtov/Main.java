package ru.khrebtov;

import java.util.Arrays;

public class Main {

    public int[] afterFor(int[] arr) {
        int[] newArr;
        int indexLastFor = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4 & indexLastFor < i) {
                indexLastFor = i;
            }
        }
        if (indexLastFor == -1) {
            throw new RuntimeException("В массиве нет 4");
        }
        newArr = Arrays.copyOfRange(arr, indexLastFor + 1, arr.length);
        return newArr;
    }


    public boolean isHaveSomeNumbers(int[] arr) {
        int countOne = 0;
        int countFor = 0;

        for (int j : arr) {
            if (j != 4 && j != 1) {
                return false;
            }
            if (j == 1) {
                countOne++;
            }
            if (j == 4) {
                countFor++;
            }
        }
        return !(countOne == 0 || countFor == 0);
    }
}
