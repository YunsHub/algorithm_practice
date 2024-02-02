import java.util.StringTokenizer
import kotlin.math.max

//2 2
//3 5
//2 9
fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()
    val temp = IntArray(N)
    var sum = 0

    st = StringTokenizer(readLine())
    repeat(temp.size) {
        temp[it] = st.nextToken().toInt()
        if(it < K) {
            sum += temp[it]
        }
    }

    var start = 0
    var end = K
    var answer = sum
    while(end < N) {
        sum -= temp[start++]
        sum += temp[end++]

        answer = max(answer, sum)
    }

    print(answer)
}