import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

lateinit var visitMapStartLink : BooleanArray
lateinit var startLinkMap : Array<IntArray>
var minStartLink = Int.MAX_VALUE

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    startLinkMap = Array(num){ intArrayOf()}
    for(i in 0 until num){
        startLinkMap[i] = reader.readLine().split(" ").map(String::toInt).toIntArray()
    }
    visitMapStartLink = BooleanArray(num) {false}
    dfsStartLink(num, deep = 0, start = 0)
    println(minStartLink)

}

fun dfsStartLink(num: Int, deep: Int,start : Int) {

    if((num/2) == deep){

        var startSum = 0
        var linkSum = 0

        for(i in 0 until num-1){
            for(j in i+1 until num){
                if(visitMapStartLink[i] && visitMapStartLink[j]){
                    startSum += startLinkMap[i][j]
                    startSum += startLinkMap[j][i]
                }

                if(!visitMapStartLink[i] && !visitMapStartLink[j]){
                    linkSum += startLinkMap[i][j]
                    linkSum += startLinkMap[j][i]
                }

            }
        }

        if(minStartLink > abs(startSum - linkSum)){
            minStartLink = abs(startSum - linkSum )
        }

        return
    }

    for(i in start until num){
        if(!visitMapStartLink[i]){
            visitMapStartLink[i] = true
            dfsStartLink(num,deep+1,i)
            visitMapStartLink[i] = false
        }
    }
}
