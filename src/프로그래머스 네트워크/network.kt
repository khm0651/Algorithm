package `프로그래머스 네트워크`

var a = 0
fun main(args : Array<String>){

    var n: Int = 3
    var computers: Array<IntArray> = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 1))

    var visitMap = Array<Boolean>(computers.size, {false})

    for( i in 0 until computers.size){
        if(!visitMap[i]){
            findNetwork(i, computers, visitMap)
            a++
        }

    }

}

fun findNetwork(i: Int, computers: Array<IntArray>, visitMap: Array<Boolean>) {
    for(j in 0 until computers[0].size){
        if(i != j && visitMap[j] == false && computers[i][j] == 1){
            visitMap[j] = true
            findNetwork(j, computers, visitMap)
        }
    }
}


