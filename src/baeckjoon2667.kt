import java.io.BufferedReader
import java.io.InputStreamReader

var answer2667 = 0
var answer2667List = ArrayList<Int>()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var map = Array(n){Array(n){0} }
    var visitMap = Array(n){BooleanArray(n)}
    for(i in 0 until n){
        map[i] = readLine().map { it.toString().toInt() }.toTypedArray()
    }
    for(i in 0 until n){
        for(j in 0 until n){
            if(map[i][j] == 1 && !visitMap[i][j]) {
                dfs2667(visitMap,map,i,j,count = 0)
                answer2667List.add(answer2667)
                answer2667=0
            }
        }
    }
    bw.write("${answer2667List.size}\n")
    answer2667List.sort()
    answer2667List.forEach { bw.write("${it}\n") }
    bw.flush()

}

fun dfs2667(visitMap: Array<BooleanArray>, map: Array<Array<Int>>, i: Int, j: Int, count: Int) {
    if(visitMap[i][j] || map[i][j]==0) return
    visitMap[i][j] = true
    answer2667++
    if(j-1>=0)  dfs2667(visitMap, map, i, j-1, count+1)
    if(j+1<map[0].size)  dfs2667(visitMap, map, i, j+1, count+1)
    if(i-1>=0) dfs2667(visitMap, map, i-1, j, count)
    if(i+1<map.size)  dfs2667(visitMap, map, i+1, j, count)

}
