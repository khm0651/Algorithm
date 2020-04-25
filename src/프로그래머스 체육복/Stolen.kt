package `프로그래머스 체육복`

class Solution{
    fun solution(n:Int, lost:IntArray , reserve:IntArray) : Int{
        var answer = 0;
        var map = HashMap<Int,Int>()

        for(i in 1..n){
            map.set(i,1)
        }
        for(i in reserve.indices){
            map.set(reserve[i],map.get(reserve[i])!!+1)
        }
        for(i in lost.indices){
            map.set(lost[i],map.get(lost[i])!!-1)
        }
        map.forEach { k, v ->
            if(v==0){
                if(k==1){
                    if(map.get(k+1)!! > 1){
                        map.set(k,map.get(k)!!+1)
                        map.set(k+1,map.get(k+1)!!-1)
                    }
                }else if(k == map.size){
                    if(map.get(k-1)!! > 1){
                        map.set(k,map.get(k)!!+1)
                        map.set(k-1,map.get(k-1)!!-1)
                    }
                }else{
                    if(map.get(k+1)!! > 1){
                        map.set(k,map.get(k)!!+1)
                        map.set(k+1,map.get(k+1)!!-1)
                    }else if(map.get(k-1)!! > 1){
                        map.set(k,map.get(k)!!+1)
                        map.set(k-1,map.get(k-1)!!-1)
                    }
                }

            }
        }
        map.forEach { k, v -> if(v>0)answer++ }
        return answer
    }
}

fun main(args:Array<String>){
    var n = 3
    var lost = intArrayOf(3)
    var reserve = intArrayOf(1)
    Solution().solution(n,lost,reserve)
}