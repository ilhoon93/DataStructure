package com.company.codingInterview;

import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.Stack;

/*
* 1. 문자열은 java에서 변경할 수 없다. (아마 포인터 배열로 선언되어 있기때문?)
* 2. 문자열 클래스 정렬하는 방법은 스트링 -> 문자열 배열 -> 정렬 -> 정렬된 문자열 배열로 스트링 객체 생성
* 3. str.charAt(i) : String 변수에 i번째 문자를 char형으로 변환해서 리턴해준다.
* 4. 문자열의 범위를 알고, 범위가 크지 않다면 범위 만큼 배열을 만들어서 비교하는 방법이 O(N)으로 해결할 수 있는 방법이다.
* 5. 자바에서 메소드를 중첩으로 정의할 수 없다.(메소드 내에서 메소드 정의)
* 6. 배열에 대입 연산자 사용하면 얕은복사(주소복사), int[] b = a.clone(); 이런 식으로 해야 값이 복사된다.(깊은 복사)
* 7. 문자열을 합칠 때는 StringBuilder자료형을 쓰면 더 효율적이다.
*       - 합칠 때마다 새로운 객체를 생성하고 복사하는 것이 아니라, 배열 공간이 부족할 때만 생성하고 복사한다.
*       - 기존문자열을 모두 순회하며 복사하지 않고 기존문자열 뒤쪽으로 새로운 문자열을 하나씩 붙여준다.
*
* */
public class Pr1 {

    /* 1.1 중복이 없는가 (비트패턴 풀이있음) */
    public boolean pr1 (String str){
//        나의 풀이 : 문자열 정렬 -> 문자열 순회하며 인접한 값이 같은게 있는지 비교 NlogN
//        char[] StringToChar = str.toCharArray();    //
//        Arrays.sort(StringToChar);
//        //String sortedStr = new String(StringToChar);
//        int n = str.length();
//
//        for (int i=0; i<n-1; i++){
//            if (StringToChar[i] == StringToChar[i+1]){
//                System.out.println("중복이 있다.");
//                return false;
//            }
//        }
//        System.out.println("중복이 없다.");
//        return true;

//      다른 풀이 1 (아스키 코드값만 들어온다고 가정)
//      문자값 범위를 알고 있을 때
//          문자값 범위보다 길이가 길면 바로 중복이 있는 것으로 판단.
//          문자값 범위 만큼 배열을 만든다, 문자열을 순회하며 현재 문자에 해당하는 배열 인덱스 값을 증가 시킨다, 1보다 크면 바로 중복으로 종료
//          시간 복잡도 N
        boolean[] ascii = new boolean[255];
        for (int i=0; i<str.length(); i++){
            int a = str.charAt(i);

            if (ascii[a]==true){
                return false; // 중복이 있다.
            }
        }
        return true;
    }

    /* 1.2 순열 확인 */
    public boolean pr2 (String str1, String str2){
        // 나의 풀이 : 문자열 길이 비교 다르면 순열관계 x, 같으면 정렬해서 문자가 모두 같으면 같은 것 하나라도 다르면 다른 것.
//        int lenStr1 = str1.length();
//        int lenStr2 = str2.length();
//
//        if (lenStr1 == lenStr2){
//            char [] str1ToChar = str1.toCharArray();
//            char [] str2ToChar = str2.toCharArray();
//            Arrays.sort(str1ToChar);
//            Arrays.sort(str2ToChar);
//
//            for (int i = 0; i<lenStr1; i++){
//                if (str1ToChar[i] != str2ToChar[i]){
//                    System.out.println("순열관계가 아니다.");
//                    return false;
//                }
//            }
//            System.out.println("순열관계다.");
//            return true;
//        }else{
//            System.out.println("순열관계가 아니다.");
//            return false;
//        }

        // 다른 풀이
        // 문자값의 범위를 안다면 각각 문자열 범위만큼 배열을 만든 후에, 문자열의 등장 횟수가 같은지 비교한다.
        if (str1.length() == str2.length()){
            int[] str1_pool = new int[256];
            int[] str2_pool = new int[256];

            for (int i = 0; i<str1.length(); i++){
                int s1 = str1.charAt(i);
                int s2 = str2.charAt(i);
                str1_pool[s1]++;
                str2_pool[s2]++;
            }

            for (int i = 0; i<256; i++){
                if (str1_pool[i] != str2_pool[i]){

                    System.out.println("false");
                    return false;
                }
            }
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }

    /* 1.3 URL화 */
    public String pr3 (char[] str, int orgLen){
        // 나의 풀이 (틀림)
        // 모든 문자가 공백일 수 있다고 가정하고 기존 문자열 * 3의 길이만큼의 char 배열을 생성한다.
        // 새로운 문자 배열을 생성하지 않고 기존 배열의 길이보다 더 뒤에 인덱스에 어떻게 값을 집어넣지?
        // * 기존 문자열 뒤에 충분한 공백이 같이 주어진다는 조건!!
//        int dstLen = orgLen*3;
//        int idx = orgLen-1;  // 기존 문자열의 마지막 요소
//        int idxIn = (orgLen*3)-1;
//        while (idx > 0){
//            if (str[idx] == ' '){
//                str[idxIn--] = '0';
//                str[idxIn--] = '2';
//                str[idxIn--] = '%';
//            }else{
//                str[idxIn] = str[idx];
//                idxIn--;
//            }
//            idx--;
//        }
//        String result = new String(str);
//        return result;

        int spaceCount = 0;
        int index = 0;
        int i = 0;
        for (i = 0; i<orgLen; i++){
            if(str[i]==' '){
                spaceCount++;
            }
        }
        index = orgLen + (spaceCount*2);
        if (orgLen < str.length){
            str[orgLen] = '\0';
        }
        for(i = orgLen-1; i>=0; i--){
            if (str[i] == ' '){
                str[index-1] = '0';
                str[index-2] = '2';
                str[index-3] = '%';
                index = index-3;
            } else  {
                str[index-1] = str[i];
                index--;
            }
        }
        String result = new String(str);
        return result;
    }

    /* 1.4 회문순열 (비트패턴 풀이있음) */
    public boolean pr4(String str){
        // 나의 풀이
        // 문자열을 정렬 후에 하나씩 스택에 삽입한다, 스택의 맨위에 요소와 현재 비교할 문자열이 같으면 스택에서 문자열을 제거한다.
        // 같지 않으면 스택에 해당 문자열을 삽입한다.
        // 문자열의 전체 길이가 짝수라면 스택이 비어있어야 회문순열이고
        // 문자열의 전체 길이가 홀수라면 스택이 1개만 남아있어야 회문순열이다.
        // NlogN
//        char[] strToChar = str.toCharArray();
//        Arrays.sort(strToChar);
//        int n = str.length();
//
//        Stack<Character> stack = new Stack<Character>();
//        for (int i=0; i<n; i++){
//            if (stack.empty()){
//                stack.push(strToChar[i]);
//            }
//            else{
//                if (stack.peek() == strToChar[i]){
//                    stack.pop();
//                    continue;
//                }
//                else{
//                    stack.push(strToChar[i]);
//                }
//            }
//        }
//        if (n%2 == 0){
//            if (stack.empty()){
//                System.out.println("회문 순열이다");
//                return true;
//            }else{
//                System.out.println("회문 순열이 아니다");
//                return false;
//            }
//        }else{
//            if (stack.size() == 1){
//                System.out.println("회문 순열이다");
//                return true;
//            }
//            else{
//                System.out.println("회문 순열이 아니다");
//                return false;
//            }
//        }

        /* 다른 풀이 (문자의 범위를 알아야한다.)
        // 해시테이블을 이용하여 각 문자가 몇번 등장했는지 센다.
        // 전체 문자열의 길이가 짝수이면 홀수번 등장한 문자가 없어야되고, 전체 길이가 홀수면 홀수번 등장 문자가 1개여야한다.
        // 각문자가 몇번 등장했는지 센다
        // N
        */
        int[] table = new int[256];
        int oddCnt = 0;
        for (char c : str.toCharArray()){
            table[c]++;
        }
        for (int i : table) {
            if (i % 2 != 0) {
                oddCnt++;
            }
        }
        if (str.length()%2 == 0){
            if (oddCnt == 0){
                return true;
            } else {
                return false;
            }
        } else {
            if (oddCnt == 1){
                return true;
            } else {
                return false;
            }
        }
    }

    /* 1.5 하나 빼기 */
    public boolean pr5(String str1, String str2){
        // 나의 풀이
        // 두 문자열의 길이의 차이가 2이상이라면 절대 편집 1번으로 같아질 수 없다.
        // 두 문자의 길이가 같다면 두 문자열을 하나씩 비교해 다른 문자가 1개만 있다면 가능
        // 두 문자의 길이가 1차이라면 하나씩 비교하면서 다른 문자열이 하나 나오면 flag변경
        // flag 달라지면 길이 작은 문자열 i-1과 길이 긴 문자열 i 값이 같은지 비교해서 또 달라지면 false, 계속 같으면 true
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
                } else{
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
        // 나의 풀이
//        String result = "";
//        char[] strToChar = str.toCharArray();
//        char s = strToChar[0];
//        int cnt = 1;
//        for (int i=1; i<str.length(); i++){
//            if (s==strToChar[i]){
//                cnt++;
//            }
//            else{
//                result = result + s + Integer.toString(cnt);
//                cnt = 1;
//            }
//            s = strToChar[i];
//        }
//        result = result + s + Integer.toString(cnt);
//        if(result.length() > str.length()){
//            result = str;
//        }
//        return result;

        // 다른 풀이
        // 문자열을 합칠 때 + 연산보다는 StringBuilder를 사용하면 더 효율적이다.
        // 최종문자열의 길이만 먼저 계산해보는 방법도 있다. (압축한 결과가 비효율적이라면 압축과정을 생략해서 좋다, Stringbuilder의 크기를 미리 설정할 수 있어 좋다)
        StringBuilder result = new StringBuilder();
        char[] strToChar = str.toCharArray();
        char s = strToChar[0];
        int cnt = 1;
        for (int i=1; i<str.length(); i++){
            if (s==strToChar[i]){
                cnt++;
            }
            else{
                result.append(s);
                result.append(Integer.toString(cnt));
                cnt = 1;
            }
            s = strToChar[i];
        }
        result.append(s);
        result.append(Integer.toString(cnt));
        if (result.length() > str.length()){
            return str;
        }else {
            return result.toString();
        }

    }

    /* 1.7 행렬 회전 (행렬을 추가로 사용하지 않고 푸는 방법) */
    public void pr7(int [][] data){
        // 나의 풀이
        // 행렬을 추가로 사용해서 복사했다.
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
        // 다른 풀이
        // 행렬을 추가로 사용하지 않고 푸는 방법
    }

    /* 1.8 0 행렬 (비트패턴 이용한 풀이) */
    public void pr8(int [][] data){
        // 나의 풀이
        // 0이 여러개인 경우 제대로 처리하지 못한다.
//        int m = data.length;
//        int n = data[0].length;
//
//        int X = 0;
//        int Y = 0;
//        int flag = 0;
//        for (int i=0; i<m; i++){
//            for (int j=0; j<n; j++){
//                if (data[i][j] == 0){
//                    X=i;
//                    Y=j;
//                    flag = 1;
//                    break;
//                }
//            }
//        }
//        if (flag == 1){
//            for (int i=0; i<m; i++){
//                data[i][Y] = 0;
//            }
//            for (int j=0; j<n; j++) {
//                data[X][j] = 0;
//            }
//        }
//
//        for (int i=0; i<m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(data[i][j]);
//            }
//            System.out.println();
//        }

        // 다른 풀이
        // 0의 위치를 저장하는 배열을 따로 만들기
        boolean[] row = new boolean[data.length];
        boolean[] column = new boolean[data[0].length];

        for (int i=0; i<row.length; i++){
            for (int j=0; j<column.length; j++){
                if (data[i][j] == 0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i=0; i< row.length; i++){
            if(row[i]){
                for (int x = 0; x<column.length; x++){
                    data[i][x] = 0;
                }
            }
        }
        for (int i=0; i< column.length; i++){
            if(column[i]){
                for (int x = 0; x<row.length; x++){
                    data[x][i] = 0;
                }
            }
        }
        for (int i=0; i<row.length; i++) {
            for (int j = 0; j < column.length; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println();
        }


    }

    /* 1.9 문자열 회전 */
    public boolean pr9(String str1, String str2){
        // 틀림
//        char [] str1ToChar = str1.toCharArray();
//        char [] str2ToChar = str2.toCharArray();
//        Arrays.sort(str1ToChar);
//        Arrays.sort(str2ToChar);

        // 다른 풀이
        // Str2를 특정 지점에서 끊어서 회전한것
        // S1 = xy (wat + erbottle)
        // S2 = yx (erbottle + wat)
        // yx는 xyxy에 언제나 포함되어 있다.
        // S1+S1에 S2가 포함되어 있는지 확인하면 된다.

        String s1s1 = str1 + str1;


        for (int i = 0 ; i<s1s1.length()- str2.length(); i++){
            String s = s1s1.substring(i,i+str2.length());
            if (s.equals(str2)) {
                System.out.println(str2 + "/" + s + "True");
                return true;
            }
        }
        return false;
    }
}
