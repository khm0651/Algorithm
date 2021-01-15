import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    var min = Long.MAX_VALUE
    var rgbArr = Array(num){LongArray(3)}
    var list = ArrayList<List<Long>>()
    for(i in 0 until num){
        var rgb = reader.readLine().split(" ").map(String::toLong)
        list.add(rgb)
    }
    for(i in 0 until 3){
        rgbArr[0][i] = list[0][i]
    }

    findMin(rgbArr,list)

    for(item in rgbArr[num-1]){
        if(min > item) min = item
    }

    println(min)
}

fun findMin(rgbArr: Array<LongArray>, list: ArrayList<List<Long>>) {

    for(i in 1 until rgbArr.size){
        for(j in 0 until 3){
            when(j){
                0 -> {
                    if(rgbArr[i-1][1]<rgbArr[i-1][2]) rgbArr[i][j] = rgbArr[i-1][1] + list[i][j]
                    else rgbArr[i][j] = rgbArr[i-1][2] + list[i][j]
                }

                1 -> {
                    if(rgbArr[i-1][0]<rgbArr[i-1][2]) rgbArr[i][j] = rgbArr[i-1][0] + list[i][j]
                    else rgbArr[i][j] = rgbArr[i-1][2] + list[i][j]
                }

                2 -> {
                    if(rgbArr[i-1][0]<rgbArr[i-1][1]) rgbArr[i][j] = rgbArr[i-1][0] + list[i][j]
                    else rgbArr[i][j] = rgbArr[i-1][1] + list[i][j]
                }
            }
        }
    }
}

