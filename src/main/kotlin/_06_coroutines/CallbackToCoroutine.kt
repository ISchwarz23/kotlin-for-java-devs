package _06_coroutines

import kotlinx.coroutines.runBlocking
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class CallbackService(val name: String) {

    class Response(val fromService: CallbackService, val message: String)

    fun doRequest(from: String, callback: (Response) -> Unit) {
        // do heavy work here
        callback(Response(this, "Hi $from!\n -- Yours, $name"))
    }
}

fun main() {
    val s1 = CallbackService("Service 1")
    val s2 = CallbackService("Service 2")

    s1.doRequest(s2.name) { response1 ->
        println(response1.message)

        response1.fromService.doRequest(s1.name) { response2 ->
            println(response2.message)
        }
    }

    runBlocking {
        val response1 = s1.doRequest(s2.name)
        println(response1.message)

        val response2 = s2.doRequest(s1.name)
        println(response2.message)
    }
}


suspend fun CallbackService.doRequest(from: String) =
    suspendCoroutine<CallbackService.Response> { context ->
        doRequest(from) { response ->
            context.resume(response)
        }
    }