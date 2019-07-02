package study.leetcode.month1.day23;

import java.util.ArrayList;
import java.util.List;

import study.leetcode.ListNode;

/**
 * @author huangqiaowei
 * @date 2019-06-26 14:00
 **/
public class Solution {

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5. 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        if (n == list.size()) {
            head = head.next;
        } else {
            list.get(list.size() - n - 1).next = list.get(list.size() - n - 1).next.next;
        }
        return head;
    }

}
