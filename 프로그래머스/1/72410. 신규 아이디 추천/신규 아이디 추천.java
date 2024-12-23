import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String solution(String new_id) {
        
                String temp_id = new_id.toLowerCase();

        Deque<Character> answerQueue = new ArrayDeque<>();
        for (int i = 0; i < temp_id.length(); i++) {
            char ch = temp_id.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                answerQueue.add(ch);
                continue;
            }

            if (ch == '-' || ch == '_' || ch == '.') {
                if (!answerQueue.isEmpty() && answerQueue.peekLast() == ch && ch == '.') {
                    continue;
                }
                answerQueue.add(ch);
                continue;
            }

            if (ch >= '0' && ch <= '9') {
                answerQueue.add(ch);
            }
        }

        if (!answerQueue.isEmpty() && answerQueue.peekFirst() == '.') {
            answerQueue.removeFirst();
        }

        if (!answerQueue.isEmpty() && answerQueue.peekLast() == '.') {
            answerQueue.removeLast();
        }

        if (answerQueue.isEmpty()) {
            answerQueue.addLast('a');
        }

        while (answerQueue.size() > 15) {
            answerQueue.removeLast();
        }

        if (answerQueue.peekLast() == '.') {
            answerQueue.removeLast();
        }

        if (answerQueue.size() <= 2) {
            while (answerQueue.size() <= 2) {
                answerQueue.addLast(answerQueue.peekLast());
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!answerQueue.isEmpty()) {
            sb.append(answerQueue.removeFirst());
        }
        
        String answer = sb.toString();
        return answer;
    }
}