import java.util.Scanner;

import Task1A.*;
import Task1B.*;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("hello\n" +
                "this is first task\n" +
                "choose subtask you want to start solve: (a/b)");
        String answer = scan.nextLine();
        while (!(answer.equals("a") || answer.equals("b"))){
            System.out.println("please enter correct subtask (a/b)");
            answer = scan.nextLine();
        }
        if (answer.equals("a"))
            Task1A.TaskA();
        else Task1B.TaskB();
    }
}
