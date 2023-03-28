package org.example.tema5;

public class InvalidDocumentException extends Exception {
    public InvalidDocumentException(Exception ex) {
        super("Invalid document file.", ex);
    }
}
