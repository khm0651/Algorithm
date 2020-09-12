var answer: ArrayList<Int> = arrayListOf()

fun main (args:Array<String>){

    var info: Array<String> = arrayOf("java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50")
    var query: Array<String> = arrayOf("java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150")

    var mapList : ArrayList<HashMap<String,String>> = arrayListOf()
    for(i in info){
        var arr = i.split(" ")
        var map = HashMap<String,String>()
        map.put("lan",arr[0])
        map.put("position",arr[1])
        map.put("career",arr[2])
        map.put("soul",arr[3])
        map.put("score",arr[4])
        mapList.add(map)
    }
    for(q in query){

        var removeAnd = q.replace("and","")
        var arr = removeAnd.split(" ")
        var arrList = ArrayList<String>()
        for(i in arr){
            if (i != ""){
                arrList.add(i)
            }
        }

        var queryArr = arrayOf("lan","position","career","soul","score")
        find(0,mapList,queryArr,arrList, arrayListOf<HashMap<String,String>>())
    }

    print(`프로그래머스 타겟넘버`.answer.toIntArray())

}

fun find(index : Int, mapList:ArrayList<HashMap<String,String>>,queryArr : Array<String>,splitArr: List<String>,preArr : ArrayList<HashMap<String,String>>){
    if(mapList.isEmpty()){
        return
    }
    if(index == queryArr.size){
        `프로그래머스 타겟넘버`.answer.add(mapList.size)
        return
    }
    preArr.clear()
    for(i in mapList.indices){
        if(splitArr[index] == mapList[i].get(queryArr[index]) || splitArr[index]=="-"){
            preArr.add(mapList[i])
        }else if(queryArr[index] == "score"){
            if(mapList[i].get(queryArr[index])!!.toInt()>=splitArr[index].toInt()){
                preArr.add(mapList[i])
            }
        }
    }
    find(index+1,preArr.clone() as ArrayList<HashMap<String, String>>,queryArr,splitArr,preArr)

}