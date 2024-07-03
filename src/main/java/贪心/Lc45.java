package 贪心;

/**
 * 跳跃游戏2
 */
public class Lc45 {
    public int jump(int[] nums) {
        int length = nums.length;
        int max = 0;
        int end = 0;
        int step = 0;

        for (int i = 0; i < length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }
}
