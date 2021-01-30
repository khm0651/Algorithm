import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var n = readLine().toInt()
    var nList = readLine().split(" ").map(String::toInt).toIntArray()
    nList.sort()
    var m = readLine().toInt()
    var mList = readLine().split(" ").map(String::toInt).toIntArray()
    var bw = System.out.bufferedWriter()
    for(i in 0 until m){
        bw.write("${searchItem(nList,target = mList[i], start=0, end=n)}\n")
    }
    bw.flush()
}

fun searchItem(nList: IntArray, target: Int, start: Int, end : Int): Int {
    var mid = (start+end)/2
    if(nList[mid] == target) return 1
    if(mid == start) return 0
    if(nList[mid] > target) return searchItem(nList, target, start, mid)
    else return searchItem(nList, target, mid, end)
}
