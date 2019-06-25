package Task1A;

import java.util.Scanner;

public class Main {

    private static int IsCorrectMatrixSize(Scanner scan){
        int parameter;
        while (true){
            try {
                parameter = Integer.parseInt(scan.nextLine());
                if (parameter <= 0) {
                    System.out.println("please enter positive number");
                } else{
                    break;
                }
            } catch (NumberFormatException e){
                System.out.println("input number, please");
            }
        }
        return parameter;
    }

    public static void main(String[] args) {
        System.out.println("hello\nwe will create matrix and calculate her reverse version");
        Scanner scan = new Scanner(System.in);
        System.out.println("enter number of lines:");
        int lines = IsCorrectMatrixSize(scan);
        System.out.println("enter number of columns:");
        int columns = IsCorrectMatrixSize(scan);
        int[][] matrix = new int[lines][columns];
        System.out.println("matrix created\n");
        String answer;
        do{
            System.out.println("do you want to fill it manually or randomly?");
            answer = scan.nextLine();
        } while (!(answer.equals("manually") || answer.equals("randomly")));
        int[] matrixContent;
        if (answer.equals("manually")){

        }
        scan.close();
    }
}
