package `백준 영화감독숌`

import java.io.BufferedReader
import java.io.InputStreamReader

var countNum = 0
var movieName = charArrayOf()
fun main(args:Array<String>){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    for(i in 666 until Int.MAX_VALUE){
        if(num == countNum) break
        findMovieName(i)
    }
    println(movieName)
}

fun findMovieName(i: Int) {
    var charArray = i.toString().toCharArray()
    for(i in charArray.size-1 downTo 2){

        if(charArray[i] == '6' && charArray[i-1] == '6' && charArray[i-2] == '6') {
            countNum++
            movieName = charArray
            break
        }
    }
}
