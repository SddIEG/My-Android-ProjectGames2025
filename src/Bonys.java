

import java.util.Random;
import java.util.Scanner;

public class Bonys {
    private int x;
    private int y;
    private int c;
    private String img = "\uD83D\uDD2E";
    private Random r = new Random();

    public Bonys(int sizeBoard) {
        this.x = r.nextInt(sizeBoard) + 1;
        this.y = r.nextInt(sizeBoard) + 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getImg() {
        return img;
    }

    public boolean conflictPerson(int personX, int personY) {
        return this.x == personX && this.y == personY;
    }

    public boolean kasino(int difficult) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы встречате Торговый автомат. На удивление он оплачен.Может эта шутка?(Вы можете засунуть руку Да/Нет)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Да")) {
            String[] bonuses = {"\uD83D\uDD77\uFE0F", "\uD83C\uDF2F", " "};

            String result = bonuses[r.nextInt(bonuses.length)];
            System.out.println("Вы протягиваете руку " + result);

            if (result.equals("\uD83C\uDF2F")) {
                System.out.println("Опа . Халяву залутал");
                c = 1;
            } else if (result.equals("\uD83D\uDD77\uFE0F")) {
                System.out.println("АААА ПАУУУУК.Мдаа минус одна жизнь(");
                c = 0;

            } else {
                System.out.println("Пусто пусто выросла капуста");
                c = 2;
            }
        } else {
            System.out.println("Вы не стали рисковать, может оно и к лучшему.");
            c = 2;
        }
        return false;
    }

    public int c() {
        return c;
    }
}
