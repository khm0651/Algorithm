package `백준 유기농배추`

import java.util.*

var count = 0
fun main(args : Array<String>){
    var sc = Scanner(System.`in`)
    var testcase = sc.nextLine().toInt()
    var list :ArrayList<Array<Array<Boolean>>> = arrayListOf()
    for (i in 0 until testcase){
        var input = sc.nextLine()
        var width = input.split(" ")[0].toInt()
        var height = input.split(" ")[1].toInt()
        var coordCount = input.split(" ")[2].toInt()
        list.add(Array(height,{Array(width,{false})}))
        for(j in 0 until coordCount){
            var coord = sc.nextLine()
            list[i][coord.split(" ")[1].toInt()][coord.split(" ")[0].toInt()] = true
        }
    }


    for(i in 0 until testcase){
        var visit = Array(list[i].size,{Array(list[i][0].size,{false})})
        for(j in 0 until list[i].size){
            for(k in 0 until list[i][j].size){

                findDFS(list[i], visit, j, k, false)
            }
        }
        println(count)
        count =0

    }
}

fun findDFS(arr : Array<Array<Boolean>> ,visit: Array<Array<Boolean>>, idx: Int, jdx: Int,isCheck : Boolean) {
    if(!arr[idx][jdx]) return
    else{
        if(!visit[idx][jdx]){
            visit[idx][jdx] = true
            var f = isCheck
            if(!f){
                count++
                f = true
            }
            if(jdx != 0) findDFS(arr, visit, idx, jdx - 1, f)
            if(jdx+1 != arr[0].size) findDFS(arr, visit, idx, jdx + 1, f)
            if(idx != 0) findDFS(arr, visit, idx - 1, jdx, f)
            if(idx+1 != arr.size) findDFS(arr, visit, idx + 1, jdx, f)
        }
    }

}

