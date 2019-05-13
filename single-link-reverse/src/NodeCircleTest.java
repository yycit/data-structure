import java.util.HashSet;
import java.util.Set;

/**
 * @author yinyachuan
 * @create 2019-05-10 14:35
 * @desc  ���������ж��������Ƿ��л�
 * leetcode-cn: 141
 **/
public class NodeCircleTest {

    public static void main(String[] args) {

        Node node0 = new Node(1);
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(7);

        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);

        Node head = node0;
//        boolean flag = hasCycle(head);
        boolean flag = hasCycle2(head);
        System.out.println(flag);
    }


    /**
     * ��ϣ�����
     * @param head
     * @return
     */
    public static boolean hasCycle(Node head) {
        Set<Node> nodeSeen = new HashSet<>();
        while (head != null){
            if(nodeSeen.contains(head)){
                return true;
            }else{
                nodeSeen.add(head);
            }
            head = head.getNext();
        }
        return false;
    }


    /**
     * �ÿ���ָ����
     * @param head
     * @return
     * �߽�ֵ�жϣ�
     *  head == null        // �������޻�
     *  head.next == null   // ֻ��һ���ڵ�������޻�
     */
    public static boolean hasCycle2(Node head){
        if(head == null || head.getNext() == null){
            return false;
        }
        Node slow = head;
        Node fast = head.getNext();
        while (fast != slow){
            if(fast == null || fast.getNext() == null){
                return false;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return true;
    }

}
