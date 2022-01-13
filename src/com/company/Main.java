package com.company;


import com.company.algorithm.BubbleSort;
import com.company.algorithm.InsertionSort;
import com.company.algorithm.SelectionSort;


public class Main {
    public static int [] test1 = {5, 4, 6 ,8, 1, 3};



    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        //bubbleSort.sort(test1);
        //selectionSort.sort(test1);
        insertionSort.sort(test1);

    }
}
