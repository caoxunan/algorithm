package greatest_common_divisor;

/**
 * @program: algorithm
 * @description: 求两个数的最大公约数
 * @author: cxn
 * @create: 2018-05-17 15:27
 * @Version v1.0
 */
public class GetGreatestCommonDivisor {

    public static long time2;
    public static long time3;
    public static long time4;

    public static void main(String[] args) {

        int a = 1000000000;
        int b = 500500;
        // 循环次数
        int count = 10000;

        long start = System.currentTimeMillis();
        int result = 1;
        for (int i = 0; i < count; i++) {
            result = getGreatestCommonDivisor1(a, b);
        }
        long end = System.currentTimeMillis();
        System.out.println("暴力枚举法：" + result + "_" + "消耗时间：" + (end - start));

        long start2 = System.currentTimeMillis();
        int result2 = 1;
        for (int i = 0; i < count; i++) {
            result2 = getGreatestCommonDivisor2(a, b);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("辗转相除法：" + result2 + "_" + "消耗时间：" + (end2 - start2) + ",_循环次数：" + time2);

        long start3 = System.currentTimeMillis();
        int result3 = 1;
        for (int i = 0; i < count; i++) {
            result3 = getGCD3(a, b);
        }
        long end3 = System.currentTimeMillis();
        System.out.println("更相减损法：" + result3 + "_" + "消耗时间：" + (end3 - start3) + ",_循环次数：" + time3);

        long start4 = System.currentTimeMillis();
        int result4 = 1;
        for (int i = 0; i < count; i++) {
            result4 = getGCD4(a, b);
        }
        long end4 = System.currentTimeMillis();
        System.out.println("更相减损法：" + result4 + "_" + "消耗时间：" + (end4 - start4) + ",_循环次数：" + time4);

    }



    /**
     * 暴力枚举法，试图寻找一个合适的整数i，看看这个整数能否被两个整型参数numberA和numberB同时整除
     * 时间复杂度是O(min(a,b))
     * @param numberA
     * @param numberB
     * @return
     */
    public static int getGreatestCommonDivisor1(int numberA, int numberB) {
        int smallNumber = numberA < numberB ? numberA : numberB;
        int bigNumber = numberA > numberB ? numberA : numberB;

        if (bigNumber % smallNumber == 0) {
            return smallNumber;
        }

        int greatestCommonDivisor = 1;

        for (int i = 2; i < smallNumber / 2; i++) {

            if (numberA % i == 0 && numberB % i == 0) {
                greatestCommonDivisor = i;
            }
        }

        return greatestCommonDivisor;
    }

    /**
     * 辗转相除法，又名欧几里得算法
     * 基于定理：两个正整数a和b（a>b），他们的最大公约数等于a除以b的余数c和b之间的最大公约数。
     * 缺点：当整数值较大时，取模运算%的性能较低。
     * 时间复杂度：近似O(log(max(a,b))),但取模运算性能较差
     * @param numberA
     * @param numberB
     * @return
     */
    public static int getGreatestCommonDivisor2(int numberA, int numberB) {
        time2 ++;
        int result = 1;

        if (numberA > numberB) {
            result = gcd(numberA, numberB);
        } else {
            result = gcd(numberB, numberA);
        }

        return result;
    }

    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }

    }

    /**
     * 更相减损术--->出自九章算数
     * 基于定理：两个正整数a和b（a>b），他们的最大公约数等于a-b的差值c和较小数b的最大公约数。
     * 缺点：虽然避免理大整数取模的性能问题，但是运算次数不稳定，两数相差悬殊的时候，递归次数较多。
     * 时间复杂度：算法性能不稳定，最坏的时间复杂度O(max(a,b))
     * @param numberA
     * @param numberB
     * @return
     */
    public static int getGCD3(int numberA, int numberB) {
        time3 ++;
        if (numberA == numberB) {
            return numberB;
        }
        if (numberA < numberB) {
            return getGCD3(numberB - numberA, numberA);
        } else {
            return getGCD3(numberA - numberB, numberB);
        }

    }

    /**
     * 辗转相除法 与 更相减损术 相结合
     * 避免了取模运算，算法性能稳定，时间复杂度O(log(max(a,b)))
     * @param numberA
     * @param numberB
     * @return
     */
    public static int getGCD4(int numberA, int numberB) {
        time4++;
        if (numberA == numberB) {
            return numberA;
        }
        if (numberA < numberB) {
            // 保证参数A永远大于等于参数B，为减少代码量
            return getGCD4(numberB, numberA);
        } else {
            // 和1做按位与运算，判断奇偶
            if ((numberA & 1) == 0 && (numberB & 1) == 0) {
                // 都是偶数
                return getGCD4(numberA >> 1, numberB >> 1) << 1;
            } else if ((numberA & 1) == 0 && (numberB & 1) == 1) {
                // numberA是偶数  numberB是奇数
                return getGCD4(numberA >> 1, numberB);
            } else if ((numberA & 1) == 1 && (numberB & 1) == 0) {
                // numberA是奇数  numberB是偶数
                return getGCD4(numberA, numberB >> 1);
            } else {
                // 都是奇数
                return getGCD4(numberB, numberA - numberB);
            }
        }
    }

}
