## 16. [연습문제] 문자열 다루기 기본

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12918
- 난이도 : 중하
### 문제설명
```
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.

제한 사항
- s는 길이 1 이상, 길이 8 이하인 문자열입니다.


(입출력 예)
s	    return
"a234"	false
"1234"	true
```
### 문제풀이
- 문자열 s의 길이가 4 혹은 6인지를 확인하는 분기처리
- 문자열 s를 for문으로 순회하면서 해당 문자를 아스키코드로 변환시켜주고 0~9에 해당하는 아스키코드 48~57 사이라면 answer에 true값을 저장한다.
- 만약 범위 밖이라면 바로 false값을 return한다.
### 정답코드
```java
class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        if (len == 4 || len == 6){
            System.out.println("문자열 길이가 4 or 6");
            for(int i = 0; i < s.length(); i++){
                int ascii_code = s.charAt(i);
                if(ascii_code >= 48 && ascii_code <= 57){
                    System.out.println(String.format("%d, 48~57사이",ascii_code));
                    answer = true;
                } else {
                    System.out.println(String.format("%d, 범위밖",ascii_code));
                    return false;
                }
            }
        } else {
            return false;
        }
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- Java: 아스키코드, Char, String 변환과 응용
    + https://devyoseph.tistory.com/43


## 17. [연습문제] 문자열 내 p와 y의 개수

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12916
- 난이도 : 중하
### 문제설명
```
대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요.
'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.

제한사항
- 문자열 s의 길이 : 50 이하의 자연수
- 문자열 s는 알파벳으로만 이루어져 있습니다.


(입출력 예)
s	       answer
"pPoooyY"	true
"Pyy"	   false


입출력 예 설명
입출력 예 #1
'p'의 개수 2개, 'y'의 개수 2개로 같으므로 true를 return 합니다.

입출력 예 #2
'p'의 개수 1개, 'y'의 개수 2개로 다르므로 false를 return 합니다.

※ 공지 - 2021년 8월 23일 테스트케이스가 추가되었습니다.
```
### 문제풀이
- 문자열 s를 for문으로 하나씩 순회하면서 p, P, y, Y일 경우에 p의 개수와 y의 개수 각각 카운트
- p의 개수와 y의 개수를 비교해서 false혹은 true를 return해준다.
### 정답코드
```java
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p_num = 0;
        int y_num = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='p'||s.charAt(i) == 'P'){
                p_num++;
            } else if(s.charAt(i) == 'y'||s.charAt(i) == 'Y'){
                y_num++;
            }
        }
        if (y_num != p_num){
            return false;
        } else {
            return answer;
        }
        
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- 

## 18. [연습문제] 서울에서 김서방 찾기

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12919
- 난이도 : 중하
### 문제설명
```
String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요.
seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.

제한 사항
- seoul은 길이 1 이상, 1000 이하인 배열입니다.
- seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
- "Kim"은 반드시 seoul 안에 포함되어 있습니다.


(입출력 예)
seoul	             return
["Jane", "Kim"]	"김서방은 1에 있다"
```
### 문제풀이
- String 배열 seoul을 for문으로 순회하면서 "Kim"이 맞는지 확인
- 맞다면 String format을 사용해 "김서방은 [index]에 있다"를 answer값에 넣고 answer를 return
### 정답코드
```java
class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        for(int i = 0; i < seoul.length; i++){
            if (seoul[i].equals("Kim")) {  // seoul[i] == "Kim"은 안됨.
                answer = String.format("김서방은 %d에 있다", i);
            }
        }
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- String format
    + https://velog.io/@kdhyo/JAVAString-Format-%EC%82%AC%EC%9A%A9%EB%B2%95
- [JAVA] String에서의 ==와 equals() 차이점
    + https://go-coding.tistory.com/35


## 19. [연습문제] 수박수박수박수박수박수?

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12922
- 난이도 : 중하
### 문제설명
```
길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.

제한 조건
- n은 길이 10,000이하인 자연수입니다.


(입출력 예)
n	return
3	"수박수"
4	"수박수박"
```
### 문제풀이
- 짝수 홀수 분기처리
- 짝수 -> for문으로 n/2만큼 반복해 answer에 "수박"을 추가
- 홀수 -> for문으로 n/2만큼 반복해 answer에 "수박"을 추가 후에 마지막에 "수"를 추가
### 정답코드
```java
class Solution {
    public String solution(int n) {
        String answer = "";
        if (n % 2 == 0){
            for(int i = 0; i < n/2; i++){
                answer += "수박";
            }
        } else {
            for(int i = 0; i < n/2; i++){
                answer += "수박";
            }
            answer += "수";
        }
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- 


## 20. [해쉬] 완주하지 못한 선수

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/42576
- 난이도 : 중하
### 문제설명
```
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
- 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
- completion의 길이는 participant의 길이보다 1 작습니다.
- 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
- 참가자 중에는 동명이인이 있을 수 있습니다.


(입출력 예)
participant	                                                       completion	                 return
["leo", "kiki", "eden"]	                                        ["eden", "kiki"]	             "leo"
["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
["mislav", "stanko", "mislav", "ana"]	                  ["stanko", "ana", "mislav"]	        "mislav"


입출력 예 설명
예제 #1
"leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2
"vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3
"mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
```
### 문제풀이
- 
### 정답코드
```java
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> participant_list = new ArrayList<>(Arrays.asList(participant));
        List<String> completion_list = new ArrayList<>(Arrays.asList(completion));
        for(String el : participant_list) {
            if(participant_list.indexOf(el) != participant_list.lastIndexOf(el)){
                answer = el;
            }
        }
        participant_list.removeAll(completion_list);
        if(participant_list.size() == 1){
            answer = String.join("", participant_list);
        }
        return answer;
    }
}
```
- [코드실행]했을 때 주어진 테스트 3개는 성공했지만 [제출]했을 때는 몇개의 테스트케이스 틀리고 효용성 테스트에서 시간초과..

- 예전에 파이썬에서 풀었던 방식 참고

<span style="background-color: rgba(242,179,188,0.5)">**수정**</span>

```java
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i = 0; i < completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        if (answer == ""){
            answer = participant[participant.length-1];
        }
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- [Java] 자바 배열 정렬하기(오름차순, 내림차순) Arrays.sort()
    + https://coding-factory.tistory.com/549
- Java - ArrayList를 String으로 변환
    + https://codechacha.com/ko/java-convert-arraylist-to-string/
- [TIL]자바 리스트 중복 항목만 추출 : indexOf, lastIndexOf, HashSet 활용
    + https://whitepro.tistory.com/411
- Collection remove에 대해
    + `Exception in thread "main" java.lang.UnsupportedOperationException: remove`
    + https://kkwonsy.tistory.com/14
- [JAVA] Arrays.asList()
    + https://m.blog.naver.com/roropoly1/221140156345
- Java 변수 선언 & 초기화 방법 - Array, List, Set, Map
    + http://dveamer.github.io/backend/InitializingJavaVariable.html
- [Java]배열과 리스트 초기화하는 방법
    + https://dpdpwl.tistory.com/110
- 자바(Java) 리스트(List,ArrayList) 이용하는 방법
    + https://mainia.tistory.com/2323
- [Java] 자바 ArrayList, List의 교집합, 부분집합, 차집합, 합집합 구하는 방법 총정리
    + https://ddolcat.tistory.com/794