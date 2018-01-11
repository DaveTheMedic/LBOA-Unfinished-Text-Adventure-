/*
Made by: David Krismer
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Main extends JFrame implements ActionListener {

    JButton start;
    JPanel panel;

    public static void main(String[] Args) {
        Main frame = new Main();
        frame.setVisible(true);
        frame.setSize(800, 900);
        frame.setResizable(false);
        frame.createWindow();
    }

    private void createWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        start = new JButton("*Start*");
        start.addActionListener(this);
        window.add(start);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(800, 800));
        panel.setBackground(Color.black);
        window.add(panel);
    }

    private void updateText(int size, int spacing, int line, int delay, String s, Color color, Boolean shake, Boolean centered, Boolean instant, Boolean fade) {
        Random r = new Random();
        Graphics g = panel.getGraphics();
        int x = 50, y;
        switch (line) {
            case 1:
                y = 100;
                break;
            case 2:
                y = 200;
                break;
            case 3:
                y = 300;
                break;
            case 4:
                y = 400;
                break;
            case 5:
                y = 500;
                break;
            case 6:
                y = 600;
                break;
            case 7:
                y = 700;
                break;
            case 8:
                y = 800;
                break;
            default:
                y = 0;
                break;
        }

        s = s.toUpperCase();
        String[] a1 = s.split("");
        int toCenter;
        int pSize;
        pSize = size * 72 / 96;
        toCenter = (a1.length * pSize);
        toCenter = toCenter / 2;
        g.setFont(new Font("TimesRoman", Font.PLAIN, pSize));
        if (!instant && !fade) {
            if (centered) {
                x = 400 - toCenter;
                for (int i = 0; i < a1.length; i++) {
                    delay(delay);
                    g.setColor(color);
                    if (!shake) {
                        g.drawString(a1[i], x, y);
                    } else if (shake) {
                        g.drawString(a1[i], x + (r.nextInt(spacing / 2) - spacing), y + (r.nextInt(spacing / 2) - spacing));
                    }
                    x += spacing;
                }
            } else if (!centered) {
                for (int i = 0; i < a1.length; i++) {
                    delay(delay);
                    g.setColor(color);
                    if (!shake) {
                        g.drawString(a1[i], x, y);
                    } else if (shake) {
                        g.drawString(a1[i], x + (r.nextInt(spacing / 2) - spacing), y + (r.nextInt(spacing / 2) - spacing));
                    }
                    x += spacing;
                }
            }
        } else if (instant) {
            if (centered) {
                x = 400 - (g.getFontMetrics().stringWidth(s) / 2);
                delay(delay);
                g.setColor(color);
                if (!shake) {
                    g.drawString(s, x, y);
                } else if (shake) {
                    g.drawString(s, x + (r.nextInt(spacing / 2) - spacing), y + (r.nextInt(spacing / 2) - spacing));
                }
                x += spacing;
            } else if (!centered) {
                delay(delay);
                g.setColor(color);
                if (!shake) {
                    g.drawString(s, x, y);
                } else if (shake) {
                    g.drawString(s, x + (r.nextInt(spacing / 2) - spacing), y + (r.nextInt(spacing / 2) - spacing));
                }
                x += spacing;
            }
        } else if (fade) {
            if (centered) {
                x = 400 - (g.getFontMetrics().stringWidth(s) / 2);

                g.setColor(Color.black);
                for (int c = 0; c <= 255; c++) {
                    delay(delay);
                    g.setColor(new Color(c, c, c));
                    if (!shake) {
                        g.drawString(s, x, y);
                    } else if (shake) {
                        g.drawString(s, x + (r.nextInt(spacing / 2) - spacing), y + (r.nextInt(spacing / 2) - spacing));
                    }
                }
                x += spacing;
            } else if (!centered) {

                g.setColor(color);
                for (int c = 0; c <= 255; c++) {
                    delay(delay);
                    g.setColor(new Color(c, c, c));
                    if (!shake) {
                        g.drawString(s, x, y);
                    } else if (shake) {
                        g.drawString(s, x + (r.nextInt(spacing / 2) - spacing), y + (r.nextInt(spacing / 2) - spacing));
                    }
                }
                x += spacing;
            }
        }
    }

    private void lightning(int fade) {
        Graphics g = panel.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 800);
        delay(200);
        for (int i = 255; i >= 0; i--) {
            g.setColor(new Color(i, i, i));
            g.fillRect(0, 0, 800, 800);
            delay(fade);
        }
    }

    private void clear() {
        Graphics g = panel.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 800);
    }

    private void delay(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameRuntime();
    }
    
    public void printTitle(){
        Graphics g = panel.getGraphics();
        String s = "The Last Breath of Atlantis";
        
        g.setFont(new Font("TimesRoman", Font.ITALIC, 40));
        int l = (g.getFontMetrics().stringWidth(s) / 2);
        for(int c = 0; c <= 255; c++){
            g.setColor(new Color(0,0,c));
            g.drawString(s, 400 - l, 400);
            delay(80);
        }
    }

    private void gameRuntime() {
        updateText(30, 20, 1, 100, "You were alone.", Color.WHITE, false, false, false, false);
        delay(1000);
        updateText(30, 20, 2, 100, "That was your simple existance.", Color.WHITE, false, false, false, false);
        delay(1000);
        updateText(35, 20, 3, 300, "Until...", Color.WHITE, false, false, false, false);
        delay(3000);
        lightning(30);
        delay(500);
        updateText(30, 20, 4, 100, "The world came alive.", Color.WHITE, false, true, false, false);
        delay(800);
        lightning(10);
        printTitle();
        //updateText(45, 20, 4, 100, "The Last Breath of Atlantis.", Color.BLUE, false, true, false, true);
    }
}
