package view;

import java.awt.*;
import java.net.http.WebSocket.Listener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import controller.DrawingEventListener;

public class DrawingPanel {

    private JFrame window;
    private DrawingCanvas canvas = new DrawingCanvas(this);
    private ColorGrid colorGrid = new ColorGrid(this, 10, 10, 20);
    private CurrentColor currentColor = new CurrentColor(this, 20);
    private ColorSetShow colorSetShow = new ColorSetShow(150);


    private ButtonGroup colorGroup = new ButtonGroup();
    private JRadioButton redBtn, greenBtn, blueBtn, yellowBtn, blackBtn;
    private JRadioButton pencilBtn, lineBtn, ovalBtn, circleBtn, rectangleBtn, squareBtn;
    private JRadioButton noneBtn, fillBtn, transparentBtn;
    private JButton clearBtn, exitBtn, generateBtn;
    private ButtonGroup fillGroup;
    private Color color = Color.black;

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
        rightPanel.setLayout(new GridLayout(4, 1)); // 3 row 1 col

            /* Colors */
            blueBtn = new JRadioButton("B");
            redBtn = new JRadioButton("R");
            greenBtn = new JRadioButton("G");
            yellowBtn = new JRadioButton("Y");
            blackBtn = new JRadioButton("Default (Black)");
                blackBtn.setSelected(true);
            // group color buttons
            colorGroup.add(redBtn);
            colorGroup.add(greenBtn);
            colorGroup.add(blueBtn);
            colorGroup.add(yellowBtn);
            colorGroup.add(blackBtn);
            
            /* Color Panel */
            JPanel colorPanel = new JPanel();
            colorPanel.setLayout(new GridLayout(2,1));
            TitledBorder colorBoxTitle = BorderFactory.createTitledBorder("Main Color");
            colorPanel.setBorder(colorBoxTitle);
            colorPanel.setBackground(Color.lightGray);
                colorPanel.add(redBtn);
                colorPanel.add(greenBtn);
                colorPanel.add(blueBtn);
                colorPanel.add(yellowBtn);
                colorPanel.add(blackBtn);
            
        rightPanel.add(colorPanel);

            /* Current Color Set */
            
            JPanel colorSetPanel = new JPanel();
            TitledBorder currentColorSetTitle = BorderFactory.createTitledBorder("Present Color");
            colorSetPanel.setBorder(currentColorSetTitle);
            colorSetPanel.add(colorSetShow);
        rightPanel.add(colorSetPanel);

            /* Shape Options */
            pencilBtn = new JRadioButton("Pencil");
                pencilBtn.setSelected(true);
            lineBtn = new JRadioButton("Line");
            ovalBtn = new JRadioButton("Oval");
            circleBtn = new JRadioButton("Circle");
            rectangleBtn = new JRadioButton("Rectangle");
            squareBtn = new JRadioButton("Square");
            var shapeBtnGroup = new ButtonGroup();
            shapeBtnGroup.add(pencilBtn);
            shapeBtnGroup.add(lineBtn);
            shapeBtnGroup.add(ovalBtn);
            shapeBtnGroup.add(circleBtn);
            shapeBtnGroup.add(rectangleBtn);
            shapeBtnGroup.add(squareBtn);

            JPanel shapePanel = new JPanel();
            shapePanel.setLayout(new GridLayout(2,1));
            TitledBorder shapeBoxTitle = BorderFactory.createTitledBorder("Shape Options");
            shapePanel.setBorder(shapeBoxTitle);
            shapePanel.setBackground(Color.LIGHT_GRAY);
                JPanel sPanel = new JPanel();
                sPanel.setLayout(new GridLayout(2,1));
                sPanel.setBackground(Color.LIGHT_GRAY);
                sPanel.add(pencilBtn);
                sPanel.add(lineBtn);
                sPanel.add(ovalBtn);
                sPanel.add(circleBtn);
                sPanel.add(rectangleBtn);
                sPanel.add(squareBtn);
            shapePanel.add(sPanel);
                JPanel fillPanel = new JPanel();
                fillPanel.setLayout(new GridLayout(1,2));
                TitledBorder fillTitle = BorderFactory.createTitledBorder("Fill Options");
                fillPanel.setBorder(fillTitle);
                fillPanel.setBackground(Color.LIGHT_GRAY);
                noneBtn = new JRadioButton("None");
                    noneBtn.setSelected(true);
                fillBtn = new JRadioButton("Fill");
                    fillBtn.setEnabled(false);
                transparentBtn = new JRadioButton("Transparent");
                    transparentBtn.setEnabled(false);
                fillGroup = new ButtonGroup();
                fillGroup.add(noneBtn);
                fillGroup.add(fillBtn);
                fillGroup.add(transparentBtn);
                fillPanel.add(noneBtn);
                fillPanel.add(fillBtn);
                fillPanel.add(transparentBtn);
            shapePanel.add(fillPanel);
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
        JPanel canvasPanel = new JPanel();
        TitledBorder canvasTitle = BorderFactory.createTitledBorder("Drawing Simulator");
        canvasPanel.setBorder(canvasTitle);
        canvasPanel.setBackground(Color.LIGHT_GRAY);
        container.add(BorderLayout.CENTER, canvasPanel);   
        canvasPanel.add(canvas);

        /* WEST */

        JPanel colorGeneratorPanel = new JPanel();
        colorGeneratorPanel.setLayout(new GridLayout(3,1));
        TitledBorder colorGridTitle = BorderFactory.createTitledBorder("Color Generator");
        colorGeneratorPanel.setBorder(colorGridTitle);
        colorGeneratorPanel.setBackground(Color.LIGHT_GRAY);
        container.add(BorderLayout.WEST, colorGeneratorPanel);
                
            /* Color Grid */    
        colorGeneratorPanel.add(colorGrid);

            /* Current Color */ 
            JPanel currentColorPanel = new JPanel();
            currentColorPanel.setLayout(new GridLayout(2,1));
            TitledBorder currentColorTitle = BorderFactory.createTitledBorder("Recent Colors");
            currentColorPanel.setBorder(currentColorTitle);
            currentColorPanel.setBackground(Color.LIGHT_GRAY);
            currentColorPanel.add(currentColor);
            
            /* Generate Button */
            generateBtn = new JButton("Generate Colors");
            currentColorPanel.add(generateBtn);

        colorGeneratorPanel.add(currentColorPanel);

        /* SOUTH */
        JPanel southPanel = new JPanel();
        container.add(BorderLayout.SOUTH, southPanel);
        southPanel.setLayout(new GridLayout(1, 2));

        JPanel pixelPanel = new JPanel();
        TitledBorder pixelTitle = BorderFactory.createTitledBorder("Pixels");
        pixelPanel.setBorder(pixelTitle);
        XYStatus.setText(" ");
        mouseStatus.setText("Ready!");
        pixelPanel.add(XYStatus);
        JPanel mouseStatePanel = new JPanel();
        TitledBorder mouseStateTitle = BorderFactory.createTitledBorder("Status");
        mouseStatePanel.setBorder(mouseStateTitle);
        mouseStatePanel.add(mouseStatus);

        southPanel.add(pixelPanel);
        southPanel.add(mouseStatePanel);

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

            fillBtn.addActionListener(eventListener);
            noneBtn.addActionListener(eventListener);
            transparentBtn.addActionListener(eventListener);

            // control
            generateBtn.addActionListener(eventListener);
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

    public CurrentColor getCurrentColor(){
        return currentColor;
    }

    public ColorSetShow getColorSetShow(){
        return colorSetShow;
    }

    public Color setColor(Color color){
        return this.color = color;
    }

    public Color getColor(){
        return color;
    }

    // Color Getters
    public ButtonGroup getColorGroup(){
        return colorGroup;
    }

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

    public JRadioButton getNoneBtn(){
        return noneBtn;
    }

    public JRadioButton getFillBtn(){
        return fillBtn;
    }

    public JRadioButton getTransparentBtn(){
        return transparentBtn;
    }

    public ButtonGroup getFillGroup(){
        return fillGroup;
    }

    // Control Getters
    public JButton getGenerateBtn(){
        return generateBtn;
    }

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