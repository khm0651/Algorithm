import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var list = IntArray(n)
    var st = StringTokenizer(readLine())
    for(i in 0 until n) list[i] = st.nextToken().toInt()
    var path = IntArray(n){-1}
    var lisList = ArrayList<Int>()
    var lisLen = -1
    var stack = Stack<Int>()
    for( i in 0 until n){
        if(lisList.isEmpty()) {
            lisList.add(list[i])
            lisLen++
            path[i]= lisLen
        } else {
            if(lisList[lisLen] < list[i]){
                lisList.add(list[i])
                lisLen++
                path[i]= lisLen
            }else{
                var pos = lowerBound14003(lisList,target = list[i],start = 0,end = lisLen)
                lisList[pos] = list[i]
                path[i]= pos
            }
        }
    }
    bw.write("${lisLen+1}\n")
    for(i in n-1 downTo 0){
        if(path[i] == lisLen){
            stack.add(list[i])
            lisLen--
        }
    }
    while(stack.isNotEmpty()){
        bw.write("${stack.pop()} ")
    }
    bw.flush()
}

fun lowerBound14003(lisList: ArrayList<Int>, target: Int, start: Int, end: Int): Int {

    var s = start
    var e = end

    while(s < e){
        var mid = (s+e) / 2
        if(target > lisList[mid]) s = mid + 1
        else e = mid
    }

    return e
}
