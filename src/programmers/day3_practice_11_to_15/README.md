## 11. [연습문제] x만큼 간격이 있는 n개의 숫자

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12954
- 난이도 : 하
### 문제설명
```
함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다.
다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

제한 조건
- x는 -10000000 이상, 10000000 이하인 정수입니다.
- n은 1000 이하인 자연수입니다.

입출력 예
x	n	answer
2	5	[2,4,6,8,10]
4	3	[4,8,12]
-4	2	[-4, -8]
```
### 문제풀이
- n개의 리스트를 지니기때문에 for문으로 n번만큼 수행
- x부터 시작해 x씩 증가하는데 만약 i가 0부터 시작이면 첫번째 값이 0이됨 -> i=1부터 시작
- i가 1부터 시작하면 answer[]의 인덱스가 1부터 시작하고 결국 에러발생 -> 인덱스는 i-1로 설정
- i*x한 값을 answer[i-1]로 넣는다.
### 정답코드
```java
class Solution {
  public long[] solution(int x, int n) {
    long[] answer = new long[n];
    for(int i = 1; i <= n; i++){
      answer[i-1] = (i*x);
    }
    return answer;
  }
}
```
<span style="background-color: rgba(242,179,188,0.5)">**수정**</span>
```java
class Solution {
  public long[] solution(long x, int n) {
    long[] answer = new long[n];
    for(int i = 1; i <= n; i++){
      answer[i-1] = (i*x);
    }
    return answer;
  }
}
```
### 문제풀면서 참고했던 자료 혹은 내용
- 13,14번 문제만 틀려서 질문하기를 봤더니 매개변수 int x -> long x로 변경해주니 해결 되었음.


## 12. [연습문제] 부족한 금액 계산하기

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/82612
- 난이도 : 중하
### 문제설명
```
새로 생긴 놀이기구는 인기가 매우 많아 줄이 끊이질 않습니다.
이 놀이기구의 원래 이용료는 price원 인데, 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다.
즉, 처음 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다.
놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return 하도록 solution 함수를 완성하세요.
단, 금액이 부족하지 않으면 0을 return 하세요.


제한사항
- 놀이기구의 이용료 price : 1 ≤ price ≤ 2,500, price는 자연수
- 처음 가지고 있던 금액 money : 1 ≤ money ≤ 1,000,000,000, money는 자연수
- 놀이기구의 이용 횟수 count : 1 ≤ count ≤ 2,500, count는 자연수


(입출력 예)
price	money	count	result
3	     20	      4	     10


입출력 예 설명
입출력 예 #1
이용금액이 3인 놀이기구를 4번 타고 싶은 고객이 현재 가진 금액이 20이라면,
총 필요한 놀이기구의 이용 금액은 30 (= 3+6+9+12) 이 되어 10만큼 부족하므로 10을 return 합니다.

참고 사항
- 미션 언어는 Java, JavaScript, Python3, C++ 만 해당 됩니다.
- 같은 코드를 제출한 사람이 여럿이라면 코드를 가장 먼저 제출한 분께 상품을 드립니다.
- 좋아요 수가 동일할 경우 코드를 가장 먼저 제출한 분께 상품을 드립니다.
```
### 문제풀이
- answer에는 count번째 타게되었을 때 총 비용을 저장한다.
- for문은 1~n이기 때문에 i는 1부터 시작한다.
- 만약 총 비용인 answer가 가진돈인 money보다 크거나 같다면 0을 return
- 그 외에는 answer - money을 return 하도록 조건문으로 분기처리.
### 정답코드
```java
class Solution {
  public long solution(int price, int money, int count) {
    long answer = 0;
    for(int i = 1; i <= count; i++){
      answer += price * i;
    }
    if (money >= answer){
      return 0;
    } else{
      return answer-money;
    }
  }
}
```
### 문제풀면서 참고했던 자료 혹은 내용
- 

## 13. [연습문제] 2016년

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12901
- 난이도 : 중하
### 문제설명
```
2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT입니다.
예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.

제한 조건
- 2016년은 윤년입니다.
- 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)


(입출력 예)
a	b	result
5	24	"TUE"
```
### 문제풀이
- calendar라는 배열을 생성해서 요일을 저장해서 calendar[a][b]에 맞는 요일을 꺼낼 수 있게 해서 문제 해결할 계획

- months int 배열을 생성 후 inxex 값에 해당하는 달의 일 수를 저장 -> ex) months[1] = 31 의미 : 1월은 31일까지 있다.

- days는 String 배열 생성 후 1월1일이 금요일부터 시작이니깐 FRI부터 차례대로 값을 저장

- calendar라는 String 2차원 배열 생성 후 index값과 월, 일을 맞춰주기위해 각각 13,32로 배열 초기화

- for문은 2중 for문으로 1월과 1일부터 순회해야하기 때문에 각각 i와 j는 1부터 시작

- cnt로 days배열을 순회하고 cnt값이 7이되면 cnt=0으로 초기화시켜줘야지 0~6이 계속 적으로 반복된다.

### 정답코드
```java
import java.util.Arrays;

class Solution {
  public String solution(int a, int b) {
    String answer = "";
    String[][] calendar = new String[13][32];
    int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    int cnt = 0;
    for (int i = 1; i <= 12; i++){
      for (int j = 1; j <= months[i]; j++){
        if(cnt == 7){
          cnt = 0;
          calendar[i][j] = days[cnt];
          cnt ++;
        } else {
          calendar[i][j] = days[cnt];
          cnt ++;
        }
      }
    }
    // for(int i = 0; i <= 12; i++){
    //     System.out.println(Arrays.toString(calendar[i]));
    // }
    answer = calendar[a][b];
    return answer;
  }
}
```
### 문제풀면서 참고했던 자료 혹은 내용
- 문제풀이 진행 중 배열의 값을 출력하기 위해 Arrays의 toString함수 사용
  + https://hianna.tistory.com/510


## 14. [연습문제] 나누어 떨어지는 숫자 배열

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12910
- 난이도 : 중하
### 문제설명
```
array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

제한사항
- arr은 자연수를 담은 배열입니다.
- 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
- divisor는 자연수입니다.
- array는 길이 1 이상인 배열입니다.


(입출력 예)

arr	          divisor	         return
[5, 9, 7, 10]	5	           [5, 10]
[2, 36, 1, 3]	1	        [1, 2, 3, 36]
[3,2,6]	       10	             [-1]


(입출력 예 설명)

입출력 예#1
arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.

입출력 예#2
arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.

입출력 예#3
3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.
```
### 문제풀이
- 
### 정답코드
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                list.add(arr[i]);
            }
        }
        if(list.size() == 0){
            list.add(-1);
        }
        // ArrayList 정렬
        Collections.sort(list);
        // ArrayList를 int[]로 변경
        int[] answer = list.stream()
            .mapToInt(i -> i)
            .toArray();
        return answer;
    }
}
```


## 15. [연습문제] 내적

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/70128
- 난이도 : 중하
### 문제설명
```
길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다. a와 b의 내적을 return 하도록 solution 함수를 완성해주세요.

이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. (n은 a, b의 길이)

제한사항
- a, b의 길이는 1 이상 1,000 이하입니다.
- a, b의 모든 수는 -1,000 이상 1,000 이하입니다.


(입출력 예)
a	              b	          result
[1,2,3,4]	[-3,-1,0,2]     	3
[-1,0,1]	[1,0,-1]	       -2


입출력 예 설명
입출력 예 #1
a와 b의 내적은 1*(-3) + 2*(-1) + 3*0 + 4*2 = 3 입니다.

입출력 예 #2
a와 b의 내적은 (-1)*1 + 0*0 + 1*(-1) = -2 입니다.
```
### 문제풀이
- 문제에서 설명하는 내적 그대로 적용
### 정답코드
```java
class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i < a.length; i++){
           answer += a[i]*b[i];
        }
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- 
### 문제풀면서 참고했던 자료 혹은 내용
- ArrayList 배열 사용법
  + https://crazykim2.tistory.com/558
  + https://psychoria.tistory.com/765
- ArrayList 요소 추가
  + https://www.delftstack.com/ko/howto/java/how-to-add-new-elements-to-an-array-in-java/
- ArrayList 정렬하기 (오름차순, 내림차순, 사용자 정의)
  + https://hianna.tistory.com/569
- Integer ArrayList을 int 배열로 변환 방법
  + https://velog.io/@deannn/Java-int%ED%98%95-ArrayList-%EB%B0%B0%EC%97%B4-%EB%B3%80%ED%99%98
