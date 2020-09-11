package `백준 2667번 단지번호붙히기`
import java.util.Scanner

var count = 0
var answer = arrayListOf<Int>()

fun main (args:Array<String>){
    var sc : Scanner = Scanner(System.`in`)
    var n : Int = 0;
     n = sc.nextLine().toInt()
    var arr = Array(n, { IntArray(n) })
    var map = Array(n, { Array<String>(n ,{"0"}) })
    for(i in 0 until n){
        var str = sc.nextLine()
        for(j in 0 until str.length){
            arr[i][j] = str.get(j).toString().toInt()
        }
    }

    for(i in 0 until arr.size){

        for(j in 0 until arr[i].size){
            if(arr[i][j]==1 && map[i][j]!="visit"){
                count = 0
                find(arr,map,i,j)
                answer.add(count)
            }
        }
    }

    answer.sort()
    println(answer.size)
    for(i in 0 until answer.size){
        println(answer[i])
    }

}

fun find(arr: Array<IntArray>, map: Array<Array<String>>, i: Int, j: Int) {

    if(arr[i][j] == 1 && map[i][j]!="visit"){
        count = count + 1
        map[i][j]="visit"

        if(j != 0 && arr[i][j-1] == 1 && map[i][j-1]!="visit") find(arr,map,i,j-1)
        if(j != arr[i].size -1 && arr[i][j+1]==1 && map[i][j+1]!="visit") find(arr,map,i,j+1)
        if(i != 0 && arr[i-1][j]==1 && map[i-1][j]!="visit") find(arr,map,i-1,j)
        if(i != arr.size -1 && arr[i+1][j]==1 && map[i+1][j]!="visit") find(arr,map,i+1,j)
    }
}




