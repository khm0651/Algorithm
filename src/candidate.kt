import java.util.*

fun main (args : Array<String>){
    var relation = arrayOf(
            arrayOf("100","ryan","music","2"),
            arrayOf("200","apeach","math","2"),
            arrayOf("300","tube","computer","3"),
            arrayOf("400","con","computer","4"),
            arrayOf("500","muzi","music","3"),
            arrayOf("600","apeach","music","2")
    )


    solution(relation)
}

fun solution(relation: Array<Array<String>>): Int {
    var answer = 0
    var rowSize = relation.size
    var colSize = relation[0].size
    var candidateList = LinkedList<Int>()

    var bit = 1 shl colSize
    for(i in 0 until bit){
        if(check(relation,rowSize,colSize,i)) candidateList.add(i)
    }

    candidateList.forEachIndexed { index, i ->

    }
    return answer
}

fun check(relation: Array<Array<String>>, rowSize : Int, colSize : Int, subset : Int) : Boolean{
    for(a in 0 until rowSize-1){
        for(b in a+1 until rowSize){
            var isSame = true
            for(k in 0 until colSize){
                if(subset and ( 1 shl k )  == 0) continue
                var bj = relation[a][k]
                var dj = relation[b][k]
                if(relation[a][k] != relation[b][k]) {
                    isSame = false
                    break
                }
            }
            if(isSame) return false
        }
    }
    return true
}