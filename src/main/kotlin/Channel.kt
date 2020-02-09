import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        val channel = Channel<Int>()
            launch {
                for(x in 1..5)
                    channel.send(x*x)
                channel.close()
            }
        for(i in channel){
            //channel 은 iterable 이므로 close 전까지
            //채널 안을 확인할 수 있다.
            println(i)
        }
//        for(i in 1..5)
//            println(channel.receive())
    }
}

