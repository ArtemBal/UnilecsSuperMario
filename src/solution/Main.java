package solution;

public class Main {
    public static int solution(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int[][] d = new int[rows][cols];
        d[0][0] = array[0][0];

        for (int i = 1; i < rows; i++)
        {
            d[i][0] = d[i - 1][0] + array[i][0];
        }
        for (int i = 1; i < cols; i++)
        {
            d[0][i] = d[0][i - 1] + array[0][i];
        }
        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++)
            {
                d[i][j] = Math.min(d[i - 1][j], d[i][j - 1]) + array[i][j];
            }
        System.out.println("d matrix");
        for (int[] ints : d) {
            for (int j = 0; j < d[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        return d[rows - 1][cols - 1];
    }
    public static void main(String[] args) {
        int[][] array = new int[][]{
                { 5, 9, 4, 3 },
                { 3, 1, 6, 9 },
                { 8, 6, 8, 12 }
        };
        System.out.println("Array");
        for (int[] ints : array) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

        System.out.println("Minimal damadge is: " + solution(array));
    }
}