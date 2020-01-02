package study.leetcode.month1.day29;

import study.leetcode.ListNode;

/**
 * @author huangqiaowei
 * @date 2019-06-30 22:15
 **/
public class Solution {

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head 给定的链表
     * @return 符合条件的链表
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode start = head.next;
        ListNode temp = new ListNode(0);
        temp.next = head;
        if (head.next != null) {
            // 两两交换
            while (head != null && head.next != null) {
                temp.next = head.next;
                temp = temp.next;
                head.next = temp.next;
                temp.next = head;
                head = head.next;
                temp = temp.next;
            }
            return start;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.getListNode(new int[]{1, 2, 3, 4});
        Solution solution = new Solution();
        solution.swapPairs(listNode);
    }
}
