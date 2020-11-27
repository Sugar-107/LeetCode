package com.wenhui;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 通过次数298,649提交次数473,837
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test05 {
    /**
     * 迭代法
     * @param l1 升序的链表
     * @param l2 升序的链表
     * @return 返回一个新的链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
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
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){

        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val > l2.val){
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }else {
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }

    }


    public static void main(String[] args) {
        ListNode L1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode L2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode ls =  new Test05().mergeTwoLists(L1,L2);


    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}