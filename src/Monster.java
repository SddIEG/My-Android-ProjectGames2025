import java.util.Random;
import java.util.Scanner;

public class Monster {
    private String image = "\uD83D\uDC80";
    private  int x, y;
    Random r = new Random();

    Monster(int sizeBoard){
        this.y = r.nextInt(sizeBoard - 1);
        this.x = r.nextInt(sizeBoard);
    }

    public String getImage() {
        return image;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean conflictPerson(int personX, int personY){
        return personY - 1 == this.y && personX - 1 == this.x;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean taskMonster(int difficultGame){
        System.out.println("Вот твоя задача:");
        int x = r.nextInt(100);
        int y = r.nextInt(100);
        int trueAnswer = x + y;
        System.out.println("Вот: " + x + " + " + y + " = ?");
        Scanner s = new Scanner(System.in);
        int ans = s.nextInt();
        if (trueAnswer == ans) {
            System.out.println("Ты молодец,ладно ты победил эту битву.");
            return true;
        }
        System.out.println("Ты слишком слаб,ты мне не ровня)");
        return false;
    }
}