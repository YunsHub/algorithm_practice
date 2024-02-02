import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val w = st.nextToken().toInt()
    val h = st.nextToken().toInt()

    val miro = Array(w) {
        IntArray(h)
    }

    for (i in 0..w - 1) {
        val str = readLine()
        for (j in 0..h - 1) {
            miro[i][j] = str[j] - '0'
        }
    }

    val q = LinkedList<IntArray>()
    q.add(intArrayOf(0, 0))
    while(!q.isEmpty()) {
        val now = q.poll()

        repeat(DIR_NUM) {
            val nx = now[0] + dx[it]
            val ny = now[1] + dy[it]
            if(nx >= 0 && ny >= 0 && nx < w && ny < h && miro[nx][ny] == 1) {
                miro[nx][ny] += miro[now[0]][now[1]]
                q.add(intArrayOf(nx, ny))
            }
        }
    }

    print(miro[w-1][h-1])

}

const val DIR_NUM = 4
val dx: Array<Int> = arrayOf(0, 1, 0, -1)
val dy: Array<Int> = arrayOf(1, 0, -1, 0)

fun bfs(land: Array<IntArray>, x: Int, y: Int) {
    land[x][y] = 0;

    repeat(DIR_NUM) {
        val nx = x + dx[it]
        val ny = y + dy[it]

        if (nx >= 0 && ny >= 0 && nx < land.size && ny < land[0].size && land[nx][ny] == 1) {
            land[nx][ny] = 0
            dfs(land, nx, ny)
        }
    }
}


fun dfs(land: Array<IntArray>, x: Int, y: Int) {
    land[x][y] = 0;

    repeat(DIR_NUM) {
        val nx = x + dx[it]
        val ny = y + dy[it]

        if (nx >= 0 && ny >= 0 && nx < land.size && ny < land[0].size && land[nx][ny] == 1) {
            land[nx][ny] = 0
            dfs(land, nx, ny)
        }
    }
}