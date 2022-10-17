package codeTop;

public class T004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 计算数组总长度以及目标位置
        int len = nums1.length + nums2.length;
        int target = (len + 1) / 2;
        // 记录当前位置的两个指针
        int p1 = 0, p2 = 0;
        int remain = target;        // 记录剩下多少个值需要移动
        // 循环移动指针，每次移动剩余距离的一半
        while (remain > 1 && p1 < nums1.length && p2 < nums2.length) {
            int move = remain / 2;
            // 查看移动后的两个指针的位置，如果越界则找到最后一个
            int t1 = Math.min((p1 + move - 1), nums1.length - 1);
            int t2 = Math.min((p2 + move - 1), nums2.length - 1);
            // 对于比较起来较小的位置，其左边的部分都不可能是remain小的位置了
            if (nums1[t1] < nums2[t2]) {
                remain -= t1 - p1 + 1;  // 剩余的数量更新
                p1 = t1 + 1;            // 更新指针
            } else {
                remain -= t2 - p2 + 1;  // 剩余的数量更新
                p2 = t2 + 1;            // 更新指针
            }
        }
        // 获得target的下标。如果某个数组已经走完，则直接增加，否则比较较小值
        int targetValue;
        if (p1 == nums1.length) {
            targetValue = nums2[p2 + remain - 1];
            p2 += remain;
        } else if (p2 == nums2.length) {
            targetValue = nums1[p1 + remain - 1];
            p1 += remain;
        } else if (remain == 1) {
            if (nums1[p1] < nums2[p2]) {
                targetValue = nums1[p1];
                p1++;
            } else {
                targetValue = nums2[p2];
                p2++;
            }
        } else {
            targetValue = -1;
            System.out.println("error");
        }
        // 判断数组总长度的奇偶性，如果是奇数则直接返回，否则寻找下一个数并返回
        if (len % 2 == 1) {
            return targetValue;
        } else {
            int nextValue = -1;
            if (p1 == nums1.length ||
                    (p2 != nums2.length && nums1[p1] > nums2[p2])) {
                nextValue = nums2[p2];
            } else {
                nextValue = nums1[p1];
            }
            return ((double)targetValue + nextValue) / 2;
        }

    }
}
