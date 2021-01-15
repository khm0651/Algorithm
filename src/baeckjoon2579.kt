import java.io.BufferedReader
import java.io.InputStreamReader


fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    var memo = IntArray(num+1){0}
    var list = IntArray(num+1){0}
    for(i in 1 .. num) list[i] = reader.readLine().toInt()
    println(findMax2579(memo,list))
}

fun findMax2579(memo: IntArray, list: IntArray): Int {

    for(i in 1 until list.size){
        when (i) {
            1 -> memo[i] = list[i]
            2 -> memo[i] = memo[i-1] + list[i]
            3 -> memo[i] = kotlin.math.max(list[i-1]+list[i] ,list[i-2]+list[i] )
            else -> {
                memo[i] = kotlin.math.max(memo[i-3]+list[i-1]+list[i], memo[i-2]+list[i])
            }
        }

    }
    return memo.last()
}


