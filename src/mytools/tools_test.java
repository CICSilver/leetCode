package mytools;

import mytools.list.MyArrayList;
import mytools.list.MyLinkedList;
import mytools.stringmatch.BF;
import mytools.stringmatch.KMP;

import java.util.Arrays;

public class tools_test {

    private void josef(MyArrayList arrayList, int startNum, int initCount) {
        if (arrayList == null) {
            return;
        }
        if (startNum < 0 || startNum > arrayList.size()) {
            throw new IndexOutOfBoundsException("起始下标" + startNum + "超出集合范围");
        }
        while (arrayList.size() != 1) {
            startNum += initCount - 1;
            while (startNum >= arrayList.size()) {
                startNum = startNum - arrayList.size();
            }
            arrayList.remove(startNum);
            System.out.println(Arrays.toString(arrayList.asArray()));
        }
    }

    private void josefLink(MyLinkedList list,int startNum,int initNum) {
        if(list == null) {
            return;
        }
        if(startNum < 0 || startNum> list.size()) {
            throw new IndexOutOfBoundsException("起始下标超出集合范围");
        }
        while(list.size()!=1) {
            startNum+=initNum-1;
            while (startNum>=list.size()) {
                startNum = startNum-list.size();
            }
            list.remove(startNum);
            System.out.println(list.toString());
        }
    }


    //0-1-2-3-4-5
    public static void main(String[] args) {
        int len = 5;
        int initCount = 3;
        int startNum = 0;
        MyArrayList<Integer> myArrayList=new MyArrayList<>();
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        // myLinkedList.add(1);
        // myLinkedList.add(1,2);
        for(int i=1;i<7;i++) {
            myArrayList.add(i);
            myLinkedList.add(i);
        }
        String txt="10110010110001010";
        String pat="0101";
        System.out.println("KMP:"+ KMP.indexOf(txt,pat));
        System.out.println("BF:"+ BF.indexOf(txt,pat));

    }
}
