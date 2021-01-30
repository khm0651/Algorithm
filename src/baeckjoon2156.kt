import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    var memo = IntArray(num+1){0}
    var list = IntArray(num+1){0}
    for(i in 1 .. num) list[i] = reader.readLine().toInt()
    when(num){
        1 -> println(list[1])
        2 -> println(list[1]+list[2])
        else ->{
            memo[1]=list[1]
            memo[2]=list[1]+list[2]
            for(i in 3 .. num){
                memo[i] = memo[i-3]+list[i-1]+list[i]
                memo[i] = max(memo[i-2] + list[i], memo[i])
                memo[i] = max(memo[i-1] ,memo[i])
            }
            println(memo.last())
        }
    }
}