
import java.util.Random;

public class BigBigBoss {
    private int x;
    private int y;
    private int sizeBoard;
    private String img = "\uD83D\uDC7E"; 
    Random r = new Random();

    public BigBigBoss(int sizeBoard){
        this.sizeBoard = sizeBoard;
        this.r = new Random();
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

    private void moveUp(){
        if(y>1){
            y--;
        }
    }

    private void moveDown(){
        if(y<sizeBoard){
            y++;
        }
    }

    private void moveLeft(){
        if(x>1){
            x--;
        }
    }

    private void moveRight(){
        if(x<sizeBoard){
            x++;
        }
    }

    public void Step() {
        int hod = r.nextInt(4);
        switch (hod) {
            case 0 -> moveUp();
            case 1 -> moveDown();
            case 2 -> moveLeft();
            case 3 -> moveRight();
        }
    }

    public boolean movePlayer(int playerX, int playerY){
        return this.x == playerX && this.y == playerY;
    }

    public void attackPlayer(Person player) {
        player.endLive();
        System.out.println("Директор заметил вас  и ищет вас. Вы теряете одну жизнь(" + player.getLive());
    }
}
