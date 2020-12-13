package com.company;

public class Command {
    private String row;
    private int column;
    private int count;

    public Command(String input) {

        String[] array = input.split(":");
        row = array[0];
        column = Integer.parseInt(array[1]);
        count = Integer.parseInt(array[2]);
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
