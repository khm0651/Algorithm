import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.collections.ArrayList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var ( v, e ) = readLine().split(" ").map { it.toInt() }
    var k = readLine().toInt()
    var graph = Array(v+1){ArrayList<Node1753>()}
    var distance = IntArray(v+1){Int.MAX_VALUE}
    distance[k] = 0
    for(i in 0 until e){
        var (u,v,w) = readLine().split(" ").map{it.toInt()}
        graph[u].add(Node1753(v,w))
    }
    dijkstra(graph,distance,k)
    for(i in 1 .. v) if(distance[i] == Int.MAX_VALUE) bw.write("INF\n") else bw.write("${distance[i]}\n")
    bw.flush()
}

fun dijkstra(graph: Array<ArrayList<Node1753>>, distance: IntArray, k: Int) {
    var q = PriorityQueue<Node1753>()
    q.add(Node1753(k,0))
    while(q.isNotEmpty()){
        var node = q.poll()
        if( node.w > distance[node.v]) continue
        for(i in 0 until graph[node.v].size){
            var to = graph[node.v][i]
            if(distance[to.v] > distance[node.v]+to.w){
                distance[to.v] = distance[node.v]+to.w
                q.add(Node1753(to.v,distance[to.v]))
            }
        }
    }

}

data class Node1753(var v : Int, var w : Int) : Comparable<Node1753>{
    override fun compareTo(other: Node1753): Int {
        return w - other.w
    }

}