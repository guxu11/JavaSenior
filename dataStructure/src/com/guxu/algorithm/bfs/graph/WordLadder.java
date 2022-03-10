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

    // 双向bfs
    String beginword, endword;
    Set<String> wordlist;
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        this.beginword = beginWord;
        this.endword = endWord;
        wordlist = new HashSet<>(wordList);
        if (!wordlist.contains(endWord)) return 0;
        return bfs();
    }

    private int bfs() {
        Queue<String> queue1 = new LinkedList<>();
        queue1.add(beginword);
        Queue<String> queue2 = new LinkedList<>();
        queue2.add(endword);
        Map<String, Integer> map1 = new HashMap<>();
        map1.put(beginword, 0);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put(endword, 0);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int res = 0;
            if (queue1.size() <= queue2.size()) {
                res = update(queue1, map1, map2);
            } else {
                res = update(queue2, map2, map1);
            }
            if (res != 0) return res;
        }
        return 0;
    }

    private int update(Queue<String> queue, Map<String, Integer> map1, Map<String, Integer> map2) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String s = queue.poll();
            char[] chars = s.toCharArray();
            int n = s.length();
            for (int j = 0; j < n; j++) {
                char c = chars[j];
                for (char k = 'a'; k <= 'z'; k++) {
                    if (k == c) continue;
                    char[] clone = chars.clone();
                    clone[j] = k;
                    String newString = new String(clone);
                    if (map1.containsKey(newString)) continue;
                    if (!wordlist.contains(newString)) continue;
                    if (map2.containsKey(newString)) {
                        return map1.get(s) + 2 + map2.get(newString);
                    } else {
                        queue.add(newString);
                        map1.put(newString, map1.get(s) + 1);
                    }
                }
            }
        }
        return 0;
    }

    @Test
    public void test() {
//        List<String> words = Arrays.asList("a", "b","c");
        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");
        String beginWord = "hit", endWord = "cog";
//        String beginWord = "a", endWord = "c";
//        System.out.println(beginWord.substring(3));
        System.out.println(ladderLength2(beginWord, endWord, words));
    }
}
