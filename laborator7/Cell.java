package org.example.laborator7;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<Token> tokens;

    public Cell() {
        tokens = new ArrayList<>();
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "tokens=" + tokens +
                '}';
    }
}
