
import java.util.Arrays;

class Solution {
    public static int[][] rotate90Degree(int[][] matrix) {
        int N = matrix.length;
        int[][] rotated = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[j][N - i - 1] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static boolean isUnlocked(int[][] expandedLock, int[][] key, int xOffset, int yOffset, int lockSize, int keySize) {
        int[][] tempLock = new int[expandedLock.length][expandedLock[0].length];
        for (int i = 0; i < expandedLock.length; i++) {
            tempLock[i] = Arrays.copyOf(expandedLock[i], expandedLock[i].length);
        }

        // Overlay the key onto the expanded lock
        for (int i = 0; i < keySize; i++) {
            for (int j = 0; j < keySize; j++) {
                int x = xOffset + i;
                int y = yOffset + j;
                if (x >= 0 && x < tempLock.length && y >= 0 && y < tempLock.length) {
                    tempLock[x][y] += key[i][j];
                }
            }
        }

        // Check if the original lock area is correctly matched
        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                if (tempLock[lockSize - 1 + i][lockSize - 1 + j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solve(int[][] key, int[][] lock) {
        int lockSize = lock.length;
        int keySize = key.length;

        // Create an expanded version of the lock to accommodate key movement
        int expandedLockSize = lockSize * 3;
        int[][] expandedLock = new int[expandedLockSize][expandedLockSize];

        // Place the original lock in the middle of the expanded lock
        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                expandedLock[lockSize - 1 + i][lockSize - 1 + j] = lock[i][j];
            }
        }

        // Try all 4 possible rotations of the key
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotate90Degree(key);
            // Try moving the key to every possible position
            for (int xOffset = 1 - keySize; xOffset < lockSize * 2; xOffset++) {
                for (int yOffset = 1 - keySize; yOffset < lockSize * 2; yOffset++) {
                    if (isUnlocked(expandedLock, key, lockSize - 1 + xOffset, lockSize - 1 + yOffset, lockSize, keySize)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = solve(key, lock);
        return answer;
    }
}
