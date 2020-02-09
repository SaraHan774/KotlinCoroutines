import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        repeat(100_000){
            //십만개의 코루틴을 런칭한다.
            println(".")
            //매우 빠르다. 똑같이 십만개의 스레드를 런칭하면
            //프로그램 크래시가 날 것이다
        }
    }
}