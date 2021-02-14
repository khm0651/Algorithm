//import java.io.BufferedReader
//import java.io.InputStreamReader
//import java.util.*
//
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
//    var bw = System.out.bufferedWriter()
//    var n = readLine().toInt()
//    var st = StringTokenizer(readLine())
//    var list = IntArray(n)
//    var dp = IntArray(n){1}
//    var path = IntArray(n){-1}
//    var maxIdx = -1
//    var maxLen = -1
//    var stack = Stack<Int>()
//    for(i in 0 until n){
//        list[i] = st.nextToken().toInt()
//    }
//    for(i in 0 until n){
//        for(j in 0 until i){
//            if(list[i] > list[j] && dp[i] < dp[j]+1){
//                dp[i] = dp[j]+1
//                path[i] = j
//                if(maxLen<dp[i]){
//                    maxLen = dp[i]
//                    maxIdx = i
//                }
//            }
//        }
//    }
//    if(maxLen == -1) {
//        bw.write("1\n")
//        bw.write("${list[0]} ")
//    }else{
//        bw.write("${maxLen}\n")
//        while(true){
//            stack.push(list[maxIdx])
//            maxIdx = path[maxIdx]
//            if(maxIdx == -1) break
//        }
//        while(stack.isNotEmpty()){
//            bw.write("${stack.pop()} ")
//        }
//    }
//
//    bw.flush()
//}

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val n=br.readLine()!!.toInt()
    val arr=br.readLine()!!.split(" ").map { it.toInt() }

    val dp=IntArray(n)
    val pairs= arrayListOf<Pair<Int,Int>>()
    var idx=0

    dp[0]=arr[0]
    pairs.add(Pair(0,arr[0]))

    fun lowerBound(arr: IntArray, end: Int, target: Int): Int {
        var s = 0
        var e = end

        while (e > s)
        {
            val mid = (s + e) / 2
            if (arr[mid] >= target)
                e = mid
            else s = mid + 1
        }
        return e
    }

    for (i in 1 until n) {
        if (dp[idx]<arr[i]) {
            dp[++idx]=arr[i]
            pairs.add(Pair(idx,arr[i]))
            continue
        }
        val lowerbound=lowerBound(dp,idx,arr[i])
        dp[lowerbound]=arr[i]
        pairs.add(Pair(lowerbound,arr[i]))
    }

    println(idx+1)
    val stack=Stack<Int>()
    for (i in n-1 downTo 0) {
        if (pairs[i].first==idx) {
            stack.push(pairs[i].second)
            idx--
        }
    }

    println(stack.reversed().joinToString(" "))
}