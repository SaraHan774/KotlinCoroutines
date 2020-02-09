import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
//        tryCatch()
        onCompletion()
    }
}

suspend fun onCompletion(){
//finally 와 비슷한 역할을 하는 onCompletion 함수를 사용한다.
    (1..3).asFlow()
        //.onEach{ check(it != 2)} //블럭을 없애면 예외처리가 된다.
        .onCompletion{
            e ->
            if(e != null){
                println("Flow completed with exception $e")
            }else{
                println("Flow completed successfully")
            }
        }
        .catch{
                e -> println("Caught Exception $e")
        }.collect{
            println(it)
        }
}

suspend fun catch(){
    //catch operator 를 사용해서 처리하기
    (1..3).asFlow()
        .onEach{ check(it != 2)}
        .catch{
            e -> println("Caught Exception $e")
        }.collect{
            println(it)
        }
}

suspend fun tryCatch(){
    try {
        (1..3).asFlow()
            .onEach{check(it != 2)}
            .collect{ println(it)}
    }catch (e : Exception){
        println("Caught exception ${e.localizedMessage}")
    }
}