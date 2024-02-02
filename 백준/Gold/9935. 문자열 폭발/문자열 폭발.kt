import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    val boom = readLine()
    val stack: Stack<Char> = Stack()
    val strLen = str.length
    val boomLen = boom.length

    repeat(strLen) {
        stack.push(str[it])
        if(boomLen <= stack.size) {
            var len = boomLen // 2
            var cnt = 0
            while(len > 0 && stack.get(stack.size - len) == boom[boomLen - len]) {
                cnt++
                len--
            }

            if(cnt == boomLen) {
                repeat(cnt) {
                    stack.pop()
                }
            }
        }
    }

    if(stack.isEmpty()) print("FRULA")
    else {
        val sb = StringBuilder()
        stack.forEach { sb.append(it) }
        println(sb.toString())
    }


}