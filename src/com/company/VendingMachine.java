package com.company;

import com.company.Models.Chips.Doritos;
import com.company.Models.Chips.Lays;
import com.company.Models.Chips.Pringels;
import com.company.Models.Drinks.CocaCola;
import com.company.Models.Drinks.Fanta;
import com.company.Models.Drinks.Sprite;
import com.company.Models.Product;
import com.company.Models.Sweets.Bounty;
import com.company.Models.Sweets.Mars;
import com.company.Models.Sweets.Snickers;

import java.util.*;

public class VendingMachine {

    private HashMap<String, List<Queue<Product>>> board;

    public Queue<Product> getProducts(Command command) {
        board = new HashMap<>();
        initilazeBoard(board);

        if (command.getRow().equals("A")) {

            return getProductFromBoard(board.get("A"), command.getCount(), command.getColumn());

        } else if (command.getRow().equals("B")) {

            return getProductFromBoard(board.get("B"), command.getCount(), command.getColumn());

        } else if (command.getRow().equals("C")) {

            return getProductFromBoard(board.get("C"), command.getCount(), command.getColumn());

        }

        return null;
    }

    private Queue<Product> getProductFromBoard(List<Queue<Product>> board, int count, int column) {

        if (column <= board.size()) {
            if (board.get(column - 1).size() >= count) {
                System.out.println("VendingMachine balance: " + (board.get(column - 1).size() - count));

                Queue<Product> getProduct = new LinkedList<>();

                for (int i = 0; i < count; i++) {
                    board.get(column - 1).poll();
                    getProduct.add(board.get(column - 1).peek());
                }

                return getProduct;
            }
        }

        return null;
    }

    private void initilazeBoard(HashMap<String, List<Queue<Product>>> board) {
        List<Queue<Product>> allChips = initializeChips();
        List<Queue<Product>> allDrinks = initializeDrinks();
        List<Queue<Product>> allSweets = initializeSweets();

        board.put("A", allChips);
        board.put("B", allDrinks);
        board.put("C", allSweets);

    }

    private List<Queue<Product>> initializeSweets() {
        Queue<Product> snickers = new LinkedList<>();
        Queue<Product> mars = new LinkedList<>();
        Queue<Product> bounty = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            snickers.add(new Snickers());
            mars.add(new Mars());
            bounty.add(new Bounty());
        }

        ArrayList<Queue<Product>> allSweets = new ArrayList<>();

        allSweets.add(0, snickers);
        allSweets.add(1, mars);
        allSweets.add(2, bounty);

        return allSweets;

    }

    private List<Queue<Product>> initializeDrinks() {
        Queue<Product> cocaCola = new LinkedList<>();
        Queue<Product> fanta = new LinkedList<>();
        Queue<Product> sprite = new LinkedList<>();

        ArrayList<Queue<Product>> allProductsInRow = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            cocaCola.add(new CocaCola());
            fanta.add(new Fanta());
            sprite.add(new Sprite());
        }

        allProductsInRow.add(0, cocaCola);
        allProductsInRow.add(1, fanta);
        allProductsInRow.add(2, sprite);

        return allProductsInRow;

    }

    private List<Queue<Product>> initializeChips() {
        Queue<Product> layses = new LinkedList<>();
        Queue<Product> doritos = new LinkedList<>();
        Queue<Product> pringales = new LinkedList<>();

        ArrayList<Queue<Product>> allProductsInRow = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            layses.add(new Lays());
            doritos.add((new Doritos()));
            pringales.add(new Pringels());
        }

        allProductsInRow.add(0, layses);
        allProductsInRow.add(1, doritos);
        allProductsInRow.add(2, pringales);

        return allProductsInRow;
    }

    public HashMap<String, List<Queue<Product>>> getBoard() {
        return board;
    }

    public void setBoard(HashMap<String, List<Queue<Product>>> board) {
        this.board = board;
    }
}
