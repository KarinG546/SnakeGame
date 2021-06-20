import javax.swing.*;
import java.awt.*;

public class MenuScene extends JPanel {

    private int sceneId;

    public MenuScene(){
        this.setDoubleBuffered(true);
        this.sceneId = Definitions.MENU_SCENE;
    }

    public void paint(Graphics graphics){
       Graphics2D createGraphics = (Graphics2D) graphics;
       createGraphics.setFont(new Font("Ariel",Font.BOLD,40));
       createGraphics.setPaint(Color.BLACK);
       createGraphics.drawString("Welcome to the best Snake game ever!",125,100);
       createGraphics.drawString("To start game, press enter",250,600);
       createGraphics.dispose();
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }
}
