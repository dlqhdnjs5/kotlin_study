package study.test.part1

import java.util.stream.Collectors

fun main() {
    var text = "ggggg"
    println(text.split("#")[0])

    var aaf = "sdfls,x API rate limit exceeded sduxx"
    var xx = listOf<String>("sfdsfdsf", aaf, "vxnxnxn")

    if (null == false) {
        println("sdfsss")
    }

    xx.filter { it.contains("API rate limit exceeded") == true }.map { println(it) }

/*





    var listTestt = listOf(
        SenderConfig("nt11","bb","111"),
        SenderConfig("nt11","bb","111"),
        SenderConfig("nt11","bb","111"),
        SenderConfig("nt12","aa","111"),
        SenderConfig("nt12","aa","111"),
        SenderConfig("nt11","cc","111"),
        SenderConfig("nt11","cc","111"),
        SenderConfig("nt11","aa","111")
    )
*/

    var ss: MutableList<String>? = mutableListOf<String>()

    if (ss != null) {
        ss.add("ssf")
    }

    ss = null

    ss = mutableListOf()



    var nullTest: MutableList<SenderConfig>? = mutableListOf<SenderConfig>()
    //nullTest = null


    if (null == true) {
        println("sdfsfsf")
    }

    if (null == false) {
        println("sdfsfsf")
    }
/*
    var pairTest = mutableListOf<Pair<String, List<SenderConfig>>>()
    pairTest.add("test1" to listOf(SenderConfig("nt2", "bbb"), SenderConfig("nt2", "bbb1"), SenderConfig("nt2", "bbb2"), SenderConfig("nt2", "bbb3")))
    pairTest.add("test1" to listOf(SenderConfig("nt2", "bbb"), SenderConfig("nt2", "bbb1"), SenderConfig("nt2", "bbb2"), SenderConfig("nt2", "bbb3")))
    pairTest.add("test1" to listOf(SenderConfig("nt2", "bbb"), SenderConfig("nt2", "bbb1"), SenderConfig("nt2", "bbb2"), SenderConfig("nt2", "bbb3")))
*/

    val intTest: Int = 150/45
    println(intTest)

    var divdeTest = listOf("aa","bb","cc","dd","ff","hh","rr","zz").chunked(3)
    println(divdeTest)

    /*var map = mutableMapOf<String, List<SenderConfig>>()
    map.put("nt1", listOf(SenderConfig("nt1", "aaa", 165), SenderConfig("nt1", "xvx", 165),SenderConfig("nt1", "asdzc", 165),SenderConfig("nt1", "wvvx", 165),SenderConfig("nt1", "vnvnv", 165),SenderConfig("nt1", "vbnvf", 165),SenderConfig("nt1", "aaa1", 165), SenderConfig("nt1", "aaa2", 165), SenderConfig("nt1", "aaa3", 165)))
    map.put("nt2", listOf(SenderConfig("nt2", "bbb", 165), SenderConfig("nt2", "bbb1", 165), SenderConfig("nt2", "bbb2", 165), SenderConfig("nt2", "bbb3", 165)))

    var divided: MutableList<Pair<String, List<SenderConfig>>> = mutableListOf()
    map.forEach { (employeeNo, senderConfigList ) ->
        var totalLengthBefor: Int = senderConfigList.map { it.length }
            .reduce { acc, i -> acc + i }

        if (totalLengthBefor > 500) {
            var total: Int = 0
            var addList: MutableList<SenderConfig> = mutableListOf()

            senderConfigList.forEachIndexed { index, senderConfig  ->
                total += senderConfig.length


                if (total < 500) {
                    addList.add(senderConfig)

                    if (index >= senderConfigList.size - 1) { //마지막이면
                        divided.add(Pair(employeeNo, addList))
                    }
                } else { // 꽊참

                    divided.add(Pair(employeeNo, addList)) //지금까지 한거 넣음

                    if (senderConfig.length > 500) {
                        println("너무 큼")
                    } else {
                        addList = mutableListOf() //한번 초기화
                        addList.add(senderConfig)
                        total = senderConfig.length //total 초기화


                        if (index >= senderConfigList.size - 1) { //마지막이면
                            divided.add(Pair(employeeNo, addList))
                        }
                    }
                }
            }
        }
    }*/


}

fun varTest(aa: String, bb: Boolean?) {
    if (bb == null) {
        println("ok")
    } else {
        println("fuck")
    }
}

data class SenderConfig (var employeeNo: String, var name: String, var length: Int)