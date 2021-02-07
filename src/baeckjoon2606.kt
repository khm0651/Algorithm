import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var count2606 = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var m = readLine().toInt()
    var map = Array(n+1){Array(n+1){0} }
    var visitMap = BooleanArray(n+1)
    for(i in 0 until m){
        var (node1,node2) = readLine().split(" ").map{it.toInt()}
        map[node1][node2] = 1
        map[node2][node1] = 1
    }
    //dfs2606(map,visitMap,v = 1 )
    bfs2606(map,visitMap,v=1)
    bw.write("${count2606}")
    bw.flush()
}

fun bfs2606(map: Array<Array<Int>>, visitMap: BooleanArray, v: Int) {
    var q : Queue<Int> = LinkedList<Int>()
    q.add(v)
    visitMap[v] = true
    while(q.isNotEmpty()){
        var item = q.poll()
        for(i in 1 until visitMap.size){
            if(!visitMap[i] && map[item][i] == 1){
                q.add(i)
                visitMap[i] = true
                count2606++
            }
        }
    }
}

fun dfs2606(map: Array<Array<Int>>, visitMap: BooleanArray, v: Int) {
    if(visitMap[v]) return
    visitMap[v] = true
    for(i in 1 until visitMap.size){
        if(!visitMap[i] && map[v][i] == 1) {
            count2606++
            dfs2606(map, visitMap, i)
        }
    }
}
