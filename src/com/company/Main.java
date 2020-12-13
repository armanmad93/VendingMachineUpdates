package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Command command = new Command(scanner.nextLine());
        VendingMachine vendingMachine = new VendingMachine();

        System.out.println(vendingMachine.getProducts(command));

    }
}
