import java.util.Scanner;

import javax.transaction.xa.XAException;

public class J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] inputGraph = new int[n][n];
        int[][] fixedGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.next(); // лутаем 
            for (int j = 0; j < n; j++) {
                inputGraph[i][j] = (line.charAt(j) - '0');
                //так как char ~ short - арифметика меняет тип на short, легко конвертируемый в int
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (inputGraph[i][j] == 1) {
                    fixedGraph[i][j] = 1; // восстанавливаем граф
                    for (int meow = j + 1; meow < n; meow++) {
                        inputGraph[i][meow] = (inputGraph[i][meow] - inputGraph[j][meow] + 10) % 10;
                        // отрезаем пути, и берем вычисления по модулю 10, но т.к. в теории
                        // можем получить модуль от отрицательного числа(bad) - добавляем 10
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(fixedGraph[i][j]);
            }
            System.out.println();
        }
    }
}