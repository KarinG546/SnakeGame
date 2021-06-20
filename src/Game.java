import javax.swing.*;

public class Game extends JFrame {

    public static void main(String[] args) {
        new Game();
    }

    public Game(){
        this.setVisible(true);
        this.setSize(Definitions.WINDOW_WIDTH,Definitions.WINDOW_HEIGHT);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Best Snake Game Ever");
        GameScene gameScene = new GameScene();
        gameScene.setBounds(0,0,Definitions.WINDOW_WIDTH,Definitions.WINDOW_HEIGHT);
        this.add(gameScene);
        SnakeMovement snakeMovement = new SnakeMovement(gameScene.getSnake(),gameScene,gameScene.getGraphics());
        this.addKeyListener(snakeMovement);


    }
}
