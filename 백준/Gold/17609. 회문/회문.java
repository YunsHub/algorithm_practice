import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String str = br.readLine();

            int start = 0;
            int end = str.length() - 1;

            System.out.println(getType(str, 0, start, end));

        }
        
    }

    //su mmu us 1


    public static int getType(String str, int type, int start, int end) {
        if(type == 2) {
            return type;
        }
        
        while(start < end) {
            char first = str.charAt(start);
            char last = str.charAt(end);

            if(first == last) {
                start++;
                end--;
            } else {
                int firstType = getType(str, type+1, start+1, end);
                int lastType = getType(str, type+1, start, end-1);
                type = Math.min(firstType, lastType);
                break;
            }
        }

        return type;
    }
}
    