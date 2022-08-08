import jianzhiOffer.Offer35;
import utils.TreeNode;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Offer35 offer = new Offer35();
//        System.out.println(offer.copyRandomList(node0));
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
