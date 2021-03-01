import kotlin.math.max
import kotlin.math.min

fun main(){
    FindBigRectangle().solution(arrayOf(
            intArrayOf(0,1,1,1),
            intArrayOf(1,1,1,1),
            intArrayOf(1,1,1,1),
            intArrayOf(0,0,1,0),
    ))
}

class FindBigRectangle{
    fun solution(board : Array<IntArray>) : Int{
        var answer = Int.MIN_VALUE
        for(i in 0 until board.size){
            for(j in 0 until board[0].size){
                if(board[i][j] != 0){
                    var range = min(board.size-(i+1) , board[0].size-(j+1))
                    answer = max(findBigRectangle(i,j,range,board),answer)
                }
            }
        }
        return answer
    }

    private fun findBigRectangle(idx: Int, jdx: Int, range: Int, board: Array<IntArray>) : Int {
        if(range == 0) return 1
        return if(checkRectangle(idx,jdx,range,board)){
            (range+1)*(range+1)
        }else{
            findBigRectangle(idx, jdx, range-1, board)
        }
    }

    private fun checkRectangle(idx: Int, jdx: Int, range: Int, board: Array<IntArray>): Boolean {
        for(i in idx .. idx+range){
            for(j in jdx .. jdx+range){
                if(board[i][j] == 0) return false
            }
        }
        return true
    }
}