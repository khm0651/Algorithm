import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    var memo = IntArray(num+1){0}
    println(findmin(memo,num))
}

fun findmin(memo: IntArray, num: Int): Int {

    for(i in 2 .. num){
        when {
            i % 3 == 0 && i % 2 == 0 -> memo[i] = kotlin.math.min(memo[i/3] , memo[i/2]) + 1

            i % 3 == 0 -> memo[i] = kotlin.math.min(memo[i/3], memo[i-1]) + 1

            i % 2 ==0 -> memo[i] = kotlin.math.min(memo[i/2], memo[i-1]) + 1

            else -> memo[i] = memo[i-1]+1

        }
    }
    return memo[num]

}
