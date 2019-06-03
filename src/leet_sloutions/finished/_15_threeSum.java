package leet_sloutions.finished;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class _15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>(nums.length);
        for(int i=0;i<nums.length;i++) {
            int target=0-nums[i];
            int[] newNums=getNums(nums,i);
            ArrayList<Integer> secList=(ArrayList<Integer>) twoSumV2(newNums,target);
            if(secList!=null) {
                secList.add(nums[i]);
                res.add(secList);
            }
        }
        return res;
    }

    private int[] getNums(int[] oldNums,int subScript) {
        int[] res=new int[oldNums.length-1];
        int i=0,j=0;
        while(i< oldNums.length) {
            if(i!=subScript) {
                res[j]=oldNums[i];
                i++;
                j++;
            }else {
                i++;
            }
        }
        return res;
    }


    public List<Integer> twoSumV2(int[] nums, int target) {
        ArrayList<Integer> res=new ArrayList<>();
        HashMap<Integer,Integer> hashMap=new HashMap<>(nums.length);
        for(int i=0;i<nums.length;i++) {
            //判断map中是否存在与差值相同的key
            if(hashMap.containsKey(nums[i])) {
                //若存在，即当前值的下标符合条件，map中key为当前值所对应的val及对应值的下标
                res.add(hashMap.get(nums[i]));
                res.add(i);
                return res;
            }
            //没有则将target与当前值的差值作为key,下标作为val存入map
            hashMap.put(target-nums[i],i);
        }
        return null;
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ls = new ArrayList<>();

            for (int i = 0; i < nums.length - 2; i++) {
                if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                    int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                    while (l < r) {
                        if (nums[l] + nums[r] == sum) {
                            ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                            while (l < r && nums[l] == nums[l + 1]) {
                                l++;
                            }
                            while (l < r && nums[r] == nums[r - 1]) {
                                r--;
                            }
                            l++;
                            r--;
                        } else if (nums[l] + nums[r] < sum) {
                            while (l < r && nums[l] == nums[l + 1]) {
                                l++;
                            }
                            // 跳过重复值
                            l++;
                        } else {
                            while (l < r && nums[r] == nums[r - 1]) {
                                r--;
                            }
                            r--;
                        }
                    }
                }
            }
            return ls;
        }
    }


    public static void main(String[] args) {
        _15_threeSum test=new _15_threeSum();
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(test.threeSum(nums));
    }
}
