import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {

    runBlocking {
        val numbersFlow = sendNumbers4()
        //cold 하므로 변수에 할당하는 순간에는 값을 emit 하지 않는다.
        println("Flow has not started yet")
        println("starting flow now")
        numbersFlow.collect{
            println(it)
        }
        println("flows are cold!")
    }

    runBlocking {
        val numbersFlow2 = sendNumbers5()
        withTimeoutOrNull(1000L){
            numbersFlow2.collect{
                println(it)
            }
        }
    }
}

fun sendNumbers4() = flow{
    listOf(1, 2, 3).forEach{
        emit(it)
    }
}

fun sendNumbers5() = flow{
    listOf(1, 2, 3).forEach{
        delay(400L)
        emit(it)
    }
}