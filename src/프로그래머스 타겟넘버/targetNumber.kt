package `프로그래머스 타겟넘버`

var answer =0
fun main(args:Array<String>){
    var numbers: IntArray = intArrayOf(1, 1, 1, 1, 1)
    var target: Int = 3
    findtarget(numbers, target, 0, 0)
}

fun findtarget(numbers: IntArray, target: Int, idx:Int,result:Int) {
    if(idx == numbers.size){
        if(target == result){
            answer++
        }
        return
    }

    var n = numbers[idx]
    var minus = result-n
    var plus = result+n

    findtarget(numbers, target, idx + 1, minus)

    findtarget(numbers, target, idx + 1, plus)


}

