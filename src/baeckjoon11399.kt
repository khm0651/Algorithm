import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    var arr = reader.readLine().split(" ").map(String::toInt).toIntArray()
    var dp = IntArray(num)
    var visit = BooleanArray(num){false}
    for(i in 0 until num){
        findNumMin(arr,visit)
    }
}

fun findNumMin(arr: IntArray, visit: BooleanArray) {
    var min = Int.MAX_VALUE
    var idx = 0
    for(i in arr.indices){
        if(!visit[i]){
            if(min>arr[i]){
                idx=i
                min = arr[i]
            }
        }
    }
    visit[idx] = true
}
