package org.example;

public class Dev {
    private Computer com;

    public void setCom(Computer com) {
        this.com = com;
    }

    public void build() {
        System.out.println("Working on Spring project!");
        com.compile();
    }

}
