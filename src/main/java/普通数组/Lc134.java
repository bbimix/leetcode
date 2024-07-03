package 普通数组;

/**
 * 加油站
 */

public class Lc134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = -1;

        for (int j = 0; j < n; j++) {
            int last = 0;
            int i = j;
            int count = 0;
            if (gas[i] >= cost[i]) {
                start = i;
                last += gas[i] - cost[i];
                i = (i + 1) % n;
                while (last >= 0 && i != start) {
                    last += gas[i] - cost[i];
                    if (last < 0)
                        break;
                    i = (i + 1) % n;
                    count++;
                }
                if (i == start) {
                    if (last + gas[i] - cost[i] >= 0)
                        return start;
                } else {
                    j = j + count + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,3,2,4,1,5,3,2,4};
        int[] cost = {1,1,1,3,2,4,3,6,7,4,3,1};
        Lc134 lc134 = new Lc134();
        int res = lc134.canCompleteCircuit(gas, cost);
        System.out.println(res);
    }

}
