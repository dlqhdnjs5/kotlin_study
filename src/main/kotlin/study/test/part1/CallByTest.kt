package study.test

fun callByNameTest(call: () -> Boolean): Boolean {
    println("callByNameTest")
    return call()
}

fun callByValueTest(a: Boolean): Boolean {
    println("callByValueTest")
    return a
}

fun callByValueTest1(): Boolean {
    println("callByValue1")
    return true
}

fun lamdaOkay(call: () -> Boolean): () -> Boolean {
    return call
}


fun main() {
    val callByName1: () -> Boolean = {
        println("callByName1")
        true
    }

    val bb: String? = null

    val size: Int= bb?.length ?: -1

    val itTest: (Int) -> Int = { it }
    println(" this is it  ${itTest(10)}")
//callByNameTest(callByName1)
    //callByValueTest(callByValueTest1())


}