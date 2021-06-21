import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameScene extends JPanel {

    private int sceneId;
    private Snake snake;
    private Fruit fruit;
    private MenuScene menuScene;

    public GameScene(){
        this.setDoubleBuffered(true);
        this.setLayout(null);
        this.snake = new Snake(100,200,25,25);
        this.fruit = new Fruit(300,500,20,20);
        this.menuScene = new MenuScene();
        this.sceneId = Definitions.MENU_SCENE;
        this.mainGameLoop();
    }

    public int startGame(){
        this.sceneId = Definitions.GAME_SCENE;
        return sceneId;
    }

    public void addANewFruit(){
        Random random = new Random();
        Fruit newFruit = new Fruit(random.nextInt(Definitions.WINDOW_WIDTH),random.nextInt(Definitions.WINDOW_HEIGHT),20,20);
        this.fruit = newFruit;
    }

    public boolean collision (){
        Rectangle snakeRectangle = snake.getBounds();
        Rectangle fruitRectangle = fruit.getBounds();
        boolean collision = snakeRectangle.intersects(fruitRectangle);
        return collision;
    }

   /* public void addToSnakesBody (){
        Snake newSnake = new Snake(this.snake.getX()+this.snake.getWidth(),this.snake.getY()+this.snake.getHeight(),
                this.snake.getWidth(),this.snake.getHeight());
        this.snake = newSnake;
    }*/

    public void paint(Graphics graphics){
        super.paint(graphics);
        this.setBackground(Color.GREEN);
        switch (this.sceneId){
            case Definitions.MENU_SCENE:
                this.menuScene.paint(graphics);
                break;
            case Definitions.GAME_SCENE:
                this.snake.paint(graphics);
                this.fruit.paint(graphics);
                break;
        }
    }

    private void mainGameLoop(){
        new Thread(() -> {
            while(true){
                if(collision()){
                    System.out.println("collision!!");
                    addANewFruit();
                    //addToSnakesBody();
                }
                repaint();
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }
}


