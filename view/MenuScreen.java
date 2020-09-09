package view;

import java.awt.*;
import javax.swing.*;

public class MenuScreen {
    
    private JFrame window;

    public MenuScreen(JFrame window){
        this.window = window;
    }

    public void init(){
        Container container = window.getContentPane();
        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(400, 200));
        menuPanel.setLayout(new GridLayout(2, 1));
        container.add(BorderLayout.CENTER, menuPanel);

        var drawingButton = new JButton("Drawing Simulator");
        menuPanel.add(drawingButton);

        drawingButton.addActionListener(e -> {
            window.getContentPane().removeAll();
            var panel = new DrawingPanel(window);
            panel.init();
            window.pack();
            window.revalidate();
        });
    }
}