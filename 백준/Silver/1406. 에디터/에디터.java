import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> editor1= new Stack<>();
        Stack<Character> editor2 = new Stack<>();
        for (Character c : input.toCharArray()) {
            editor1.push(c);
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] commands = br.readLine().split(" ");
            String command = commands[0];
            switch (command) {
                case "L":
                    if (editor1.isEmpty()) break;
                    editor2.push(editor1.pop());
                    break;
                case "D":
                    if (editor2.isEmpty()) break;
                    editor1.push(editor2.pop());
                    break;
                case "B":
                    if (editor1.isEmpty()) break;
                    editor1.pop();
                    break;
                case "P":
                    editor1.push(commands[1].charAt(0));
                    break;
            }
        }

        while (!editor1.isEmpty()) {
            editor2.push(editor1.pop());
        }

        StringBuilder answer = new StringBuilder();
        while (!editor2.isEmpty()) {
            answer.append(editor2.pop());
        }
        System.out.println(answer);
    }
}