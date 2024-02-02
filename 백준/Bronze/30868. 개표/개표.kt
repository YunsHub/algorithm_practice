fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
  
    for(i in 1..n) {        
        val cnt = readLine().toInt()
        val sb = StringBuilder()

        val mok = cnt / 5
        val remain = cnt % 5

        for(j in 1..mok) {
            sb.append("++++ ")
        }

        for(j in 1..remain) {
            sb.append("|")
        }
        println(sb)        
    }

    
}
