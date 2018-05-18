package simple.reverse_integer;

/**
 * @program: algorithm
 * @description:    反转整数
 *
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。

    示例 1:

    输入: 123
    输出: 321
    示例 2:

    输入: -123
    输出: -321
    示例 3:

    输入: 120
    输出: 21
    注意:

    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2的31次方,  2的31次方 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 * @author: cxn
 * @create: 2018-05-18 14:43
 * @Version v1.0
 */
public class Solution {

    public static int reverse(int x) {
        boolean flag = false;
        if (x < 0){
            flag = true;
        }
        String s = String.valueOf(x);
        s = s.replace("-","");
        char[] chars = s.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            newChars[chars.length -i - 1] = chars[i];
        }
        String s1 = String.valueOf(newChars);

        if (flag) {
            if (Long.valueOf(s1)-1 > Integer.MAX_VALUE) {
                return 0;
            }
        }else{
            if (Long.valueOf(s1) > Integer.MAX_VALUE) {
                return 0;
            }
        }

        int result = Integer.valueOf(s1).intValue();
        return flag ? -result : result;
    }

    public static int reverse2(int x){

        boolean flag = x < 0;
        if (flag) {
            x = -x;
        }

        long r = 0;

        while (x > 0){
            r = r * 10 + x % 10;
            x /= 10;
        }

        if (flag) {
            r = -r;
        }
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) r;

    }
    public static void main(String[] args) {
        int input = -21474848;
        int reverse = reverse2(input);
        System.out.println(reverse);
    }
}
