package xiaomage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/06/01/13:59
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        /*list.remove(0);
        int remove = list.remove(8);*/
        list.add(0,100);
        //System.out.println(remove);
        System.out.println(list);
    }
}
