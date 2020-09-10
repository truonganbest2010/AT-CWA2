package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import controller.DrawingEventListener;

public class DrawingPanel {

    private JFrame window;
    private DrawingCanvas canvas;
    private JRadioButton blueBtn, redBtn, greenBtn;
    private JRadioButton lineBtn, ovalBtn, circleBtn, rectangleBtn, squareBtn;
    private JButton clearBtn, exitBtn;

    private JLabel XYStatus = new JLabel();
    private JLabel mouseStatus = new JLabel();

    public DrawingPanel(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container container = window.getContentPane();
        window.setTitle("Drawing Simulator");

        // RIGHT
            JPanel rightPanel = new JPanel();
            container.add(BorderLayout.EAST, rightPanel);
            rightPanel.setLayout(new GridLayout(3, 1)); // 3 row 1 col

            // Colors
            blueBtn = new JRadioButton("Blue");
            redBtn = new JRadioButton("Red");
            greenBtn = new JRadioButton("Green");
            ButtonGroup colorGroup = new ButtonGroup(); // group color buttons
            colorGroup.add(blueBtn);
            colorGroup.add(redBtn);
            colorGroup.add(greenBtn);

            JPanel colorPanel = new JPanel();
            TitledBorder colorBoxTitle = BorderFactory.createTitledBorder("Color Box");
            colorPanel.setBorder(colorBoxTitle);
            colorPanel.setBackground(Color.lightGray);
            colorPanel.add(blueBtn);
            colorPanel.add(redBtn);
            colorPanel.add(greenBtn);
            
            rightPanel.add(colorPanel);

            // Shape Options
            lineBtn = new JRadioButton("Line");
            ovalBtn = new JRadioButton("Oval");
            circleBtn = new JRadioButton("Circle");
            rectangleBtn = new JRadioButton("Rectangle");
            squareBtn = new JRadioButton("Square");
            ButtonGroup shapeBtnGroup = new ButtonGroup();
            shapeBtnGroup.add(lineBtn);
            shapeBtnGroup.add(ovalBtn);
            shapeBtnGroup.add(circleBtn);
            shapeBtnGroup.add(rectangleBtn);
            shapeBtnGroup.add(squareBtn);

            JPanel shapePanel = new JPanel();
            TitledBorder shapeBoxTitle = BorderFactory.createTitledBorder("Shape Options");
            shapePanel.setBorder(shapeBoxTitle);
            shapePanel.setBackground(Color.LIGHT_GRAY);
            shapePanel.add(lineBtn);
            shapePanel.add(ovalBtn);
            shapePanel.add(circleBtn);
            shapePanel.add(rectangleBtn);
            shapePanel.add(squareBtn);
            
            rightPanel.add(shapePanel);


            // Control Buttons
            clearBtn = new JButton("Clear");
            exitBtn = new JButton("Exit");

            JPanel controlPanel = new JPanel();
            TitledBorder controlBoxTitle = BorderFactory.createTitledBorder("Control Box");
            controlPanel.setBorder(controlBoxTitle);
            controlPanel.add(clearBtn);
            controlPanel.add(exitBtn);
            rightPanel.add(controlPanel);

        // LEFT

        // Canvas
        canvas = new DrawingCanvas(this);
        JPanel canvasPanel = new JPanel();
        TitledBorder canvasTitle = BorderFactory.createTitledBorder("Drawing Here");
        canvasPanel.setBorder(canvasTitle);
        canvasPanel.setBackground(Color.LIGHT_GRAY);
        canvasPanel.add(canvas);
        container.add(BorderLayout.WEST, canvasPanel);

        // SOUTH
        JPanel southPanel = new JPanel();
        container.add(BorderLayout.SOUTH, southPanel);
        southPanel.setLayout(new GridLayout(1, 2));
        TitledBorder pixelTitle = BorderFactory.createTitledBorder("Pixel");
        southPanel.setBorder(pixelTitle);
        southPanel.add(XYStatus);
        southPanel.add(mouseStatus);


        // Event Listener
        DrawingEventListener eventListener = new DrawingEventListener(this);

            // color
            blueBtn.addActionListener(eventListener);
            redBtn.addActionListener(eventListener);
            greenBtn.addActionListener(eventListener);

            // shape
            lineBtn.addActionListener(eventListener);
            ovalBtn.addActionListener(eventListener);
            circleBtn.addActionListener(eventListener);
            rectangleBtn.addActionListener(eventListener);
            squareBtn.addActionListener(eventListener);
            
            // control
            clearBtn.addActionListener(eventListener);
            exitBtn.addActionListener(eventListener);

            // canvas
            canvas.addMouseListener(eventListener);
            canvas.addMouseMotionListener(eventListener);

    }

    public JFrame getWindow(){
        return window;
    }

    public DrawingCanvas getCanvas(){
        return canvas;
    }

    public JRadioButton getBlueBtn(){
        return blueBtn;
    }

    public JRadioButton getRedBtn(){
        return redBtn;
    }

    public JRadioButton getGreenBtn(){
        return greenBtn;
    }

    public JRadioButton getLineBtn(){
        return lineBtn;
    }

    public JRadioButton getOvalBtn(){
        return ovalBtn;
    }

    public JRadioButton getCircleBtn(){
        return circleBtn;
    }

    public JRadioButton getRectangleBtn(){
        return rectangleBtn;
    }

    public JRadioButton getSquareBtn(){
        return squareBtn;
    }

    public JButton getClearBtn(){
        return clearBtn;
    }

    public JButton getExitBtn(){
        return exitBtn;
    }

    public JLabel setXYStatuslbl(){
        return XYStatus;
    }

    public JLabel setMouseStatuslbl(){
        return mouseStatus;
    }

}