import java.util.*;

class Solution {
    static class Node {
        int seq;
        int arrivedTime;
        int workTime;

        public Node(int seq, int arrivedTime, int workTime) {
            this.seq = seq;
            this.arrivedTime = arrivedTime;
            this.workTime = workTime;
        }
    }

    public int solution(int[][] jobs) {
        int[][] arrayJobs = new int[jobs.length][3];

        // 작업 배열 초기화
        for (int i = 0; i < jobs.length; i++) {
            arrayJobs[i][0] = i + 1;      // 작업 순서 번호
            arrayJobs[i][1] = jobs[i][0]; // 도착 시간
            arrayJobs[i][2] = jobs[i][1]; // 작업 시간
        }

        // 도착 시간 기준으로 정렬
        Arrays.sort(arrayJobs, Comparator.comparingInt(a -> a[1]));

        // 작업 큐와 우선순위 큐
        Queue<Node> waitingQueue = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.workTime));

        for (int[] job : arrayJobs) {
            waitingQueue.add(new Node(job[0], job[1], job[2]));
        }

        int result = 0;  // 총 대기 시간
        int time = 0;    // 현재 시간
        int completedJobs = 0;

        // 작업 처리
        while (completedJobs < jobs.length) {
            // 현재 시간에 도착한 작업을 우선순위 큐에 추가
            while (!waitingQueue.isEmpty() && waitingQueue.peek().arrivedTime <= time) {
                pq.add(waitingQueue.poll());
            }

            if (!pq.isEmpty()) {
                // 가장 짧은 작업 선택
                Node current = pq.poll();
                time += current.workTime;
                result += time - current.arrivedTime; // 대기 시간 계산
                completedJobs++;
            } else {
                // 큐가 비어있으면 시간을 증가시킴
                time++;
            }
        }

        // 평균 대기 시간 반환
        return result / jobs.length;
    }
}
