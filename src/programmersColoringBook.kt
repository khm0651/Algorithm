import kotlin.math.max

fun main(){
    ColoringBook().solution(6,4, arrayOf(
            intArrayOf(1,1,1,0),
            intArrayOf(1,2,2,0),
            intArrayOf(1,0,0,1),
            intArrayOf(0,0,0,1),
            intArrayOf(0,0,0,3),
            intArrayOf(0,0,0,3),
    ))
}

class ColoringBook{

    fun solution (m : Int, n : Int,picture : Array<IntArray>) : IntArray{
        var answer = IntArray(2)
        var numberOfArea = 0
        var maxSizeOfOneArea = Int.MIN_VALUE
        var visitMap = Array(picture.size){BooleanArray(picture[0].size)}
        for(i in 0 until m){
            for(j in 0 until n){
                if(visitMap[i][j] || picture[i][j] == 0) continue
                numberOfArea++
                maxSizeOfOneArea = max(findColoringBook(i,j, picture, visitMap,picture[i][j]),maxSizeOfOneArea)
            }
        }
        answer[0] = numberOfArea
        answer[1] = maxSizeOfOneArea
        return answer
    }

    private fun findColoringBook(m: Int, n: Int, picture: Array<IntArray>, visitMap: Array<BooleanArray>, target: Int) : Int {
        if(visitMap[m][n] || picture[m][n] != target) return 0
        var count = 0
        visitMap[m][n] = true
        count++
        if(checkRange(m-1,n,picture)) count += findColoringBook(m-1,n, picture, visitMap, target)
        if(checkRange(m,n-1,picture)) count += findColoringBook(m,n-1, picture, visitMap, target)
        if(checkRange(m+1,n,picture)) count += findColoringBook(m+1,n, picture, visitMap, target)
        if(checkRange(m,n+1,picture)) count += findColoringBook(m,n+1, picture, visitMap, target)
        return count
    }

    private fun checkRange(m: Int, n: Int, picture: Array<IntArray>): Boolean {
        return m in 0 until picture.size && n in 0 until picture[0].size
    }
}