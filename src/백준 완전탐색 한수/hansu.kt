package `백준 완전탐색 한수`

import java.util.*
fun main(args : Array<String>){

    var num = 0
    var sc = Scanner(System.`in`)
    num = sc.nextInt()
    print(solution(num))

}

fun solution(num : Int) : Int{
    var count = 0
    for (i in 1..num) {
        if (i < 100) count++
        else{
            var charArr = i.toString().toCharArray()
            var dif = charArr[1].toInt() - charArr[0].toInt()
            var isHan = true
            for(j in 0 until charArr.size-1){
                if( !(charArr[j+1].toInt() - charArr[j].toInt() == dif) ) isHan = false
            }
            if(isHan) count++
        }
    }
    return count
}