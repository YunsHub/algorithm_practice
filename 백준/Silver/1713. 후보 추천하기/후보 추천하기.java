import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] student = new int[101];
        LinkedList<Integer> album = new LinkedList<>();


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(!album.contains(num)){
                if(album.size() == N){
                    int min = student[album.get(0)], idx = 0;
                    for(int j = 1; j < N; j++){
                        int no = album.get(j);
                        if(student[no] < min){
                            min = student[no];
                            idx = j;
                        }
                    }
                    student[album.get(idx)] = 0;
                    album.remove(idx);
                }
                album.add(num);
            }

            student[num]++;

        }

        Collections.sort(album);

        StringBuilder sb = new StringBuilder();
        for(int no : album){
            sb.append(no).append(" ");
        }
        System.out.println(sb);

    }
}