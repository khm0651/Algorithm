package `프로그래머스 크레인 인형뽑기`

import java.util.*
import kotlin.collections.ArrayList

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        var st = ArrayList<Stack<Int>>()
        var result :Stack<Int> = Stack<Int>()
        for (i in board.indices){
            st.add(Stack<Int>());
        }
        for(i in board.size-1 downTo 0){
            for (j in board.size-1 downTo 0){
                if(board[i][j] == 0){
                    continue
                }
                st[j].push(board[i][j])
            }
        }
        for(i in moves.indices){
            if(!st[moves[i]-1].isEmpty()){
                result.push(st[moves[i]-1].pop())
            }
            if(!result.isEmpty()){
                var f = true;
                while(f){

                    for(i in 0 until result.size-1){
                        if(result.get(i) == result.get(i+1)){
                            result.pop()
                            result.pop()
                            answer+=2

                        }
                    }

                    f=false

                }
            }



        }
        return answer
    }
}


fun main(args: Array<String>){



}