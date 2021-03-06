package week3.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 */
public class LeetCode_590_0227 {

    public List<Integer> postorder(Node root) {
        //递归法
//        return method1(root);
        //迭代法
        return method2(root);
    }

    //
    private List<Integer> method2(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        //既然不迭代那就使用额外空间
//        存储每一次的node节点信息
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            res.addFirst(node.val);
            if (node.children.size() > 0) {
                for (Node n : node.children) {
                    if (n != null) stack.add(n);
                }
            }
        }
        return res;
    }

    private List<Integer> method1(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, Node root) {
        if (root == null) return;
        for (Node node : root.children) {
            helper(res, node);
        }
        res.add(root.val);
    }

    /*
   // Definition for a Node.*/
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> _children) {
            this.val = val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.addFirst(1);
        integers.addFirst(2);
        integers.addFirst(3);
        integers.addLast(4);
        integers.addLast(5);
        integers.addLast(6);
        integers.pollFirst();
        integers.pollLast();
        System.out.println(1);
        Node node = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node.children=new ArrayList<>(Arrays.asList(node1,node2,node3));
        node1.children=new ArrayList<>(Arrays.asList(node5,node6));
        new LeetCode_590_0227().method2(node);
    }
}
