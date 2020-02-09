import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        val job1 = launch {
//            delay(3000L)
            println("Job 1 launched")
            val job2 = launch {
                println("Job 2 launched")
                delay(3000L)

                println("Job 2 is finishing")
            }

            job2.invokeOnCompletion { println("Job 2 Completed") }

            val job3 = launch {
                println("Job 3 launched")
                delay(3000L)
                println("Job 3 is finishing")
            }
        }

        delay(500L)
        job1.invokeOnCompletion {
            println("Job 1 is completed")
        }

        println("Job 1 will be canceled")
        job1.cancel()
    }
}