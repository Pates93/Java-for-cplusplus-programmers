/*
 * Swing version
 */

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class MultiListenerSimple extends JFrame
                           implements ActionListener {
    TextBox topTextBox;
    TextBox bottomTextBox;

    JButton button1, button2;

    final static String newline = "\n";

 	static final long serialVersionUID = -673724713844689830L;

    public MultiListenerSimple() {
        JPanel contentPane = new JPanel();

		//	--- create GUI
		{	//	--- Center
			JPanel panel=new JPanel(new FlowLayout());
			topTextBox=new TextBox("What MultiListener hears:");
			panel.add(topTextBox);

			bottomTextBox=new TextBox("What Eavesdropper hears:");
			panel.add(bottomTextBox);
			contentPane.add(panel,BorderLayout.CENTER);
		}


		{	//	--- South
			JPanel panel=new JPanel();
			panel.setLayout(new FlowLayout());
			button1=new MyButton("Blah blah blah","Hello from MultiListener");
			panel.add(button1);

			button2=new MyButton("You don't say!");
			panel.add(button2);
			contentPane.add(panel,BorderLayout.SOUTH);
		}

		//	--- add listeners
        button1.addActionListener(this);	// Registrera detta objekt som lyssnare
        button2.addActionListener(this);	// Registrera detta objekt som lyssnare

        button2.addActionListener(new Eavesdropper(bottomTextBox.getTextArea()));	// Registrear ett annat objekt som lyssnare

        setContentPane(contentPane);

		addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					   System.exit(0);
			   }
		 });

    }

    public void actionPerformed(ActionEvent e) {
        topTextBox.getTextArea().append(e.getActionCommand() + newline);
    }

    public static void main(String arg[]){
	  MultiListenerSimple mul=new MultiListenerSimple();
	  mul.pack();
	  mul.setVisible(true);
   }

   class MyButton extends JButton
   {	MyButton(String label){super(label);}

	   	MyButton(String label, String actionCommand)
   		{	super(label);
   			setActionCommand(actionCommand);
		}

 		static final long serialVersionUID = -673724713844689830L;
   }

   class TextBox extends JPanel
   {	TextBox(String label)
		{	setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			JLabel l = new JLabel(label);
			add(l);

			textArea = new JTextArea();
			textArea.setEditable(false);
			JScrollPane topScrollPane = new JScrollPane(textArea);
			Dimension preferredSize = new Dimension(200,75);
			JScrollPane scrollPane=new JScrollPane(textArea);
			scrollPane.setPreferredSize(preferredSize);
			add(scrollPane);
		}

		JTextArea getTextArea(){return textArea;}

		JTextArea textArea;
 		static final long serialVersionUID = -673724713844689830L;
   }
}

class Eavesdropper implements ActionListener {
    JTextArea myTextArea;
    public Eavesdropper(JTextArea ta) {myTextArea = ta;}

    public void actionPerformed(ActionEvent e)
    {	myTextArea.append(e.getActionCommand()+ MultiListenerSimple.newline);
    }
}
