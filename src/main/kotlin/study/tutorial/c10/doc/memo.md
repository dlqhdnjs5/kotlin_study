# 제네릭

### 제네릭 이란
* 자료형의 객체들을 다루는 메서드나 클래스에서 컴파일 시간에 자료형을 검사해 적당한 자료형을 선택할 수 있도록 하기위함
것

### 제네릭 일반적인 사용
* 앵글 브래킷(<>) 사이에 형식 매개변수(T)를 사용해 선언
* 형식 매개변수는 자료형을 대표하는 용어로 T와 같이 특정 영문의 대문자로 사용


```kotlin
class Box<T> (a: T) {
    var name = a
}

fun main() {
    val box1: Box<Int> = Box(1)
    val box2 = Box("bowon")
    
    println(box1.name) //1
    println(box2.name) // hello
}
```


## 형식 매개변수의 이름
* 강제사항은 없으나 일종의 규칙처럼 사용된다.
  * E : 요소
  * K : 키
  * N : 숫자
  * T : 타입
  * V : 값
  * S, U, V etc. 두번째, 세번째, 네번째 형식 

## 형식 매개변수를 한 개 이상 받는 클래스
* 인스턴스를 생성하는 시점에서 클래스의 자료형을 정하게 된다.
* 제네릭 클래스 내에 메서드에도 다음과 같이 형식 매개변슈를 사용

```kotlin
class MyClass<T> { // 한 개의 형식 매개변수를 가지는 클래스
    fun myMethod(a: T) { // 메서드의 매개변수 자료형에 사용됨
        ...
    }
}
```
### 프로퍼티에 지정하는경우
* 주 생성자나 부 생성자에 형식 매개변수를 지정해 사용.

* 주생성자의 형식 매개변수
```kotlin
class MyClass<T> (val myProp: T) { // 주생성자의 프로퍼티
    
}
```



* 부생성자의 형식 매개변수
```kotlin
class MyClass<T>  { 
    val myProp: T// 프로퍼티
    
    constructor(myProp: T) { // 부 생성자 사용
        this.myProp = myProp
    }
}
```


### 형식매개변수의 null 제어

* null 을 하용하지 않으려면
  * 특정 자료형으로 제한한다. -> <T: any>

```kotlin
class GenericNull<T> {
    fun EqualityFunc(arg1: T, arg2: T) {
        println(arg1?.equals(arg2))
    }
}

fun main() {
  val obj = GenericNull<String>() // non-null 로 선언됨
  obj.EqualityFunc("Hello", "world") // null 이 허용되지 않음

  val obj2 = GenericNull<Int?>() // null 이 가능한 형식으로 선언
  obj2.EqualityFunc(null, 10) // null 사용
}
```


## 제네릭 함수 혹은 메서드
* 제네릭 함수 혹은 메서드
  * 해당 함수나 메섣 앞쪽에 <T> 와 같이 지정
  * 자료형의 결정은 함수가 호출될 때 컴파일러가 자료형 추론
  * 이 자료형은 반환 자료형과 매개변수 자료형에 사용할 수 있다.

```kotlin

fun <T> genericFunc(arg: T): T? { ... } // 매개변수와 반환 자료형에 형식 매개변수 T가 사용됨

fun <K, V> put(key: K, value: V): Unit { ... } // 형식 매개변수가 여러개인 경우
```


* 예제 
```kotlin
fun <T> find(a: Array<T>, Target: T): Int {
    for (i in a.indices) {
        if (a[i] == Target) return i
    }

    return -1
}

fun main() {
    val arr1: Array<String> = arrayOf("Apple", "Banana", "Cherry", "Durian")
    val arr2: Array<Int> = arrayOf(1, 2, 3, 4)

    println("arr,indices ${arr1.indices}") // indices 는 배열의 유효범위 반환
    println(find<String>(arr1, "Cherry"))
    println(find(arr2, 2)) // 요소 2의 인덱스 찾아내기
}
```

### 제네릭과 람다식
* 형식 매개변수로 선언된 함수의 매개변수를 연산할 경우

```kotlin
fun <T> add(a:T, b:T): T {
    return a + b // 오류 ! 자료형 결정할수 없음
}
```

* 람다식 사용해서 연산식 작성 가능

```kotlin
fun <T> add(a: T, b: T, op:(T, T) -> T): T {
    return op(a, b)
}

fun main() {
    val result = add(2,3, {a, b -> a + b})
    // val result = add(2,3) {a, b -> a + b} 와 같음
    println(reuslt)
}
```


### 자료형 제한하기
* 형식 매개변수를 특정한 자료형을 제한
  * 자료형의 사용범위를 좁히기 위해 자료형을 제한
  * 자바에서는 extends 나 super 를 사용해 자료형을 제한
  * 코틀린은 콜론(:)과 자료형을 기입하면 형식 매개변수 T의 자료형이 기입한 자료형으로 제한됨

```kotlin
class Calc<T: Number> {
    fun plus(arg1: T, arg2: T): Double {
        return arg1.toDouble() + arg2.toDouble()
    }
}

fun main() {
  val ss = Calc<Int>()
  ss.plus(2, 3)
}
```


## 상, 하위 형식의 가변성
### 가변성 이란?
* 형식 매개변수가 클래스 계층에 어떤 영향을 미치는지 정의
  * 형식 A의 값이 필요한 모든 장소에 형식 B의 값을 넣어도 아무 문제가 없다면 B는 A의 하위 형식
  * Int는 Number의 하위 클래스
* 클래스와 자료형
  * String
    * 클래스인가(O), 자료형인가(O)
  * Stinrg
    * 클래스인가(X), 자료형인가(O)
  * List
    * 클래스인가(O), 자료형인가(O)
  * List<String>
    * 클래스인가(X), 자료형인가(O)

### 하위클래스는 상위 클래스가 수용
```kotlin
val integer: Int = 1
val number: Number = integer // 하위 자료형 Int 를 Number가 수용함
```

```kotlin
val integer: Int = 1;
val nullableInteger: Int? =  integer
```

## 가변셩의 3가지 유형
### 3가지 유형
* 공변성 
  * T1 이 T의 하위 자료형이면, C<T1> 는 C<T> 의 하위 자료형이다
  * 생산자 입장의 out 성질
* 반 공변성
  * T1 이 T의 하위 자료형이면, C<T> 는 C<T1> 의 하위 자료형이다
  * 생산자 입장의 in 성질
* 무변성
  * C<T> 와 C<T1>는 아무 관계가 없다
  * 생산자 + 소비자

  

무변성
```kotlin
class Box<T>(val size: Int)

val anys: Box<Any> = Box<Int>(10) 자료형 불일치
```

공변성
```kotlin
class Box<out T>(val size: Int)

val anys: Box<Any> = Box<Int>(10) // 객체 생성 가능
```

반공변성
```kotlin
class Box<in T>(val size: Int)

val anys: Box<Any> = Box<Int>(10) // 자료형 불일치
val nothing = Box<Nothing> = Box<Int>(10) // 생성 가능 
```

* in 은 입력 형식 매개변수에서 가능하고 out은 출력 형식 매개변수에서 가능 (in 은 setter, out 은 getter)

## 자료형 프로젝션

### 선언 지점 변성
  * 클래스 자체에 가변성을 지정하는 방식으로 클래스에 in/out 을 지정할 수 있다.
  * 선언하면서 지정하면 클래스의 공변성을 전체적으로 지정하는 것
    * 클래스를 사용하는 장소에서는 따로 자료형을 지정해 줄 필요가 없음


### 사용 지점 변성
  * 메서드 매개변수에서 또는 제네릭 클래스를 생성할 때와 같이 사용 위치에서 가변성을 지정하는 방식


### 사용지점 변성 예
```kotlin
  class Box<T>(var item: T)
```

* Box의 사용지점에서 box의 item을 얻느냐(get) 설정하느냐(set)에 따라 out/in 결정

```kotlin
fun <T> printObj(box: Box<out Animal>) {
  val obj: Animal = box.item// item의 값을 얻음(get)
  box.item = Animal() // 오류 ! set 하려고 할때는 in 이 지정되어야 한다.
  println(obj)
}
```