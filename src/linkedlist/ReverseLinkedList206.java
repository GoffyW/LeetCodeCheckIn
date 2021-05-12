package linkedlist;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author guogoffy
 */


public class ReverseLinkedList206 {


    /**
     * 方法一：利用迭代实现
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 首先最容易想到的就是边界条件，，如果传进来为null,则直接返回null,如果只传进来一个Node,则也不需要反转，直接返回即可
        /*if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }*/
        //这两句代码又可以直接合并成一句代码
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = null;
        while (head != null){
            // 为什么需要临时变量：因为在循环过程中，当把头节点指向新的节点时，之后的节点将会断开指针，没有引用，故先用临时节点标记
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
    /**
     * 方法二：利用递归实现
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        // 首先最容易想到的就是边界条件，，如果传进来为null,则直接返回null,如果只传进来一个Node,则也不需要反转，直接返回即可
        /*if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }*/
        //这两句代码又可以直接合并成一句代码
        if (head == null || head.next == null){
            return head;
        }
        // 为什么传head.next，就是因为需要反转当前节点之后的所有节点，返回的结果就是反转之后的链表的头节点
        ListNode newHead = reverseList2(head.next);
        // TODO 还需要理解
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
