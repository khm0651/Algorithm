import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

var answer : Long = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var input = readLine().split(" ").map{it.toInt()}
    var k = input[0]
    var n = input[1]
    var list = LongArray(k)
    var MAX = Long.MIN_VALUE

    for(i in 0 until k) {
        list[i] = readLine().toLong()
        MAX = max(MAX,list[i])
    }
    findMaxCm(list,start=0,end = MAX*2,n)
    println(answer)
}

fun findMaxCm(list: LongArray, start: Long, end: Long, n: Int) {
    var mid = ( start + end ) / 2

    if(mid == start) return

    if(checkCm(list,mid,n)){
        answer = max(answer,mid)
        findMaxCm(list, mid, end, n)
    }else{
        findMaxCm(list, start, mid,n)
    }
}

fun checkCm(list: LongArray, mid: Long, n: Int): Boolean {
    var count : Long = 0
    for(i in list) count += i/mid
    return count >= n
}
