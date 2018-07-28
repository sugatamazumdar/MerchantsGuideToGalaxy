package com.merchants.guide.to.galaxy.roman;

public enum Roman {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
    private final int value;
    private Roman(int value) {
        this.value = value;
    }
    public int toInt() {
        return value;
    }
}
