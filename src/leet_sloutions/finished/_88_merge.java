package leet_sloutions.finished;

import java.util.Arrays;

public class _88_merge {
    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     *
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1=nums1.length-1;
        n--;
        while(n>=0) {
            nums1[len1--]=nums2[n--];
        }
        Arrays.sort(nums1);
    }
}
