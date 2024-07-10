package Algorithm;

import java.util.Queue;
import java.util.ArrayDeque;
class Day3 {
	public static void main(String[] args) {
		int[] array = new int[] {10};
		System.out.println(solution(100, 100, array));
	}
	
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
    	Queue<Integer> bridge = new ArrayDeque<>();

        int answer = 0;
        for(int i=0; i<bridge_length; i++){
            bridge.add(0);
        }
        int truckIdx = 0;
        int trucksWeight = 0;
        while(truckIdx < truck_weights.length){
            answer++;
            trucksWeight -= bridge.poll();
            if(trucksWeight + truck_weights[truckIdx] <= weight){
                bridge.add(truck_weights[truckIdx]);
                trucksWeight += truck_weights[truckIdx];
                truckIdx++;
            }
            else {
                bridge.add(0);
            }
        }

        return bridge_length + answer;
    }
   }
