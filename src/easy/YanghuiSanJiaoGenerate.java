package easy;

import java.util.ArrayList;
import java.util.List;

public class YanghuiSanJiaoGenerate {
    public static void main(String[] args) {
        System.out.println(generate(5));

    }
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> res = new ArrayList<>();
        if (numRows==0){
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(temp);
        if (numRows==1){
            return res;
        }
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(1);
        temp1.add(1);
        res.add(temp);
        if (numRows==2){
            return res;
        }
        List<Integer> preRow = res.get(1);
        for (int i = 3; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i-1; j++) {
                    list.add(preRow.get(j)+preRow.get(j-1));
            }
            list.add(1);
            preRow = list;
            res.add(list);
        }
        return res;
    }
}
