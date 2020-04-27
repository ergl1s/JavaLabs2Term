package bsu.rfe.java.group7.lab6.Bibikov.varA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Field extends JPanel {

    private boolean paused;
    private boolean taskPause;
    private ArrayList<BouncingBall> balls = new ArrayList<BouncingBall>(10);


    private Timer repaintTimer = new Timer(10, new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
            repaint();
        }
    });

    public Field() {
        setBackground(Color.WHITE);
        repaintTimer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D canvas = (Graphics2D) g;
        for (BouncingBall ball: balls) {
            ball.paint(canvas);
        }
    }

    public void addBall() {
        balls.add(new BouncingBall(this));
    }

    public synchronized void pause() {
        paused = true;
    }
    public synchronized void taskPause() {
        notifyAll();
        taskPause = true;
        paused = false;
    }

    public synchronized void resume() {
        paused = false;
        taskPause = false;
        notifyAll();
    }

    public synchronized void canMove(BouncingBall ball) throws InterruptedException {
        if (paused) {
            wait();
        }
        if (taskPause) {
            if(ball.getMark()) {
                wait();
            }
        }
    }
}