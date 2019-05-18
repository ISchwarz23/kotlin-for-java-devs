package _03_functions

abstract class Element
class Container(vararg val children: Element) : Element()
class Text(val text: String) : Element()


fun main() {
    val root = Container(
        Text("Hello"),
        Container(
            Text("World"),
            Container(
                Text("from"),
                Text("Kotlin")
            ),
            Text("example")
        ),
        Text(":)")
    )

    println(root.extractText())
}


fun Element.extractText(): String {
    return extractText(this, StringBuilder()).toString()
}

fun extractText(e: Element, sb: StringBuilder): StringBuilder {
    if (e is Text) {
        val text = e as Text
        sb.append(text.text).append(" ")
    } else if (e is Container) {
        val container = e as Container
        for (child in container.children) {
            extractText(child, sb)
        }
    } else {
        error("Unrecognized element: $e")
    }

    return sb
}