package com.csg.demo.testAhead;

import java.util.Stack;

public class Tree {

    public static  Stack<String> stack = new Stack();

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public void travel(INodeHandler nh) {
        this.travel(nh, root);
    }

    private void travel(INodeHandler nh, Node node) {
        //你的前序遍历代码
        if (node.left == null) {
            //如果该节点下面无子节点
            stack.add(node.data);
        } else if (node.left != null && node.right != null) {
            //如果该节点下面有2个子节点
            stack.add(node.data);
            for(int i = 0;i<2;i++){
                if( i == 0){
                    travel(nh, node.left);
                }else{
                    travel(nh, node.right);
                }
            }
        } else {
            //如果该节点下面只有1个子节点
            stack.add(node.left == null ? node.right.data : node.left.data);
        }
    }

}
