import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<String> ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            ans = new ArrayList<>();
            comb(1, "1");
            Collections.sort(ans);
            for(String s : ans) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    public static void comb(int n, String str) {
        if(n == N) {
            String express = str.replaceAll(" ", "");
            StringTokenizer st = new StringTokenizer(express, "-|+", true);
            int sum = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                if(s.equals("+")) {
                    sum += Integer.parseInt(st.nextToken());
                } else {
                    sum -= Integer.parseInt(st.nextToken());
                }
            }
            if(sum == 0) {
                ans.add(str);
            }
            return;
        }
        comb(n + 1, str + "+" + (n + 1));
        comb(n + 1, str + "-" + (n + 1));
        comb(n + 1, str + " " + (n + 1));
    }

//    public static void comb(int n, Stack<Character> s1, String str) {
//        if(N * 2 - 1 == n) {
//            Stack<Character> s2 = (Stack<Character>) s1.clone();
//            int sum = s2.pop() - '0';
//            while (!s2.isEmpty()) {
//                char c = s2.pop();
//                if(c == '+') {
//                    int sum2 = 0;
//                    int blank = 0;
//                    while (!s2.isEmpty()) {
//                        char c2 = s2.peek();
//                        if(c2 == '+' || c2 == '-') {
//                            break;
//                        }
//                        else if(c2 == ' ') {
//                            blank++;
//                        } else {
//                            sum2 += (s2.pop() - '0') * Math.pow(10, blank);
//                        }
//                    }
//                    sum += sum2;
//                } else if (c == '-') {
//                    int sum2 = 0;
//                    int blank = 0;
//                    while (!s2.isEmpty()) {
//                        char c2 = s2.peek();
//                        if(c2 == '+' || c2 == '-') {
//                            break;
//                        }
//                        else if(c2 == ' ') {
//                            blank++;
//                        } else {
//                            sum2 += (s2.pop() - '0') * Math.pow(10, blank);
//                        }
//                    }
//                    sum = sum2 - sum;
//                }
//            }
//            if(sum == 0) {
//                System.out.println(str);
//            }
//            return;
//        }
//
//        if(n % 2 == 0) {
//            s1.add((char)((n / 2) + 1 + '0'));
//            comb(n + 1, s1, str + (n / 2 + 1));
//            s1.pop();
//        } else {
//            s1.add('+');
//            comb(n + 1, s1, str + '+');
//            s1.pop();
//            s1.add('-');
//            comb(n + 1, s1, str + '-');
//            s1.pop();
//            s1.add(' ');
//            comb(n + 1, s1, str + ' ');
//            s1.pop();
//        }
//
//    }
}