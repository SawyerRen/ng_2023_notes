package company.uber.goodluck;

import java.util.*;
import java.util.Random;

// 这题两种解法，第二种解法比较特殊，面试中我觉得能想到第一种就ok了
public class Q384 {

    // 这个解法我用string，下一个解法用的是int[]，本质是一样的
    // 这个解法把string转换成list，从list中随机拿出一个char，加入stringbuilder，再把这个char从list中去掉
    class Solution {
        String str;
        Random random = new Random();

        public Solution(String s) {
            this.str = s;
        }

        public String reset() {
            return str;
        }

        public String shuffle() {
            StringBuilder builder = new StringBuilder();
            // list中保存str中的字符
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                list.add(str.charAt(i));
            }
            for (int i = 0; i < list.size(); i++) {
                // 随机取出index，加入stringbuilder，并且从list中去掉
                int randomIndex = random.nextInt(list.size());
                builder.append(randomIndex);
                list.remove(randomIndex);
            }
            return builder.toString();
        }
    }

    // 用了一个特殊的算法，遍历整个array，对于每一个index，
    // 都随机和前面的（包括自己）一个index交换
    class Solution1 {
        int[] nums;
        Random random;

        public Solution1(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int[] res = nums.clone();
            for (int i = 0; i < res.length; i++) {
                int index = random.nextInt(i + 1);
                swap(res, i, index);
            }
            return res;
        }

        private void swap(int[] nums, int i, int j) {
            int n = nums[i];
            nums[i] = nums[j];
            nums[j] = n;
        }
    }
}
