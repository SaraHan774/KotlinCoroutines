import kotlinx.coroutines.*

fun main() {

    println("Program execution will now block")
    //다른 UI 스레드가 없기 때문에 Main 에서 한다.
    runBlocking {
        launch {
            delay(1000L)
            println("Task From runBlocking")
        }

        GlobalScope.launch {
            delay(500L)
            println("Task From Global Scope")
        }

        coroutineScope{
            launch {
                delay(1500L)
                println("Task From Coroutine Scope")
            }
        }
    }

    println("Program execution will now continue")
}