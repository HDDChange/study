package top.hddchange.demo.algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * 二叉树
 *
 * @author huangqiaowei
 * @date 2019-06-22 10:17
 **/
public class BinaryTree {

    /**
     * 节点,链式存储
     */
    private class Node {
        public Node next;
        public String data;
    }

    /**
     * 二叉树的储存 <br>
     * 1. 顺序存储 <br>
     * * 左孩子是父节点的 2n 右孩子是父节点的 2n-1 <br>
     * * 非完全二叉树在顺序存储的时候 会造成空间的浪费 <br>
     * 2. 链式存储 <br>
     * * 递归实现，非递归实现
     *
     * 要求： 初始化一个二叉树 n层高的数
     */
    public void save(int n) {
        // 顺序储存 n层高的树 节点数 = 2^n -1
        Integer[] demo = new Integer[Double.valueOf(Math.pow(2, n)).intValue() - 1];
        // 层次
        for (int i = 1; i <= n; i++) {
            // 遍历每一层 每层起点 2^n - 1 最大节点 2^n - 1
            for (int j = 0; j < Math.pow(2, i - 1); j++) {
                demo[Double.valueOf(Math.pow(2, i - 1) + j - 1).intValue()] =
                    Double.valueOf(Math.pow(2, i - 1) + j).intValue();
            }
        }
        System.out.println(Arrays.toString(demo));
        // 递归实现
        init(demo, 1);
        System.out.println(Arrays.toString(demo));

        // 堆栈实现
        stackSave(demo);
        System.out.println(Arrays.toString(demo));

    }

    /**
     * 顺序递归初始化
     *
     * @param demo 数组
     */
    public void init(Integer[] demo, int i) {
        int temp = i;
        demo[temp - 1] = temp;
        // 先初始化中 就是中序
        if (2 * i <= demo.length) {
            temp = 2 * i;
            init(demo, temp);
        } else if ((2 * i + 1) <= demo.length) {
            temp = 2 * i + 1;
            init(demo, temp);
        }
    }

    /**
     * 非递归实现 <br>
     * 1. 遇到节点就压栈 并遍历它的左子树 <br>
     * 2. 出栈，访问，遍历右子树
     *
     * @param demo 目标数组
     */
    public void stackSave(Integer[] demo) {
        Stack stack = new Stack();
        int i = 1;
        while (i <= demo.length) {
            while (i <= demo.length) {
                // 亚栈
                stack.push(demo[i]);
                // 访问左子树
                i = 2 * i;
            }
            if (!stack.empty()) {
                Integer x = (Integer) stack.pop();
                x = x;
                i = 2 * i + 1;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.save(2);
    }
}
