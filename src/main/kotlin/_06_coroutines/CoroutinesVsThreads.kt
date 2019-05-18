package _06_coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.lang.Thread.sleep
import kotlin.concurrent.thread

fun main() = threads(100_000, ::println)

fun threads(n: Int, action: (Int) -> Unit) {
    val threads = List(n) {
        thread {
            sleep(1000L)
            action(it)
        }
    }
    threads.forEach { it.join() }
}


fun coroutines(n: Int, action: (Int) -> Unit) = runBlocking {
    val jobs = List(n) {
        async {
            delay(1000L)
            println(it)
        }
    }
    jobs.forEach { it.join() }
}
