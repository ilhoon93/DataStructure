package com.company.dataStructure;

public interface StackInterface {

    // 스택의 맨 위에 요소를 추가한다.
    void push(int item);

    // 스택의 맨 위에 요소를 제거하고 그 값을 반환한다.
    int pop();

    // 스택의 맨 위의 요소를 반환한다.
    int peek();

    // 스택에 있는 모든 요소를 삭제한다.
    void clear();

    // 스택에 요소가 비어있는지 확인한다. 비었으면 True
    boolean isEmpty();
}
