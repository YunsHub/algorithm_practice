import java.util.Stack
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        var st = StringTokenizer(readLine())
        val w = st.nextToken().toInt()
        val h = st.nextToken().toInt()
        if(w == 0 || h == 0) break

        val land = Array(h) {
            IntArray(w)
        }

        for(i in 0..h-1) {
            st = StringTokenizer(readLine())
            for(j in 0..w-1) {
                land[i][j] = st.nextToken().toInt()
            }
        }

        var cnt = 0
        for(i in 0..h-1) {
            for(j in 0..w-1) {
                if(land[i][j] == 1) {
                    dfs(land, i, j)
                    cnt++
                }
            }
        }

        sb.append(cnt).append("\n")
    }
    println(sb)
}

const val DIR_NUM = 8
val dx: Array<Int> = arrayOf(0, 1, 1, 1, 0, -1, -1, -1)
val dy: Array<Int> = arrayOf(1, 1, 0, -1, -1, -1, 0, 1)
fun dfs(land: Array<IntArray>, x: Int, y: Int) {
    land[x][y] = 0;

    repeat(DIR_NUM) {
        val nx = x + dx[it]
        val ny = y + dy[it]

        if(nx >= 0 && ny >= 0 && nx < land.size && ny < land[0].size && land[nx][ny] == 1) {
            land[nx][ny] = 0
            dfs(land, nx, ny)
        }
    }
}