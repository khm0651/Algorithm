



fun main (args:Array<String>){

    var reg1 = Regex("^[`프로그래머스 네트워크`.getA-zA-Z0-9.\\-_]*$")
    var reg2 = Regex("[^`프로그래머스 네트워크`.getA-zA-Z0-9.\\-_]*$")
    var new_id = ""
    var check = true
    if(!(new_id.length>=3 && new_id.length<=15)){
        check= false
    }
    if(check){
        check = reg1.matches(new_id)
        for(i in 0 until new_id.length){
            if(i == 0 || i==new_id.length-1){
                if(new_id.get(i) == '.'){
                    check = false
                }
            }
            if(i!=0 && (new_id.get(i-1) == '.' && new_id.get(i) == '.')){
                check = false
            }
        }
    }


    if(!check){
        var reco_id = new_id.toLowerCase()
        reco_id = reco_id.replace("[^`프로그래머스 네트워크`.getA-zA-Z0-9\\-._]".toRegex(),"")
        reco_id = reco_id.replace("\\.+".toRegex(),".")
        reco_id = reco_id.replace("^\\.".toRegex(),"")
        reco_id = reco_id.replace("\\.$".toRegex(),"")
        if(reco_id == ""){
            reco_id = "`프로그래머스 네트워크`.getA"
        }
        if(reco_id.length>=16){
            reco_id = reco_id.substring(0,15)
        }
        reco_id = reco_id.replace("\\.$".toRegex(),"")
        if(reco_id.length<=2){
            var c = reco_id.get(reco_id.length-1)
            while(reco_id.length !=3){
                reco_id = "${reco_id}${c}"
            }
        }
        println(reco_id)
    }else{
        println(new_id)
    }

}



