package datastructures.linkedlist;



/**
 * 链表数据结构实现
 * @author guogoffy
 */
public class LinkedList<E> {
    private int size;
    private Node<E> first;

    /**
     * 元素的数量
     * @return
     */
    int size(){
        return 0;
    };

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty(){
        return false;
    };

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    boolean contains(E element){
        return false;
    };

    public void add(E element){
        // 当 first 为空时，说明此时没有节点，所以 first 引用新节点即可
        if (first == null){
            first = new Node<>(element,null);
        }else{

        }

    };

    /**
     * 传入一个 index,返回该 index 处的节点对象
     * @param index
     * @return
     */
    private Node<E> node(int index){
        // TODO 参数检查
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    /**
     * 私有类，链表中的节点
     * @param <E>
     */
    private class Node<E>{
        E element;
        Node<E> next;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

}
