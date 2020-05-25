package com.company;


public class Table {
    private String first_column;
    private String second_column;


    public Table(String first_column,String second_column){
        this.first_column = first_column;
        this.second_column = second_column;
    }

    public String getFirst_column() {
        return first_column;
    }

    public void setFirst_column(String first_column) {
        this.first_column = first_column;
    }

    public String getSecond_column() {
        return second_column;
    }

    public void setSecond_column(String second_column) {
        this.second_column = second_column;
    }

}
