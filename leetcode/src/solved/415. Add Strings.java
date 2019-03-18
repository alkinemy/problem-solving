/**
 * https://leetcode.com/problems/add-strings/
 */

class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }

        StringBuilder sb = new StringBuilder();
        int num1Pointer = num1.length() - 1;
        int num2Pointer = num2.length() - 1;
        int carry = 0;
        while (num1Pointer >= 0 && num2Pointer >= 0) {
            int sum = (num1.charAt(num1Pointer) - '0') + (num2.charAt(num2Pointer) - '0') + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            num1Pointer--;
            num2Pointer--;
        }

        String rest = null;
        int restPointer = -1;
        if (num1Pointer >= 0) {
            rest = num1;
            restPointer = num1Pointer;
        } else if (num2Pointer >= 0) {
            rest = num2;
            restPointer = num2Pointer;
        }
        if (rest != null) {
            while(restPointer >= 0) {
                int sum = (rest.charAt(restPointer) - '0') + carry;
                carry = sum / 10;
                sb.append(sum % 10);
                restPointer--;
            }
        }

        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}




//short code
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }

        StringBuilder sb = new StringBuilder();
        int num1Pointer = num1.length() - 1;
        int num2Pointer = num2.length() - 1;
        int carry = 0;
        while (num1Pointer >= 0 || num2Pointer >= 0) {
            int num1Value = num1Pointer < 0 ? 0 : num1.charAt(num1Pointer) - '0';
            int num2Value = num2Pointer < 0 ? 0 : num2.charAt(num2Pointer) - '0';
            int sum = num1Value + num2Value + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            num1Pointer--;
            num2Pointer--;
        }

        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
