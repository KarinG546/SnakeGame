import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameScene extends JPanel {

    private int sceneId;
    private Snake snake;
    private Fruit fruit;
    private Fruit[] fruits;
    private MenuScene menuScene;

    public GameScene(){
        this.setDoubleBuffered(true);
        this.setLayout(null);
        this.snake = new Snake(100,200,25,25);
        this.fruit = new Fruit(300,500,20,20);
        this.fruits = new Fruit[]{fruit};
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
        int counter = 0;
        for(int i=0; i<fruits.length; i++){
            counter++;
        }
        if(counter>=1){
            Fruit[] newFruits = new Fruit[counter+1];
            for (int i=0; i<fruits.length; i++){
                newFruits[i] = fruits[i];
            }
            newFruits[counter] = new Fruit(random.nextInt(Definitions.WINDOW_WIDTH),random.nextInt(Definitions.WINDOW_HEIGHT),20,20);
            this.fruits = newFruits;
        }
    }

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
                    if (collision(fruits)) {
                        System.out.println("collision!!");
                        addANewFruit();

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

    public boolean collision (Fruit[] fruits){
        Rectangle snakeRectangle = snake.getBounds();
        Rectangle firstFruitRectangle = fruit.getBounds();
        boolean firstCollision = snakeRectangle.intersects(firstFruitRectangle);
        for(int i=0; i<fruits.length; i++){
            Rectangle fruitRectangle = fruits[i].getBounds();
            boolean collision = snakeRectangle.intersects(fruitRectangle);
            return collision;
        }
        return firstCollision;
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


