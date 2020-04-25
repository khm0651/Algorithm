package `1`
import kotlin.collections.HashMap

class MarathonKt{
    fun solution(participant:Array<String> , completion:Array<String>) :String{
        var answer =""
        var map : HashMap<String,Int> = HashMap<String,Int>()
        for(i in participant.indices){
            if(map.containsKey(participant[i])){
                map.set(participant[i], map[participant[i]]!! + 1)
            }else{
                map.set(participant[i],1)
            }

        }
        for(i in completion.indices){
            if(map.containsKey(completion[i])){
                map.set(completion[i], map[completion[i]]!! - 1)
                if(map.get(completion[i]) == 0){
                    map.remove(completion[i])
                }
            }
        }

        map.forEach { k, v -> answer+=k }
        return answer
    }
}

fun main (args:Array<String>){
    var participant:Array<String> = arrayOf("mislav", "stanko","mislav", "ana")
    var completion:Array<String> = arrayOf("stanko", "ana", "mislav")
    print(MarathonKt().solution(participant,completion))
}