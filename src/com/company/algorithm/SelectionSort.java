package com.company.algorithm;

public class SelectionSort {

    public int [] sort(int [] input){
        int [] result = input;

        for (int i = 0; i < result.length; i++){

            int min_val = 987654321;
            int min_inx = 0;

            for (int j = i; j < result.length; j++) {
                if (result[j] < min_val) {
                    min_val = result[j];
                    min_inx = j;
                }
            }

            int temp = result[i];
            result[i] = result[min_inx];
            result[min_inx] = temp;

            // 출력
            for (int x: result){
                System.out.print(x);
            }
            System.out.println("");
        }
        return result;
    }
}
