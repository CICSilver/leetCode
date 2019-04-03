package leet_sloutions.finished;

import mytools.sort.Sort;

public class _217_containsDuplicate {
    /**
     * 判断数组中是否存在重复的数据，需要用到上面的快速排序
     * @param nums 原数组
     * @return true or false
     */
    public boolean containsDuplicate(int[] nums){
        _26_removeDuplicates removeDuplicates=new _26_removeDuplicates();
        if(nums.length==0) {
            return false;
        }
        int temp=nums.length;
        Sort.quickSort(nums);
        int N=removeDuplicates.removeDuplicates(nums);
        return temp != N;
    }
}
