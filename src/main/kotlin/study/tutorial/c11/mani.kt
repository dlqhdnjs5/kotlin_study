package study.tutorial.c11

import java.util.*

fun main() {

    println(Regex.escapeReplacement("\\d"))
    println("\\d")

    //불변형_list()
    //indices_사용한_컬렉션_접근()
    //emptyList함수()
    //listOfNotNull함수()
    //arrayListOf_함수()
    //mutableListOf_함수 ()
    //toMutableList_함수()
    //setOf_함수()
    //sortedSetOf_함수()
    //mapOf_함수()
    //mutableMapOf_함수()
    //map_자료구조()
    //list_확장함수()
    //요소_순환()
    //fold_함수()
    //map_함수()
    //flat_map_함수()
    //groupBy_함수()
    //요소처리와_검색()
    //시퀀스_생성()
    //asSequence_함수()
    //정렬()
}
fun 불변형_list() {
    var numbers: List<Int> = listOf(1, 2, 3, 4, 5)
    var names: List<String> = listOf("one", "two", "trhee")

    for (name in names) {
        println(name)
    }

    for (num in numbers) print(num)

    //형식 매개변수 생략 경우
    var mixedTypes = listOf("hello", 1, 2.445, 's') // 생략되어있지만 any 가 사용되어 어떤 타입이든 받을수 있다.
}


fun indices_사용한_컬렉션_접근() {
    var fruits = listOf("apple", "banana", "kiwi")

    for (index in fruits.indices) { // 인덱스 를 불러올수 있다.
        println("fruit[$index] = ${fruits[index]}")
    }
}


fun emptyList함수() {
    val emptyList = emptyList<String>()
}

fun listOfNotNull함수() {
    val nonNullList = listOfNotNull(2, 45, 2, null, 5, null)
    println(nonNullList) // 2, 45, 2, 5
}

fun arrayListOf_함수() {
    val stringList = arrayListOf<String>("hello", "kotlin", "wow")
    stringList.add("java")
    stringList.remove("hello")
    println(stringList) // kotlin, wow, java
}

fun mutableListOf_함수() {
    // 가변형 list의 생성 및 추가, 삭제, 변경
    val mutableList = mutableListOf<String>("A", "B", "C")
    mutableList.add("D")
    mutableList.removeAt(1) // 인덱스 1 삭제
    mutableList[0] = "G" // 인덱스 0 을 변경, set과 같은 역할
    println(mutableList)
}

fun toMutableList_함수() {
    val name = listOf("one", "two", "three")

    val mutableName = name.toMutableList()
    mutableName.add("four") // 가변형 으로 변환된 list 에 하나의 요소 추가한다.
}

fun setOf_함수() {
    val mixedTypesSet = setOf("Hello", 5, "world", 3.14) // 자료형 혼합
    var intSet: Set<Int> = setOf(1, 5, 5) // intSet 에는 1, 5만 생성
}

fun sortedSetOf_함수() {
    val intSortedSet: TreeSet<Int> = sortedSetOf(4, 1, 7, 2)
    intSortedSet.add(6)
    intSortedSet.remove(1)
    println(intSortedSet) // 2,4,6,7
    intSortedSet.clear()
    println(intSortedSet) // []
}

fun mapOf_함수() {
    val langMap = mapOf(11 to "java", 22 to "Kotlin", 33 to "C++")

    for ((key, value) in langMap) {
        println("key = $key , value = $value ")
    }

    println("langMap[22] = ${langMap[22]}")
    println("langMap.get(22) = ${langMap.get(22)}")
    println("langMap.keys = ${langMap.keys}") // 맵의 모든 key 출력력
}

fun mutableMapOf_함수() {
    val capitalCityMap = mutableMapOf("Korea" to "seoul", "china" to "beijing", "japan" to "tokyo")
    println(capitalCityMap.values) // 값만 출력
    println(capitalCityMap.keys) // 키만 출력
    capitalCityMap.put("Uk", "London")
    capitalCityMap.putAll(mapOf("US" to "NY"))
}

fun map_자료구조() {
    val hashMap = hashMapOf(1 to "hello", 2 to "world")
    val sortedMap = sortedMapOf(1 to "apple", 2 to "banana")
    val linked = linkedMapOf(1 to "apple", 2 to "banana")
}


fun list_확장함수() {
    val list1 = listOf("one", "two", "three")
    val list2 = listOf<Int>(1, 2, 3)

    println(list1 + "four") // ["one", "two", "three", "four"] 출력되나 list1 에 four 이 들어간것은 아니다.
    println(list2 + "hello") // [1, 2, 3 "four"] 출력되나 list2 에 four 이 들어간것은 아니고 새로운 list가 생성되어 화면상에 찍히는것.
    println(list2 - 1) // [2, 3]
    println(list1 + listOf("abc"))

    val map1 = mapOf("hi" to 1, "hello" to 2)


    println(map1 + Pair("bye", 3)) // Pair 을 사용한 map 의 요소 추가
    println(map1 - "hello") // hello 키를 가지고있는 값 제거
    println(map1 + mapOf("apple" to 4))
    println(map1 - listOf("hi", "hello")) //list 에 일치하는 key값을 map 에서 제거

    val map2 = map1 + mapOf("apple" to 4)
    println(map2) // {hi=1, hello=2, apple=4}

    val map3 = map1 - listOf("hi")
    println(map3) // {hello=2}
}


fun 요소_순환() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100))
    val map = mapOf(11 to "java", 22 to "kotlin", 33 to "C++")

    list.forEach { print("$it") }
    println()
    list.forEachIndexed { index, value -> println("index[$index]: $value") } // 매개변수 index 포함

    val returnedList = list.onEach { it * 2 }
    val returendMap = map.onEach { it.value + " language" }

    println(returnedList) // [1, 2, 3, 4, 5, 6]
    println(returendMap) // {11=java, 22=kotlin, 33=C++}
}


fun fold_함수() {
    val list = listOf(1, 2, 3, 4)

    println(list.fold(4) { total, next -> total + next }) // 4 + 1 + 2 + 3 + 4

    //foldRight : fold와 같고 마지막 요소에서 처음 요소로 반대로 적용
    println(list.foldRight(4) { total, next -> total + next }) // 4 + 4 + 3 + 2 + 1

    println(list.reduce { total, next -> total + next }) //  1 + 2 + 3+ 4
    println(list.reduceRight { total, next -> total + next }) // 4 + 3 + 2 + 1+
}

fun map_함수() {
    val list = listOf(1, 2, 3, 4, 5)
    val listWithNull = listOf(1, null, 3, null, 5, null)

    // map: 컬렉션에 주어진 식을 적용해 새로운 컬렉션을 반환
    println(list.map { it * 2 }) // [2, 4, 6, 8, 10]

    // mapIndexed: 컬렉션에 인덱스를 포함해 주어진 식을 적용해 새로운 컬렉션 반환
    val mapIndexed = list.mapIndexed { index, it -> index * it } //[0, 2, 6, 12, 20]
    println(mapIndexed)

    // mapNotNull : null 을 제외하고 식을 적용해 새로운 컬렉션 반환
    println(listWithNull.mapNotNull { it?.times(2) }) // [2, 6, 10]


}

fun flat_map_함수() {
    val list = listOf(1, 2, 3, 4, 5)

    println(list.flatMap { listOf(it, 'A') }) // [1, A, 2, A, 3, A, 4, A, 5, A]
    val result = listOf("abc", "12").flatMap { it.toList() } // [a, b, c, 1, 2]
    println(result)
}

fun groupBy_함수() {
    val list = listOf(1, 2, 3, 4, 5)

    val grpMap = list.groupBy { if (it % 2 == 0) "even" else "odd" }
    println(grpMap)
}

fun 요소처리와_검색() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100))
    val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)

    // 인덱스에 해당하는 요소 반환
    println("elementAt: ${list.elementAt(1)}") // 2
    println("elementAt: ${list[1]}") // 2

    // 인덱스를 벗어나는 경우 식에 따라 결과 반환 아니면 요소 반환
    println("elementAtOrElse ${list.elementAtOrElse(10, {2 * it})}") // 20
    println("elementAtOrElse ${list.elementAtOrElse(10) {2 * it}}") // 20

    // 인덱스를 벗어나는 경우 null 반환
    println("elementAtORNull: ${list.elementAtOrNull(10)}" ) // null
}

fun 시퀀스_생성() {
    val nums: Sequence<Int> = generateSequence(2) { if (it < 30) it + 1 else null} // 계속 값을 생성해 낸다.

    println(nums.take(18).toList()) // [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]

    println(nums.count()) // 29
}

fun 체이닝_함수() {
    val list = listOf(1, 2, 3, 4, 5)
    val listDefualt = list
        .map { println("map($it) "); it * it }
        .filter { println("filter($it)" ); it % 2 == 0 }

    println(listDefualt)
}

fun asSequence_함수() {
    val list = listOf(1, 2, 3, 4, 5)
    val listDefualt = list.asSequence()
        .map { println("map($it) "); it * it }
        .filter { println("filter($it)" ); it % 2 == 0 }
        .toList()

    println(listDefualt)
}

fun 정렬() {
    val list = listOf(1,3, 5, 4, 9, 7)

    println(list.reversed())
    println(list.sortedByDescending() {it % 3})
}