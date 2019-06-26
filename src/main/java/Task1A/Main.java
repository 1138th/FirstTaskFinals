package Task1A;

import java.util.Scanner;

public class Main extends MatrixWork{

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("hello\n" +
                "we will create matrix and calculate its reverse version\n"+
                "numbers of lines and columns must be equal if you want to calculate reverse matrix\n" +
                    "enter matrix lines:");
        int lines = IsCorrectSize();
        System.out.println("enter matrix columns:");
        int columns = IsCorrectSize();
        double[][] matrix = new double[lines][columns];
        double[] matrixContent = new double[lines * columns];
        String answer;
        if (lines != columns) {
            System.out.println("numbers of lines and columns are not equal - " +
                    "you will not be able to calculate determinant and reverse matrix\n" +
                    "do you want to continue matrix creating? (y/n)");
            answer = scan.nextLine();
            while (!(answer.equals("y") || answer.equals("n"))){
                System.out.println("enter correct command (y/n)");
                answer = scan.nextLine();
            }
            if (answer.equals("y")){
                do{
                    System.out.println("do you want to fill it manually or randomly?");
                    answer = scan.nextLine();
                } while (!(answer.equals("manually") || answer.equals("randomly")));
                if (answer.equals("manually")){
                    System.out.println("input " + matrixContent.length + " numbers");
                    matrixContent = InitializeMatrix(matrixContent.length);
                    matrix = ConvertLineToMatrix(matrixContent, lines, columns);
                } else{
                    matrix = FillRandomly(lines, columns);
                }
                System.out.println("your matrix created and filled with values," +
                        " but it's not square matrix thus you unable to continue calculates:");
                Print(matrix);
            } else {
                System.out.println("you chose \"no\"");
            }
        } else {
            System.out.println("numbers of lines and columns are equal");
            do{
                System.out.println("do you want to fill it manually or randomly?");
                answer = scan.nextLine();
            } while (!(answer.equals("manually") || answer.equals("randomly")));
            if (answer.equals("manually")){
                System.out.println("input " + matrixContent.length + " numbers");
                matrixContent = InitializeMatrix(matrixContent.length);
                matrix = ConvertLineToMatrix(matrixContent, lines, columns);
            } else{
                matrix = FillRandomly(lines, columns);
            }
            System.out.println("your matrix filled with values:");
            Print(matrix);
            double[][] reserveMatrix = CloneMatrix(matrix);
            double det = Determinant(reserveMatrix);
            System.out.println("matrix determinant: " + det);
            if (det == 0){
                System.out.println("determinant equals zero: reverse matrix does not exist");
            } else {
                reserveMatrix = CloneMatrix(matrix);
                reserveMatrix = AlgebraicAdditions(reserveMatrix);
                reserveMatrix = ReverseMatrix(reserveMatrix, det);
                System.out.println("reverse matrix:");
                Print(reserveMatrix);
            }
        }
        scan.close();
    }
}
