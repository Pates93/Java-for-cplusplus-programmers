import javax.swing.*;

public class Dialog
{	Dialog()
	{	JDialog d=new JDialog();
		JDialog d2=new JDialog();
		d.setTitle("Error");
		d.setVisible(true);
		d2.setTitle("Error2");
		d2.setVisible(true);
	}

	public static void main(String[] args){new Dialog();}
}
