import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var (V,E) = readLine().split(" ").map { it.toInt() }
    var graph = Array(V+1){ArrayList<Node1197>()}
    var visitMap = BooleanArray(V+1)
    var pq = PriorityQueue<Node1197>()
    var answer = 0
    var cnt = 0
    for(i in 0 until E){
        var (A,B,C) = readLine().split(" ").map { it.toInt() }
        graph[A].add(Node1197(B,C))
        graph[B].add(Node1197(A,C))
    }
    pq.add(Node1197(1,0))
    while(pq.isNotEmpty()){
        var item = pq.poll()
        if(visitMap[item.v]) continue
        visitMap[item.v] = true
        answer+=item.w
        for(next in graph[item.v]){
            if(!visitMap[next.v]){
                pq.add(next)
            }
        }
        if(++cnt == V) break
    }
    bw.write("${answer}")
    bw.flush()
}


data class Node1197(var v :Int, var w : Int):Comparable<Node1197>{
    override fun compareTo(other: Node1197): Int {
        return this.w - other.w
    }
}