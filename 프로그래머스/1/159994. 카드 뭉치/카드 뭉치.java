class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int indexCards1 = 0;
        int indexCards2 = 0;
        String answer = "Yes";

        for (int i = 0; i < goal.length; i++) {
            String str = goal[i];

            if (indexCards1 < cards1.length && str.equals(cards1[indexCards1])) {
                indexCards1++;
            } else if (indexCards2 < cards2.length && str.equals(cards2[indexCards2])) {
                indexCards2++;
            } else {
                answer = "No";
            }
        }
        return answer;
    }
}