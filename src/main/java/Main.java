import java.io.IOException;
import java.util.List;

/**
 * Created by onotole on 9/27/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        List<Pool> poolList = Input.parse();
        for (Pool pool: poolList) {
            int waterAmount = pool.countPossibleAmountOfWaterToFillUp();
            System.out.println(waterAmount);
        }
    }
}
