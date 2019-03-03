package myTools;

import myTools.List.MyArrayList;

import java.util.Arrays;

public class tools_test {
    private void josef(MyArrayList arrayList,int startNum,int initCount) {
        if(arrayList==null) {
            return;
        }
        if(startNum<0||startNum>arrayList.size()) {
            throw new IndexOutOfBoundsException("起始下标"+startNum+"超出集合范围");
        }
        int count=1;
        while(arrayList.size()!=1) {
            while(count!=initCount) {
                count++;
            }
            count=1;
            startNum+=initCount-1;
            while(startNum>=arrayList.size()) {
                startNum=startNum-arrayList.size();
            }
            arrayList.remove(startNum);
            System.out.println( Arrays.toString(arrayList.asArray()));
        }
    }
    public static void main(String[] args) {
        int len=10;
        int initCount=4;
        int startNum=0;
        MyArrayList<Integer> arrayList=new MyArrayList<>(10);
        for(int i=0;i<len;i++) {
            arrayList.add(i);
        }
        tools_test tools_test=new tools_test();
        tools_test.josef(arrayList,startNum,initCount);
    }
}
