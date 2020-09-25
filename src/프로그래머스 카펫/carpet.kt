package `프로그래머스 카펫`

fun main(args : Array<String>){
    var brown = 8
    var yellow = 1
    solution(brown, yellow)
}

fun solution(brown: Int, yellow: Int): IntArray {
    var answer = ArrayList<Int>()

    if(yellow == 1){
        answer.add(3)
        answer.add(3)
        return answer.toIntArray()
    }
    for(i in 1..yellow/2){
        if(yellow%i != 0) continue
        if( ( (i * 2) + ( (yellow / i) *2) ) + 4 == brown ){
            if(!(answer.contains((yellow / i)+2) && answer.contains(i+2))){
                answer.add((yellow / i)+2)
                answer.add(i + 2)
            }
        }
    }

    return answer.toIntArray()
}