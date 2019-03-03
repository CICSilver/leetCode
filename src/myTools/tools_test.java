package myTools;

import myTools.List.MyArrayList;

import java.util.Arrays;

public class tools_test {
    public void josef(MyArrayList arrayList) {
        int count=1;
        int initCount=4;
        int nums=0;
        while(arrayList.size()!=1) {
            while(count!=initCount) {
                count++;
            }
            count=1;
            nums+=initCount-1;
            while(nums>=arrayList.size()) {
                nums=nums-arrayList.size();
            }
            arrayList.remove(nums);
            System.out.println( Arrays.toString(arrayList.asArray()));
        }
    }
    public static void main(String[] args) {
        int len=10;
        MyArrayList<Integer> arrayList=new MyArrayList<>(10);
        for(int i=0;i<len;i++) {
            arrayList.add(i);
        }
        tools_test tools_test=new tools_test();
        tools_test.josef(arrayList);
    }
}
