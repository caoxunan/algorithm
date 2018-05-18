package simple.two_sum;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithm
 * @description:    两数之和
 *
 *  给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
    你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

    示例:
    给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]

 * @author: cxn
 * @create: 2018-05-18 14:10
 * @Version v1.0
 */
public class Solution {


    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Label:
        for (int i = 0; i < nums.length -1; i++) {

            for (int j = i+1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break Label;
                }
            }
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer mapInteger = map.get(target - nums[i]);
            if (map.containsKey(target - nums[i])) {
                result[0] = mapInteger;
                result[1] = i;
                break;
            }else{
                // 把值作为key，下标作为value存入map
                map.put(nums[i],i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-3,2,4};
        int target = 1;
        int[] result = twoSum2(nums, target);
        System.out.println(Arrays.toString(result));
    }


}
