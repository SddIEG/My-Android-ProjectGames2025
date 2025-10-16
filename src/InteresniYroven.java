import java.util.Random;
import java.util.Scanner;

public class TestBonys {

    public static void main(String[] args) {
        System.out.println("БОООНУС");
        int plus=0,minus=0;
        int dif = 2;
        Random r = new Random();
        int chans = r.nextInt(dif+1) - dif;

        if (chans == 0) {
            System.out.println("DFGHJKLMNPQRSTUVWXYZ");

        }else {
            System.out.println("@#$%^");
        }

        String[] bon = {"\uD83D\uDCA9", "❤\uFE0F", "\uD83C\uDF1D"};

        System.out.println("Ты можешь крутить или нет .Если повезёт то я подарю тебе одну жизнь)"
                + "\n Просто скажи Да или Нет");
        Scanner s = new Scanner(System.in);
        String ans = s.next();
        String one, two, three;



        for (int i = 0; i < 10; i++) {
            one = bon[r.nextInt(bon.length)];
            two = bon[r.nextInt(bon.length)];
            three = bon[r.nextInt(bon.length)];
            System.out.println(one + "|" + two + "|" + three);
            if (one == two && one == three) {
                System.out.println("Ура");
                plus++;
            } else {
                System.out.println("Увы");
                minus++;
            }
        }
        System.out.println("Ура ="+plus+" Мдэээ ="+minus);
    }

}
