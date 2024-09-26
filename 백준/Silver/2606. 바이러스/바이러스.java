import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfPC = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] network = new ArrayList[numOfPC + 1];
        for (int i = 1; i <= numOfPC; i++) {
            network[i] = new ArrayList<>();
            network[i].add(i);
        }

        int numOfEdges = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfEdges; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            network[u].add(v);
            network[v].add(u);
        }

        Queue<Integer> queueOfInfect = new LinkedList<>();
        boolean[] isInfected = new boolean[numOfPC + 1];
        isInfected[1] = true;
        queueOfInfect.add(1);
        int answer = 0;
        while (!queueOfInfect.isEmpty()) {
            int cur = queueOfInfect.poll();
//
//            for (Integer x : network[cur]) {
//                if (isInfected[x]) {
//                    continue;
//                }
//                queueOfInfect.add(x);
//                isInfected[x] = true;
//                answer++;
//            }
            
            for (int i = 0; i < network[cur].size(); i++) {
                if (isInfected[network[cur].get(i)]) {
                    continue;
                }
                queueOfInfect.add(network[cur].get(i));
                isInfected[network[cur].get(i)] = true;
                answer++;
            }
        }
        System.out.println(answer);
    }
}