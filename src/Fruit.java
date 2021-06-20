import java.awt.*;

public class Fruit {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;

    public Fruit(int x, int y, int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.visible = true;
    }

   public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void paint(Graphics graphics) {
        if (isVisible()) {
            graphics.setColor(Color.ORANGE);
            graphics.fillRect(x, y, width, height);
        }
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
