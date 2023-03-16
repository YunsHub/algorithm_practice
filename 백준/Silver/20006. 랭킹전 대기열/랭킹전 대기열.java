import java.io.*;
    import java.util.*;


    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        static class Room
        {
            List<User> users = new ArrayList<>();


        }

        static public class User implements  Comparable<User>
        {
            int level;
            String nickName;

            public User(int level, String nickName) {
                this.level = level;
                this.nickName = nickName;
            }



            @Override
            public int compareTo(User o) {
                return nickName.compareTo(o.nickName);
            }
        }

        public static void main(String[] args) throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ArrayList<Room> rooms = new ArrayList<>();
            for(int i=0;i<p;i++)
            {
                st = new StringTokenizer(br.readLine());
                int l= Integer.parseInt(st.nextToken());
                String  n =st.nextToken();
                boolean flag= false;
                for (Room room : rooms) {
                    if(room.users.size() >=m)
                        continue;
                    if(!room.users.isEmpty() && room.users.get(0).level - 10 <= l && l <= room.users.get(0).level + 10)
                    {
                        flag= true;
                        room.users.add(new User(l,n));
                        break;
                    }
                }
                if(!flag)
                {
                    Room room = new Room();
                    room.users.add(new User(l,n));
                    rooms.add(room);

                }
            }

            for (Room room : rooms) {
                Collections.sort(room.users);
                if(room.users.size() == m )
                    bw.write("Started!\n");
                else
                    bw.write("Waiting!\n");
                for(int i=0;i<room.users.size();i++)
                {
                    int level = room.users.get(i).level;
                    String nickName = room.users.get(i).nickName;

                    bw.write(Integer.toString(level) + " " + nickName+"\n");
                }
            }
            bw.flush();

        }


    }