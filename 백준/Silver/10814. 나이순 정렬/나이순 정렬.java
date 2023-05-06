import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class Member implements Comparable<Member> {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member m) {
            return this.age - m.age;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[i] = new Member(age, name);
        }
        Arrays.sort(members);

        for(Member m : members) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }

        System.out.println(sb);
    }
}