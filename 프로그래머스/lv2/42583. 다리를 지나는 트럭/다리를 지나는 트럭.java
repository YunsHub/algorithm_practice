import java.util.*;
class Solution {
    public class Truck {
        int weight;
        int second;
        public Truck(int weight, int second) {
            this.weight = weight;
            this.second = second;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // Queue 사용
        Queue<Truck> truckQueue = new LinkedList<>();
        int truckIdx = 1;
        int answer = 1;
        // while문으로 트럭의 마지막 인덱스까지 반복 (answer++)
        // sum을 활용해 다리에 올라가있는 truck의 총 무게 저장    
        truckQueue.add(new Truck(truck_weights[0], 1));
        int sum = truck_weights[0];
        while(!truckQueue.isEmpty()) {
            // Queue의 사이즈 계속 확인 (조건문)
            
            
            if(truckQueue.peek().second == bridge_length) {
                sum -= truckQueue.poll().weight;
            }
            
            if(truckQueue.size() <= bridge_length && truckIdx < truck_weights.length &&
               sum + truck_weights[truckIdx] <= weight) {                
                truckQueue.add(new Truck(truck_weights[truckIdx], 0));
                sum += truck_weights[truckIdx++];
            }
            
            // 트럭이 얼마나 오래 있었는지
            for(int size = 0; size < truckQueue.size(); size++) {
                Truck truck = truckQueue.poll();
                truckQueue.add(new Truck(truck.weight, truck.second + 1));
            }            
            answer++;
        }
        
                
        return answer;
    }
}