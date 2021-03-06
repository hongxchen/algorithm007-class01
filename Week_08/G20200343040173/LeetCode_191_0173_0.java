/**
191. 位1的个数
编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。

示例 1：

输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 
方法 0：自己想的办法，是把 int 转成 2 进制字符串，然后数字符串中 1 的个数，这个超慢。

时间复杂度：O(1)
空间复杂度：O(1)
*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits = 0;
        String s = Integer.toBinaryString(n);
        for (char c : s.toCharArray()) {
            if (c == '1') {
                bits++;
            }
        }
        return bits;
    }
}