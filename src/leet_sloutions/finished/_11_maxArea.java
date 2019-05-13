package leet_sloutions.finished;

public class _11_maxArea {
    public int maxArea(int[] height) {
        if(height.length==0) {
            return 0;
        }
        int i=0,j=height.length-1;
        int distance=0;
        int res=0;
        while(i<j) {
            distance=j-i;
            int tempRes;
            tempRes=height[i]<height[j]?height[i++]*distance:height[j--]*distance;
            res=Math.max(res,tempRes);
        }
        return res;
    }

    public static void main(String[] args) {
        _11_maxArea test=new _11_maxArea();
        int[] temp={2,3,4,5,17,18,6};
        System.out.println(test.maxArea(temp));
    }
}
