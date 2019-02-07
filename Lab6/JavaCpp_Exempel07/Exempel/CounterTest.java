import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Counter extends JLabel implements ActionListener {
    private int value, speed;
    public Counter(int value, int speed) {
        this.value = value;
        this.speed = speed;
        //setText(Integer.toString(value));
        Timer timer = new Timer(1000 / speed, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent ae) {
        setText(Integer.toString(++value));
    }
}

public class CounterTest extends JFrame {
    public CounterTest() {
        super("CounterTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(200, 75);
        Counter counter1 = new Counter(0, 10);
        counter1.setForeground(Color.red);
        Counter counter2 = new Counter(0, 1);
        add(counter1);
        add(counter2);
        //pack();  // pack all components
        setVisible(true);
    }

    public static void main(String[] args) {
        CounterTest test = new CounterTest();
    }
}
