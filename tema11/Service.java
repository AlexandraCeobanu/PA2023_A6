package com.example.laborator11;

@org.springframework.stereotype.Service

public class Service {

    public String printCount(int count) {
        return "Number of players: " + count;
    }

}
