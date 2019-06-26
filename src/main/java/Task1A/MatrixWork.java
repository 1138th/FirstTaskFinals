package Task1A;

import java.util.Random;
import java.util.Scanner;

class MatrixWork {

    private static Scanner scan = new Scanner(System.in);

    static int IsCorrectSize(){
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
                System.out.println("please enter number");
            }
        }
        return parameter;
    }

    static double[] InitializeMatrix(int size){
        double[] matrixContent = new double[size];
        int size2 = 0;
        while (size2 < size){
            String[] stringsMatrixContent = scan.nextLine().split(" ");
            try {
                for (int i = 0; i < stringsMatrixContent.length; i++){
                    matrixContent[size2] = Integer.parseInt(stringsMatrixContent[i]);
                    System.out.println(matrixContent[size2++] + " added");
                    if (size2 == size) {
                        break;
                    }
                }
            } catch (NumberFormatException e){
                System.out.println("please enter number");
            }
        }
        return matrixContent;
    }

    static double[][] ConvertLineToMatrix(double[] matrixContent, int size){
        double[][] matrix = new double[size][size];
        int lineIndex = 0;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                matrix[i][j] = matrixContent[lineIndex++];
            }
        }
        return matrix;
    }

    static double[][] FillRandomly(int size){
        double[][] matrix = new double[size][size];
        Random rand = new Random();
        for (int i = 0; i < size; i++){
            for (int j = 0; j <size; j++){
                matrix[i][j] = rand.nextInt(200) + 1;
                matrix[i][j] /= 10;
            }
        }
        return matrix;
    }

    static double Determinant(double[][] matrix){
        double det = 1;
        double[] constants = new double[matrix.length];
        double[] lineNumbers = new double[matrix.length];
        double multipleIndex;
        for (int i = 0; i < matrix.length; i++){
            constants[i] = matrix[i][i];
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] /= constants[i];
                lineNumbers[j] = matrix[i][j];
            }
            for (int i1 = i + 1; i1 < matrix.length; i1++){
                multipleIndex = matrix[i1][i];
                for (int j1 = 0; j1 < matrix[i].length; j1++){
                    matrix[i1][j1] -= lineNumbers[j1] * multipleIndex;
                }
            }
        }
        for (double item : constants){
            det *= item;
        }
        return det;
    }

    static double[][] Transposition(double[][] matrix){
        double[][] transposedMatrix = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

    static double[][] AlgebraicAdditions(double[][] matrix){
        double[][] additionsMatrix = new double[matrix.length][matrix.length];
        double[][] addition = new double[matrix.length - 1][matrix.length - 1];
        double[][] transposedMatrix = Transposition(matrix);
        Print(transposedMatrix);System.out.println();
        for (int i = 0; i < additionsMatrix.length; i++){
            for (int j = 0; j < additionsMatrix[i].length; j++){
                for (int i1 = 0; i1 < additionsMatrix.length; i1++){
                    for (int j1 = 0; j1 < additionsMatrix[i].length; j1++){
                    }
                }
                Print(addition);System.out.println();
                additionsMatrix[i][j] = Determinant(addition);
            }
        }
        return additionsMatrix;
    }

    static double[][] CloneMatrix(double[][] matrix){
        double[][] reserveMatrix = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                reserveMatrix[i][j] = matrix[i][j];
            }
        }
        return reserveMatrix;
    }

    static void Print(double[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.printf("%9.3f", matrix[i][j]);
            }
            System.out.println();
        }
    }
}