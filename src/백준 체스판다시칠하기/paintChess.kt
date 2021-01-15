package `백준 체스판다시칠하기`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.collections.ArrayList

lateinit var chessBoard : Array<ArrayList<Char>>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var min = Int.MAX_VALUE
    var input = readLine()
    var row = input.split(" ")[1].toInt()
    var col = input.split(" ")[0].toInt()
    chessBoard = Array(col) {arrayListOf<Char>()}


    for(i in 0 until col){
        var rowInput = readLine()
        for (item in rowInput) {
            chessBoard[i].add(item)
        }
    }

    for(i in 0 until col - 7){
        for(j in 0 until row - 7){
            var num = checkChessB(i, j)
            if(min > num) min = num
            num = checkChessW(i, j)
            if(min > num) min = num
        }
    }

    println(min)

}

fun checkChessB(col: Int, row: Int) : Int{
    var changeChessNum = 0
    var startChar = 'B'
    for(i in col until col + 8){
        var c = startChar
        for(j in row until row + 8){
            if(chessBoard[i][j] != c) changeChessNum++
            c = if(c == 'W') 'B' else 'W'
        }
        startChar = if(startChar == 'W') 'B' else 'W'
    }
    return changeChessNum
}

fun checkChessW(col: Int, row: Int) : Int{
    var changeChessNum = 0
    var startChar = 'W'
    for(i in col until col + 8){
        var c = startChar
        for(j in row until row + 8){
            if(chessBoard[i][j] != c) changeChessNum++
            c = if(c == 'W') 'B' else 'W'
        }
        startChar = if(startChar == 'W') 'B' else 'W'
    }
    return changeChessNum
}







