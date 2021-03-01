fun main (){
    NextBigNum().solution(15)
}

class NextBigNum{
    fun solution(n : Int) : Int{
        var answer = 0
        for(i in n+1 .. 1000000){
            if(Integer.bitCount(i) == Integer.bitCount(n)){
                answer = i
                break
            }
        }
        return answer
    }
}