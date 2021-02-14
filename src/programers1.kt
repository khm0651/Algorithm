fun main(){
    var s = Solution()
    s.solution(arrayOf(
        intArrayOf(1,1,0,0),
        intArrayOf(1,0,0,0),
        intArrayOf(1,0,0,1),
        intArrayOf(1,1,1,1)
    ))
    //[[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]
}

class Solution {

    fun solution(arr: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf(0,0)

        answer = quadTreeProgramers(0,0,arr,num = arr.size,answer)
        return answer
    }

    private fun quadTreeProgramers(i: Int, j: Int, arr: Array<IntArray>, num: Int, answer: IntArray): IntArray {

        var a = answer
        if(!checkProgramers(i,j,num,arr)){
            a = quadTreeProgramers(i, j, arr, num/2, a)
            a = quadTreeProgramers(i, j + (num/2), arr, num/2, a)
            a = quadTreeProgramers(i + (num/2), j, arr, num/2, a)
            a = quadTreeProgramers(i + (num/2), j + (num/2), arr, num/2, a)
        }else{
            var v = arr[i][j]
            when(v){
                0 -> a[0] = a[0]+1
                1 -> a[1] = a[1]+1
            }
            return a
        }
        return a
    }

    private fun checkProgramers(idx: Int, jdx: Int, num: Int, arr: Array<IntArray>): Boolean {
        var v = arr[idx][jdx]

        for(i in idx until num+idx){
            for(j in jdx until num+jdx){
                if(arr[i][j] != v) return false
            }
        }

        return true
    }

}