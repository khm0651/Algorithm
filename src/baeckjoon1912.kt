import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    var dt = reader.readLine().split(" ").map(String::toInt).toIntArray()
    var result = Int.MIN_VALUE
    for(i in 0 until num){
        var dp = IntArray(num)
        dp[i]=dt[i]
        result = max(result,dp[i])
        for(j in i+1 until num){
            dp[j] = dt[j] + dp[j-1]
            result = max(result,dp[j])
        }
    }
    println(result)
}