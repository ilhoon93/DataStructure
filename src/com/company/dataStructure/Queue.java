package com.company.dataStructure;

public class Queue implements QueueInterface{

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int [] queueArray;  // 저장할 배열


    // 생성자
    public Queue(){
        this.size = 0;
        this.queueArray = new int[DEFAULT_CAPACITY];
    }

    // O(1)
    @Override
    public void push(int item) {
        if (size >= queueArray.length){
            System.out.println("Queue size full");
        }
        queueArray[size] = item;
        size++;
    }

    // O(1)
    @Override
    public int pop() {

        return 0;
    }

    @Override
    public int front() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
