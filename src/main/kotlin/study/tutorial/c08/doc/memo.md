# 8장 프로퍼티와 초기화


## 프로퍼티의 접근

* 자바의 필드
  * 단순한 변수 선언만 가지기 때문에 접긍늘 위한 메서드를 따로 만들어야 함
* 코틀린의 프로퍼티
  * 변수 선언과 기본적인 접근 메서드를 모두 가지고 있음
  * 따로 접근 메서드를 만들지 않아도 내부적으로 생성하게 됨 


## 자바에서 필드를 사용할때
  * getter 와 setter 의 구성
    * 게터와 세터를 합쳐 접근 메서드 라고 한다.
    * 자바에서는 모든 필드에 대한 접근 메서드를 만들어야 하는 수고를 해야함.
    * 필드가 많아질수록 접근 메소드가 점점 많아지는 문제가 생긴다.

## 코틀린 에서 게터와 세터가 작동하는 방식
 * 접근 메소드는 생략한다 (내부적으로 생성된다)

```kotlin
class User(_id: Int, _name: String, _age: Int) {
    
    val id: Int = _id
    var name: String = _name
    var age: Int = _age
}

```

좀더 간략하게는

```kotlin
class User2(val _id: Int, var _name: String, var _age: Int) 
```

## 게터와 세터의 동작

```kotlin
    val user = User(1, "sean", 30)
    
    val name = user.name // user.name 은 내부적으로 .getName()에 접근 하게됨
    user.age = 41 // 이럴경우 내부적으로 setter 에 접근하게 된다.
    
    println("name : ${user.name}") // user.name 의 경우 내부적으로 getter() 에 접근하게 된다.
```

* user.name 같은경우 객체 직접 접근처럼 보일수 잇으나 내부적으로 getter, setter 를 통해 접근한다. 


* 게터와 세터가 포함되는 프로퍼티 선언 구조
  * var 프로퍼티 이름
    * 게터
    * 세트
  * val 프로퍼티 이름
    * 게터
    * 불변형인 val 은 게터만 설정 가능하다.
    
  
###기본적인 게터와 세터를 지정을 할수있고 custom이 가능하다

```kotlin
class User(_id: Int, _name: String, _age: Int) {

    val id: Int = _id
        get() = field    
    
    var name: String = _name
        get() = field // name 으로 하면 재귀에 빠질수가 있다.
        set(value) {
            field = value.uppercase()
        }
    
    var age: Int = _age
        get() = field
        set(value) { // value의경우 위부에서 넣은 값을 가져온다.
            field = value
        }
}
```


## 프로퍼티의 오버라이딩 사용하기

```kotlin
open class First {
    open val x: Int = 0
        get() {
            println("first X")
            return field
        }

    val y: Int = 0 //open 키워드가 없어서 final 프로퍼티이다.
}

class Second: First() {
    override val x: Int = 1
        get()  {
            println("Second x")
            return field + 3
        }
    
    // override val y: Int = 0 // 오버라이딩이 블가능 하다.
}
```
* open 키워드를 통해 오버라이딩이 가능하다. 없으면 불가능

## 지연 초기화와 위임

### 지연초기화가 필요한 이유
* 클래스에서는 기본적으로 선언하는 프로퍼티 자료형들은 null 을 가질수 없음
* 하지만 객체의 정보가 나중에 나타나는 경우 나중에 초기화 할 수 있는 방법 필요
* 지연 초기화를 위해 lateinit 과 lazy 키워드 사용


### lateinit를 사용한 지연 초기화
* 의존성이 있는 초기화나 unit 테스트를 위한 코드를 작성
  * 예) car 클래스의 초기화 부분에 engine 클래스와 의존성을 가지는 경우 Enine 객체가 생성되지 않으면 완전하게 초기화 할 수 없는 경우
  * 예) 단위 테스트를 위해 임시적으로 객체를 생성 해야 하는경우
* 프로퍼티 지연 초기화
  * 클래스를 선언할 때 프로퍼티 선언은 null 을 허용하지 않는다.
  * 하지만, 지연 초기화를 위한 lateinit 키워드를 사용하면 프로퍼티에 값이 바로 할당되지 않아도 된다.
* lateinit 의 제한
  * var 로 선언된 프로퍼티만 가능
  * 프로퍼티에 대한 게터와 세터를 사용할수 없다.

```kotlin
class Person {
    lateinit var name: String

    fun test() {
        if (!::name.isInitialized) { // isInitialized는 프로퍼티 초기화 여부를 판단.
            println("초기화 안됨")
        } else {
            println("초기화 됨")
        }
    }
}

fun main() {
    val bowon = Person()
    bowon.test() // 초기화 안됨 출력
    bowon.name = "bowon"
    bowon.test() // 초기화됨 출력
}
```


## lazy 를 사용한 지연 초기화
### lazy를 통한 지연 초기화 특징
* 호출 시점에 by lazy {...} 정의에 의해 블록 부분의 초기화를 진행한다.
* 불변의 변수 선언인 val 에서만 사용 가능하다.
* val 이므로 값을 다시 변경할 수 없다.

```kotlin

class LazyTest {
    init {
        println("init block") // ②
    }

    val subject by lazy {
        println("lazy initialized") // ⑥ 반환값만 반환하고 초기화 된상태에서는 반한값 외에 함수 실행 안함
        "Kotlin Programming" // ⑦ lazy 반환값
    }
    fun flow() {
        println("not initialized") //  ④
        println("subject one: $subject") // ⑤ 최초 초기화 시점!
        println("subject two: $subject") // ⑧ 이미 초기화된 값 사용
    }
}
fun main() {
    val test = LazyTest()
    test.flow()
}
```

결과
```
init block
not init
lazy init
subject one: Kotlin programming
subject two: Kotlin programming
```

```kotlin
    var isPersonInstantiated: Boolean = false  // ① 초기화 확인 용도

    val person : Person2 by lazy { // ② lazy를 사용한 person 객체의 지연 초기화
        isPersonInstantiated = true
        Person2("Kim", 23) // ③ 이 부분이 Lazy 객체로 반환 됨
    }
    val personDelegate = lazy { Person2("Hong", 40) }  // ④ 위임 변수를 사용한 초기화

    println("person Init: $isPersonInstantiated")
    println("personDelegate Init: ${personDelegate.isInitialized()}")
    println("personDelegate Init2: ${personDelegate.isInitialized()}")

    println("person.name = ${person.name}")  // ⑤ 이 시점에서 초기화
    println("personDelegate.value.name = ${personDelegate.value.name}")  // ⑥ 이 시점에서 초기화

    println("person Init: $isPersonInstantiated")
    println("personDelegate Init: ${personDelegate.isInitialized()}")
```

* val personDelegate = lazy { Person2("Hong", 40) } 이럴 경우 Person 에는 value를 통해 접근 (6번 참고)

결과
```
person Init: false
personDelegate Init: false
personDelegate Init2: false
person.name = Kim
personDelegate.value.name = Hong
person Init: true
personDelegate Init: true

```

### by lazy 의 모드
* 3가지 모드 지정 가능
  * SYNCHRONIZED 
    * 락을 사용해 단일 스레드만이 사용하는 것을 보장 (기본값)
  * PUBLICATION 
    * 여러 군데서 호출될 수 있으나 처음 초기화된 후 반환 값을 사용
  * NONE
    * 락을 사용하지 않기 때문에 빠르지만 다중 스레드가 접근 가능
      * (값의 일관성 보장 못함)
 ```kotlin
private val model by lazy(mode = LazyThreadSafetyMode.NONE) {
    Injector.app().tracsactionsModel() // 이코드는 단일 스레드의 보장이 될때
}
```

## 클래스 위임하기

by를 사용하면 하나의 클래스가 다른 클래스에 위임하도록 선언하여 위임된 클래스가 가지는 멤버를 참조없이 호출할 수 있게 됩니다.  그러면 프로퍼티 위임이란 무엇일까요? 프로퍼티 위임이란 프로퍼티의 게터와 세터를 특정 객체에게 위임하고 그 객체가 값을 읽거나 쓸 때 수행하도록 만드는 것을 말합니다. 프로퍼티 위임을 하려면 위임을 받을 객체에 by 키워드를 사용하면 됩니다.

```kotlin
interface Animal {
    fun eat() { ... }
    ...
}
class Cat : Animal { }
val cat = Cat()
class Robot : Animal by cat  // Animal의 정의된 Cat의 모든 멤버를 Robot에 위임함
```

* 만약 Animal인터페이스를 구현하고 있는 Cat 클래스가 있다면 Animal에서 정의하고 있는 Cat의 모든 멤버를 Robot클래스로 위임할 수 있습니다. 즉, Robot은 Cat이 가지는 모든 Animal의 메소드를 가지는데 이것을 클래스 위임(Class delegation)이라고 합니다.
* 위임을 사용하면?
  * 위임을 통해 상속과 비슷하게 최종 클래스의 모든 기능을 사용하면서 동시에 기능을 추가 확장 구현할 수 있다.
  
```kotlin

interface Car {
    fun go(): String
}

class VanImple(val power: String): Car {
    override fun go(): String {
       return "는 짐을 적재하며 $power 마력을 가집니다"
    }
}

class SportImple(val power: String): Car {
    override fun go(): String {
        return "는 경주용에 사용되며 $power 마력을 가집니다"
    }
}

class CarModel(val model:String, impl:Car): Car by impl {
    fun carInfo() {
        println("$model ${go()}")
    }
}

fun main() {
    val myDamas = CarModel("Damas", VanImple("100 마력"))
    val mySports = CarModel("sports", SportImple("350 마력"))
    
    myDamas.carInfo()
    mySports.carInfo()
}
```
결과
```
Damas 는 짐을 적재하며 100 마력 마력을 가집니다
sports 는 경주용에 사용되며 350 마력 마력을 가집니다
```

* by imple 을 사용하지 않으면 아래처럼 직접 구현해 줘야한다.
```kotlin
class CarModel2(val model:String, val impl:Car): Car {
    fun carInfo() {
        println("$model ${impl.go()}")
    }

    override fun go(): String {
        return ""
    }
}
```

### 프로퍼티 위임과 by lazy 다시보기
* 동작분석
  1. lazy 람다식 함수는 람다를 전달받아 저장한 Lazy<T> 인스턴스를 반환한다
  2. 최초 프로퍼티의 게터 실행은 lazy에 넘겨진 람다식 함수를 실행하고 결과를 기록한다.
  3. 이후 프로퍼티의 게터 실행은 이미 초기화 되어 기록값을 반환한다.


## observable과 vetoable 의 위임
* observable
  * 프로퍼티를 감시하고 있다가 특정 코드의 로직에서 변경이 일어날때 호출
```kotlin
fun main() {
    val user3 = User3()
    user3.name = "bowon" // 값이 변경되는 시점에서 첫 이벤트 발생
    user3.name = "bowon2" // 값이 변경되는 시점에서 두번째 이벤트 발생
}

class User3 {
    var name: String by Delegates.observable("NONAME") {
            prop, old, new -> // 람다식 매개변수로 프로퍼티, 기존값, 새로운값
        println("$old -> $new") // 이부분은 이벤트가 발생할 때만 실행 된다.
    }
}  
```
* vetoable
  * 감시보다는 수여한다는 의미로 반환값에 따라 프로퍼티 변경을 허용하거나 취소한다.
```kotlin
   var max: Int by Delegates.vetoable(0) { // 초기값 0
        prop, old, new -> 
        new > old // 조건에 맞지 않으면 거부권 행사
    }
    
    println(max) // 0
    max = 10
    println(max) // 10
    
    //여기서 부터는 기존값이 새값 보다 크므로 false, 따라서 5를 재할당 하지 않는다.
    max = 5
    println(max) // 10
```
