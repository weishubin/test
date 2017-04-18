import java.util.Arrays;

/**
 * 回溯实现八皇后问题
 * Created by weishubin on 2017/3/24.
 */
public class Queen {
    private static int N = 8;
    public static void main(String[] args) {
        int[] queenColumnPos = new int[N];
        int count = 0;
        Arrays.fill(queenColumnPos, -1);

        int row = 0;
        int column;
        while (row >= 0) {
            column = queenColumnPos[row] + 1;
            if (column == N) {
                queenColumnPos[row] = -1;
                row--;
                continue;
            }
            queenColumnPos[row] = column;
            if (canAddQueue(queenColumnPos, row, column)) {
                if (row == N - 1) {
                    count++;
                    printResult(queenColumnPos);
                    queenColumnPos[row] = -1;
                    row--;
                } else {
                    row++;
                }
            }
        }
        System.out.println(count);
    }

    private static void printResult(int[] queenColumnPos) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (queenColumnPos[i] == j) {
                    System.out.print('q');
                } else {
                    System.out.print('*');
                }
            }
            System.out.println();
        }
        System.out.println("----------------------");

    }

    public static boolean canAddQueue(int[] queenPos, int row, int column) {
        for (int i = 0; i < row; i++) {
            if (isConfit(i, queenPos[i], row, column)) {
                return false;
            }
        }
        return true;
    }

    //是否不能放
    public static boolean isConfit(int queenRow, int queenColumn, int row, int column) {
        if (queenRow == row || queenColumn == column) {
            return true;
        }
        return Math.abs(queenRow - row) == Math.abs(queenColumn - column);
    }
}
