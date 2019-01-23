import edu.princeton.cs.algs4.StdDraw;

import javax.swing.*;
import java.awt.*;

public class Draw extends JFrame {
    public Draw() {
        super("Draw");
        Dimension dimension=getToolkit().getScreenSize();
        //获取屏幕分辨率
        setBounds(dimension.width/4,dimension.height/4,dimension.width/2,dimension.height/2);
        StdDraw.point(108,120);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        Draw draw=new Draw();
    }
}

