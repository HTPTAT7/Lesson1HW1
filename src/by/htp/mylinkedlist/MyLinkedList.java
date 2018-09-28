package by.htp.mylinkedlist;

/**
 * Created by Михаил on 19.02.2017.
 */
public class MyLinkedList<Type> {
    private int count;
    private MyNode<Type> first;
    private MyNode<Type> last;

    public MyLinkedList(){
        this.count = 0;
    }

    public void addElement(Type newElement){
        MyNode<Type> tempLast = last;
        MyNode<Type> currentNode = new MyNode<>(newElement, tempLast, null);
        this.last = currentNode;
        if(tempLast == null){
            this.first = currentNode;
        }
        else{
            tempLast.setNext(currentNode);
        }
        this.count++;
    }

    public boolean addElement(int position, Type newElement){
        if(position == 0) {
            MyNode<Type> temp = first;
            MyNode<Type> currentNode = new MyNode<Type>(newElement, null, temp);
            temp.setPrev(currentNode);
            this.first = currentNode;
            this.count++;
            return true;
        }
        if(position == count){
            this.addElement(newElement);
            return true;
        }
        if(0 < position && position < count){
            MyNode<Type> temp = first;
            for(int i=0; i<position; i++){
                temp = temp.getNext();
            }
            MyNode<Type> currentNode = new MyNode<Type>(newElement, temp.getPrev(), temp);
            temp.getPrev().setNext(currentNode);
            temp.setPrev(currentNode);
            this.count++;
            return true;
        }
        return false;
    }

    public void removeFirst(){
        MyNode<Type> temp = first;
        first = temp.getNext();
        temp.getNext().setPrev(null);
        this.count--;
    }

    public void removeLast(){
        MyNode<Type> temp = last;
        last = temp.getPrev();
        temp.getPrev().setNext(null);
        this.count--;
    }

    public boolean removeElement(int position){
        if(position == 0) {
            removeFirst();
            return true;
        }
        if(position == count-1){
            removeLast();
            return true;
        }
        if(0 < position && position < count-1){
            MyNode<Type> temp = first;
            for(int i=0; i<position; i++){
                temp = temp.getNext();
            }
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
            this.count--;
            return true;
        }
        return false;
    }

    public Type getFirtsElementValue(){
        return first.getValue();
    }

    public Type getLastElementValue(){
        return last.getValue();
    }

    public Type getElementValue(int position){
        if(position == 0) {
            return getFirtsElementValue();
        }
        if(position == count-1){
            return getLastElementValue();
        }
        if(0 < position && position < count-1){
            MyNode<Type> temp = first;
            for(int i=0; i<position; i++){
                temp = temp.getNext();
            }
            return temp.getValue();
        }
        return null;
    }

    public void replaceFirtsElementValue(Type newElement){
        first.setValue(newElement);
    }

    public void replaceLastElementValue(Type newElement){
        last.setValue(newElement);
    }

    public boolean replaceElementValue(int position, Type newElement){
        if(position == 0) {
            replaceFirtsElementValue(newElement);
            return true;
        }
        if(position == count-1){
            replaceLastElementValue(newElement);
            return true;
        }
        if(0 < position && position < count-1){
            MyNode<Type> temp = first;
            for(int i=0; i<position; i++){
                temp = temp.getNext();
            }
            temp.setValue(newElement);
            return true;
        }
        return false;
    }

    public int returnSize(){
        return count;
    }

    public String toString(){
        MyNode<Type> tempNode = first;
        StringBuilder result = new StringBuilder(tempNode.toString());
        while (tempNode.getNext()!=null){
            tempNode = tempNode.getNext();
            result = result.append(", "+tempNode.toString());
        }
        return "MyLinkedList contains: ["+result+"]";
    }
}

class MyNode<Type>{
    private Type value;
    private MyNode<Type> next;
    private MyNode<Type> prev;

    public MyNode(Type value, MyNode prev, MyNode next){
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public Type getValue() {
        return value;
    }

    public void setValue(Type value) {
        this.value = value;
    }

    public MyNode<Type> getNext() {
        return next;
    }

    public void setNext(MyNode<Type> next) {
        this.next = next;
    }

    public MyNode<Type> getPrev() {
        return prev;
    }

    public void setPrev(MyNode<Type> prev) {
        this.prev = prev;
    }

    public String toString(){
        return value.toString();
    }
}
