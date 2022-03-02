package com.guxu.algorithm.bfs.graph;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 127. 单词接龙
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        int m = wordList.size(), n = beginWord.length();
        Set<Character> alphabet = new HashSet<>();
        for(String word: wordList) {
            for (char c: word.toCharArray()) {
                alphabet.add(c);
            }
        }
        int res = 0;
        Deque<String> queue = new LinkedList<>();
        queue.addLast(beginWord);
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String word = queue.poll();
                if (word.equals(endWord)) return ++res;
                if (visited.contains(word)) continue;
                visited.add(word);
                for (int i = 0; i < n; i++) {
                    char c = word.charAt(i);
                    for (char ch : alphabet) {
                        if (ch == c) continue;
                        String newWord = word.substring(0, i) + ch + word.substring(i + 1);
                        if (words.contains(newWord) && !visited.contains(newWord)) {
                            queue.addLast(newWord);
                        }
                    }
                }
            }
            res++;
        }
        return res;
    }

    @Test
    public void test() {
        List<String> words = Arrays.asList("a", "b","c");
//        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");
//        String beginWord = "hit", endWord = "cog";
        String beginWord = "a", endWord = "c";
//        System.out.println(beginWord.substring(3));
        System.out.println(ladderLength(beginWord, endWord, words));
    }
}
