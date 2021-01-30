import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    var distance = reader.readLine().split(" ").map(String::toLong)
    var cost = reader.readLine().split(" ").map(String::toLong)
    var c : Long= 0
    var distanceSum :Long= 0
    var result :Long= 0
    for(i in 0 until num-1){

        if( i == 0){
            c = cost[i]
            distanceSum = distance[i]
        }else{
            if(c>cost[i]){
                result+= c * distanceSum
                c = cost[i]
                distanceSum = distance[i]
            }else{
                distanceSum += distance[i]
            }
        }
    }
    result+= c * distanceSum
    println(result)

}