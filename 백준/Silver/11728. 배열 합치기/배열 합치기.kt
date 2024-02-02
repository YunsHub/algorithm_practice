import java.util.StringTokenizer

//2 2
//3 5
//2 9
fun main() {
    var st = StringTokenizer(readln())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    val Aarr = IntArray(a) { 0 }
    val Barr = IntArray(b) { 0 }

    st = StringTokenizer(readln())
    for(i in 0..a-1) {
        Aarr[i] = st.nextToken().toInt()
    }

    st = StringTokenizer(readln())
    for(i in 0..b-1) {
        Barr[i] = st.nextToken().toInt()
    }

    var Aidx = 0
    var Bidx = 0
    val max = a + b

    val sb = StringBuilder()
    while (Aidx + Bidx < max) {
        if(Aidx >= a) {
            sb.append(Barr[Bidx++]).append(" ")
        } else if(Bidx >= b) {
            sb.append(Aarr[Aidx++]).append(" ")
        } else if(Aarr[Aidx] > Barr[Bidx]) {
            sb.append(Barr[Bidx++]).append(" ")
        } else {
            sb.append(Aarr[Aidx++]).append(" ")
        }
    }

    print(sb)
}