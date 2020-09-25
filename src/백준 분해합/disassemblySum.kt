package `백준 분해합`

import java.util.*

fun main(args:Array<String>){
    var sc = Scanner(System.`in`)
    var num = sc.nextInt()
    solution(num)
}

fun solution(num : Int){
    if(num < 11){
        println(0)
    }else{
        for(i in 10 until num){
            var split = i.toString().toCharArray()
            var sum = 0
            for(i in split){
                sum += i.toString().toInt()
            }
            sum += i
            if( sum == num ) {
                println(i)
                return
            }

        }
        println(0)
    }
}
