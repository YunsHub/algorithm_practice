import java.util.StringTokenizer
import kotlin.math.max

//8 30 4 30
//7
//9
//7
//30
//2
//7
//9
//25
fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val sushi = st.nextToken().toInt()
    val K = st.nextToken().toInt()
    val bonus = st.nextToken().toInt()
    var kind = 0

    val arr = IntArray(N)
    val dish = IntArray(sushi+1)

    repeat(N) {
        arr[it] = readLine().toInt()
        if(it < K) {
            if(dish[arr[it]] == 0) kind++
            dish[arr[it]]++
        }
    }


    var answer = if(dish[bonus] == 0) kind + 1 else kind

    repeat(N) {
        dish[arr[it]]--
        if(dish[arr[it]] == 0) kind--

        val end = (it + K) % N
        if(dish[arr[end]] == 0) kind++
        dish[arr[end]]++

        answer = if(dish[bonus] == 0) {
            max(answer, kind + 1)
        } else {
            max(answer, kind)
        }
    }

    print(answer)
}