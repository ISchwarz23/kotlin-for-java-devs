package _02_properties


private var prop: String = "..."

fun getProp() = prop
fun setProp(v: String) {
    println("New value: $v")
    prop = v
}


private var _os: String? = null
val os: String
    get() {
        if (_os == null) {
            println("Observing OS information...")
            _os = System.getProperty("os.name")
        }
        return _os!!
    }

fun main() {
    for (i in 1..3) {
        println(os)
    }
}