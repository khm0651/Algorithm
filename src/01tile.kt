import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    if(num == 0) println("0")
    else if(num == 1) println("1")
    else if(num == 2)println("2")
    else{
        var dp = LongArray(num+1)
        dp[0] = 0
        dp[1] = 1
        dp[2] = 2
        for(i in 3..num){
            dp[i] = (dp[i-2] + dp[i-1]) % 15746
        }
        println(dp.last())
    }

}