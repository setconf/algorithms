package org.algorithms.palindrome;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Palindrome {

    /*
     * Checks if a word can be a palindrome if we swapped characters position in it
     * */
    public boolean canBePalindrome(String word) {
        final int initialCharCount = 1;
        Map<Character, Integer> stats = new HashMap<>();
        for (char aChar : word.toCharArray()) {
            stats.computeIfPresent(aChar, (k, v) -> ++v);
            stats.putIfAbsent(aChar, initialCharCount);
        }
        return stats.values().stream().filter(v -> v % 2 > 0).count() < 2;
    }

    /*
     * Checks if a word is a palindrome
     * */
    public boolean isPalindrome(String word) {
        char[] chars = word.toCharArray();
        int head = 0;
        int tail = chars.length - 1;
        while (head < tail) {
            if (chars[head] - chars[tail] != 0) return false;
            head++;
            tail--;
        }
        return true;
    }
}
