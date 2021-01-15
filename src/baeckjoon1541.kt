import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    var reader =  BufferedReader(InputStreamReader(System.`in`))
    var list = reader.readLine().split("-").toMutableList()
    var result = 0
    for(i in list.indices){
        if(list[i].contains("+")){
            var split = list[i].split("+").map(String::toInt)
            var sum = 0
            for(item in split) sum+=item
            list[i] = sum.toString()
        }
    }
    for(i in 0 until list.size) result = if(i==0) list[0].toInt() else result - list[i].toInt()
    println(result)
}