import javax.swing.JFrame;

import view.DrawingPanel;

public class Main {

    public static void main(String[] args){

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(100, 100);

        var panel = new DrawingPanel(window);;
        panel.init();

        window.pack();
        window.setVisible(true);
    }
}