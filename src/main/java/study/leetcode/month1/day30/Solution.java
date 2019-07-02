package study.leetcode.month1.day30;

import study.leetcode.ListNode;

import java.util.Stack;

/**
 * @author huangqiaowei
 * @date 2019-07-01 10:16
 **/
public class Solution {

    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。
     * <p>
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 示例 :
     * <p>
     * 给定这个链表：1->2->3->4->5
     * <p>
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * <p>
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     * <p>
     * 说明 :
     * <p>
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head 链表
     * @param k    要翻转的值
     * @return 结果
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode result = new ListNode(0);
        ListNode end = result;
        end.next = head;
        while (end.next != null) {
            // 压栈
            while (stack.size() < k) {
                if (head != null) {
                    stack.push(head);
                    head = head.next;
                } else {
                    break;
                }

            }
            // 出栈
            if (stack.size() == k) {
                stack.firstElement().next = stack.peek().next;
                while (stack.size() > 0) {
                    end.next = stack.pop();
                    end = end.next;
                }
            } else {
                end = stack.peek();
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.getListNode(new int[]{1, 2, 3});
        Solution solution = new Solution();
        ListNode listNode1 = solution.reverseKGroup(listNode, 2);
        System.out.printf("ok");
    }
}
