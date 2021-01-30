import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var input = reader.readLine().split(" ").map(String::toInt)
    var num = input[0]
    var target = input[1]
    var list = IntArray(num)
    var count = 0
    for(i in 0 until num) list[i] = reader.readLine().toInt()

    for(i in num-1 downTo 0){
        if(target == 0) break
        if(target<list[i]) continue
        while(target - list[i] >= 0){
            target -= list[i]
            count++
            if(target==0) break
        }
    }
    println(count)
}