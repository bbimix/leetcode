package 图论;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 最小基因变化
 *
 * 看见这个题 也有并查集的感觉
 */

public class Lc433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene))
            return 0;
        Set<String> set = new HashSet<>();
        for (String b : bank) {
            set.add(b);
        }
        if (!set.contains(endGene))
            return -1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startGene);
        int step = 1;
        char[] chars = {'A','C','G','T'};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (chars[k] != cur.charAt(j)) {
                            StringBuffer sb = new StringBuffer(cur);
                            sb.setCharAt(j, chars[k]);
                            String next = sb.toString();
                            if (!visited.contains(next) && set.contains(next)) {
                                if (next.equals(endGene))
                                    return step;
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
