public class Palindrome {

    public static boolean isDoublePalindrome (char[] digits)
    {
        // A double palindrome is defined as follows:
        // (1) The string has even length.
        // (2) The string is a palindrome.
        // (3) Each half of the string is also a palindrome.

        // check if the string has even length
        if (digits.length % 2 != 0) {
            return false;
        }

        int lenArr = digits.length;
        int halfLenArr = digits.length / 2;

        for (int i = 0; i < halfLenArr; i++) {
            /*We do not need to traverse the whole array, we can just traverse half of it
             * and mirror the indices to check from the other end of the array
             */
            // check if the string is a palindrome as a whole
            if (digits[i] != digits[lenArr - 1 - i]) {
                return false;
            }

            // check if any of the halves violate the palindrome rule
            if (digits[i] != digits[halfLenArr - 1 - i] || digits[halfLenArr + i] != digits[lenArr - 1 - i]) {
                return false;
            }
        }
        // if none of the above conditions are violated, then the string is a double palindrome
        return true;
    }
}
