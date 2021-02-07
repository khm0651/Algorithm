//import java.io.BufferedReader
//import java.io.InputStreamReader
//import java.util.PriorityQueue
//
//fun main () = with(BufferedReader(InputStreamReader(System.`in`))){
//    var bw = System.out.bufferedWriter()
//    var testcase = readLine().toInt()
//    for(i in 0 until testcase){
//        var (n,m,t) = readLine().split(" ").map { it.toInt() }
//        var (s,g,h) = readLine().split(" ").map{it.toInt()}
//        var graph = Array(n+1){ArrayList<Node9370>()}
//        var candidate = IntArray(t)
//        for(i in 0 until m){
//            var (a,b,d) = readLine().split(" ").map{it.toInt()}
//            graph[a].add(Node9370(b,d))
//            graph[b].add(Node9370(a,d))
//        }
//        for(i in 0 until t) candidate[i] = readLine().toInt()
//        var answer = ArrayList<Int>()
//        for(i in 0 until t){
//            var list = arrayOf(
//                intArrayOf(s,g,h,candidate[i]),
//                intArrayOf(s,h,g,candidate[i])
//            )
//            for(i in 0 until 2){
//                var best1 = dijkstra9370(graph,list[i][0])
//                var best2 = dijkstra9370(graph,list[i][1])
//                var best3 = dijkstra9370(graph,list[i][2])
//                if(best1[list[i][3]] == best1[list[i][1]] + best2[list[i][2]] + best3[list[i][3]]){
//                   answer.add(list[i][3])
//                }
//            }
//        }
//        answer.sort()
//        answer.forEach {
//            bw.write("${it} ")
//        }
//        bw.write("\n")
//    }
//    bw.flush()
//}
//
//fun dijkstra9370(graph: Array<ArrayList<Node9370>>, start: Int): IntArray {
//    var q = PriorityQueue<Node9370>()
//    q.add(Node9370(start,0))
//    var distance = IntArray(graph.size){Int.MAX_VALUE}
//    distance[start] = 0
//    while(q.isNotEmpty()){
//        var node = q.poll()
//        for(i in 0 until graph[node.to].size){
//            var next = graph[node.to][i]
//            if(distance[next.to]>distance[node.to]+next.w){
//                distance[next.to] = distance[node.to]+next.w
//                q.add(Node9370(next.to,distance[next.to]))
//            }
//        }
//    }
//    return distance
//}
//
//data class Node9370 (var to : Int, var w : Int) : Comparable<Node9370>{
//    override fun compareTo(other: Node9370): Int {
//        return w - other.w
//    }
//
//}

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Edge(val to: Int, val dist: Int)

const val MAX = 1111111111

fun dij(edges: Array<MutableList<Edge>>, s: Int): Array<Int> {
    val pq = PriorityQueue<Edge>(compareBy { it.dist })
    val rtn = Array(edges.size) { MAX }
    pq.add(Edge(s, 0))
    while (pq.isNotEmpty()) {
        val now = pq.poll()
        if (rtn[now.to] != MAX) continue
        else rtn[now.to] = now.dist
        edges[now.to].forEach { pq.add(Edge(it.to, it.dist + now.dist)) }
    }
    return rtn
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine().toInt()) {
        val (n, m, t) = readLine().split(' ').map { it.toInt() }
        var (s, g, h) = readLine().split(' ').map { it.toInt() - 1 }
        val edges = Array(n) { mutableListOf<Edge>() }
        repeat(m) {
            val st = StringTokenizer(readLine())
            val (a, b, d) =
                Triple(st.nextToken().toInt() - 1, st.nextToken().toInt() - 1, st.nextToken().toInt())
            edges[a].add(Edge(b, d))
            edges[b].add(Edge(a, d))
        }
        val btw = edges[h].find { it.to == g }!!.dist
        val target = List(t) { readLine().toInt() - 1 }.sorted()
        val temp = dij(edges, s)
        if (temp[h] > temp[g])
            g = h.also { h = g }
        val result = dij(edges, g)
        val ans = mutableListOf<Int>()
        target.forEach {
            if (temp[h] + btw + result[it] <= temp[it])
                ans.add(it + 1)
        }
        println(ans.joinToString(" "))
    }
}