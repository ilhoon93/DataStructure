package com.company.dataStructure;

public class StringBuilder {
    private char[] value;       // 문자열을 저장할 배열
    private int size;           // 배열방의 크기
    private int index;          // 새로 추가될 캐릭터의 방번호를 기억

    public StringBuilder(){
        size = 1;
        value = new char[size];
        index = 0;
    }

    public void append(String str){
        if (str == null) str = "null";
        int len = str.length();
        ensureCapacity(len);
        for (int i=0; i<str.length(); i++){
            value[index] =str.charAt(i);
            index++;
        }
    }

    // 배열방이 넉넉하지 않으면 배열방의 크기를 늘려주는
    private void ensureCapacity(int len){
        if (index + len > size){
            size = (size + len) * 2;
            char[] newValue = new char[size];
            for (int i=0; i<value.length; i++){
                newValue[i] = value[i];
            }
            value = newValue;
        }
    }

    public String toString(){
        return new String(value, 0, index);
    }
}
