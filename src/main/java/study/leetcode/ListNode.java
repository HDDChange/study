package study.leetcode;

/**
 * @author huangqiaowei
 * @date 2019-06-26 19:02
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    /**
     * 生成listnode
     *
     * @param ints 数组
     * @return ListNode
     */
    public static ListNode getListNode(int[] ints) {
        ListNode listNode = null, start = null;
        for (int i = 0; i < ints.length; i++) {
            ListNode temp = new ListNode(ints[i]);
            if (i == 0) {
                start = temp;
            }
            if (listNode == null) {
                listNode = temp;
            } else {
                listNode.next = temp;
                listNode = temp;
            }
        }
        return start;
    }
}
