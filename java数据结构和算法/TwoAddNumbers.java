/**
 * 两数相加算法 中等难度（leetcode no.2）
 */
public class TwoAddNumbers {

    public static void main(String[] args) {
       // 创建第一个链表
       ListNode head1 = new ListNode(2);
       head1.next = new ListNode(4);
       head1.next.next = new ListNode(3);

       // 创建第二个链表
       ListNode head2 = new ListNode(5);
       head2.next = new ListNode(6);
       head2.next.next = new ListNode(4);

       // 调用相加方法
       ListNode result = addTwoNumbers3(head1, head2);

       // 打印结果
       ListNode node = result;
       while (node != null) {
           System.out.print(node.val + " ");
           node = node.next;
       }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        while (head1 != null) {
            if (head2 != null) {
                head1.val += head2.val;
                head2 = head2.next;
            }
            if (head1.next == null && head2 != null) {
                head1.next = head2;
            }
            head1 = head1.next;
        }
        merge(l1);
        return l1;

    }

    public static void merge(ListNode head) {
        while (head != null) {
            if (head.val >= 10) {
                head.val = head.val % 10;
                if (head.next == null) {
                    head.next = new ListNode(0);
                }
                head.next.val += 1;
            }
            head = head.next;

        }
    }
    /**
     * 优化后的实现方式1
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) { 
        ListNode head1 = l1;
        ListNode head2 = l2;
        while (head1 != null) {
            if (head2 != null) {
                head1.val += head2.val;
                head2 = head2.next;
            }
            if (head1.val >= 10) {
                head1.val = head1.val % 10;
                if (head1.next == null) {
                    head1.next = new ListNode(1);
                } else {
                    head1.next.val += 1;
                }
            }
            head1 = head1.next;
        }
        return l1;
    }

     /**
     * 将两个链表表示的数字相加，返回一个新的链表表示相加后的数字。
     * chatGPT提供的最优方法
     * @param l1 链表1
     * @param l2 链表2
     * @return 相加后的链表
     */
    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        // 创建一个虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0; // 进位

        // 对两个链表进行遍历
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;

            // 将相加后的结果加入新链表中
            tail.next = new ListNode(sum);
            tail = tail.next;
        }
        return dummy.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}
