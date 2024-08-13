package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

import static java.lang.Math.random;

@Getter
@Setter
@ToString
public class Door {


    private boolean hasPrize;
    private final int doorNumber;
    private boolean doorIsChoosen;

    public Door(int doorNumber) {
        this.doorNumber = doorNumber;
        this.hasPrize = false;
        this.doorIsChoosen = false;
    }

    public boolean openDoor(int doorNumber){
        return this.hasPrize;
    }
}
