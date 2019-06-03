package leet_sloutions.finished;


import mytools.helper.intListToArray;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class _349_intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        for(int i:nums1) {
                hashSet.add(i);
        }
        for(int i:nums2) {
            if(hashSet.contains(i)&& !list.contains(i)) {
                list.add(i);
            }
        }
        return intListToArray.toArray(list);

    }

    public static void main(String[] args) {
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        _349_intersection test=new _349_intersection();
        System.out.println(2<<1);
    }
}
