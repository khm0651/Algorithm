import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    var memo = Array<LongArray>(500){ LongArray(500){-1} }
    var list = Array<LongArray>(500){ LongArray(500){-1} }

    for(i in 0 until num){
        var input = reader.readLine().split(" ").map(String::toLong)
        for(j in input.indices) list[i][j] = input[j]
    }

    memo[0][0] = list[0][0]
    println(findMax(memo,list, deep =0,num))

}

fun findMax(memo: Array<LongArray>, list: Array<LongArray>, deep: Int, num: Int): Long {

    if(deep == num-1) {
        var max = Long.MIN_VALUE
        for(i in memo[deep].indices){
            if(memo[deep][i].toInt() == -1) break
            if(max < memo[deep][i]) max = memo[deep][i]
        }
        return max
    }

    for(i in list[deep].indices){
        if(list[deep][i].toInt() == -1) break
        if(memo[deep+1][i] <= memo[deep][i] + list[deep+1][i]) memo[deep+1][i] = memo[deep][i] + list[deep+1][i]
        if(memo[deep+1][i+1] <= memo[deep][i] + list[deep+1][i+1]) memo[deep+1][i+1] = memo[deep][i] + list[deep+1][i+1]
    }
    return findMax(memo, list, deep+1, num)
}
