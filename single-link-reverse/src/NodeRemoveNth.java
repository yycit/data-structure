/**
 * @author yinyachuan
 * @create 2019-05-13 10:49
 * @desc 删除链表的倒数第n个节点
 **/
public class NodeRemoveNth {


    public static void main(String[] args) {

        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        Node head = node0;
        Node node = removeNthFromEnd(head, 2);
        while (node != null){
            System.out.println(node.getData());
            node = node.getNext();
        }

    }

    /**
     * 迭代法求解
     *  我们注意到这个问题可以容易地简化成另一个问题：
     *  删除从列表开头数起的第 (L - n + 1) 个结点，
     *  其中 L是列表的长度。只要我们找到列表的长度 L，这个问题就很容易解决。
     * @param head
     * @param n
     * @return
     */
    public static Node removeNthFromEnd(Node head, int n){
        Node dummy = new Node(0);
        dummy.setNext(head);
        Node first = head;
        int length = 0;
        while (first != null){
            length++;
            first = first.getNext();
        }
        length = length - n;
        first = dummy;
        while(length > 0){
            length--;
            first = first.getNext();
        }
        first.setNext(first.getNext().getNext());
        return dummy.getNext();
    }


    /**
     * 一次遍历，两个指针
     * @param head
     * @param n
     * @return
     */
    public static Node removeNthFromEnd2(Node head, int n){
        Node dummy = new Node(0);
        dummy.setNext(head);
        Node first = dummy;
        Node second = dummy;
        for(int i=1; i<= n+1; i++){
            first = first.getNext();
        }
        while (first != null){
            first = first.getNext();
            second = second.getNext();
        }
        second.setNext(second.getNext().getNext());
        return dummy.getNext();
    }

}
