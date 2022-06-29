## 21. [연습문제] 이상한 문자 만들기

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12930
- 난이도 : 중하
### 문제설명
```
문자열 s는 한 개 이상의 단어로 구성되어 있습니다.
각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

제한 사항
- 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
- 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.


(입출력 예)
s	                     return
"try hello world"	"TrY HeLlO WoRlD"

입출력 예 설명
"try hello world"는 세 단어 "try", "hello", "world"로 구성되어 있습니다.
각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 "TrY", "HeLlO", "WoRlD"입니다.
따라서 "TrY HeLlO WoRlD" 를 리턴합니다.
```
### 문제풀이
- 문자열 s를 각각 비교해야하기 때문에 for문으로 순회
- 가장 중요한 포인트는 문자열 전체의 짝/홀수 인덱스가 아니라 단어 공백기준별로 짝/홀수 인덱스로 판단해야한다는 점이다. 👉🏻 그렇기 때문에 for문의 i가 아닌 `int cnt = 0`을 선언 후 초기화 해준다.
- 그래서 for문 안에서 if문으로 공백을 기준으로 분기처리 해준다.
- 만약 s.charAt(i)이 공백이라면 answer에는 똑같이 공백을 더해주고 cnt값을 0으로 초기화시켜준다.
- 만약 s.charAt(i)가 그냥 문자열이라면 조건에서와 같이 짝수 or 0일 때 대문자로, 홀수일 때 소문자로 변경해준다.
- 이때, String의 메소드인 toUpperCase()와 toLowerCase()를 사용해준다.
- s.charAt(i)는 char형이기 때문에 String으로 변경해주기 위해 String.valueOf()를 사용해준다.
### 정답코드
```java
class Solution {
    public String solution(String s) {
        String answer = "";
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(String.valueOf(s.charAt(i)).equals(" ")){
                answer += " ";
                cnt = 0;
                // System.out.println("공백입니다. answer에 공백 추가 후 cnt는 0으로 초기화");
            } else {
                // System.out.println(cnt);
                if(cnt % 2 == 0 || cnt == 0){  
                    answer += String.valueOf(s.charAt(i)).toUpperCase();
                } else {
                    answer += String.valueOf(s.charAt(i)).toLowerCase();
                }
                cnt++;
            }
        }
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- [Java] 대문자를 소문자로, 소문자를 대문자로 변환
    + https://pridiot.tistory.com/24


## 22. [연습문제] 자릿수 더하기

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12931
- 난이도 : 중하
### 문제설명
```
자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

제한사항
- N의 범위 : 100,000,000 이하의 자연수


(입출력 예)
N	  answer
123	    6
987	   24


입출력 예 설명
입출력 예 #1
문제의 예시와 같습니다.

입출력 예 #2
9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.
```
### 문제풀이
- int n을 String을 변환 후 for문으로 순회
- num.charAt(i)가 char형이기 때문에 char to int로 변환
- 변환한 수를 answer에 각각 더해준다.
### 정답코드
```java
public class Solution {
    public int solution(int n) {
        int answer = 0;
        String num = String.valueOf(n);
        for(int i = 0; i < num.length(); i++){
            answer += (num.charAt(i) - '0');
        }
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- Java에서 Char를 Int로 변환하는 방법
    + https://www.delftstack.com/ko/howto/java/how-to-convert-char-to-int-in-java/



## 23. [연습문제] 자연수 뒤집어 배열로 만들기

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12932
- 난이도 : 중하
### 문제설명
```
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

제한 조건
- n은 10,000,000,000이하인 자연수입니다.


(입출력 예)
n	      return
12345	[5,4,3,2,1]
```
### 문제풀이
- n을 String으로 변환해주고 String의 길이와 같은 배열의 크기를 갖는 정수형 배열 선언
- for문으로 순회하면서 각각의 값을 charAt()으로 가져와서 answer에 값을 넣는다.
- 이때 `num.charAt(len-1-i)`로 해준다. 그 이유는 String의 마지막 값부터 answer에 순차적으로 넣어야 숫자가 뒤집어지기 때문이다.
### 정답코드
```java
import java.util.*;

class Solution {
    public int[] solution(long n) {
        String num = String.valueOf(n);
        int len = num.length();
        int[] answer = new int[len];
        for(int i = 0; i < len; i++){
            answer[i] = (num.charAt(len-1-i) - '0');
        }
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- Java - Char를 Int로 변환하기
    + https://frhyme.github.io/java/java_basic02_char_to_int/



## 24. [연습문제] 정수 내림차순으로 배치하기

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12933
- 난이도 : 중하
### 문제설명
```
함수 solution은 정수 n을 매개변수로 입력받습니다.
n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
예를들어 n이 118372면 873211을 리턴하면 됩니다.

제한 조건
- n은 1이상 8000000000 이하인 자연수입니다.


(입출력 예)
n	     return
118372	873211
```
### 문제풀이
- long n을 String 변환 후 split()을 사용해 String 배열로 변환
- Arrays.sort()와 Collections.reverseOrder()를 사용해 내림차순 처리
- String배열의 값을 result에 차례대로 넣어서 String으로 변환
- String을 Long으로 변환 후 return
### 정답코드
```java
import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String result = "";
        String[] num = String.valueOf(n).split("");
        //System.out.println(Arrays.toString(num));
        Arrays.sort(num, Collections.reverseOrder());
        //System.out.println(Arrays.toString(num));
        for(String el : num){
            result += el;
        }
        //System.out.println(result);
        answer = Long.parseLong(result);        
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- [Java] 자바 배열 정렬하기(오름차순, 내림차순) Arrays.sort()
    + https://coding-factory.tistory.com/549
- Java에서 문자열을 Long으로 변환하는 방법
    + delftstack.com/ko/howto/java/how-to-convert-a-string-to-long-in-java/



## 25. [연습문제] 정수 제곱근 판별

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12934
- 난이도 : 중하
### 문제설명
```
임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고,
n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

제한 사항
- n은 1이상, 50000000000000 이하인 양의 정수입니다.


(입출력 예)
n	  return
121	   144
3	   -1


입출력 예 설명
입출력 예#1
121은 양의 정수 11의 제곱이므로, (11+1)를 제곱한 144를 리턴합니다.

입출력 예#2
3은 양의 정수의 제곱이 아니므로, -1을 리턴합니다.
```
### 문제풀이
- Math.sqrt()를 사용해 n의 제곱근을 double x변수에 저장
- x를 1로 나눈 나머지가 0이라면 x는 소수점 자리가 없어 정수제곱근이라고 판단
- Math.round()를 사용해 double에서 long으로 형 변환하는데 이때 +1을 한 후에 long_x변수에 저장
- answer에 long_x * long_x의 값을 저장 후 return
- answer에는 -1로 초기화 했기 때문에 x가 정수제곱근이 아니라면 그대로 -1을 return할 것임.
### 정답코드
```java
class Solution {
    public long solution(long n) {
        long answer = -1;
        double x = Math.sqrt(n);
        if(x % 1 == 0){
            long long_x = Math.round(x+1);
            answer = (long_x * long_x);
        } 
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- [java] 캐스팅하지 않고 double을 long으로 변환하는 방법은 무엇입니까?
    + http://daplus.net/java-%EC%BA%90%EC%8A%A4%ED%8C%85%ED%95%98%EC%A7%80-%EC%95%8A%EA%B3%A0-double%EC%9D%84-long%EC%9C%BC%EB%A1%9C-%EB%B3%80%ED%99%98%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95%EC%9D%80-%EB%AC%B4%EC%97%87/


## 26. [연습문제] 제일 작은 수 제거하기

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12935
- 난이도 : 중하
### 문제설명
```
정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

제한 조건
- arr은 길이 1 이상인 배열입니다.
- 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.


(입출력 예)
arr	         return
[4,3,2,1]	[4,3,2]
[10]	      [-1]
```
### 문제풀이
- 원소 삭제를 위해 ArrayList를 생성 후 arr값을 ArrayList에 복사
- for문으로 순회하면서 최소값과 최소값 인덱스를 저장
- 최소값 인덱스를 사용해 ArrayList에서 최소값 삭제
- 최소값 삭제 후 만약 ArrayList의 길이가 0(빈 배열)이라면 -1을 추가해준다.
- 정수배열인 answer를 생성하고 ArrayList값을 복사해준 후 return.

### 정답코드
```java
import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        // ArrayList 생성
        List<Integer> list = new ArrayList<>();
        int min = arr[0];
        int min_idx = 0;

        // arr값을 list에 복사
        for(int el : arr){
            list.add(el);
        }

        // 최소값을 비교 후에 최소값, 최소값 인덱스 저장
        for(int i = 1; i < list.size(); i++){
            if(min > list.get(i)){
                min = list.get(i);
                min_idx = i;
            }
        }

        // 최소값 인덱스로 최소값 삭제
        list.remove(min_idx);

        // 최소값 삭제 후 list길이가 0이면 -1을 추가
        if(list.size() == 0){
            list.add(-1);
        }

        // list에 있는 값을 정수배열 answer에 복사
        int[] answer = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++) {
            answer[i] = list.get(i).intValue();
        }
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- [Java] Integer ArrayList을 int 배열로 변환 방법
    + https://velog.io/@deannn/Java-int%ED%98%95-ArrayList-%EB%B0%B0%EC%97%B4-%EB%B3%80%ED%99%98
- [Java] 배열을 List로, List를 배열로 변환하기
    + https://hianna.tistory.com/551
- [JAVA]자바 리스트(list)의 remove() 아이템(객체, 요소) 삭제하는 방법 2가지 : remove(),Iterator를 사용하자!!
    + https://ddolcat.tistory.com/924




## 27. [연습문제] 콜라츠 추측

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12943
- 난이도 : 중하
### 문제설명
```
1937년 Collatz란 사람에 의해 제기된 이 추측은,
주어진 수가 1이 될 때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다.
작업은 다음과 같습니다.

1-1. 입력된 수가 짝수라면 2로 나눕니다. 
1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다. 
2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다. 


예를 들어, 주어진 수가 6이라면 6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1 이 되어 총 8번 만에 1이 됩니다.
위 작업을 몇 번이나 반복해야 하는지 반환하는 함수, solution을 완성해 주세요.
단, 주어진 수가 1인 경우에는 0을, 작업을 500번 반복할 때까지 1이 되지 않는다면 –1을 반환해 주세요.

제한 사항
- 입력된 수, num은 1 이상 8,000,000 미만인 정수입니다.


(입출력 예)
n	   result
6	     8
16	     4
626331	-1


입출력 예 설명
입출력 예 #1
문제의 설명과 같습니다.

입출력 예 #2
16 → 8 → 4 → 2 → 1 이 되어 총 4번 만에 1이 됩니다.

입출력 예 #3
626331은 500번을 시도해도 1이 되지 못하므로 -1을 리턴해야 합니다.

※ 공지 - 2022년 6월 10일 다음과 같이 지문이 일부 수정되었습니다.

주어진 수가 1인 경우에 대한 조건 추가
```
### 문제풀이
- num이 1이 될때까지이기 때문에 while문 사용
- 제일 첫번째 조건으로는 num == 1이고 answer가 500일때 while문을 break해준다.
- 두,세번째 조건은 작업 1-1,1-2을 코드화 시켜준다.
- while문을 나와서 만약 answer가 500이라면 -1을 리턴해준다.
### 정답코드
```java
class Solution {
    // 매개변수를 int에서 long으로 수정하니 3번째 문제도 해결되었음.
    public int solution(long num) {
        int answer = 0;
        while(true){
            if(num == 1 || answer == 500){
                break;
            }
            if(num % 2 == 0){
                num /= 2;
                answer ++;
            } else if(num % 2 == 1){
                num = (num*3)+1;
                answer ++;
            }
        }
        if (answer == 500){
            return -1;
        }
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- solution함수의 매개변수가 int일 때는 3번 테스트케이스가 계속 돌아가서 강제 종료가 되었다. 그래서 작업을 조금 더 줄일 수 있는 방법을 모색하다가 제한사항이 눈에 들어왔다. 제한사항이 num은 1이상 800만 미만의 정수라고 하는데 1-2작업에서 곱하기 3해주는 것 때문에 혹시나 오버플로우가 발생해서 그런 것이 아닐까라는 생각에 int를 long으로 변경했다. 그랬더니 테스트케이스 3번도 잘 되었다.



## 28. [연습문제] 하샤드 수

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12947
- 난이도 : 중하
### 문제설명
```
양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.

제한 조건
- x는 1 이상, 10000 이하인 정수입니다.


(입출력 예)
x	return
10	true
12	true
11	false
13	false


입출력 예 설명
입출력 예 #1
10의 모든 자릿수의 합은 1입니다. 10은 1로 나누어 떨어지므로 10은 하샤드 수입니다.

입출력 예 #2
12의 모든 자릿수의 합은 3입니다. 12는 3으로 나누어 떨어지므로 12는 하샤드 수입니다.

입출력 예 #3
11의 모든 자릿수의 합은 2입니다. 11은 2로 나누어 떨어지지 않으므로 11는 하샤드 수가 아닙니다.

입출력 예 #4
13의 모든 자릿수의 합은 4입니다. 13은 4로 나누어 떨어지지 않으므로 13은 하샤드 수가 아닙니다.
```
### 문제풀이
- x를 String.valueOf()로 문자열로 변환
- 문자열을 차례대로 for문으로 순회하면서 num.charAt()으로 각각의 문자열을 추출
- 추출한 문자열을 int형으로 변환 후 sum_digits 변수에 더한다.
- for문을 빠져나온 후 x를 sum_digits로 나눈 나머지가 0이 아니라면 answer에 false를 저장 후 answer를 return해준다.
### 정답코드
```java
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String num = String.valueOf(x);
        int sum_digits = 0;
        for(int i=0; i < num.length(); i++){
            sum_digits += (num.charAt(i) - '0');
        }
        if(x % sum_digits != 0){
            answer = false;
        }
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- 