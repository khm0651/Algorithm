import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var inorderList = readLine().split(" ").map{it.toInt()}
    var postorderList = readLine().split(" ").map{it.toInt()}
    var position = IntArray(n+1)
    for( i in inorderList.indices) {
        position[inorderList[i]] = i
    }

    search2263(inStart = 0  , inEnd = n-1, postStart = 0 , postEnd = n-1, inorderList,postorderList,bw,position)
    bw.flush()

}

fun search2263(
    inStart: Int,
    inEnd: Int,
    postStart: Int,
    postEnd: Int,
    inorderList: List<Int>,
    postorderList: List<Int>,
    bw: BufferedWriter,
    position: IntArray
) {
    if( inStart > inEnd && postStart > postEnd) return
    var root = postorderList[postEnd]
    bw.write("${root} ")
    var targetIndex = position[root]
    var leftLen = targetIndex - inStart
    search2263(inStart, targetIndex-1, postStart, postStart + leftLen - 1, inorderList, postorderList, bw, position)
    search2263(inStart + leftLen + 1, inEnd, postStart + leftLen, postEnd -1, inorderList, postorderList, bw, position)
}

