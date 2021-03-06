//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


package com.Simba.algorithm007class01.leetcode.editor.cn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NAryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreePreorderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Integer> preorder(Node root) {
           List<Integer> res=new ArrayList<>();
            Stack<Node> stack=new Stack<>();
            if(root!=null)stack.add(root);
            while (!stack.isEmpty()){
                Node node=stack.pop();
                res.add(node.val);
                if(node.children!=null){
                    for(int i=node.children.size()-1;i>=0;i--){
                        stack.add(node.children.get(i));
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


}