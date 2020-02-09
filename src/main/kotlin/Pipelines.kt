import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        val numbers = produceNumbers()
        val squares = square(numbers) //위의 결과가 인풋으로 들어간다.

        for(i in 1..5){
            println(squares.receive())
        }
        println("Done!")
        coroutineContext.cancelChildren() //모든 코루틴을 취소한다.
    }
}

fun CoroutineScope.produceNumbers() =
    produce {
        var x = 1
        while(true){
            //x를 증가시켜서 보낸다.
            send(x++)
        }
    }

fun CoroutineScope.square(numbers : ReceiveChannel<Int>)
    = produce {
    for(x in numbers){
        send(x * x)
    }
}