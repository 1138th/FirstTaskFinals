package Task1A;

import java.util.Scanner;

public class Main extends MatrixWork{

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("hello\n" +
                "we will create matrix and calculate its reverse version");
        int size;
        System.out.println("numbers of lines and columns are be equal if we want to calculate reverse matrix\n" +
                    "enter matrix size:");
        //size = IsCorrectSize();
        size = 3;
        double[][] matrix = new double[size][size];
        System.out.println("matrix created");
        String answer;
        /*do{
            System.out.println("do you want to fill it manually or randomly?");
            answer = scan.nextLine();
        } while (!(answer.equals("manually") || answer.equals("randomly")));*/
        answer = "randomly";
        double[] matrixContent = new double[size * size];
        if (answer.equals("manually")){
            System.out.println("input " + matrixContent.length + " numbers");
            matrixContent = InitializeMatrix(matrixContent.length);
            matrix = ConvertLineToMatrix(matrixContent, size);
        } else{
            matrix = FillRandomly(size);
        }
        System.out.println("your matrix filled with values:");
        Print(matrix);
        double[][] reserveMatrix = CloneMatrix(matrix);
        double det = Determinant(reserveMatrix);
        System.out.println("matrix determinant: " + det);
        if (det == 0){
            System.out.println("determinant equals zero: reverse matrix does not exist");
        } else {
        }
        reserveMatrix = CloneMatrix(matrix);
        reserveMatrix = AlgebraicAdditions(reserveMatrix);
        Print(reserveMatrix);
        scan.close();
    }
}
