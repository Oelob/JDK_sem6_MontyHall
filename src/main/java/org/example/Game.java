package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Game {
    private int doorChoosen;
    private int random = new Random().nextInt(1,3);

    /**
     * Процесс игры
     */
    public void gameRun(){
        //первый этап: создание игрока, дверей, первый выбор игрока
        Gamer gamer1 = new Gamer(1, "Igor");
        System.out.println("Игра началась, игрок должен выбрать дверь!");
        List<Door> doorsForGame = doors();
        doorChoosen = gamer1.firstDoorChoosing(doorsForGame);
        System.out.println("Игрок " + gamer1.getName() + " выбрал дверь номер " + doorChoosen);
        System.out.println(doorsForGame);
        System.out.println("Есть ли приз за дверью: " + doorsForGame.get(doorChoosen-1).isHasPrize());

        //второй этап: удаление одной двери, повторный выбор участника, результат
        System.out.println("---------------------");
        System.out.println("Время ведущему убрать одну дверь!");
        chooseAndRemoveDoor(doorsForGame);
        System.out.println("Дорогой, " + gamer1.getName() + " вы хотите поменять свой выбор?");


    }

    /**
     * Метод создания трех дверей для игры
     * @return
     */
    private List<Door> doors (){
        List<Door> result;
        result = new ArrayList<>(Arrays.asList(new Door(1),
                new Door(2),
                new Door(3)));
        return hidingPrize(result);
    }

    /**
     * Метод для назначения выйгрышной двери
     * @param doors
     * @return
     */
    private List<Door> hidingPrize(List<Door> doors){
        int doorWithPrize = random;
        for (Door door : doors) {
            if (door.getDoorNumber()==doorWithPrize){
                door.setHasPrize(true);
            }
        }
        return doors;
    }
    /**
     * Метод выбора и удаления одной двери
     */
    private List<Door> chooseAndRemoveDoor(List<Door> doors){
        for (Door door : doors) {
            if(door.isHasPrize()==false){
                doors.remove(door);
            }
        }
        return doors;
    }





}
