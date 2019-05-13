/**
 * @author yinyachuan
 * @create 2019-05-13 16:03
 * @desc ��������м�ڵ�
 * ����һ������ͷ��� head �ķǿյ���������������м��㡣
 * ����������м��㣬�򷵻صڶ����м���
 **/
public class NodeMiddleTest {


    public static void main(String[] args) {

        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
//        node4.setNext(node5);

        Node head = node0;
        Node node = middleNode(head);
        System.out.println(node.getData());

    }

    /**
     * ����ָ�뷨�������м�ڵ�
     * @param head
     * @return
     */
    public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

}
