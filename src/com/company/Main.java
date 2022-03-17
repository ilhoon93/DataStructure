package com.company;


import com.company.algorithm.BubbleSort;
import com.company.algorithm.InsertionSort;
import com.company.algorithm.QuickSort;
import com.company.algorithm.SelectionSort;
import com.company.codingInterview.Pr1;


public class Main {
    public static int [] testArr = {5, 3, 6 ,8, 1, 4};
    public static int [][] testArrMul = {{1,2,3},{4,5,6},{7,8,9}};
    public static int [][] testArrMul2 = {{1,0,3},{4,5,6},{7,0,9}};

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
        //pr1.pr2("5623", "3012");
        //String str = "Mr John Smith      ";
        //System.out.println(pr1.pr3(str.toCharArray(), 13));
        //pr1.pr4("123221");
        //pr1.pr5("bale", "pale");
        //System.out.println(pr1.pr6("abababababbbbbbbbbbbbbbbbbbbbbb"));
        //int [][] tmp = {{1,2,3},{4,5,6},{7,8,9}};
        //pr1.pr7(tmp);

        //pr1.pr8(testArrMul2);

        pr1.pr9("waterbottle", "erbottlewaq");
    }
}
