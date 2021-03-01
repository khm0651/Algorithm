import java.util.PriorityQueue

fun main(){
    MoreSpicy().solution(intArrayOf(1,1,1,1,1,1),11111)
}

class MoreSpicy{
    fun solution(scoville : IntArray, k : Int) : Int{
        var answer = 0
        var pq = PriorityQueue<Int> {o1, o2 ->
            o1 - o2
        }
        for(i in scoville) pq.add(i)
        while(pq.peek() < k){
            answer++
            var one = pq.poll()
            if(pq.isEmpty()){
                answer = -1
                break
            }
            var two = pq.poll()
            pq.add(one + (two * 2))
        }
        return answer
    }
}