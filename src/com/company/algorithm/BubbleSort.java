package com.company.algorithm;

public class BubbleSort {


    public int [] sort(int [] input){
        int [] result = input;

        for (int i = 0; i < result.length-1; i++){
            for (int j = 0; j < result.length-1-i; j++){
                if (result[j] > result[j + 1]){
                    int temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                }
            }
            for (int x: result){
                System.out.print(x);
            }
            System.out.println("");
        }
        return result;
    }
}
