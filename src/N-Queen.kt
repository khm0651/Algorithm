import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

lateinit var visitMapQueen : IntArray
var answerNqueen = 0

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()

    visitMapQueen = IntArray(num)

    dfsNqueen(num,0,0)
    println(answerNqueen)
}

fun dfsNqueen(col: Int, isPutNum : Int, row : Int) {

    if(isPutNum == col){
        answerNqueen++
        return
    }

    for(i in 0 until col){
        visitMapQueen[row] = i
        if(isPutChess(row)) dfsNqueen(col,isPutNum + 1 , row + 1)
    }

}

fun isPutChess(cureentRow : Int): Boolean {

    for( row in 0 until cureentRow){
        if(visitMapQueen[row] == visitMapQueen[cureentRow] || cureentRow - row == abs(visitMapQueen[row] - visitMapQueen[cureentRow])) return false
    }
    return true
}
