import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var num = readLine().toInt()
    var map = Array(num,){IntArray(num)}
    var hashMap = HashMap<Int,Int>()
    hashMap[-1] = 0
    hashMap[0] = 0
    hashMap[1] = 0
    for(i in 0 until num){
        var st = StringTokenizer(readLine())
        for(j in 0 until num){
            map[i][j] = st.nextToken().toInt()
        }
    }
    paperCount(0,0,num,map,hashMap)
    bw.write("${hashMap[-1]}\n${hashMap[0]}\n${hashMap[1]}")
    bw.flush()
    bw.close()
}

fun paperCount(i: Int, j: Int, num: Int, map: Array<IntArray>, hashMap: HashMap<Int, Int>) {
    if(checkPaper(idx=i,jdx=j,num,map)){
        hashMap.replace(map[i][j], hashMap[map[i][j]]!!+1)
    }else{
        paperCount(i, j, num/3, map, hashMap)
        paperCount(i, j + (num/3), num/3, map, hashMap)
        paperCount(i, j + ((num/3)*2), num/3, map, hashMap)
        paperCount(i + (num/3), j, num/3, map, hashMap)
        paperCount(i + (num/3), j + (num/3), num/3, map, hashMap)
        paperCount(i + (num/3), j + ((num/3)*2), num/3, map, hashMap)
        paperCount(i + ((num/3)*2), j, num/3, map, hashMap)
        paperCount(i + ((num/3)*2), j + (num/3), num/3, map, hashMap)
        paperCount(i + ((num/3)*2), j + ((num/3)*2), num/3, map, hashMap)
        return
    }
}

fun checkPaper(idx: Int, jdx: Int, num: Int, map: Array<IntArray>): Boolean {
    var start = map[idx][jdx]
    for(i in idx until num + idx){
        for(j in jdx until num + jdx){
            if(start != map[i][j]) return false
        }
    }
    return true
}
