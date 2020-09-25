package `백준 완전탐색 블랙잭`

import java.util.*
import kotlin.collections.ArrayList

var m = 0
fun main(args:Array<String>){
    var sc = Scanner(System.`in`)
    var target = 0
    var one = sc.nextLine()
    target = one.split(" ")[1].toInt()
    var cardList = Array<Int>(one.split(" ")[0].toInt(),{0})
    var two = sc.nextLine().split(" ")
    for(i in cardList.indices){
        cardList[i] = two[i].toInt()
    }
    var visit = Array<Boolean>(cardList.size,{false})
    solution(cardList, visit, arrayListOf(), target)
    println(m)
}

fun solution(cardList: Array<Int>,visit : Array<Boolean>,accumulatorList : ArrayList<Int>,target:Int){

    for(i in cardList.indices){
        if(m == target) return
        if(!visit[i] && accumulatorList.size!=3){
            visit[i] = true
            accumulatorList.add(cardList[i])
            var total = 0
            if(accumulatorList.size == 3){
                for(i in accumulatorList) total += i
                if(total <= target){
                    if(m < total) m = total
                }
                solution(cardList, visit, accumulatorList, target)

            }else{
                solution(cardList, visit, accumulatorList, target)
            }
            visit[i] = false
            accumulatorList.removeAt(accumulatorList.size-1)
        }
    }

}