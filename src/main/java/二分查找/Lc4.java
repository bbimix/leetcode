package 二分查找;

/**
 * 找两个有序数组中位数
 *
 * 要求  时间复杂度 O(log(m + n))
 *
 * 最后变换为问题 在两个有序的数组中找第k小的元素
 */

public class Lc4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        if (n % 2 == 1) {
            double median = getNum(nums1, nums2, n / 2 + 1);
            return median;
        } else {
            double median = (getNum(nums1, nums2, n / 2) + getNum(nums1, nums2, n / 2 + 1)) / 2.0;
            return median;
        }
    }

    private int getNum(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            if (index1 == n1)
                return nums2[index2 + k - 1];
            if (index2 == n2)
                return nums1[index1 + k - 1];
            if (k == 1)
                return Math.min(nums1[index1], nums2[index2]);

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, n1) - 1;
            int newIndex2 = Math.min(index2 + half, n2) - 1;

            int p1 = nums1[newIndex1], p2 = nums2[newIndex2];
            if (p1 <= p2) {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
