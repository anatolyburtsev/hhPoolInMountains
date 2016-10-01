import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by onotole on 9/27/16.
 */
public class WaterSpentTest {
    private Pool pool;

    @Before
    public void setUp() throws Exception {
        pool = new Pool();
        pool.fillUpEx1();
    }

    @Test
    public void fillWater() throws Exception {
        assertThat(pool.countPossibleAmountOfWaterToFillUp(), equalTo(4));
    }

    @Test
    public void fillWaterExHH1() {
        pool.fillUp(pool.fillUpExHH1());
        assertThat("первый пример от HH", pool.countPossibleAmountOfWaterToFillUp(), equalTo(2));
    }

    @Test
    public void fillWaterExHH2() {
        pool.fillUp(pool.fillUpExHH2());
        assertThat("первый пример от HH", pool.countPossibleAmountOfWaterToFillUp(), equalTo(7));
    }

    @Test
    public void testHugePool() {
        int x = 50;
        int y = 50;
        int maxHeight = 1000;
        Random random = new Random();
        List<String> bottomsList = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            List<String> currentLine = new LinkedList<>();
            for (int j = 0; j < x; j++) {
                currentLine.add("" + random.nextInt(maxHeight));
            }
            bottomsList.add(String.join(" ", currentLine));
        }
        Pool hugePool = new Pool(y, x, bottomsList);
        assertThat("проверка, что такой большой бассейн обрабатывается", hugePool.countPossibleAmountOfWaterToFillUp(), notNullValue());
    }

}