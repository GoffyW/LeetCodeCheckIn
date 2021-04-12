package easy;

/**
 * @author guogoffy
 */
public class LongestCommonPrefixTest {
    public static void main(String[] args) {
        String strs [] =  {"flower","flow","flight"};
        System.out.println(longestCommonPrefixTest(strs));

    }
    public static String longestCommonPrefixTest(String [] args){
        if (args.length==0){
            return "";
        }
        // 最长前缀末尾位置
        int end = args[0].length()-1;
        for (int i = 0; i < args.length; i++) {
            int j = 0;
            // 优化1: 不用比较整个字符串, 只要比较前缀长度即可
            for(;j<=end && j<args[i].length();++j){
                if (args[0].charAt(j)!=args[i].charAt(j)){
                    break;
                }
            }
            // 没有公共前缀, 不用再遍历剩余字符串
            end = Math.min(end,j-1);
            // 没有公共前缀, 不用再遍历剩余字符串
            if (end<0){
                break;
            }
        }
        return args[0].substring(0,end+1);
    }
    public static String longestCommonPrefixTest2(String[] strs) {
        if(strs.length==0)return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length()==0)return "";
                //公共前缀不匹配就让它变短！
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }
}
