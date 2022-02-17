package com.company.algorithm;

import java.util.Arrays;

public class QuickSort {

    public int [] sort(int [] input, int left, int pivot) {

        if (pivot == left){
            return input;
        }
        int[] result = input;

        for (int i = 0; i < input.length - 1; i++) {
            if (result[i] < result[pivot]) {
                int temp = result[i];
                result[i] = result[left];
                result[left] = temp;
                left++;
            }
        }
        int temp = result[left];
        result[left] = result[pivot];
        result[pivot] = temp;
        pivot = left;

        // 출력
        for (int x : result) {
            System.out.print(x);
        }
        System.out.println("");

        sort(Arrays.copyOfRange(result,0, pivot),0,Math.max(pivot-1,0));
        sort(Arrays.copyOfRange(result,pivot+1, result.length-1),0,Arrays.copyOfRange(result,pivot+1, result.length-1).length-1);

        return result;
    }
}
