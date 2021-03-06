/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 
 * 66. Plus One

* 
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

 */
import java.util.*;
public class Leetcode_66_PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return new int[]{1};
        
        int carry = 0;
        if (digits[digits.length - 1] + 1 == 10) {
            digits[digits.length - 1] = 0;
            carry = 1;
            for (int i = digits.length - 2; i >= 0; i--) {
                if ( digits[i] + carry == 10) {
                    digits[i] = 0;
                    carry = 1;
                }
                else {
                    digits[i] += carry;
                    carry = 0;
                    break;
                }
            }
        }
        else {
            digits[digits.length - 1] += 1;
        }
        
        if (carry == 1) {
            int[] result = Arrays.copyOf(new int[]{1}, digits.length + 1);
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
        return digits;
    }
}
