import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()

    var (M,N,K) = readLine().split(" ").map { it.toInt() }
    var map = Array(M){IntArray(N)}
    for(i in 0 until K){
        var item = readLine().split(" ").map { it.toInt() }
        var x1 = item[0]
        var y1 = item[1]
        var x2 = item[2]
        var y2 = item[3]
        for(i in y1 until y2){
            for(j in x1 until x2){
                map[i][j] = 1
            }
        }
    }
    var count = 0
    var answerList = ArrayList<Int>()
    for(i in 0 until M){
        for(j in 0 until N){
            if(map[i][j] == 0){
                count++
                answerList.add(getAreaSize(map,idx =i, jdx = j,size = 1))
            }
        }
    }
    answerList.sort()
    bw.write("${count}\n")
    for(i in answerList) bw.write("${i} ")
    bw.flush()
}

fun getAreaSize(map: Array<IntArray>, idx: Int, jdx: Int, size: Int) : Int {
    if(map[idx][jdx] == 1) return size-1
    map[idx][jdx] = 1
    var dx = intArrayOf(1,0,-1,0)
    var dy = intArrayOf(0,1,0,-1)
    var s = size
    for(i in 0 until 4){
        var nextIdx = idx + dy[i]
        var nextJdx = jdx + dx[i]
        if(canMoveThere2583(map,nextIdx,nextJdx)){
            s = getAreaSize(map, nextIdx, nextJdx, s+1)
        }
    }
    return s
}

fun canMoveThere2583(map: Array<IntArray>, nextIdx: Int, nextJdx: Int): Boolean {
    return nextIdx in 0 until map.size && nextJdx in 0 until map[0].size
}
