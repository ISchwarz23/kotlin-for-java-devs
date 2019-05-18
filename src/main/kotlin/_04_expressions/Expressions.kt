package _04_expressions

class Example(val a: Int, val b: String?, val c: Boolean)

fun main() {
    var ex = Example(1, null, true)

    val a = ex.a
    val b = ex.b
    val c = ex.c
    println("a = " + a + ", b = " + b + ", c = " + c)


    val map = HashMap<String, Int>()
    map.put("k1", 1)
    map.put("k2", 2)
    map.put("k3", 3)

    for (e in map.entries) {
        val key = e.key
        val value = e.value
        println(key + " -> " + value)
    }


    var s: String
    if (System.currentTimeMillis() % 2L == 0L) {
        s = "Strike!"
    } else {
        s = "Not this time!"
    }
    println(s)
}

fun test(e: Example): String {
    when (e.a) {
        1 -> return "Odd"
        2 -> return "Even"
        3 -> return "Odd"
        4 -> return "Even"
        5 -> return "Odd"
        6 -> return "Even"
        else -> return "too big"
    }
}

fun test2(str: String?): String? {
    println(str!!.length)

    if (str != null) {
        str.forEach { it ->
            println(it)
        }
    }

    if (str == null) return ""

    return str
}