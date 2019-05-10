/**
 * @author yinyachuan
 * @create 2019-05-10 10:57
 * @desc 反转单链表
 **/
public class NodeReverseTest {

    public static void main(String[] args) {

        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        Node head = node0;
        while (head != null){
            System.out.println(head.getData() + "");
            head = head.getNext();
        }

//        head = reverseNode(node0);
        head = reverseListForRecusion(node0);

        while (head != null){
            System.out.println(head.getData() + "");
            head = head.getNext();
        }
    }


    /**
     * 迭代法反转单链表.
     * @param head
     * @return
     */
    public static Node reverseNode(Node head) {
        if (head == null) {
            return null;
        }
        // 上一结点
        Node pre = head;
        // 当前结点
        Node cur = head.getNext();
        // 临时结点，用于保存当前结点的指针域（即下一结点）
        Node tmp;
        // 当前结点为null，说明位于尾结点
        while (cur != null) {
            tmp = cur.getNext();
            // 反转指针域的指向
            cur.setNext(pre);
            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);
        return pre;
    }

    /**
     * 迭代法反转单链表.
     * 复杂度分析
     *  时间复杂度：O(n)，假设 n是列表的长度，时间复杂度是 O(n)。
     *  空间复杂度：O(1)
     * @param head
     * @return
     */
    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


    /**
     * 递归，在反转当前节点之前先反转后续节点
     */
    public static Node reverseListForRecusion(Node head){
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.getNext() == null) {
            // 若为空链或者当前结点在尾结点，则直接还回
            return head;
        }
        // 先反转后续节点head.getNext()
        Node reHead = reverseListForRecusion(head.getNext());
        // 将当前结点的指针域指向前一结点
        head.getNext().setNext(head);
        // 前一结点的指针域令为null;
        head.setNext(null);
        // 反转后新链表的头结点
        return reHead;
    }
}
