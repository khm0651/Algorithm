import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var case = 1
    while(true){
        var answer4803 = 0
        var (n,m) = readLine().split(" ").map{it.toInt()}
        if(n ==0 && m == 0) break
        var tree = Array(n+1){ArrayList<Int>()}
        var visitMap = BooleanArray(tree.size)
        repeat(m){
            var (from,to) = readLine().split(" ").map{it.toInt()}
            tree[from].add(to)
            tree[to].add(from)
        }
        for(i in 1 until tree.size){
            if(!visitMap[i]) {
                if(dfs4803(tree,start = i,before = 0,visitMap)) answer4803 += 1
            }
        }
        when(answer4803){
            0-> bw.write("Case ${case}: No trees.\n")
            1-> bw.write("Case ${case}: There is one tree.\n")
            else -> bw.write("Case ${case}: A forest of ${answer4803} trees.\n")
        }
        case++
    }
    bw.flush()
}

fun dfs4803(tree: Array<ArrayList<Int>>, start: Int, before: Int, visitMap: BooleanArray): Boolean {

    visitMap[start] = true
    for(i in 0 until tree[start].size){
        if(tree[start][i] == before) continue
        if(visitMap[tree[start][i]]) return false
        if(!dfs4803(tree,tree[start][i],start,visitMap)) return false
    }
    return true
}
