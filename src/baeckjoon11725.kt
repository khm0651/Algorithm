import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var tree = Array(n+1){ArrayList<Int>()}
    var visitMap = BooleanArray(n+1)
    var parent = IntArray(n+1)
    repeat(n-1){
        var (v1,v2) = readLine().split(" ").map{it.toInt()}
        tree[v1].add(v2)
        tree[v2].add(v1)
    }
    bfs11725(tree,visitMap,parent)
    printAnswer11725(parent,bw)
}

fun printAnswer11725(parent: IntArray, bw: BufferedWriter) {
    for(i in 2 until parent.size) bw.write("${parent[i]}\n")
    bw.flush()
}

fun bfs11725(tree: Array<ArrayList<Int>>, visitMap: BooleanArray, parent: IntArray) {
    var q : Queue<Int> = LinkedList<Int>()
    q.add(1)
    visitMap[1] = true
    while(q.isNotEmpty()){
        var node = q.poll()
        for(i in 0 until tree[node].size){
            var next = tree[node][i]
            if(visitMap[next]) continue
            parent[next] = node
            q.add(next)
            visitMap[next] = true
        }
    }
}
