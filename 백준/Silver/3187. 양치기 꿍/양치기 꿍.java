import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Area {
        public int x;
        public int y;

        public Area(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int R = Integer.parseInt(st.nextToken()); // 세로
        int C = Integer.parseInt(st.nextToken()); // 가로

        Character[][] pasture = new Character[R][C]; // R * C
        boolean[][] isVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            input = br.readLine();
            for (int j = 0; j < C; j++) {
                pasture[i][j] = input.charAt(j);
            }
        }

        int aliveSheepCount = 0;
        int aliveWolvesCount = 0;
        Queue<Area> search = new LinkedList<>();
        int countArea = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (pasture[i][j] == '#' || isVisited[i][j]) {
                    continue;
                }

                int sheepCountInArea = 0;
                int wolvesCountInArea = 0;
                if (pasture[i][j] == 'k') sheepCountInArea++;
                else if (pasture[i][j] == 'v') wolvesCountInArea++;

                search.add(new Area(i, j));
                isVisited[i][j] = true;
                while (!search.isEmpty()) {
                    Area cur = search.poll();

                    int[] dx = {0, 1, 0, -1};
                    int[] dy = {1, 0, -1, 0};

                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                        if (pasture[nx][ny] == '#' || isVisited[nx][ny]) continue;

                        search.add(new Area(nx, ny));
                        isVisited[nx][ny] = true;
                        if (pasture[nx][ny] == 'k') sheepCountInArea++;
                        else if (pasture[nx][ny] == 'v') wolvesCountInArea++;
                    }
                }

                if (sheepCountInArea == 0 && wolvesCountInArea == 0) continue;
                if (sheepCountInArea > wolvesCountInArea) aliveSheepCount += sheepCountInArea;
                else aliveWolvesCount += wolvesCountInArea;
            }
        }
        System.out.println(aliveSheepCount + " " + aliveWolvesCount);
    }
}