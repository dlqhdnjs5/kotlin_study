package study.tutorial.c10

class Box<T> (a: T) {
    var name = a
}

fun main() {
    val box1: Box<Int> = Box(1)
    val box2 = Box("bowon")

    var a = MyClass2<Int>(12)



    val obj = GenericNull<String>() // non-null 로 선언됨
    obj.EqualityFunc("Hello", "world") // null 이 허용되지 않음

    val obj2 = GenericNull<Int?>() // null 이 가능한 형식으로 선언
    obj2.EqualityFunc(null, 10) // null 사용
}

class MyClass<T>  {
    val myProp: T// 프로퍼티

    constructor(myProp: T) { // 부 생성자 사용
        this.myProp = myProp
    }
}

class MyClass2<T> (val myProp: T) { // 주생성자의 프로퍼티

}

open class Parent

class Child: Parent()

class Cup<T>


class GenericNull<T> {
    fun EqualityFunc(arg1: T, arg2: T) {
        println(arg1?.equals(arg2))
    }
}


