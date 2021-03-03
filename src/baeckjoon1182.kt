import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var answer1182 = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var st = StringTokenizer(readLine())
    var n = st.nextToken().toInt()
    var s = st.nextToken().toInt()
    st = StringTokenizer(readLine())
    var list = IntArray(n)
    for(i in 0 until n) list[i] = st.nextToken().toInt()
    var visitMap = BooleanArray(n)
    dfs1182(list,visitMap,0,s,0)
    bw.write("${answer1182}")
    bw.flush()
}

fun dfs1182(list: IntArray, visitMap: BooleanArray, sum: Int, s: Int,idx :Int) {
    if(sum == s && idx != 0){
        answer1182++
    }

    for(i in idx until list.size){
        if(!visitMap[i]){
            visitMap[i] = true
            dfs1182(list, visitMap, sum+list[i], s, i+1)
            visitMap[i] = false
        }
    }
}
