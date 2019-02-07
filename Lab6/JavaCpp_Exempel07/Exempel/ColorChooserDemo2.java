import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

public class ColorChooserDemo2 extends JFrame {
    public ColorChooserDemo2() {
        super("ColorChooserDemo2");

        //Set up banner to use as custom preview panel
        final JLabel banner = new JLabel("Welcome!",
                                         JLabel.CENTER);
        banner.setForeground(Color.yellow);
        banner.setBackground(Color.blue);
        banner.setOpaque(true);
        banner.setFont(new Font("SansSerif", Font.BOLD, 24));
        banner.setPreferredSize(new Dimension(100, 65));

        JPanel bannerPanel = new JPanel(new BorderLayout());
        bannerPanel.add(banner, BorderLayout.CENTER);
        bannerPanel.setBorder(BorderFactory.createTitledBorder("Banner"));

        //Set up color chooser for setting background color
        JPanel panel = new JPanel();
        JButton bcc = new JButton("Show Color Chooser...");
        bcc.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                     Color newColor = JColorChooser.showDialog(
                                                ColorChooserDemo2.this,
                                                "Choose Background Color",
                                                banner.getBackground());
                    if (newColor != null) {
                        banner.setBackground(newColor);
                    }
                }
            }
        );
        panel.add(bcc);
        panel.setBorder(BorderFactory.createTitledBorder(
                                "Choose Background Color"));

        
        Container contentPane = getContentPane();
        contentPane.add(bannerPanel, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.CENTER);
       
    }

    public static void main(String[] args) {

        JFrame frame = new ColorChooserDemo2();

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}
