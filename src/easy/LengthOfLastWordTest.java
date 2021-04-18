package easy;

/**
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author guogoffy
 */
public class LengthOfLastWordTest {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord2("hello world "));
    }
    /**
     * 这道题的主要思路为：
     * 从右到左开始遍历，遇到空格即遍历结束，返回count
     */
    public static int lengthOfLastWord(String s) {
        if (s.length()==0 || s==null) return  0;
        int count = 0;
        for (int i = s.length()-1;i>=0;i--){
            if (s.charAt(i)== ' '){
                if (count==0) continue;
                break;
            }
            count++;
        }
        return count;
    }
    /**
     * 还有一种思路：
     * 倒叙遍历，1、末尾不是空格，遍历遇到空格为止
     *         2、末尾有空格，先过滤，再进行第一步操作
     */
    public static int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        while (end>=0 && s.charAt(end) == ' ') end--;
        if (end<0) return  0;
        int start = end;
        while (start>=0 && s.charAt(start) != ' ') start--;
        return end-start;
    }

}
