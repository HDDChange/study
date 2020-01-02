package study.leetcode.month1.day25;

import study.leetcode.ListNode;

/**
 * @author huangqiaowei
 * @date 2019-06-26 18:58
 **/
public class Solution {

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param l1 有序链表1
     * @param l2 有序链表2
     * @return 排序好的连表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode start = new ListNode(-1);
        ListNode prev = start;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return start.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = ListNode.getListNode(new int[] { 1, 2, 4 });
        ListNode listNode2 = ListNode.getListNode(new int[] { 1, 3, 4 });
        solution.mergeTwoLists(listNode1, listNode2);
    }
}
