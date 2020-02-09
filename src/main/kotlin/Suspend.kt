import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//track number of calls
//메인 어플리케이션의 변수이지만 코루틴에서 접근할 수 있다.
var functionCalls = 0

fun main() {

    GlobalScope.launch {
        completeMessage()
    }
    GlobalScope.launch {
        improveMessage()
    }

    println("Hello, ")

    Thread.sleep(2000L)
    //몇 개의 함수가 이 변수를 접근했는지 확인해본다.
    println("There have been $functionCalls calls so far")
}

//코루틴 간의 동기화의 필요가 없다.
suspend fun completeMessage(){
    delay(500L)
    println("World!")
    functionCalls++ //병렬 처리
}

suspend fun improveMessage(){
    delay(1000L)
    println("suspend functions are cool!")
    functionCalls++
}