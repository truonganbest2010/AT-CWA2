package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import controller.DrawingEventListener;

public class DrawingPanel {

    private JFrame window;
    private DrawingCanvas canvas;
    private ColorGrid colorGrid;

    private JRadioButton redBtn, greenBtn, blueBtn, yellowBtn, blackBtn;
    private JRadioButton pencilBtn, lineBtn, ovalBtn, circleBtn, rectangleBtn, squareBtn;
    private JButton clearBtn, exitBtn;
    private Color color;

    private JLabel XYStatus = new JLabel();
    private JLabel mouseStatus = new JLabel();

    public DrawingPanel(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container container = window.getContentPane();
        window.setTitle("Drawing Simulator");

        /* RIGHT */
            JPanel rightPanel = new JPanel();
            container.add(BorderLayout.EAST, rightPanel);
            rightPanel.setLayout(new GridLayout(3, 1)); // 3 row 1 col

            /* Colors */
            blueBtn = new JRadioButton("B");
            redBtn = new JRadioButton("R");
            greenBtn = new JRadioButton("G");
            yellowBtn = new JRadioButton("Y");
            blackBtn = new JRadioButton("Default");
                blackBtn.setSelected(true);
            ButtonGroup colorGroup = new ButtonGroup(); // group color buttons
            colorGroup.add(redBtn);
            colorGroup.add(greenBtn);
            colorGroup.add(blueBtn);
            colorGroup.add(yellowBtn);
            colorGroup.add(blackBtn);
            

            JPanel colorPanel = new JPanel();
            colorPanel.setLayout(new GridLayout(5,1));
            TitledBorder colorBoxTitle = BorderFactory.createTitledBorder("Main Color");
            colorPanel.setBorder(colorBoxTitle);
            colorPanel.setBackground(Color.lightGray);
            colorPanel.add(redBtn);
            colorPanel.add(greenBtn);
            colorPanel.add(blueBtn);
            colorPanel.add(yellowBtn);
            colorPanel.add(blackBtn);
            
            rightPanel.add(colorPanel);

            /* Shape Options */
            pencilBtn = new JRadioButton("Pencil");
                pencilBtn.setSelected(true);
            lineBtn = new JRadioButton("Line");
            ovalBtn = new JRadioButton("Oval");
            circleBtn = new JRadioButton("Circle");
            rectangleBtn = new JRadioButton("Rectangle");
            squareBtn = new JRadioButton("Square");
            ButtonGroup shapeBtnGroup = new ButtonGroup();
            shapeBtnGroup.add(pencilBtn);
            shapeBtnGroup.add(lineBtn);
            shapeBtnGroup.add(ovalBtn);
            shapeBtnGroup.add(circleBtn);
            shapeBtnGroup.add(rectangleBtn);
            shapeBtnGroup.add(squareBtn);

            JPanel shapePanel = new JPanel();
            shapePanel.setLayout(new GridLayout(5,1));
            TitledBorder shapeBoxTitle = BorderFactory.createTitledBorder("Shape Options");
            shapePanel.setBorder(shapeBoxTitle);
            shapePanel.setBackground(Color.LIGHT_GRAY);
            shapePanel.add(pencilBtn);
            shapePanel.add(lineBtn);
            shapePanel.add(ovalBtn);
            shapePanel.add(circleBtn);
            shapePanel.add(rectangleBtn);
            shapePanel.add(squareBtn);
            
            rightPanel.add(shapePanel);


            /* Control Buttons */
            clearBtn = new JButton("Clear");
            exitBtn = new JButton("Exit");

            JPanel controlPanel = new JPanel();
            TitledBorder controlBoxTitle = BorderFactory.createTitledBorder("Control Box");
            controlPanel.setBorder(controlBoxTitle);
            controlPanel.add(clearBtn);
            controlPanel.add(exitBtn);
            rightPanel.add(controlPanel);

        /* CENTER */

                /* Canvas */
        canvas = new DrawingCanvas(this);
        JPanel canvasPanel = new JPanel();
        TitledBorder canvasTitle = BorderFactory.createTitledBorder("Drawing Here");
        canvasPanel.setBorder(canvasTitle);
        canvasPanel.setBackground(Color.LIGHT_GRAY);
        canvasPanel.add(canvas);
        container.add(BorderLayout.CENTER, canvasPanel);

        /* WEST */

                /* Color Grid */

        colorGrid = new ColorGrid(this,20, 10, 10);
        JPanel colorGridPanel = new JPanel();
        colorGridPanel.setLayout(new GridLayout(2,1));
        TitledBorder colorGridTitle = BorderFactory.createTitledBorder("Color Generator");
        colorGridPanel.setBorder(colorGridTitle);
        colorGridPanel.setBackground(Color.LIGHT_GRAY);
        
                /* Current Color */

        colorGridPanel.add(colorGrid);
        container.add(BorderLayout.WEST, colorGridPanel);



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
            yellowBtn.addActionListener(eventListener);
            blackBtn.addActionListener(eventListener);

            // shape
            pencilBtn.addActionListener(eventListener);
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

    public ColorGrid getColorGrid(){
        return colorGrid;
    }

    public Color setColor(Color color){
        return this.color = color;
    }

    public Color getColor(){
        return color;
    }

    // Color Getters
    public JRadioButton getRedBtn(){
        return redBtn;
    }

    public JRadioButton getGreenBtn(){
        return greenBtn;
    }

    public JRadioButton getBlueBtn(){
        return blueBtn;
    }

    public JRadioButton getYellowBtn(){
        return yellowBtn;
    }

    public JRadioButton getBlackBtn(){
        return blackBtn;
    }


    // Shape Getters
    public JRadioButton getPencilBtn(){
        return pencilBtn;
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

    // Control Getters
    public JButton getClearBtn(){
        return clearBtn;
    }

    public JButton getExitBtn(){
        return exitBtn;
    }

    // Label Getters
    public JLabel setXYStatuslbl(){
        return XYStatus;
    }

    public JLabel setMouseStatuslbl(){
        return mouseStatus;
    }

}