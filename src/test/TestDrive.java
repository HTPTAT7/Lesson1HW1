package test;

import by.htp.mylinkedlist.MyLinkedList;

/**
 * Created by Михаил on 19.02.2017.
 */
public class TestDrive {
    public static void main(String[] args){
        MyLinkedList<String> temp = new MyLinkedList<>();

        temp.addElement("A");
        temp.addElement("B");
        temp.addElement("C");
        temp.addElement("D");

        System.out.println("1 "+temp.toString());

        temp.addElement(1,"Alef");

        System.out.println("2 "+temp.toString());

        System.out.println("3 "+temp.returnSize());

        temp.addElement(0,"Pre-Alef");
        System.out.println("4 "+temp.returnSize());
        System.out.println("5 "+temp.toString());
        temp.addElement("test");
        temp.addElement(7,"test 2");

        System.out.println(temp.toString());
        System.out.println(temp.returnSize());

        temp.removeFirst();
        temp.removeLast();
        System.out.println(temp.toString());
        temp.removeElement(2);
        System.out.println(temp.toString());

    }
}
