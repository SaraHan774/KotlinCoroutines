import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
//        mapOperator() //suspend function
//        filterOperator()
//        transformOperator()
//        takeOperator() //두 개의 값만 출력한다.
//        reduceOperator()
        flowOnOperator()
    }
}

suspend fun mapOperator(){
    (1..10).asFlow()
        .map{
            delay(500L)
            "mapping $it"
        }.collect{
            println(it)
        }
}

suspend fun filterOperator(){
    (1..10).asFlow()
        .filter{
            it % 2 == 0
        }.collect{
            println(it)
        }
}

suspend fun transformOperator(){
    (1..10).asFlow()
        .transform{
            emit("emitting stirng value $it")
            emit(it)
        }.collect{
            println(it)
        }
}

suspend fun takeOperator(){
    (1..10).asFlow()
        .take(2)
        .collect{
            println(it)
        }
}

suspend fun reduceOperator(){
    val size = 10
    val factorial = (1..size).asFlow()
        .reduce{accumulator, value ->
            accumulator * value
        } //terminal operator 이므로 collect 의 기능을 포함한다.
    println("Factorial of $size is $factorial")
}

suspend fun flowOnOperator(){
    (1..10).asFlow()
        .flowOn(Dispatchers.IO)
        .collect{
            println(it)
        }
}