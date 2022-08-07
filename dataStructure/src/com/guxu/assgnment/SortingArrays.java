package com.guxu.assgnment;


import java.util.Arrays;
import java.util.Scanner;

public class SortingArrays {
    private String[][] StateCapitals;

    public SortingArrays () {
        StateCapitals = new String[][]{
                {"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"}, {"Arkansas", "Little Rock"}, {"California", "Sacramento"},
                {"Colorado", "Denver"}, {"Connecticut", "Hartford"}, {"Delaware", "Dover"}, {"Florida", "Tallahassee"}, {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"}, {"Idaho", "Boise"}, {"Illinois", "Springfield"}, {"Indiana", "Indianapolis"}, {"Iowa", "Des Moines"},
                {"Kansas", "Topeka"}, {"Kentucky", "Frankfort"}, {"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"}, {"Maryland", "Annapolis"},
                {"Massachusetts", "Boston"}, {"Michigan", "Lansing"}, {"Minnesota", "Saint Paul"}, {"Mississippi", "Jackson"}, {"Missouri", "Jefferson City"},
                {"Montana", "Helena"}, {"Nebraska", "Lincoln"}, {"Nevada", "Carson City"}, {"New Hampshire", "Concord"}, {"New Jersey", "Trenton"},
                {"New Mexico", "Santa Fe"}, {"New York", "Albany"}, {"North Carolina", "Raleigh"}, {"North Dakota", "Bismarck"}, {"Ohio", "Columbus"},
                {"Oklahoma", "Oklahoma City"}, {"Oregon", "Salem"}, {"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"}, {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"}, {"Tennessee", "Nashville"}, {"Texas", "Austin"}, {"Utah", "Salt Lake City"}, {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"}, {"Washington", "Olympia"}, {"West Virginia", "Charleston"}, {"Wisconsin", "Madison"}, {"Wyoming", "Cheyenne"}
        };
    }

    public String[][] getStateCapitals() {
        return StateCapitals;
    }

    public void printStateCapitals() {
        for (int i = 0; i < StateCapitals.length; i++) {
            System.out.print(Arrays.toString(StateCapitals[i]) + " ");
            if ((i+1) % 5 == 0) System.out.println();
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < StateCapitals.length - 1; i++) {
            for (int j = 0; j < StateCapitals.length  - 1 - i; j++) {
                String curr = StateCapitals[j][1], next = StateCapitals[j+1][1];
                if (curr.compareTo(next) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private void swap(int i, int j) {
        String[] temp = StateCapitals[i];
        StateCapitals[i] = StateCapitals[j];
        StateCapitals[j] = temp;
    }


    public static void main(String[] args) {
        SortingArrays sortingArrays = new SortingArrays();
        System.out.println("The states and capitals are:");
        sortingArrays.printStateCapitals();
        sortingArrays.bubbleSort();
        String[][] StateCapitals = sortingArrays.getStateCapitals();
        System.out.println("Now enter the capital for the shown state,  just type in 'quit', if you want to quit.");
        int answered = 0, correct = 0;
        Scanner scanner = new Scanner(System.in);
        for (String[] strings: StateCapitals) {
            System.out.print("The capital of " + strings[0] + " is: ");
            String typeIn = scanner.next();
            if ("quit".equalsIgnoreCase(typeIn)) break;
            if (strings[1].equalsIgnoreCase(typeIn)) {
                System.out.println("Right!");
                correct++;
            } else {
                System.out.println("Wrong! The correct answer is " + strings[1]);
            }
            answered++;
        }
        System.out.println("You have answered " + answered + " questions. " + correct + " are correct!");

    }

}
