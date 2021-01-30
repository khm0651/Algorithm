import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    var list = arrayListOf<Int>()
    reader.readLine().split(" ").map(String::toInt).forEach { it->
        list.add(it)
    }
    var dp = IntArray(num+1)
    var idx = 1
    var result = 0
    while(list.size != 0){
        var m = Int.MAX_VALUE
        for(i in 0 until list.size){
            m = min(m,list[i])
        }
        dp[idx] = m + dp[idx-1]
        list.remove(m)
        idx++
    }

    for(i in 1 until dp.size) result += dp[i]
    println(result)

}