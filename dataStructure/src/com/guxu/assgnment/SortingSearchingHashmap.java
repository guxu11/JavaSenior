package com.guxu.assgnment;

import org.testng.annotations.Test;

import java.util.*;

public class SortingSearchingHashmap {
    private Map<String, String> stateCapitalMap;
    public SortingSearchingHashmap() {
        stateCapitalMap = new HashMap<>();
        String[][] stateCaps = new SortingArrays().getStateCapitals();
        for (String[] strings: stateCaps) {
            stateCapitalMap.put(strings[0], strings[1]);
        }
    }

    public Map<String, String> getStateCapitalMap() {
        return stateCapitalMap;
    }

    public void printStateCapitalMap() {
        Iterator<Map.Entry<String, String>> iterator = stateCapitalMap.entrySet().iterator();
        int count = 1;
        System.out.println("{ ");
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.print(entry.getKey() + ": " + entry.getValue() + ", ");
            if (count % 5 == 0) System.out.println();
            count++;
        }
        System.out.println("}");
    }

    public void sortWithTreeMap() {
        stateCapitalMap = new TreeMap<>(stateCapitalMap);
    }

    public BST storeStateCapitalInABST() {
        BST binarySearchTree = new BST();
        for (String key: stateCapitalMap.keySet()) {
            binarySearchTree.insert(key, stateCapitalMap.get(key));
        }
        return binarySearchTree;
    }

    public static void main(String[] args) {
        SortingSearchingHashmap sortingSearchingHashmap = new SortingSearchingHashmap();
        sortingSearchingHashmap.printStateCapitalMap();
        sortingSearchingHashmap.sortWithTreeMap();
        BST bst = sortingSearchingHashmap.storeStateCapitalInABST();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Now enter state, this program will display its capital. just type in 'quit', if you want to quit.");
        while (true) {
            System.out.print("Type in a state: ");
            String state = scanner.nextLine();
            String[] strings = state.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                stringBuilder.append(strings[i].substring(0, 1).toUpperCase()).append(strings[i].substring(1).toLowerCase());
                if (i < strings.length - 1) stringBuilder.append(" ");
            }
            state = stringBuilder.toString();
            if (state.equals("Quit")) {
                break;
            }
            String capital = sortingSearchingHashmap.stateCapitalMap.getOrDefault(state, "Wrong State Name!");
            System.out.println(capital);
        }

    }

    @Test
    public void test() {
        String s = "little";
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i].substring(0, 1).toUpperCase()).append(strings[i].substring(1).toLowerCase());
            if (i < strings.length - 1) stringBuilder.append(" ");
        }
        System.out.println(stringBuilder);
    }
}

class BST {
    class Node {
        String key, value;
        Node leftChild, rightChild;
        public Node(String k, String v){
            this.key = k;
            this.value = v;
            this.leftChild = this.rightChild = null;
        }
        public Node(String k, String v, Node l, Node r) {
            this.key = k;
            this.value = v;
            this.leftChild = l;
            this.rightChild = r;
        }
    }
    Node root;
    private int size;
    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }
    public void insert(String k, String v) {
        root = insertNode(root, k, v);
        size++;
    }
    public Node insertNode (Node node, String k, String v){
        if (node == null){
            node = new Node(k, v);
            return node;
        }
        if (k.compareTo( node.key) <= 0){
            node.leftChild = insertNode(node.leftChild, k, v);
        } else if (k.compareTo(root.key) > 0){
            node.rightChild = insertNode(node.rightChild, k, v);
        }
        return node;
    }
    public Node findNode (Node node, String k){
        if (k.equals( node.key)){
            return node;
        }
        if (k.compareTo(node.key) <= 0){
            return findNode(node.leftChild, k);
        } else if (k.compareTo(node.key) > 0){
            return findNode(node.rightChild, k);
        }
        return null;
    }


}
