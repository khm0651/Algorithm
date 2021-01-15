import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    var a = IntArray(500+1)
    for( i in 1 .. num){
        var input = reader.readLine().split(" ").map(String::toInt)
        a[input[0]] = input[1]
    }


}