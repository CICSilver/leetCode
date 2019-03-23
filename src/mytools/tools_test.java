package mytools;

import mytools.list.MyArrayList;
import mytools.list.MyLinkedList;

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



    //0-1-2-3-4-5
    public static void main(String[] args) {
        int len = 5;
        int initCount = 3;
        int startNum = 0;
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        // myLinkedList.add(1);
        // myLinkedList.add(1,2);
        myLinkedList.get(0);
    }
}
