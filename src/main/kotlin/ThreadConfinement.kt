import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val counterContext = newSingleThreadContext("CounterContext")
        var counter = 0
        withContext(counterContext){
            massiveRunConfined{
//                withContext(counterContext){
                    counter++
//                }
            }
        }
        println("Counter = $counter")
        //단점 : 모든것이 serial 하게 처리되어서 병렬 처리가 되지 않는다.
    }
}

suspend fun massiveRunConfined(action : suspend () -> Unit){
    val n = 100
    val k = 1000

    val time = measureTimeMillis {
        coroutineScope{
            repeat(n){
                launch {
                    repeat(k){
                        action()
                    }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")
}