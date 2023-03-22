import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Schedule> list = new ArrayList<>();
    static int result = 0;
    static int[] calendar;

    public static class Schedule implements Comparable<Schedule> {
        int startDay;
        int endDay;
        boolean use;

        Schedule(int startDay, int endDay) {
            this.startDay = startDay;
            this.endDay = endDay;
        }

        @Override
        public int compareTo(Schedule schedule) {
            if(this.endDay == schedule.endDay) {
                return this.startDay - schedule.startDay;
            }
            return this.endDay - schedule.endDay;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        calendar = new int[367];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sd = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            for (int j = sd; j <= ed; j++) {
                calendar[j]++;
            }
            list.add(new Schedule(sd, ed));
        }
        Collections.sort(list);

        boolean check = false;
        int column = 0;
        int row = 0;
        for(int i = 1; i <= 366; i++) {
            if(calendar[i] != 0) {
                check = true;
            } else {
                check = false;
                result += column * row;
                row = 0;
                column = 0;
            }
            if(check) {
                column++;
                row = Math.max(row, calendar[i]);
            }
        }

        //laminate();
        System.out.println(result);
    }

//    public static void laminate() {
//        int minColumn = Integer.MAX_VALUE;
//        int maxColumn = 0;
//        int day = 0;
//        for (Schedule schedule : list) {
//            if (!schedule.use) {
//                if (day == 0 || day + 1 >= schedule.startDay) {
//                    minColumn = Math.min(minColumn, schedule.startDay);
//                    maxColumn = Math.max(maxColumn, schedule.endDay);
//                    day = schedule.endDay;
//                    schedule.use = true;
//                } else {
//                    laminate();
//                }
//            }
//        }
//        int row = 0;
//        for (int i = minColumn; i <= maxColumn; i++) {
//            row = Math.max(row, calendar[i]);
//        }
//        result += row * (maxColumn - minColumn + 1);
//    }
}