package org.example;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Door {

    private boolean hasPrize;
    private final int doorNumber;

    public boolean openDoor(int doorNumber){
        return this.hasPrize;
    }
}
