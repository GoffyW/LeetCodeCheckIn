package easy;

import java.util.*;

/**
 * @author GoffyGUO
 */
public class UniqueNumberOfOccurrences1207 {
    public static void main(String[] args) {
       /* int [] arr = {1,2,3,3,3,4,3,4,4};
        System.out.println(uniqueOccurrences(arr));*/
       List<Integer> list = new ArrayList<>();
       list.add(1);
       list.add(2);
       list.add(3);
       list.add(4);
        List<Integer> list2 = new ArrayList<>();

        list.retainAll(list2);
        System.out.println(list);







    }
    public static boolean uniqueOccurrences(int [] arr){
        Map<Integer,Integer> map = new HashMap<>(16);
        Set<Integer> set =new HashSet<>();

        for (int data : arr) {
            if (map.get(data) == null) {
                map.put(data, 1);
            } else {
                map.put(data, map.get(data) + 1);
            }
        }
        for (Integer i:map.values()){
            if (!set.add(i)){
                return false;
            }
        }
        return true;
    }
}
