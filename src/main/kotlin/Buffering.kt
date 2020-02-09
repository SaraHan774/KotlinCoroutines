import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val time = measureTimeMillis {
            generate()
                .buffer() //버퍼를 넣으면 시간이 줄어든다.
                .collect{
                    delay(300L)
                    println(it)
                }
        }

        println("Collected in $time")
    }
}


fun generate() = flow{
    for(i in 1..3){
        delay(100L)
        emit(i)
    }
}