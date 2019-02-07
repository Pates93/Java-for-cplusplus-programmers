import javax.swing.*;

public class MyOptionPane extends JFrame
{   public MyOptionPane()
    {	super("MyOptionPane");
    	setSize(400,300);
    	setLocation(300,300);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		JOptionPane pane = new JOptionPane("My message");
		JDialog dialog = pane.createDialog(this, "häpp");
		dialog.show();

		JOptionPane.showMessageDialog(this,"Felaktigt lösenord","Login",JOptionPane.ERROR_MESSAGE);

    }

    public static void main(String[] args) {new MyOptionPane();}
}
