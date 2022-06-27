## 6. [연습문제] 없는 숫자 더하기

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/86051
### 문제설명
```
0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
- 1 ≤ numbers의 길이 ≤ 9
  - 0 ≤ numbers의 모든 원소 ≤ 9
  - numbers의 모든 원소는 서로 다릅니다.
  
입출력 예
numbers	          result
[1,2,3,4,6,7,8,0]	14
[5,8,4,0,6,7,9]	    6


(입출력 예 설명)
입출력 예 #1
5, 9가 numbers에 없으므로, 5 + 9 = 14를 return 해야 합니다.


입출력 예 #2
1, 2, 3이 numbers에 없으므로, 1 + 2 + 3 = 6을 return 해야 합니다.
```
### 문제풀이
- contains함수를 만든다.
    + 파라미터는 int[]과 key값으로 지정
    + Arrays.stream()과 anyMatch를 사용해 arr안에 key값이 있다면 true, 없다면 false를 반환
- for문으로 0~9를 순회하면서 contains함수를 통해 만약 i가 numbers에 없다면 answer에 그 숫자를 더한 후 answer를 반환
### 정답코드
```java
import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        for(int i = 0; i < 10; i++){
            if(!contains(numbers, i)){
                answer += i;
            }
        }
        return answer;
    }
    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- contains() 함수 변형
    + contains() 함수 사용해서 풀려고 했지만 아래와 같은 에러가 발생
  ```
  /Solution.java:5: error: cannot find symbol
              if(numbers.contains(i)){
                        ^
    symbol:   method contains(int)
    location: variable numbers of type int[]
  1 error
  ```
    + 아마 contains는 String 배열에서만 사용가능한 것 같음.
    + https://www.delftstack.com/ko/howto/java/array-contains-java/
- stream() 사용법
  ```java
  //int 배열
  int[] intArray = { 1, 2, 3, 4, 5 };
  IntStream intStream = Arrays.stream(intArray);
  intStream.forEach(a -> System.out.print(a + ","));
  ```
    + https://coding-factory.tistory.com/574

- final 키워드에 대한 자세한 설명 글
    + https://velog.io/@jsj3282/final-%ED%82%A4%EC%9B%8C%EB%93%9C

## 7. [연습문제] 음양 더하기


- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/76501
### 문제설명
```
어떤 정수들이 있습니다. 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와
이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다.
실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.

제한사항
- absolutes의 길이는 1 이상 1,000 이하입니다.
  - absolutes의 모든 수는 각각 1 이상 1,000 이하입니다.
- signs의 길이는 absolutes의 길이와 같습니다.
  - signs[i] 가 참이면 absolutes[i] 의 실제 정수가 양수임을, 그렇지 않으면 음수임을 의미합니다.
  
입출력 예
absolutes	signs	            result
[4,7,12]	[true,false,true]	  9
[1,2,3]	    [false,false,true]	  0


(입출력 예 설명)

입출력 예 #1
- signs가 [true,false,true] 이므로, 실제 수들의 값은 각각 4, -7, 12입니다.
- 따라서 세 수의 합인 9를 return 해야 합니다.

입출력 예 #2
- signs가 [false,false,true] 이므로, 실제 수들의 값은 각각 -1, -2, 3입니다.
- 따라서 세 수의 합인 0을 return 해야 합니다.
```
### 문제풀이
- absolutes와 signs의 길이는 같기 때문에 반복문을 사용해 같이 돌린다.

- sign[i]가 true일 때는 +를 false일 때는 -를 해준다.
### 정답코드
```java
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int n = 0;
        for(int absolute : absolutes){
            n++;
        }
        for(int i = 0; i < n; i++){
            if (signs[i]){
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
```
<span style="background-color: rgba(242,179,188,0.5)">**수정**</span>
```java
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int n = signs.length;
        for(int i = 0; i < n; i++){
            if (signs[i]){
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- length() 함수 에러
    + length() 함수 사용해서 signs나 absolutes의 길이를 구하려고 했지만 아래와 같은 에러가 발생
  ```
  /Solution.java:4: error: cannot find symbol
          int n = absolutes.length();
                           ^
    symbol:   method length()
    location: variable absolutes of type int[]
  1 error
  ```
    + 아마 length()는 int[] 배열에서는 사용불가능 한 것 같음.
    + https://www.delftstack.com/ko/howto/java/java-get-array-length/#%EB%B0%B0%EC%97%B4-length-%EC%86%8D%EC%84%B1%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC-java%EC%97%90%EC%84%9C-%EB%B0%B0%EC%97%B4-%EA%B8%B8%EC%9D%B4-%EA%B0%80%EC%A0%B8-%EC%98%A4%EA%B8%B0
    + 다른 사람 풀이를 통해 int[]은 length로 길이를 반환받을 수 있다는 것을 알게됨.



## 8. [연습문제] 평균 구하기


- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12944
### 문제설명
```
정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.

제한사항
- arr은 길이 1 이상, 100 이하인 배열입니다.
- arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.

입출력 예
arr	       return
[1,2,3,4]	2.5
[5,5]      	 5
```
### 문제풀이
- for문을 사용해 모든 값을 더한 후 arr의 길이만큼 나누어준다.
### 정답코드
```java
class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++){
            answer += arr[i];
        }
        answer /= n;
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- 



## 9. [연습문제] 핸드폰 번호 가리기

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12948
### 문제설명
```
프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.

제한 조건
- phone_number는 길이 4 이상, 20이하인 문자열입니다.

입출력 예
phone_number	   return
"01033334444"	"*******4444"
"027778888"	    "*****8888"
```
### 문제풀이
- phone_number의 길이만큼 순회하면서 마지막 4자리 전까지는 answer에 *을 추가하고 마지막 4자리는 기존 phone_number의 값을 추가
- 조건문으로 마지막 4자리에서 분기처리
- charAt()을 통해 phone_number의 값을 가져옴
### 정답코드
```java
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int n = phone_number.length();
        for(int i=0; i < n; i++){
            if(i < n-4){
                answer += "*";
            } else{
                answer += phone_number.charAt(i);
            }
        }
        System.out.println(answer);
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- Java에서는 String에서 바로 인덱스 접근이 안되어서 관련 자료를 찾아봤다.
    + Java에서 문자열의 특정 인덱스에 있는 문자 바꾸기
        * https://www.techiedelight.com/ko/replace-character-specific-index-java-string/
    + 자바 String 문자열 사용법 정리(Java String 관련 함수 잘 정리되어있음.)
        * https://yeolco.tistory.com/30

- charAt과 toCharArray 함수 비교하는 글(정말 좋은 글인듯)
    + https://shanepark.tistory.com/327



## 10. [연습문제]

- 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/12950
### 문제설명
```
행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.
2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

제한 조건
- 행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.

입출력 예
arr1	              arr2	        return
[[1,2],[2,3]]	[[3,4],[5,6]]	[[4,6],[7,9]]
[[1],[2]]	      [[3],[4]]	      [[4],[6]]
```
### 문제풀이
- 가로 n, 세로 m의 값으로 answer의 배열 선언 및 초기화
- 2차원 배열이기 때문에 이중 for문으로 모든 인덱스 순회
- arr1, arr2 각각의 [i][j] 인덱스 끼리 더한값 answer[i][j]에 넣어주기
### 정답코드
```java
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr1[0].length;
        int[][] answer = new int[n][m];
        for(int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1[i].length; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
```

### 문제풀면서 참고했던 자료 혹은 내용
- 처음에 answer의 배열을 초기화해주지 않고 `int[][] answer = {}'` 상태에서 진행했을 때 아래와 같은 오류가 났다 👉🏻 배열 초기화 진행
  ```
  Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
  ```
- Java에서 배열에 새 요소를 추가하는 방법
    + https://www.delftstack.com/ko/howto/java/how-to-add-new-elements-to-an-array-in-java/
- [Java] 자바 2차원 배열 생성(선언 및 초기화)
    + https://keichee.tistory.com/423
