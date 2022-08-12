import jianzhiOffer.Offer38;
import utils.TreeNode;

public class Runner {
    public static void main(String[] args) {
        Offer38 offer = new Offer38();
        String[] abcs = offer.permutation("abc");
        for (String s : abcs) {
            System.out.println(s);
        }
    }
}
