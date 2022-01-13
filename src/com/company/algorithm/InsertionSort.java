package com.company.algorithm;

public class InsertionSort {


    public int [] sort(int [] input) {

        int[] result = input;
        for (int i = 0; i < result.length; i++) {

            for (int j = i; j > 0; j--) {
                if (result[j] < result[j - 1]) {
                    int temp = result[j - 1];
                    result[j - 1] = result[j];
                    result[j] = temp;
                }
            }

            // 출력
            for (int x : result) {
                System.out.print(x);
            }
            System.out.println("");
        }
        return result;


    }
}
