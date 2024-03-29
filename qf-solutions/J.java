import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] inputGraph = new int[n][n]; // заводим входной граф
        int[][] fixedGraph = new int[n][n]; // заводим выходной граф
        for (int i = 0; i < n; i++) {
            String line = sc.next(); // лутаем 
            for (int j = 0; j < n; j++) {
                inputGraph[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (inputGraph[i][j] == 1) {
                    fixedGraph[i][j] = 1; // восстанавливаем граф
                    for (int k = j + 1; k < n; k++) {
                        inputGraph[i][k] = (inputGraph[i][k] - inputGraph[j][k] + 10) % 10;
                        /* 
                        отрезаем пути, и берем вычисления по модулю 10, но т.к.
                        можем получить модуль от отрицательного числа(bad) - добавляем 10
                        */
                    }
                }
            }
        }
        // вывод
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(fixedGraph[i][j]);
            }
            System.out.println();
        }
    }
}
