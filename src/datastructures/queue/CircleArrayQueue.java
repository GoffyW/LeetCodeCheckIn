package datastructures.queue;

import java.util.Scanner;

/**
 * @author GoffyGUO
 */
public class CircleArrayQueue {

    public static void main(String[] args) {
        // 3
        CircleQueue queue = new CircleQueue(4);
        // 接受用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
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
                        System.out.println("取出的数据为：" + queue1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int queue1 = queue.headQueue();
                        System.out.println("队列头数据为：" + queue1);
                    } catch (Exception e) {
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
 * 使用数组模拟[环形]队列的实现
 * 思路：front就是指队列的第一个元素，也就是说arr[front]就是队列的第一个元素，初始值为0
 * rear指向队列的最后一个元素的后一个位置，因为希望空出一个位置作为约定，初始值为0
 * 当队列满时，条件是(rear+1)%maxSize = front[满]
 * 队列为空的条件，rear = front [空]
 * 队列中有效数据个数，(rear + maxSize -front) % maxSize
 */
class CircleQueue {

    /**
     * 数组容量大小
     */
    private int maxSize;
    /**
     * 与之前的做一个调整，front就是指队列的第一个元素，也就是说arr[front]就是队列的第一个元素，初始值为0
     */
    private int front;
    /**
     * 与之前的做一个调整，rear指向队列的最后一个元素的后一个位置，因为希望空出一个位置作为约定，初始值为0
     */
    private int rear;
    /**
     * 存放数据，模拟队列
     */
    private int[] arr;

    /**
     * 创建队列的构造器
     *
     * @param arrMaxSize 初始化大小容量
     */
    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     *
     * @param n
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，无法加入数据");
            return;
        }
        // 直接将数据加入
        arr[rear] = n;
        // 将rear后移
        rear = (rear + 1) % maxSize;
    }

    /**
     * 获取队列的数据，出队列
     *
     * @return
     */
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取出数据");
        }
        //这里需要分析
        //1、先把front对应的值保存到一个临时变量
        //2、将front后移
        //3、将临时变量的值返回
        int i = arr[front];
        front = (front + 1) % maxSize;
        return i;
    }

    /**
     * 显示队列
     */
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        // 思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        // rear = 1
        // front = 0
        // maxSize = 3
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列的头数据，注意不是取出数据
     *
     * @return
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有头数据");
        }
        return arr[front];
    }


}


