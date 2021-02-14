import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main () = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var w = readLine().toInt()
    var incidentListA = Array<Incident2618>(w+1){Incident2618(1,1)}
    var incidentListB = Array<Incident2618>(w+1){Incident2618(n,n)}
    var dp = Array(n+1){IntArray(n+1){-1} }

    for(i in 1 .. w){
        var (x,y) = readLine().split(" ").map{it.toInt()}
        incidentListA[i] = Incident2618(x,y)
        incidentListB[i] = Incident2618(x,y)
    }

    bw.write("${findIncident2618(incident_A_num = 0 , incident_B_num = 0,dp,incidentListA,incidentListB,w)}")
    bw.flush()
}

fun findIncident2618(
    incident_A_num: Int,
    incident_B_num: Int,
    dp: Array<IntArray>,
    incidentListA: Array<Incident2618>,
    incidentListB: Array<Incident2618>,
    w: Int,
) : Int {
    if(incident_A_num == w || incident_B_num == w) return 0

    if(dp[incident_A_num][incident_B_num] != -1) return dp[incident_A_num][incident_B_num]

    var next_incident_num = max(incident_A_num,incident_B_num)+1
    var disA = getDistance(incidentListA[next_incident_num],incidentListA[incident_A_num])
    var distance_a_to_next = findIncident2618(next_incident_num,incident_B_num,dp, incidentListA, incidentListB, w) + disA
    var disB = getDistance(incidentListB[next_incident_num],incidentListB[incident_B_num])
    var distance_b_to_next = findIncident2618(incident_A_num,next_incident_num,dp, incidentListA, incidentListB, w) + disB

    dp[incident_A_num][incident_B_num] = min(distance_a_to_next,distance_b_to_next)

    return dp[incident_A_num][incident_B_num]
}

fun getDistance(targetCoord: Incident2618, policeCoord: Incident2618): Int {
    return abs(targetCoord.x - policeCoord.x) + abs(targetCoord.y - policeCoord.y)
}

data class Police2618 (var x : Int, var y : Int)

data class Incident2618 (var x : Int, var y: Int)