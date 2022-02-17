package com.company.codingInterview;


import java.util.Arrays;
import java.util.Stack;

/*
* 1. 문자열은 java에서 변경할 수 없다. (아마 포인터 배열로 선언되어 있기때문?)
* 2. 문자열 클래스 정렬하는 방법은 스트링 -> 문자열 배열 -> 정렬 -> 정렬된 문자열 배열로 스트링 객체 생성
*
* */
public class Pr1 {

    /* 1.1 중복이 없는가 */
    public boolean pr1 (String str){
        char[] StringToChar = str.toCharArray();    //
        Arrays.sort(StringToChar);
        //String sortedStr = new String(StringToChar);
        int n = str.length();

        for (int i=0; i<n-1; i++){
            if (StringToChar[i] == StringToChar[i+1]){
                System.out.println("중복이 있다.");
                return false;
            }
        }
        System.out.println("중복이 없다.");
        return true;
    }

    /* 1.2 순열 확인 */
    public boolean pr2 (String str1, String str2){
        int lenStr1 = str1.length();
        int lenStr2 = str2.length();

        if (lenStr1 == lenStr2){
            char [] str1ToChar = str1.toCharArray();
            char [] str2ToChar = str2.toCharArray();
            Arrays.sort(str1ToChar);
            Arrays.sort(str2ToChar);

            for (int i = 0; i<lenStr1; i++){
                if (str1ToChar[i] != str2ToChar[i]){
                    System.out.println("순열관계가 아니다.");
                    return false;
                }
            }
            System.out.println("순열관계다.");
            return true;
        }else{
            System.out.println("순열관계가 아니다.");
            return false;
        }
    }

    /* 1.3 URL화 */
    /* 문자 배열을 하나 선언하지 않고 해야하나? 하나 더 선언하면 그냥 하나씩 복사하면 끝인데? */
    public String pr3 (char[] str, int orgLen){
        int dstLen = orgLen*3;

        int idx = orgLen-1;  // 기존 문자열의 마지막 요소
        int idxIn = (orgLen*3)-1;

        while (idx > 0){
            if (str[idx] == ' '){
                str[idxIn--] = '0';
                str[idxIn--] = '2';
                str[idxIn--] = '%';
            }else{
                str[idxIn] = str[idx];
                idxIn--;
            }
            idx--;
        }
        String result = new String(str);
        return result;
    }

    /* 1.4 회문순열 */
    public boolean pr4(String str){
        char[] strToChar = str.toCharArray();
        Arrays.sort(strToChar);
        int n = str.length();

        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<n; i++){
            if (stack.empty()){
                stack.push(strToChar[i]);
            }
            else{
                if (stack.peek() == strToChar[i]){
                    stack.pop();
                    continue;
                }
                else{
                    stack.push(strToChar[i]);
                }
            }
        }
        if (n%2 == 0){
            if (stack.empty()){
                System.out.println("회문 순열이다");
                return true;
            }else{
                System.out.println("회문 순열이 아니다");
                return false;
            }
        }else{
            if (stack.size() == 1){
                System.out.println("회문 순열이다");
                return true;
            }
            else{
                System.out.println("회문 순열이 아니다");
                return false;
            }
        }
    }

    /* 1.5 하나 빼기 */
    public boolean pr5(String str1, String str2){
        int str1N = str1.length();
        int str2N = str2.length();
        char [] str1ToChar = str1.toCharArray();
        char [] str2ToChar = str2.toCharArray();

        if (str1N-str2N >= 2 || str1N-str2N <= -2){
            System.out.println("편집횟수 1회로 불가");
            return false;
        }
        else{
            if (str1N == str2N){
                int cnt = 0;
                for (int i=0; i<str1N; i++){
                    if(str1ToChar[i] != str2ToChar[i]){
                        cnt++;
                    }
                }
                if (cnt >= 2){
                    System.out.println("편집횟수 1회로 불가");
                    return false;
                }else{
                    System.out.println("편집횟수 1회로 가능");
                    return true;
                }
            }
            else{
                char [] s;
                char [] l;
                if (str1N > str2N){
                    s = str2ToChar;
                    l = str1ToChar;
                }else{
                    s = str1ToChar;
                    l = str2ToChar;
                }
                int flag = 0;
                for (int i = 0; i<str1N; i++){
                    if (flag == 0){
                        if (i == s.length){
                            System.out.println("편집횟수 1회로 가능");
                            return true;
                        }
                        if(s[i] != l[i]){ // 문자열의 마지막 글자가 달라지는 경우... 검증을 못함
                            flag = 1;
                        }
                    }
                    else{
                        if (s[i-1] != l[i]){
                            System.out.println("편집횟수 1회로 불가");
                            return false;
                        }
                    }
                }
                System.out.println("편집횟수 1회로 가능");
                return true;
            }
        }
    }

    /* 1.6 문자열 압축 */
    public String pr6(String str){
        String result = "";
        char[] strToChar = str.toCharArray();
        char s = strToChar[0];
        int cnt = 1;
        for (int i=1; i<str.length(); i++){
            if (s==strToChar[i]){
                cnt++;
            }
            else{
                result = result + s + Integer.toString(cnt);
                cnt = 1;
            }
            s = strToChar[i];
        }
        result = result + s + Integer.toString(cnt);
        if(result.length() > str.length()){
            result = str;
        }
        return result;
    }

    /* 1.7 행렬 회전 */
    public void pr7(int [][] data){
        int n = data[0].length;
        int[][] result = new int[n][n];

        for (int i=0; i<n;i++){
            for (int j=0; j<n; j++){
                result[j][n-i-1] = data[i][j];
            }
        }


        for (int i=0; i<n;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    /* 1.8 0 행렬 */
    public void pr8(int [][] data){
        int m = data.length;
        int n = data[0].length;

        int X = 0;
        int Y = 0;
        int flag = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (data[i][j] == 0){
                    X=i;
                    Y=j;
                    flag = 1;
                    break;
                }
            }
        }
        if (flag == 1){
            for (int i=0; i<m; i++){
                data[i][Y] = 0;
            }
            for (int j=0; j<n; j++) {
                data[X][j] = 0;
            }
        }

        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
    }

    /* 1.9 문자열 회전 */
    public boolean pr9(String str1, String str2){
        char [] str1ToChar = str1.toCharArray();
        char [] str2ToChar = str2.toCharArray();
        Arrays.sort(str1ToChar);
        Arrays.sort(str2ToChar);

        /*
        if (str1.isSubString(str2)){
            return true;
        }
        else{
            return false;
        }
        */
        return true;
    }
}
