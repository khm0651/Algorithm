import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var nList = TreeMap<Int,Int>()
    readLine().split(" ").map(String::toInt).forEach {
        if(nList.containsKey(it)) nList[it] = nList[it]!! + 1
        else nList[it] = 1
    }

    var m = readLine().toInt()
    var mList = readLine().split(" ").map(String::toInt).toIntArray()
    for(i in 0 until m){
        if(nList.containsKey(mList[i])) bw.write("${nList[mList[i]]} ")
        else bw.write("${0} ")
    }
    bw.flush()
}
