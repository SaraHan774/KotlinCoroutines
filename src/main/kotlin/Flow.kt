import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        println("Receiving Prime Numbers")
        sendPrimes().collect{
            //값들을 받는다.
            println("Received Prime Number $it")
        }
        println("Finished")
    }
}

fun sendPrimes() : Flow<Int> = flow{
    val primesList = listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    primesList.forEach{
        delay(it * 100L)
        emit(it)
    }
}