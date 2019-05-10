/**
 * @author yinyachuan
 * @create 2019-05-10 10:57
 * @desc ��ת������
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
     * ��������ת������.
     * @param head
     * @return
     */
    public static Node reverseNode(Node head) {
        if (head == null) {
            return null;
        }
        // ��һ���
        Node pre = head;
        // ��ǰ���
        Node cur = head.getNext();
        // ��ʱ��㣬���ڱ��浱ǰ����ָ���򣨼���һ��㣩
        Node tmp;
        // ��ǰ���Ϊnull��˵��λ��β���
        while (cur != null) {
            tmp = cur.getNext();
            // ��תָ�����ָ��
            cur.setNext(pre);
            // ָ�������ƶ�
            pre = cur;
            cur = tmp;
        }
        // ���ԭ�����ͷ�ڵ��ָ������Ϊnull�������������ͷ��㣬��ԭ�����β���
        head.setNext(null);
        return pre;
    }

    /**
     * ��������ת������.
     * ���Ӷȷ���
     *  ʱ�临�Ӷȣ�O(n)������ n���б�ĳ��ȣ�ʱ�临�Ӷ��� O(n)��
     *  �ռ临�Ӷȣ�O(1)
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
     * �ݹ飬�ڷ�ת��ǰ�ڵ�֮ǰ�ȷ�ת�����ڵ�
     */
    public static Node reverseListForRecusion(Node head){
        // head������ǰһ��㣬head.getNext()�ǵ�ǰ��㣬reHead�Ƿ�ת���������ͷ���
        if (head == null || head.getNext() == null) {
            // ��Ϊ�������ߵ�ǰ�����β��㣬��ֱ�ӻ���
            return head;
        }
        // �ȷ�ת�����ڵ�head.getNext()
        Node reHead = reverseListForRecusion(head.getNext());
        // ����ǰ����ָ����ָ��ǰһ���
        head.getNext().setNext(head);
        // ǰһ����ָ������Ϊnull;
        head.setNext(null);
        // ��ת���������ͷ���
        return reHead;
    }
}
