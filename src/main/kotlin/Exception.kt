import kotlinx.coroutines.*
import java.lang.ArithmeticException
import java.lang.IndexOutOfBoundsException

fun main() {

    runBlocking {
        val myHandler = CoroutineExceptionHandler{
            coroutineContext, throwable ->
            println("Exception Handled : ${throwable.localizedMessage}")
        }

        val job = GlobalScope.launch {
            println("Throwing exception from job")
            throw IndexOutOfBoundsException("exception in coroutine")
        }

        job.join() //예외 메시지가 보인다.

        val deferred = GlobalScope.async {
            println("Throwing Exception From async")
            throw ArithmeticException("exception from async")
        }

        try {
            deferred.await() //예외 메시지가 보인다.
        }catch (e : ArithmeticException){
            println(e.localizedMessage)
        }

    }
}