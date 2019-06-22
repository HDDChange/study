package study.leetcode.day6;

import java.util.Objects;

/**
 * 第6天
 *
 * @author huangqiaowei
 * @date 2019-06-13 21:08
 **/
public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
     *
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param l1 A
     * @param l2 B
     * @return A + B
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode end = new ListNode(0);
        ListNode start = end;
        ListNode temp = null;
        int x = 0;
        while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
            int i = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + end.val;
            if (i >= 10) {
                end.val = i % 10;
                temp = new ListNode(1);
            } else {
                end.val = i;
                temp = new ListNode(0);
            }
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
            if (Objects.nonNull(l1) || Objects.nonNull(l2) || temp.val == 1) {
                end.next = temp;
            }
            end = temp;
        }
        return start;
    }
}
