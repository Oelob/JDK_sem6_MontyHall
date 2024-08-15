package org.example;

import java.util.*;
public class Game {
    private static List<Door> doorsForGame = new ArrayList<>();//двери для игры
    private static HashMap<Integer, String> statistic = new HashMap<>();//результат игры
    private static String result;//тексторый результат каждой игры
   private static int winsWithChange;//счетчик побед со сменой двери
   private static int winsWithoutChange;//счетчик побед без смены двери
   private static int looseswithChange;//счетчик проигрышей со сменой двери
   private static int looseswithoutChange;//счетчик проигрышей без смены двери


    /**
     * Процесс игры
     */
    public static void gameRun(){//основной метод игры

        //первый этап: создание игрока, дверей, первый выбор игрока
        Gamer gamer1 = new Gamer(1, "Igor", false);
        System.out.println("Игра началась, игрок должен выбрать дверь!");
        doorsForGame = doors();
        int doorChoosen = gamer1.firstDoorChoosing(doorsForGame);
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
        gameOver(gamer1);
        result = ("Сменил ли игрок выбор - "+gamer1.isGamerHasChangedChoice()+" Победил ли игрок - "+gamer1.isHasWin());
        counter(gamer1);
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
        int doorWithPrize = new Random().nextInt(1,4);
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

    /**
     * Метод подсчета побед и поражений
     * @param gamer
     */
    private static void counter(Gamer gamer){
        if (gamer.isGamerHasChangedChoice() && gamer.isHasWin()){
            winsWithChange++;
        } else if (gamer.isGamerHasChangedChoice() == false && gamer.isHasWin()) {
            winsWithoutChange++;
        } else if (gamer.isGamerHasChangedChoice() && gamer.isHasWin() == false) {
            looseswithChange++;
        }else if (gamer.isGamerHasChangedChoice()==false && gamer.isHasWin() == false){
            looseswithoutChange++;
        }
    }

    /**
     * Метод подведения результатов каждой игры
     * @param gamer
     */
    private static void gameOver(Gamer gamer){
        for (Door door : doorsForGame) {
            if (door.isHasPrize() && door.isDoorIsChoosen()){
                System.out.println("Игрок победил!");
                gamer.setHasWin(true);
            }else if(!door.isHasPrize() && door.isDoorIsChoosen()) {
                System.out.println("К сожалению, не удалось! Стоит попробовать еще раз!");
            }
        }
//        gamer.setGamerHasChangedChoice(false);
    }

    /**
     * Метод запуска цикла игр и подсчета статистики с выводом на экран
     */
    public static void cycleMetodRun(){
        for (int i = 1; i < 1001; i++) {
            System.out.println("=================ИГРА №"+i+"==========================");
            gameRun();
            statistic.put(i, result + "\n");
            System.out.println(" ");
        }
        System.out.println(statistic.toString());
        System.out.printf("Количество побед со сменой двери = %d\n" +
                "Количество побед без смены двери = %d\n" +
                "Количество проигрышей со сменой двери = %d\n" +
                "Количество проигрышей без смены двери = %d",
                winsWithChange, winsWithoutChange, looseswithChange, looseswithoutChange);
    }
}
