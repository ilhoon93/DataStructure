package com.company.dataStructure;

public interface QueueInterface {

    // 큐의 맨 뒤에 요소를 추가한다.
    void push(int item);

    // 큐의 맨 앞에 요소를 제거하고 그 값을 반환한다.
    int pop();

    // 큐의 맨 앞의 요소를 반환한다.
    int front();

    // 큐에 있는 모든 요소를 삭제한다.
    void clear();

    // 큐에 요소가 비어있는지 확인한다. 비었으면 True
    boolean isEmpty();
}
