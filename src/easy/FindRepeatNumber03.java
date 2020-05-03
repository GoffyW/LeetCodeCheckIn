package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author GoffyGUO
 */
public class FindRepeatNumber03 {
    public static void main(String[] args) {

        //findRepeatNumber();

    }

    public static int findRepeatNumber(int [] arrs){
        Set<Integer> set  = new HashSet<>();
        int repeat = -1;
        for (int arr : arrs){
            if(!set.add(arr)){
                repeat = arr;
                break;
            }
        }
        return repeat;
    }
}
