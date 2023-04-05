import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] x = new int[n];
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            a[i] = sc.nextInt();
        }

        // 마을 위치를 기준으로 정렬
        int[][] villages = new int[n][2];
        for (int i = 0; i < n; i++) {
            villages[i][0] = x[i];
            villages[i][1] = a[i];
        }
        Arrays.sort(villages, Comparator.comparingInt(o -> o[0]));

        // 중간값을 구해서 출력
        long totalPopulation = 0;
        for (int i = 0; i < n; i++) {
            totalPopulation += villages[i][1];
        }

        long populationSum = 0;
        int mid = -1;
        for (int i = 0; i < n; i++) {
            populationSum += villages[i][1];
            if (populationSum >= (totalPopulation + 1) / 2) {
                mid = i;
                break;
            }
        }

        System.out.println(villages[mid][0]);
    }
}