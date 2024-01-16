## 5장 조건문

### 중괄호 생략
수행할 문장이 한줄이면 중괄호 생략 가능하다.
```kotlin
    val a = 1
    val b = 2

    if ( a < b )
        println("Hello")
```

### if ~ else 문의 간략화
if else 문을 한줄로 간략하게 사용가능하다.
```kotlin
    val a = 1
    val b = 2
    if (a > b)
        println("hello")
    else 
        println("hi")
    
    if (a > b) println("hello") else println("hi")
```

#### 블록을 함게 사용하는경우
블록내 마지막 식이 return 을 생략하여 리턴이 가능하다.
```kotlin
    val a = 1
    val b = 2
    
    val max = if (a > b) {
        println("hello")
        a
    } else {
        println("hi")
        b
    }
    
    println(max)
```

### 범위 연산자
변수명 in 시작값..마지막 값  으로 사용이 가능하다.

```kotlin
 val score = 8
    
    val level = if (score < 3) {
        "low"
    } else if (score in 4..8) {
        "middle"
    } else {
        "high"
    }
    
    println(level)
```

### when 
* 코틀린이 제공하는 새로운 키워드.
* java 의 switch ~ case 를 대체하는 코틀린에서만 제공되는 문법.

```kotlin
    val x = 5

    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        3,4 -> println("x 는 3 or 4 ")
        parseInt("5") -> println("x == 5")
        in 6..8 -> println("x 는 6 과 8 내 속합니다.")
        !in 10..12 -> println("x 는 10 과 12 내 속하지 않습니다.")
        is Int -> println("x 는 Int 형 입니다.")
        else -> {
            println("x 는 1,2 아니면서 3 ~ 6 에 포함되지 않습니다.")
        }
    }

    // return 을 받을수도 있음
    val result = when (x) {
        1 -> true
        else -> false
    }
```

#### 인자가 없는 when
특정 인자에 제한하지 않고 다양한 조건 구성이 가능하다.

```kotlin
 val score = 8

    when {
        score > 9 -> println("A")
        score in 7..8 -> println("B")
        score in 5..7 -> println("D")
        else -> println("F")
    }
```


### for문
#### for 문의 선언
java 의 for 문처럼 세미콜론을 사용하지 않는다.
```kotlin
    for (x in 1..6) {
        println(x)
    }

    for (x in 1..6) println(x)
```

#### 하행 반복
for문을 통해 정해진 수의 반복문을 역순으로 실행하고 싶을때 사용

```kotlin
    for (i in 5 downTo 1) print(i) // 54321
    for (i in 5..1) print(i) // in 사용시 5 -> 1 로 내려가도록 사용하지 않는다.
```

#### 필요한 단계 증가 - step
for문의 인자 i 가 step 만큼 더해져 사용이 된다.
```kotlin
    for (i in 1..5 step 2) print(i) // 1, 3, 5
```

#### 하행반복 + 필요한 단계 증가 - step
```kotlin
    for (i in 5 downTo 1 step 2) print(i)   // 5, 3, 1
```

#### unitl
반복문실행시 마지막 범위 - 1 을 하는것 대신 until을 사용할수 있다.

```kotlin
val temp = 10
for (i in 0..10-1) print(i)
// 둘이 같은 결과를 나타낸다.
for (i in 0 until 10) print(i)
```

### 흐름 제어
* return : 함수에서 결괏값을 반환하거나 지정된 라벨로 이동.
* break : for 문이나 while 에서 조건식에 상관없이 반복문을 끝낸다.
* continue : for 이나 while 의 반북문의 본문을 모두 수행하지 않고 다시 조건으로 넘어간다.

#### 람다식에서의 return, label
* 일반적으로 람다식내부에서는 return 을 사용할수 없다.
* 하지만 람다식 함수를 inline 으로 하면 return이 사용가능하다.
```kotlin
inline fun inlineLamda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

fun 람다식에서의_return() {
    println("시작")

    inlineLamda(10, 20) { a, b ->
        val result = a + b
        if (result < 40 ) return // inlineLamda 는 inline 함수이기때문에 inlineLamda 만 빠져나오는것이 아니라
                                 //  함수 본문빠져나가는 비지역 반환이 일어 나게 됨.
        println("끝") // result 가 40 보다 작으면 도달하지 못하여 실행되지 못함
    }

    println("위 result가 40 보다 작으면 나는 실행되지 못함")
}
```
* 위 내용은 inline 함수로 인해 비지역 반환이 일어나게 됨으로 맨아래 println() 문이 실행되지 못한다.
* 따라서 label을 이용하여 원하는 함수로 빠져 나갈수 있다.

```kotlin
inline fun inlineLamda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

fun 람다식에서의_return() {
    println("시작")

    inlineLamda(10, 20) lit@{ a, b ->
        val result = a + b
        if (result < 40 ) return@lit  // @label 을 사용하여 특정 함수를 빠져나갈수 있게됬다.
        println("끝")            // result 가 40 보다 작으면 도달하지 못하여 실행되지 못함
    }

    println("label 사용으로 인해 이제 나는 print 가 될수 있음.")
}
```
#### 람다식 반환
```kotlin
fun 람다식_반환 () {
    val message = labelFun@{ num: Int -> 
        if (num > 10) 
            return@labelFun "bigger than 10"
        else
            "less than 10"
    }

    print(message)
}
```
* 이 label 을 통해 람다식 반환을 사용할수도 있다.


#### 일반 익명함수의 사용
* 람다 함수가 아닌 일반 익명함수를 사용하게되면 비지역 반환이 일어나지 않게되어 label 사용이 필요없다.
```kotlin
fun 일반_익명함수() {
    println("시작")

    inlineLamda(10, 20, fun (a, b) {
        val result = a + b
        if (result < 40 ) return
       
        println("끝")
    })

    println("위 result가 40 보다 작으면 나는 실행되지 못함")
}
```


### 예외 처리
* 실행 도중 잠재적인 오류까지 검사할수 없기 때문에 정상적으로 실행이 되다가 비정상적으로 프로그램이 종료되는경우.
  * 운영체제의 문제(잘못된 시스템 호출의 문제)
  * 입력값의 문제 (존재하지 않는 파일 혹은, 숫자 입력란에 문자 입력 등)
  * 받아들일수 없는 연산 (0으로 나누기)
  * 메모리 할당 실패 및 부족
  * ...
  
#### 특정 예외 처리
* 발생할수 있는 특정 예외에 대해 catch 를 하여 처리할수 있다.
```kotlin
fun 예외처리 () {
    val a = 6
    val b = 0
    val c: Int

    try {
        c = a/b
    } catch (exception: Exception) {
        println(exception)
    } finally {
        println("finally")
    }
}
```

* java 와 코틀린의 예외 처리 차이
  * 코틀린은 체크 익셉션 에대한 try catch를 강제하지 않음.
  * 코틀린의 throw, try 키워드는 if나 when과 마찬가지로 expression이다. 그러나 if와 달리 try의 본문은 반드시 중괄호로 둘러싸야 한다.
```kotlin
fun readNumber(reader: BufferedReader) {
    val number = try {
        reader.readLine().toInt()
    } catch (e: NumberFormatException) {
        null
    }

    println(number)
}
```