package org.algorithms.palindrome;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTest {

    @ParameterizedTest
    @ValueSource(strings = {"aabb", "aba", "affa", "abb"})
    void canBePalindromeTest(String input) {
        Palindrome palindrome = new Palindrome();
        assertTrue(palindrome.canBePalindrome(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaarrrffff", "ab", "aabcdd"})
    void canNotBePalindromeTest(String input) {
        Palindrome palindrome = new Palindrome();
        assertFalse(palindrome.canBePalindrome(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aabfbaa", "aba", "afaaafa", "abba"})
    void isPalindromeTest(String input) {
        Palindrome palindrome = new Palindrome();
        assertTrue(palindrome.isPalindrome(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaarrrffff", "ab", "aabcdd", "aaddbc"})
    void isNotPalindromeTest(String input) {
        Palindrome palindrome = new Palindrome();
        assertFalse(palindrome.isPalindrome(input));
    }
}
