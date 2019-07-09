package study.leetcode.month2.day6;

import study.leetcode.TreeNode;

/**
 * @author huangqiaowei
 * @date 2019-07-06 04:25
 **/
public class Solution {


    /**
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     *
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * 示例 1:
     *
     * 输入:       1         1
     *           / \       / \
     *          2   3     2   3
     *
     *         [1,2,3],   [1,2,3]
     *
     * 输出: true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/same-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param p 左树
     * @param q 右树
     * @return 是否相同
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p== null && q == null){
            return true;
        }
        if(p!= null && q == null){
            return false;
        }
        if(p==null && q!= null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        if(!isSameTree(p.left , q.left)){
            return false;
        }
        return isSameTree(p.right , q.right);
    }

}
