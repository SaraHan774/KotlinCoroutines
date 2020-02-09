import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        sendNumbers().collect{
            println("Received $it")
        }
    }
}

//Flow Builder 를 통해서 flow 를 생성한다.
fun sendNumbers() = flow {
    for (i in 1..10){
        emit(i)
    }
}

//리스트를 직접적으로 Flow 로 Convert 한다.
fun sendNumbers2()
    = listOf(1, 2, 3).asFlow()

//vararg 를 통해서 만들 수 도 있다.
fun sendNumbers3() = flowOf(
    1, 2, 3, 4, 5
)

