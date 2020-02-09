import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    //launch coroutine
    //printout the first and second half separately

    GlobalScope.launch{
        //1초 후에 world 를 프린트한다.
        delay(2000)
        println("World!")
    }

    print("Hello, ")
    Thread.sleep(3000)
    //코루틴이 끝날 수 있도록 2초 디레이한다.
}