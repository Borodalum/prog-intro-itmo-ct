import java.util.*;

public class Reverse {
    public static void main( String[] args ) {
        BetterScanner mainScan = new BetterScanner(System.in);
        int[][] resultArray = new int[1][1];
        int height = 0; 
        while (mainScan.hasNextLine()) {
            String mN = mainScan.nextLine();
            BetterScanner lineScan = new BetterScanner(mN);
            int[] lineArray = new int[1];
            int width = 0;
            while (lineScan.hasNextInt()) {
                lineArray[width] = lineScan.nextInt();
                width++;
                if (width >= lineArray.length) {
                    lineArray = Arrays.copyOf(lineArray, lineArray.length * 2);
                }
            }
            resultArray[height] = Arrays.copyOf(lineArray, width);
            height++;
            if (height >= resultArray.length) {
                resultArray = Arrays.copyOf(resultArray, resultArray.length * 2);
            }
        }
        resultArray = Arrays.copyOf(resultArray, height);
        for (int i = resultArray.length - 1; i >= 0; i--) {
            for (int j = resultArray[i].length - 1; j >= 0; j--) {
                System.out.print(resultArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}