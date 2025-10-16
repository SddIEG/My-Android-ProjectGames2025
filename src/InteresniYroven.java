import java.util.Random;

public class BigBigBoss                    {
    private int x;
    private  int y;
    private int sizeBoard;
    private String img = "";
    Random r = new Random();


    public BigBigBoss(int sizeBoard){
        this.sizeBoard = sizeBoard;
        this.r = new Random();
        this.x = sizeBoard;
        this.y=sizeBoard;
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
    public void Step(){
        int dir = r.nextInt(4);

        switch (dir) {
            case 1 -> moveUp();
            case 2 -> moveDown();
            case 3 -> moveLeft();
            case 4 -> moveRight();

        }
    }



    public boolean movePlayer(int playerX,int playerY){
        return this.x ==playerX && this.y == playerY;
    }


}
