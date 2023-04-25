package org.example.tema7;
public class Token {
    private final int number;

    public Token(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Token{" +
                "number=" + number +
                '}';
    }
}
