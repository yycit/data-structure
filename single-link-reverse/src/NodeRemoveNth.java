/**
 * @author yinyachuan
 * @create 2019-05-13 10:49
 * @desc ɾ������ĵ�����n���ڵ�
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
     * ���������
     *  ����ע�⵽�������������׵ؼ򻯳���һ�����⣺
     *  ɾ�����б�ͷ����ĵ� (L - n + 1) ����㣬
     *  ���� L���б�ĳ��ȡ�ֻҪ�����ҵ��б�ĳ��� L���������ͺ����׽����
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
     * һ�α���������ָ��
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
