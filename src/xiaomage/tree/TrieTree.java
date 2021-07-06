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
public class TrieTree<V> {

    /**
     * 存储元素的数量
     */
    private int size;

    /**
     * 跟节点
     */
    private Node<V> root;

    public int size(){
        return 0;

    }

    public boolean isEmpty(){
        return false;
    }

    public void clear(){
        size = 0;
        root = null;
    }

    public V get(String key){
        Node<V> node = node(key);
        return node == null ? null : node.value;
    }

    /**
     * 是否包含这个key
     * @param key
     * @return
     */
    public boolean contains(String key){
        return node(key)!=null;
    }

    /**
     * 根据key查找value
     * @param key
     * @return
     */
    private Node<V> node(String key){
        if (root == null) return null;
        keyCheck(key);

        Node<V> node = this.root;
        int length = key.length();
        for (int i = 0; i < length; i++) {
            char c = key.charAt(i);// d o g
            //这里之所以不这样写的原因就是因为node（root）可能为空,所以给Node增加get的构造方法，然后在返回值中判断，如果为空先new一个
            //Node<V> vNode = node().children.get(c);
            Node<V> node1 = node.getChildren().get(c);
            if (node1==null) return null;
        }
        //如果这个word为true就说明这个单词存在，否则这个字符只是每个单词的前缀，返回null就好了
        return node.word ? node : null;
    }

    private void keyCheck(String key){
        if (key==null||key.length()==0){
            throw new IllegalArgumentException("key must not be empty");
        }
    }



    public void add(){

    }

    public void remove(){

    }

    /**
     * 是否以它为前缀
     * @param prefix
     * @return
     */
    public boolean startWith(String prefix){
        return false;
    }

    /**
     * 此处的重点是考虑如何设计这个node节点
     * //todo
     * 每一个node就是一个数据，用红色表示每个单词的结尾，
     * 我们不应该存储这一整个单词，因为从上开始，每一个单词已经存储过了，没必要再存储一边，但是我们总应该有一个字符 character
     * @param <V>
     */
    private static class Node<V>{

        HashMap<Character,Node<V>> children;

        V value;
        // 是否为单词的结尾（是否为一个完成的单词）
        boolean word;

        public HashMap<Character, Node<V>> getChildren() {
            return children == null ? new HashMap<>() : children;
        }
    }




}
