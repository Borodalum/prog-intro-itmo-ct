import java.util.Scanner;
import java.lang.Math;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();

        int ans = 2 * ((n - b + 1) / (b - a)) + 1;

        System.out.println(ans);
    }
}