package com.boot.learn.datastructure;


import java.util.Stack;

public class TreeNodeDemo {

    public static void main(String[] args) {
        TreeNode treeNode = newTreeNode();
        System.out.println("前序排列：");
        preOrder(treeNode);
        System.out.println();
        System.out.println("中序排列：");
        midOrder(treeNode);
        System.out.println();
        System.out.println("后序排列：");
        afterOrder(treeNode);
        System.out.println();
        System.out.println("前序排列非递归：");
        preOrder2(treeNode);
//        System.out.println("中序排列非递归：");
//        midOrder(treeNode);
//        System.out.println("后序排列非递归：");
//        afterOrder(treeNode);


    }

    private static void preOrder2(TreeNode treeNode){
        if(treeNode == null){
            return ;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while(!stack.isEmpty()){
            // 打印当前节点
            print(treeNode);
            if (treeNode.right != null){
                stack.push(treeNode.right);
            };
            if (treeNode.left != null){
                stack.push(treeNode.left);
            };
            treeNode = stack.pop();
        }
    }

    /**
     * 前/先序排列  根 左 右
     * @param treeNode
     */
    private static void preOrder(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        print(treeNode);
        preOrder(treeNode.getLeft());
        preOrder(treeNode.getRight());
    }

    /**
     * 中序排列  左 根 右
     * @param treeNode
     */
    private static void midOrder(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        midOrder(treeNode.getLeft());
        print(treeNode);
        midOrder(treeNode.getRight());
    }

    /**
     * 后序排列  左 右 根
     * @param treeNode
     */
    private static void afterOrder(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        afterOrder(treeNode.getLeft());
        afterOrder(treeNode.getRight());
        print(treeNode);
    }

    public static void print(TreeNode treeNode) {
        System.out.print(treeNode.getVal() + " ");
    }

    /**
     *          a
     *      b       c
     *        d   e    f
     *                g
     *  前序 a b d c e f g
     *  中序 b d a e c g f
     *  后序 d b e g f c a
     * @return
     */
    private static TreeNode newTreeNode() {
        TreeNode a = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        TreeNode f = new TreeNode("f");
        TreeNode g = new TreeNode("g");
        TreeNode h = new TreeNode("h");
        a.left = b;
        a.right = c;
        b.right = d;
        c.left = e;
        c.right = f;
        f.left = g;
        return a;
    }

}
