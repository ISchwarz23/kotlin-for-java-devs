package _02_properties

import kotlin.reflect.KProperty

class DebuggingProperty<T>(var field: T) {

    operator fun getValue(thisRef: Any?, p: KProperty<*>): T {
        println("Reading value of property '${p.name}' which is '$field'.")
        return field
    }

    operator fun setValue(thisRef: Any?, p: KProperty<*>, v: T) {
        println("Setting new value of property '${p.name}' to '$v'.")
        field = v
    }
}