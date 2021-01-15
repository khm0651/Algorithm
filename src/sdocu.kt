import java.io.BufferedReader
import java.io.InputStreamReader

var sdocuMap = Array(9){IntArray(9)}

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    for(i in 0 until 9){
        sdocuMap[i] = reader.readLine().split(" ").map(String::toInt).toIntArray()
    }
    for(i in 0 until 9 step 3){
        for(j in 0 until 9 step 3){
            var size = 0
            var visitMap = BooleanArray(9){false}
            var map = arrayListOf<Int>()
            for(row in i until i+3){
                for(col in j until j+3){
                    map.add(sdocuMap[row][col])
                    if(sdocuMap[row][col] != 0) visitMap[sdocuMap[row][col]-1] = true
                    else size++
                }
            }



        }
    }
}
