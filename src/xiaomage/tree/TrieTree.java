package xiaomage.tree;


/**
 * 需求：如何判断一堆不重复的字符串是否是某个前缀开头
 * {dog,cat,does}
 */

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/06/12/17:49
 * @Description: TrieTree 字典树（前缀树，单词查找树）
 * 字符串搜索只跟字符串的长度有关
 */
public class TrieTree<T> {

    /**
     * 存储元素的数量
     */
    private int size;

    public int size(){
        return 0;
    }

    public boolean isEmpty(){
        return false;
    }

    public void clear(){

    }

    public boolean contains(String str){
        return false;
    }

    public void add(){

    }

    public void remove(){

    }

    public boolean startWith(String prefix){
        return false;
    }

    /**
     * 此处的重点是考虑如何设计这个node节点
     * //todo
     * @param <V>
     */
    private static class Node<V>{
        HashMap<Character,Node<V>> children;


    }




}
