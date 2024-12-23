class Solution {
    public String solution(String new_id) {
    
        String temp_id = new_id.toLowerCase();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < temp_id.length(); i++) {
            char ch = temp_id.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch == '-' || ch == '_' || ch == '.') || (ch >= '0' && ch <= '9')) {
                if (answer.length() != 0 && answer.charAt(answer.length() - 1) == ch && ch == '.') {
                    continue;
                }
                answer.append(ch);
            }
        }

        if (answer.length() != 0 && answer.charAt(answer.length() - 1) == '.') {
            answer.deleteCharAt(answer.length() - 1);
        }

        if (answer.length() != 0 && answer.charAt(0) == '.') {
            answer.deleteCharAt(0);
        }

        if (answer.length() == 0) {
            answer.append('a');
        }

        while (answer.length() > 15) {
            answer.deleteCharAt(answer.length() - 1);
        }
        
        if (answer.charAt(answer.length() - 1) == '.') {
            answer.deleteCharAt(answer.length() - 1);
        }

        while (answer.length() <= 2) {
            answer.append(answer.charAt(answer.length() - 1));
        }
        
        return answer.toString();
    }
}