import javax.swing.*;

public class Frame extends JFrame {
    private static final int WIDTH = 605;       
    private static final int HEIGHT = 635;

    private Frame(String title) {
        super(title);
        setSize(WIDTH, HEIGHT);
        add(new Panel());
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Frame("Snake"));
    }
}


