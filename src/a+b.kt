import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
















    var a = reader.readLine().toInt() // 472
    var b = reader.readLine() // "385"

    for(i in b.length-1 downTo 0){
        println(a*b[i].toString().toInt())
    }
    println(a*b.toInt())

}