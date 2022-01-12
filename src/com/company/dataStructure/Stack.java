package com.company.dataStructure;



public class Stack implements StackInterface{

    private static final int DEFAULT_CAPACITY = 10;           // 스택의 기본 크기
    private int size;
    private int [] stackArray;  // 저장할 배열


    // 생성자
    public Stack(){
        this.size = 0;
        this.stackArray = new int[DEFAULT_CAPACITY];
    }

    // O(1)
    @Override
    public void push(int item){
        // 스택의 요소의 개수가 꽉 찼는지 검증
        if (size >= stackArray.length){
            System.out.println("Stack Over Flow");
            return ;
        }
        stackArray[size++] = item;
    }

    // O(1)
    public int pop(){
        if (size == 0){
            System.out.println("Stack Under Flow");
            return 0;
        }
        int result = stackArray[size-1];
        stackArray[size-1] = 0;
        size--;
        return result;
    }

    // O(1)
    @Override
    public int peek() {
        int result = stackArray[size-1];
        return result;
    }

    // O(N)
    @Override
    public void clear() {
        for (int i = 0; i < size; i++){
            stackArray[i] = 0;
        }
        size = 0;
    }

    // O(1)
    @Override
    public boolean isEmpty() {
        if (stackArray[0] == 0){
            return true;
        }else{
            return false;
        }
    }
}
