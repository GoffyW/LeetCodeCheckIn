package datastructures.queue;

import java.util.Scanner;

/**
 * @author GoffyGUO
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        // 接受用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int i = scanner.nextInt();
                    queue.addQueue(i);
                    break;
                case 'g':
                    try {
                        int queue1 = queue.getQueue();
                        System.out.println("取出的数据为："+queue1);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int queue1 = queue.headQueue();
                        System.out.println("队列头数据为："+queue1);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}


/**
 * 使用数组模拟队列的实现
 */
class ArrayQueue{

    /**
     * 数组容量大小
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 存放数据，模拟队列
     */
    private int [] arr;

    /**
     * 创建队列的构造器
     * @param arrMaxSize 初始化大小容量
     */
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        // 指向队列头部，分析出front是指向队列头部的前一个位置
        front = -1;
        // 指向队列尾，指向队列尾的数据（即就是队列的最后一个数据）
        rear = -1;
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull(){
        return rear == maxSize-1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 添加数据到队列
     * @param n
     */
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满，无法加入数据");
            return;
        }
        // 让rear 后移
        rear++;
        arr[rear] = n;
    }

    /**
     * 获取队列的数据，出队列
     * @return
     */
    public int getQueue(){
        // 判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        // front后移
        front++;
        return arr[front];
    }

    /**
     * 显示队列
     */
    public void showQueue(){
        // 遍历
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i <arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    /**
     * 显示队列的头数据，注意不是取出数据
     * @return
     */
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有头数据");
        }
        return arr[front+1];
    }



















}
