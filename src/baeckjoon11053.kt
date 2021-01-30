import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    var dp = IntArray(num)
    var dt = IntArray(num)
    dt = reader.readLine().split(" ").map(String::toInt).toIntArray()
    dp[0]=1
    var r = dp[0]
    for(i in 1 until num){
        for(j in 0 until i){
            if(dt[i]>dt[j]) dp[i] = max(dp[i],dp[j])
        }
        dp[i]+=1
        r = max(dp[i],r)
    }
    println(r)
}