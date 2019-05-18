package _01_classes

fun parseName(name: String): List<String> {
    val indexOfSpace = name.indexOf(' ')
    return listOf(name.substring(0, indexOfSpace), name.substring(indexOfSpace + 1))
}

fun main() {
    val name = parseName("John Doe")
    val first = name[0]
    val last = name[1]

    println("$name")
    println("$first $last")

    if (name != parseName("John Doe")) {
        println("Equals is not working... :(")
    }
}