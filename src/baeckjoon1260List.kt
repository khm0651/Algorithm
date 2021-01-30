import java.io.BufferedWriter
import java.util.*
import kotlin.collections.ArrayList

fun main(){
    var reader = System.`in`.bufferedReader()
    var bw = System.out.bufferedWriter()
    var (n,m,v) = reader.readLine().split(" ").map { it.toInt() }
    var map = Array(n+1){ArrayList<Int>()}
    var visitMap = BooleanArray(n+1)
    for(i in 0 until m){
        var (node1,node2) = reader.readLine().split(" ").map { it.toInt() }
        map[node1].add(node2)
        map[node2].add(node1)
    }
    for(i in 0 until map.size){
        map[i].sort()
    }

    dfs1260List(visitMap,map,v,bw)
    bw.write("\n")
    visitMap = BooleanArray(n+1)
    bfs1260List(visitMap,map,v,bw)
    bw.flush()
}

fun bfs1260List(visitMap: BooleanArray, map: Array<ArrayList<Int>>, v: Int, bw: BufferedWriter) {
    var q : Queue<Int> = LinkedList<Int>()
    q.add(v)
    visitMap[v] = true
    while(q.isNotEmpty()){
        var item = q.poll()
        bw.write("${item} ")
        for(i in 0 until map[item].size){
            if(!visitMap[map[item][i]]){
                q.add(map[item][i])
                visitMap[map[item][i]] = true
            }
        }
    }
}

fun dfs1260List(visitMap: BooleanArray, map: Array<ArrayList<Int>>, v: Int, bw: BufferedWriter) {
    if(visitMap[v]) return
    visitMap[v] = true
    bw.write("${v} ")
    for(i in 0 until map[v].size){
        if(!visitMap[map[v][i]]) dfs1260List(visitMap, map, map[v][i], bw)

    }
}
