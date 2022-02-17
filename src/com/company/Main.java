package com.company;


import com.company.algorithm.BubbleSort;
import com.company.algorithm.InsertionSort;
import com.company.algorithm.QuickSort;
import com.company.algorithm.SelectionSort;
import com.company.codingInterview.Pr1;


public class Main {
    public static int [] test1 = {5, 3, 6 ,8, 1, 4};



    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        QuickSort quickSort = new QuickSort();
        //bubbleSort.sort(test1);
        //selectionSort.sort(test1);
        //insertionSort.sort(test1);
        //quickSort.sort(test1, 0, test1.length-1);

        Pr1 pr1 = new Pr1();
        //pr1.pr1("ㅂㅈㄷ11");
        //pr1.pr2("1230", "3012");
        //String str = "ewr2323";
        //pr1.pr3(str.toCharArray(), str.length());
        //pr1.pr4("123221");
        pr1.pr5("pales", "pale");
    }
}
