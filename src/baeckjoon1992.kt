import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var num = readLine().toInt()
    var map = Array<IntArray>(num){ IntArray(num) }
    for(i in 0 until num){
        map[i] = readLine().toCharArray().map{it.toString()}.map{it.toInt()}.toIntArray()
    }
    quadTree(i=0,j=0,num,map,bw,num)
    bw.flush()
}

fun quadTree(i: Int, j: Int, num: Int, map: Array<IntArray>, bw: BufferedWriter, startNum: Int) {
    if(check(i,j,num,map)){
        if(num == startNum){
            bw.write("${map[i][j]}")
        }else{
            bw.write("${map[i][j]}")
        }
        return
    }else{
        bw.write("(")
        quadTree(i,j,num/2, map, bw, startNum)
        quadTree(i,j+(num/2),num/2, map, bw, startNum)
        quadTree(i+(num/2),j,num/2, map, bw, startNum)
        quadTree(i+(num/2),j+(num/2),num/2, map, bw, startNum)
        bw.write(")")
    }
}

fun check(idx: Int, jdx: Int, num: Int, map: Array<IntArray>): Boolean {
    var start = map[idx][jdx]
    for(i in idx until num + idx){
        for(j in jdx until num + jdx){
            if(start != map[i][j]) return false
        }
    }
    return true
}
