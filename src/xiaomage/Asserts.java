package xiaomage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/07/05/14:46
 * @Description: 断言类判断
 */
public class Asserts {
    public static void test(boolean value){
        try {
            if (!value) throw new Exception("测试未通过");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
