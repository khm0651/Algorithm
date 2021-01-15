fun main(args : Array<String>){
    var record = arrayOf<String>(
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
    )
    solution(record)
}

fun solution(record: Array<String>) : Array<String>{
    var answer = arrayOf<String>()
    var map = hashMapOf<String,String>()
    var list = arrayListOf<String>()
    for(str in record){
        var action = str.split(" ")[0]
        if(action == "Enter" || action == "Change"){
            map[str.split(" ")[1]] = str.split(" ")[2]
        }
    }

    for(str in record){
        var action = str.split(" ")[0]
        if(action == "Enter"){
            list.add("${map[str.split(" ")[1]]}님이 들어왔습니다.")
        }else if (action == "Leave"){
            list.add("${map[str.split(" ")[1]]}님이 나갔습니다.")
        }
    }

    answer = list.toTypedArray()
    return answer
}

