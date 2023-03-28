package org.example.tema5;

public class ClassCastException extends Exception {
    public ClassCastException(Exception ex) {
        super("Argumentul nu este tipul Catalog", ex);
    }
}
