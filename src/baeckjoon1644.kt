import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.collections.ArrayList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var numberOfCase = 0
    var left = 0
    var right = 1
    var decimalList = ArrayList<Int>()
    var check = BooleanArray(n+1)
    var sumList = IntArray(n+1)
    for(i in 2..n){
        if(!check[i]){
            decimalList.add(i)
            for(j in 1 until n){
                if(i*j > n) break
                check[i*j] = true
            }
        }
    }
    if(decimalList.size>=1){
        for(i in 1 .. decimalList.size) sumList[i] = sumList[i-1] + decimalList[i-1]
    }
    while(right <= decimalList.size){
        var sum = sumList[right] - sumList[left]
        if(sum == n){
            numberOfCase++
            left++
            right++
        }else if(sum < n) right++
        else left++
    }
    bw.write("${numberOfCase}")
    bw.flush()
}
