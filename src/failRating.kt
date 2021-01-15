fun main(args : Array<String>){
    var n = 5
    var stages = intArrayOf(
            2, 1, 2, 6, 2, 4, 3, 3
    )
    solution(n,stages)
}

fun solution(N: Int, stages: IntArray): IntArray {
    var answer = arrayListOf<Int>()
    var total = (stages.size).toDouble()
    var failList = arrayListOf<Fail>()
    var stageInUsers = Array<Int>(N+1) {0}

    for (stage in stages){
        stageInUsers[stage-1]++
    }

    for(i in 0 until N){
        if(stageInUsers[i] == 0) failList.add(Fail(i+1,0.0))
        else{
            failList.add(Fail(i+1,stageInUsers[i] / total))
            total -= stageInUsers[i]
        }
    }

    failList.sortWith(object : Comparator<Fail>{
        override fun compare(o1: Fail, o2: Fail): Int {
            return if(o1.fail< o2.fail) 1
            else if(o1.fail > o2.fail) -1
            else{
                if(o1.stage > o2.stage) 1
                else -1
            }
        }

    })
    for( i in failList.indices) answer.add(failList[i].stage)
    return answer.toIntArray()
}

data class Fail (
        var stage : Int = 0,
        var fail : Double = 0.0
)