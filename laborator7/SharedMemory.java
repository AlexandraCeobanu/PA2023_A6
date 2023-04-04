package org.example.laborator7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SharedMemory {
    private final List<Token> tokens=new ArrayList<>();
    public SharedMemory(int n) {
        for(int i=0;i<n*n*n;i++)
            tokens.add(new Token(i));
        Collections.shuffle(tokens);
    }
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        Collections.shuffle(tokens);
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            Random rand = new Random();
            extracted.add(tokens.get(rand.nextInt(tokens.size())));
        }
        return  extracted;
    }

}
