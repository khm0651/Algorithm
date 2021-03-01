fun main (){
    QuadZip().solution(arrayOf(
            intArrayOf(1,1,0,0),
            intArrayOf(1,0,0,0),
            intArrayOf(1,0,0,1),
            intArrayOf(1,1,1,1),
    ))
}

class QuadZip {
    fun solution(arr: Array<IntArray>): IntArray {
        var answer: IntArray = IntArray(2)
        quadZip(0,0,arr.size,answer,arr)
        return answer
    }

    private fun quadZip(i: Int, j: Int, num: Int, answer: IntArray, arr: Array<IntArray>) {
        if(!checkQuadZip(i,j,num,answer,arr)){
            quadZip(i,j, num/2, answer, arr)
            quadZip(i,j + (num/2), num/2, answer, arr)
            quadZip(i+ (num/2),j, num/2, answer, arr)
            quadZip(i + (num/2),j + (num/2), num/2, answer, arr)
        }
    }

    private fun checkQuadZip(idx: Int, jdx: Int, num: Int, answer: IntArray, arr: Array<IntArray>): Boolean {
        var target = arr[idx][jdx]
        for(i in idx until num+idx){
            for(j in jdx until num+jdx){
                if(target != arr[i][j]) return false
            }
        }
        answer[target]+=1
        return true
    }
}