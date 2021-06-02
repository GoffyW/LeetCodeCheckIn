package xiaomage;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/06/01/10:23
 * @Description: 数据数据结构的实现
 */
public class ArrayList<E> {
    /**
     * 元素的数量
     */
    private int size;

    /**
     * 所有的元素
     */
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList(int capacity){
        capacity =  (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public ArrayList(){
        //elements = new int[DEFAULT_CAPACITY];
        this(DEFAULT_CAPACITY);
    }

    /**
     * 清除所有元素
     * 这里为什么设置size等于0理解：
     * 因为所有的get或者set都判断了size是否为0（满足语义逻辑）
     * 会不会浪费内存？
     * 不会，因为这些空间还是要用，申请内存空间和销毁内存空间都是耗时操作
     * 框架外面语义是清空，但是设计的时候并非完全依照调用者的逻辑处理
     */
    public void clear(){
        size = 0;
    }

    /**
     * 元素数量
     * @return
     */
    public int size(){
        return size;
    }


    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     *
     * @param element
     * @return
     * 当元素存在时，只需要判断索引是否等于-1即可
     */
    public boolean contains(E element){
        return indexOf(element)!=ELEMENT_NOT_FOUND;
    }

    /**
     * 获得index位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        rangCheck(index);
        return elements[index];
    }

    public E set(int index, E element){
        rangCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }


    /**
     * 添加元素
     * @param element
     * @return
     * size等于几其实就是往几的位置上放
     */
    public void add(E element){
        ensureCapacity();
        elements[size] = element;
        size++;
    }

    public void add(int index,E element){
        rangCheckForAdd(index);
        for (int i = size-1; i >= index; i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 删除，注意内存的连续性
     * @param index
     */
    public E remove(int index){
        E old = elements[index];
        for (int i = index+1; i <= size-1; i++) {
            elements[i-1] = elements[i];
        }
        size--;
        return old;
    }


    /**
     * 查看元素的索引
     * @param element
     * @return
     * 注：
     * 数组中可以存储 null,null 不能调用 equals 方法，所以要对传入的元素进行判断
     * 如果查找的是 null, 需要单独处理
     * 当元素存在是返回索引，否则返回统一定义的常量
     */
    public int indexOf(E element){
        if (element == null){
            for (int i = 0; i < size; i++) {
                if (elements[i]==element) return i;
            }
        }else{
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    /**
     * 扩容
     */
    private void ensureCapacity(){
        // 获取数组当前容量
        int oleCapacity = elements.length;
        if (size<oleCapacity) return;
        // 新数组为愿数组容量的1.5倍
        int newCapacity = oleCapacity+ (oleCapacity >> 1);
        // 创建新数组
        E[]  newElements = (E[])new Object[newCapacity];
        // 原数组的元素存储到新数组中
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        // 饮用新的数组
        elements = newElements;
    }




    private void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index:" + index + ",size:" + size);
    }

    private void rangCheck(int index){
        if (index<0 || index >= size) {
            outOfBounds(index);
        }
    }

    private void rangCheckForAdd(int index){
        if (index<0 || index > size) {
            outOfBounds(index);
        }
    }

    @Override
    public String toString() {
        // size = 4, [9,8,7,6,5]
        StringBuilder builder = new StringBuilder();
        builder.append("size = "+size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i!=0) builder.append(", ");
            builder.append(elements[i]);
            //if (i!=size-1) builder.append(", "); // 还需要做减法运算，遗弃
        }
        builder.append("]");
        return builder.toString();
    }
}
