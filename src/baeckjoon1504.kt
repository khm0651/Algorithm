import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.min

fun main () = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var (n,e) = readLine().split(" ").map { it.toInt() }
    var graph = Array(n+1){ArrayList<Node1504>()}
    for(i in 0 until e){
        var (a,b,c) = readLine().split(" ").map { it.toInt() }
        graph[a].add(Node1504(b,c))
        graph[b].add(Node1504(a,c))
    }
    var (v1,v2) = readLine().split(" ").map { it.toInt() }
    var list = arrayOf(
        intArrayOf(1,v1,v2,n),
        intArrayOf(1,v2,v1,n)
    )
    var min = Int.MAX_VALUE
    for(i in 0 until list.size){
        var sum = 0
        var f = false
        for(j in 0 until list[0].size-1){
            var result = dijkstra1504(graph,list[i][j],list[i][j+1])
            if(result == Int.MAX_VALUE) {
                f = true
                break
            }
            sum += result
        }
        if(!f) min = min(min,sum)
    }
    if(min == Int.MAX_VALUE) min = -1
    bw.write("${min}")
    bw.flush()
}

fun dijkstra1504(graph: Array<ArrayList<Node1504>>, start: Int, target: Int) : Int {
    var q = PriorityQueue<Node1504>()
    q.add(Node1504(start,0))
    var distance = IntArray(graph.size){Int.MAX_VALUE}
    distance[start] = 0
    while(q.isNotEmpty()){
        var node = q.poll()
        if(node.w > distance[node.to]) continue
        for(i in 0 until graph[node.to].size){
            var next = graph[node.to][i]
            if(distance[next.to] > distance[node.to]+next.w){
                distance[next.to] = distance[node.to]+next.w
                q.add(Node1504(next.to,distance[next.to]))
            }
        }
    }
    return distance[target]
}

data class Node1504(var to : Int, var w : Int) : Comparable<Node1504>{
    override fun compareTo(other: Node1504): Int {
        return w - other.w
    }

}