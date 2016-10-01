import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by onotole on 9/30/16.
 */
public class Input {
    public static List<Pool> parse() throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        List<Pool> poolList = new ArrayList<Pool>();
        int poolCount = Integer.valueOf(stdin.readLine());
        for (int poolNumber = 0; poolNumber < poolCount; poolNumber++) {
            String[] sizes = stdin.readLine().split(" ");
            int x = Integer.valueOf(sizes[1]);
            int y = Integer.valueOf(sizes[0]);
            List<String> lines = new ArrayList<String>();
            for (int currentLevel = 0; currentLevel < y; currentLevel++) {
                lines.add(stdin.readLine());
            }

            Pool pool = new Pool(y, x, lines);
            poolList.add(pool);
        }

        return poolList;
    }
}
