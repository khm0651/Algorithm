import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var tk = StringTokenizer(readLine())

    var n = tk.nextToken().toInt()
    var m = tk.nextToken().toInt()

    tk = StringTokenizer(readLine())

    val list = IntArray(n)

    for(i in list.indices) {
        list[i] = tk.nextToken().toInt()
    }
    var lenMin = Int.MAX_VALUE
    var pos1 = 0
    var pos2 = 0
    var sum = 0
    while(true){
        if(sum >= m){
            lenMin = min(lenMin,pos2-pos1)
            sum -= list[pos1++]
        }else{
            if(pos2 == n) break
            sum += list[pos2++]
        }
    }

    if(lenMin == Int.MAX_VALUE) bw.write("0")
    else bw.write("${lenMin}")
    bw.flush()
}