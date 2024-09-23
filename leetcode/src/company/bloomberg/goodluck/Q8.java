class Solution {
    public int myAtoi(String s) {
        //1. check the whitespace (" ").
        int i = 0;
        int length = s.length();
        while(i < length && s.charAt(i) == ' '){
            i++;
        }

        //2. check the character is '-' or '+'
        boolean negative = false;
        if(i == length) return 0;
        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            negative = s.charAt(i) == '-';
            i++;
        }

        //3. get the number(long) and check the bound
        long number = 0;
        while(i < length && Character.isDigit(s.charAt(i))){
            // number = number * 10 + number; 错误写法
            number = number * 10 + (s.charAt(i) - '0');
            if(number > Integer.MAX_VALUE){
                if(negative) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            i++;
        }

        //return result(int)
        if(negative) return -(int)number;
        else return (int)number;
    }
}
