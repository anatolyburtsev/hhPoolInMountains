import java.util.ArrayList;
import java.util.List;

/**
 * Created by onotole on 9/27/16.
 */
public class Pool {
    private int[][] bottom;

    public Pool() {
        fillUp(fillUpEx1());
    }

    public Pool(int y, int x, List<String> bottoms) {
        bottom = new int[y][x];
        for (int i = 0; i < y; i++) {
            String[] bottomLevels = bottoms.get(i).split(" ");
            for (int j = 0; j < x; j++) {
                bottom[i][j] = Integer.valueOf(bottomLevels[j]);
            }
        }
//        showPool();
    }

    public void fillUp(int[][] bottomLevels) {
        bottom = bottomLevels;
    }

    int countPossibleAmountOfWaterToFillUp() {
        int waterSpent = 0;
        for (int y_min = 0; y_min < bottom.length - 2; y_min++) {
            for (int x_min = 0; x_min < bottom[0].length - 2; x_min++) {
                for (int y_max = y_min + 2; y_max < bottom.length; y_max++) {
                    for (int x_max = x_min + 2; x_max < bottom[0].length; x_max++) {
                        waterSpent += fillWaterToRect(x_min, y_min, x_max, y_max);
                    }
                }
            }
        }

        return waterSpent;
    }

    int fillWaterToRect(int x1, int y1, int x2, int y2) {
        if (Math.abs(x1 - x2) < 2 || Math.abs(y1 - y2) < 2) return 0;
        int x_max = Math.max(x1, x2);
        int x_min = Math.min(x1, x2);
        int y_max = Math.max(y1, y2);
        int y_min = Math.min(y1, y2);
        int minHeight = findMinHeightOfBorder(x_min, y_min, x_max, y_max);
        int waterSpent = 0;
        for (int x = x_min+1; x < x_max; x++) {
            for (int y = y_min+1; y < y_max; y++) {
                if (bottom[y][x] < minHeight) {
                    waterSpent += minHeight - bottom[y][x];
                    bottom[y][x] = minHeight;
                }
            }
        }
        return waterSpent;
    }

    int findMinHeightOfBorder(int x_min, int y_min, int x_max, int y_max) {
        int minHeightBorder = Integer.MAX_VALUE;

        /*
        1   2 3
        4<- 1 7<-
        5<- 8 9<-
        2   6 4
         */
        for (int y = y_min + 1; y < y_max; y++) {
            minHeightBorder = Math.min(bottom[y][x_min], minHeightBorder);
            minHeightBorder = Math.min(bottom[y][x_max], minHeightBorder);
        }

        /*
        1  2<- 3
        4  1   7
        5  8   9
        2  6<- 4
         */
        for (int x = x_min + 1; x < x_max; x++) {
            minHeightBorder = Math.min(bottom[y_min][x], minHeightBorder);
            minHeightBorder = Math.min(bottom[y_max][x], minHeightBorder);
        }
        return minHeightBorder;
    }

    int[][] fillUpEx1() {
        return new int[][] {
                {8,3,4,9,3},
                {6,1,5,8,2},
                {2,1,6,4,7},
                {1,3,7,6,5}
        };
    }

    int[][] fillUpExHH1() {
        return new int[][] {
                {4,5,4},
                {3,1,5},
                {5,4,1}
        };
    }

    int[][] fillUpExHH2() {
        return new int[][] {
                {5,3,4,5},
                {6,2,1,4},
                {3,1,1,4},
                {8,5,4,3}
        };
    }

    private void showPool() {
        for (int[] line: bottom) {
            for(int a: line) {
                System.out.print(a);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("2 3 2");
        list.add("7 1 11");
        list.add("10 1 9");
        list.add("2 4 2");
        Pool pool = new Pool(4, 3, list);
        System.out.println(pool.countPossibleAmountOfWaterToFillUp());
    }
}
