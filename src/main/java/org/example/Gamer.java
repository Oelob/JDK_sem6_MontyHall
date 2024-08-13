package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Getter
@ToString
public class Gamer {

    private final long id;
    private String name;


    /**
     * Метод первого выбора игрока
     * @param doors
     * @return
     */
    public int firstDoorChoosing(List<Door> doors){
        int result = new Random().nextInt(1,3);
        for (Door door : doors) {
            if (door.getDoorNumber() == result){
                door.setDoorIsChoosen(true);
            }
        }
        return result;
    }
    /**
     * Метод выбора игрока после удаления одной двери
     */
    public int secondDoorChoosing(List<Door> doors){
        int result = 0;

        return result;
    }
}
