import jianzhiOffer.Offer37;
import utils.TreeNode;

public class Runner {
    public static void main(String[] args) {
        Offer37 offer = new Offer37();
        TreeNode node = new TreeNode(new Integer[]{1, 2, 3, 4, null, null, null});
        TreeNode node0 = null;
        String data = offer.serialize(node);
        System.out.println(data);
        TreeNode root = offer.deserialize(data);
    }
}
