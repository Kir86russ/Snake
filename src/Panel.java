import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {

    private Field field;
    private Snake snake;
    private Image dirt, block, snakeImg, yagodka;

    Panel() {
        field = new Field();
        snake = new Snake(field);

        setFocusable(true);
        try {
            dirt = ImageIO.read(new File("resource/dirt.png"));
            block = ImageIO.read(new File("resource/block.jpg"));
            snakeImg = ImageIO.read(new File("resource/snake.png"));
            yagodka = ImageIO.read(new File("resource/yagodka.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        KeyListener keyListener = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    snake.right();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    snake.left();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    snake.up();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    snake.down();
                }
            }
        };
        addKeyListener(keyListener);
        ActionListener timeListener = e -> {
            if (!snake.isCrash()) snake.move();
            repaint();
        };

        Timer timer = new Timer(100, timeListener);
        timer.start();

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(dirt, 0, 0, null);
        g2d.setColor(Color.white);
        g2d.setFont(new Font("Calibry", Font.BOLD, 30));
        g2d.drawString(String.valueOf(snake.getScore()), 285, 50);
        if (!snake.isCrash()) {
            for (int i = 0; i < Field.SIZE; i++) {
                for (int j = 0; j < Field.SIZE; j++) {
                    switch (field.getCell(i, j)) {
                        case 1:
                            g2d.drawImage(block, i * 15, j * 15, null);
                            break;
                        case 2:
                            g2d.drawImage(yagodka, i * 15, j * 15, null);
                            break;
                        case 3:
                            g2d.drawImage(snakeImg, i * 15, j * 15, null);
                            break;

                    }
                }
            }
        } else {
            g2d.setFont(new Font("Colibry", Font.BOLD, 50));
            g2d.drawString("Game Over", 160, 200);
            g2d.setFont(new Font("Colibry", Font.BOLD, 30));
            g2d.drawString("you score: " + snake.getScore(), 200, 300);
        }
    }
}


