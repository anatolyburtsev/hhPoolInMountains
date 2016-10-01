import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by onotole on 9/27/16.
 */
@RunWith(Parameterized.class)
public class FillWaterTest {
    private static Pool pool;

    @Parameterized.Parameter(0)
    public int x_min;

    @Parameterized.Parameter(1)
    public int y_min;

    @Parameterized.Parameter(2)
    public int x_max;

    @Parameterized.Parameter(3)
    public int y_max;

    @Parameterized.Parameter(4)
    public int expectedWaterSpent;

    @Parameterized.Parameters(name = "({0},{1}), ({2},{3}), exp: {4}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {0,0,2,3,2},
                {0,0,3,2,0},
                {2,1,4,3,2}
        });
    }

    @BeforeClass
    public static void setUp() throws Exception {
        pool = new Pool();
        pool.fillUpEx1();
    }

    @Test
    public void fillWaterToRect() throws Exception {
        assertThat(pool.fillWaterToRect(x_min, y_min, x_max, y_max), equalTo(expectedWaterSpent));
    }

}