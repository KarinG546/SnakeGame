import java.awt.*;

public class Snake {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean alive;

    public Snake(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.alive = true;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void paint(Graphics graphics){
            graphics.setColor(Color.MAGENTA);
            graphics.fillOval(x, y, width, height);
    }

    public void moveDown(){
        this.y = y+5;
    }

    public void moveUp(){
        this.y = y-5;
    }

    public void moveRight(){
        this.x = x+5;
    }

    public void moveLeft (){
        this.x = x-5;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
