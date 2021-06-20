import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeMovement implements KeyListener {

    private Snake snake;
    private GameScene gameScene;
    private Graphics graphics;

    public SnakeMovement(Snake snake, GameScene gameScene, Graphics graphics ){
        this.snake = snake;
        this.gameScene = gameScene;
        this.graphics = graphics;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (snake.isAlive()) {
            if (keyCode == KeyEvent.VK_DOWN) {
                snake.moveDown();
            }
            if (keyCode == KeyEvent.VK_UP) {
                snake.moveUp();
            }
            if (keyCode == KeyEvent.VK_LEFT) {
                snake.moveLeft();
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                snake.moveRight();
            }
        }
            if (keyCode == KeyEvent.VK_ENTER) {
                if (this.gameScene.getSceneId() == Definitions.MENU_SCENE) {
                    gameScene.startGame();
                }
            }
        }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
