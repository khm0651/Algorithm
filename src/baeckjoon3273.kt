import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var list = readLine().split(" ").map{it.toInt()}
    var x = readLine().toInt()
    list = list.sorted()
    var l = 0
    var r = list.size-1
    var answer = 0
    while(l<r){
        if(list[l] + list[r] > x ) r--
        else {
            if(list[l]+list[r] == x ) answer++
            l++
        }
    }
    bw.write("${answer}")
    bw.flush()
}