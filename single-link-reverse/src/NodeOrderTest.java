/**
 * @author yinyachuan
 * @create 2019-05-10 16:25
 * @desc ������������ϲ���һ��������
 **/
public class NodeOrderTest {

    public static void main(String[] args) {

        Node node0 = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(4);
        Node node5 = new Node(6);
        Node node6 = new Node(8);

        node0.setNext(node1);
        node1.setNext(node4);
        node4.setNext(node5);

        node2.setNext(node3);
        node3.setNext(node6);

        Node head1 = node0;
        Node head2 = node2;

//        while (head1 != null){
//            System.out.println(head1.getData());
//            head1 = head1.getNext();
//        }
//
//        System.out.println("-----------");
//        while (head2 != null){
//            System.out.println(head2.getData());
//            head2 = head2.getNext();
//        }

        System.out.println("-----------");
//        Node head = mergeTwoLists(head1, head2);
        Node head = mergeTwoLists2(head1, head2);
        while (head != null){
            System.out.println(head.getData());
            head = head.getNext();
        }
    }


    /**
     * ������
     *    ÿ��ѡ��������ͷ�����С�ģ����磺���������У��������Ѿ����ո߰��źõĶ��飬
     *    ������ΰѱ��һ�����飡��Ȼ��ÿ��ѡ����������ͷ�ģ��Ƚ����ǵĸ߰�!����µĵĶ��顣
     * @param head1
     * @param head2
     * @return
     */
    public static Node mergeTwoLists(Node head1, Node head2) {

        Node mergeNode = new Node(0);
        Node p = mergeNode;
        while (head1 != null && head2 != null){
            if(head1.getData() < head2.getData()){
                p.setNext(head1);
                head1 = head1.getNext();
            }else {
                p.setNext(head2);
                head2 = head2.getNext();
            }
            p = p.getNext();
        }
        if(head1 == null){
            p.setNext(head2);
        }
        if(head2 == null){
            p.setNext(head1);
        }
        return mergeNode.getNext();
    }


    /**
     * �ݹ鷨. ���ص�Node��ͷ����λ��
     * @param head1
     * @param head2
     * @return
     */
    public static Node mergeTwoLists2(Node head1, Node head2) {
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        if(head1.getData() < head2.getData()){
           head1.setNext(mergeTwoLists2(head1.getNext(), head2));
           return head1;
        }else {
            head2.setNext(mergeTwoLists2(head1, head2.getNext()));
            return head2;
        }
    }

}
