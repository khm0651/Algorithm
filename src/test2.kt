fun main (args:Array<String>){

    var orders: Array<String> = arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH")
    var course: IntArray = intArrayOf(2,3,4)

    var arr = arrayListOf<String>()
    var map = HashMap<String,Int>()
    for(order in orders){
        for(item in order.toCharArray()){
            if(!arr.contains(item.toString())){
                arr.add(item.toString())
            }
        }
    }
    arr.sort()
    for(i in course){
        for(j in 0 .. (arr.size-i)){
            var t =""
            var tn = j
            for(k in 0 until i){
                t = "${t}${arr[tn]}"
                tn++
            }
            for(o in orders){
                if(o.contains(t)){
                    if(map.containsKey(t)){
                        map.put(t,map.get(t)!!.plus(1))
                    }else{
                        map.put(t,1)
                    }
                }
            }
            println(t)
        }
    }
}