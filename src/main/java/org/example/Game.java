package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;


public class Game {
    private static int doorChoosen;
    private static int random = new Random().nextInt(1,4);

    /**
     * Процесс игры
     */
    public static void gameRun(){
        //первый этап: создание игрока, дверей, первый выбор игрока
        Gamer gamer1 = new Gamer(1, "Igor");
        System.out.println("Игра началась, игрок должен выбрать дверь!");
        List<Door> doorsForGame = doors();
        doorChoosen = gamer1.firstDoorChoosing(doorsForGame);
        System.out.println("Игрок " + gamer1.getName() + " выбрал дверь номер " + doorChoosen);
        System.out.println(doorsForGame);
        System.out.println("Есть ли приз за дверью: " + doorsForGame.get(--doorChoosen).isHasPrize());

        //второй этап: удаление одной двери, повторный выбор участника, результат
        System.out.println("---------------------");
        System.out.println("Время ведущему убрать одну дверь!");
        chooseAndRemoveDoor(doorsForGame);
        System.out.println(doorsForGame);
        System.out.println("Дорогой, " + gamer1.getName() + " вы хотите поменять свой выбор?");
        gamer1.secondDoorChoosing(doorsForGame);
        System.out.println(doorsForGame);
    }

    /**
     * Метод создания трех дверей для игры
     * @return
     */
    private static List<Door> doors (){
        List<Door> result = new ArrayList<>();
        result.add(new Door(1));
        result.add(new Door(2));
        result.add(new Door(3));
        return hidingPrize(result);
    }

    /**
     * Метод для назначения выйгрышной двери
     * @param doors
     * @return
     */
    private static List<Door> hidingPrize(List<Door> doors){
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
    private static List<Door> chooseAndRemoveDoor(List<Door> doors){
        for (Door door : doors) {
            if(!door.isHasPrize() && !door.isDoorIsChoosen()){
                doors.remove(door);
                return doors;
            }
        }
        return doors;
    }

    public static void cycleMetodRun(){
        for (int i = 0; i < 100; i++) {
            System.out.println("=================ИГРА №"+i+"==========================");
            gameRun();
        }
    }
}
