import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        //Channel<T> 로 직접 만들지 않아도 된다.
//        val channel = produce {
//            for(x in 1..5){
//                send(x * x)
//            }
//        }

//        val channel = produceSquares()

        //더 간결하게 만들 수 있다.
        produceSquares().consumeEach {
            println(it)
        }

//        for(y in channel){
//            println(y)
//        }
    }
}

//extension function 을 활용할 수 있다.
fun CoroutineScope.produceSquares() = produce {
    for(x in 1..5){
        send(x * x)
    }
}