package study.leetcode.month1.day28;

import study.leetcode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author huangqiaowei
 * @date 2019-06-29 21:47
 **/
public class Solution {

    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param lists 目标链表
     * @return 结果链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        // 使用优先级队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        ListNode start = new ListNode(0);
        ListNode end = start;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        while (queue.size() > 0) {
            end.next = queue.poll();
            end = end.next;
            if (end.next != null) {
                queue.add(end.next);
            }
        }
        return start.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = ListNode.getListNode(new int[]{1});
        ListNode listNode2 = ListNode.getListNode(new int[]{-1});

        solution.mergeKLists(new ListNode[]{listNode1, listNode2});
    }


}
