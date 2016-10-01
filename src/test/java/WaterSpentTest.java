import org.junit.Before;
import org.junit.Test;

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

}