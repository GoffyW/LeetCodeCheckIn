package easy;


/**
 * @author guogoffy
 */
public class IsPalindRome9 {
    public static void main(String[] args) {
        System.out.println(isPalindRome(123444));

    }

    /**
     * 所有的负数都不可能是回文数
     * 所有的个位数是0的数不可能是回文数
     * @param x
     * @return
     */
    public static boolean isPalindRome(int x){
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x!=0)){
            return false;
        }
        int num = 0;
        while (x>num){
            num = num * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == num || x == num / 10;

    }
}
