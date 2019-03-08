package myTools;

import myTools.List.MyArrayList;

import java.util.Arrays;
import java.util.LinkedList;

public class tools_test {

    private void josef(MyArrayList arrayList,int startNum,int initCount) {
        if(arrayList==null) {
            return;
        }
        if(startNum<0||startNum>arrayList.size()) {
            throw new IndexOutOfBoundsException("起始下标"+startNum+"超出集合范围");
        }
        while(arrayList.size()!=1) {
            startNum+=initCount-1;
            while(startNum>=arrayList.size()) {
                startNum=startNum-arrayList.size();
            }
            arrayList.remove(startNum);
            System.out.println( Arrays.toString(arrayList.asArray()));
        }
    }
    //0-1-2-3-4-5
    public static void main(String[] args) {
        int len=5;
        int initCount=3;
        int startNum=0;
        MyArrayList<String> arrayList=new MyArrayList<>(len);
        String[] test={"A","B","C","D","E"};
        for(int i=0;i<len;i++) {
            arrayList.add(test[i]);
        }
        tools_test tools_test=new tools_test();
        System.out.println(Arrays.toString(test));
        tools_test.josef(arrayList,startNum,initCount);
    }
}
