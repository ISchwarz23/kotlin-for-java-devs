package _01_classes

class User {

    private val id: Int
    private val name: String

    constructor(i: Int, n: String) {
        this.id = i
        this.name = n
    }

    fun getId(): Int {
        return id
    }

    fun getName(): String {
        return name
    }

}