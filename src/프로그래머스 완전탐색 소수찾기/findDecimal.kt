package `프로그래머스 완전탐색 소수찾기`

import kotlin.math.sqrt

fun main(args:Array<String>){
    var numbers : String = "123"
    print(solution(numbers))
}

fun solution(numbers: String): Int {

    var answer = 0
    var charArr = numbers.toCharArray()
    var visit = Array<Boolean>(charArr.size,{false})
    var arrayList = arrayListOf<Int>()
    decimalDFS(charArr, "", visit, arrayList)
    answer = arrayList.size


    return answer
}

fun decimalDFS(charArr : CharArray,s : String,v : Array<Boolean>, arrayList : ArrayList<Int>) {

    for(i in charArr.indices){
        if (!v[i]) {
            v[i] = true
            var str = s + charArr[i].toString()
            if(isDecimal(str.toInt())) {
                if(!arrayList.contains(str.toInt())) arrayList.add(str.toInt())
            }
            decimalDFS(charArr, str, v, arrayList);
            v[i] = false;
        }
    }

}

fun isDecimal (num : Int) : Boolean {

    when {
        num < 2 -> {
            return false
        }
        num == 2 -> {
            return true
        }
        else -> {
            for(i in 2 ..  sqrt(num.toDouble()).toInt()){
                if(num%i == 0) return false
            }
            return true
        }
    }

}

