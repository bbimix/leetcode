package 普通数组;

/**
 * 除本数以外的乘积
 */


public class Lc238 {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ll = new int[n];
        int[] rr = new int[n];
        ll[0] = 1; rr[n - 1] = 1;

        for (int i = 0; i < n - 1; i++) {
            ll[i + 1] = nums[i] * ll[i];
        }
        for (int i = n - 1; i > 0; i--) {
            rr[i - 1] = nums[i] * rr[i];
        }

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = ll[i] * rr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = productExceptSelf(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

}
