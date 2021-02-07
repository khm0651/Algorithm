import java.io.BufferedReader
import java.io.InputStreamReader

fun main () = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var testCase = readLine().toInt()
    for(i in 0 until testCase){
        var (m,n,k) = readLine().split(" ").map { it.toInt() }
        var map = Array(n){Array(m){0} }
        var visitMap = Array(n){BooleanArray(m)}
        var answer = 0
        for(i in 0 until k) {
            var (x,y) = readLine().split(" ").map { it.toInt() }
            map[y][x] = 1
        }
        for(i in 0 until n){
            for(j in 0 until m){
                if(map[i][j] == 1 && !visitMap[i][j]) {
                    answer++
                    dfs1012(visitMap,map,i,j)
                }
            }
        }
        bw.write("${answer}\n")
    }
    bw.flush()
}

fun dfs1012(visitMap: Array<BooleanArray>, map: Array<Array<Int>>, i: Int, j: Int) {
    if(visitMap[i][j]) return
    visitMap[i][j] = true

    if(j!=0 && !visitMap[i][j-1] && map[i][j-1] == 1) dfs1012(visitMap, map, i, j-1)
    if(j<map[0].size-1 && !visitMap[i][j+1] && map[i][j+1] == 1) dfs1012(visitMap, map, i, j+1)
    if(i!=0 && !visitMap[i-1][j] && map[i-1][j] == 1) dfs1012(visitMap, map, i-1, j)
    if(i<map.size-1 && !visitMap[i+1][j] && map[i+1][j] == 1 ) dfs1012(visitMap, map, i+1, j)

}
