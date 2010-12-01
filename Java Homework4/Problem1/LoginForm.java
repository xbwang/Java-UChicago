import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LoginForm extends JFrame{
    JTextField tf;
    JPasswordField pf;
    JButton submitBut, clearBut, exitBut;
    JLabel  nameLabel, passwordLabel;
    LoginForm(){
	super("Andrew's Login Page");
	Container cp = getContentPane();
	cp.setLayout(new FlowLayout(FlowLayout.LEFT));

	//add login label
	nameLabel = new JLabel("login           ");
	cp.add(nameLabel);

	//add text field for login
	tf = new JTextField(10);
	cp.add(tf);

	//add password label
	passwordLabel = new JLabel("password");
	cp.add(passwordLabel);
	
	//add hidden text field for password
	pf = new JPasswordField(10);
	cp.add(pf);

	submitBut = new JButton("submit");
	cp.add(submitBut);
	
	clearBut = new JButton("clear");
	cp.add(clearBut);

	exitBut = new JButton("exit");
	cp.add(exitBut);

	//add event handlers here
	MyActionListener al = new MyActionListener(this); //I write this class
	submitBut.addActionListener(al);
	clearBut.addActionListener(al);
	exitBut.addActionListener(al);

	setSize(200,150);
	show();

    }
    
    public static void main(String[] args){
	new LoginForm();
    }

}


class MyActionListener implements ActionListener{
    private LoginForm form;

    MyActionListener(LoginForm form){
	this.form = form;
    }

    public void actionPerformed(ActionEvent ae){
	String whichButton = ae.getActionCommand();

	if (whichButton.equals("clear")){
	    this.form.tf.setText(null);
	    this.form.pf.setText(null);
	    return;
	}
	if (whichButton.equals("exit")){
	    System.exit(1);
	}
	
	if (whichButton.equals("submit")){
	    String login = this.form.tf.getText();
	    char[] password = this.form.pf.getPassword();
	    String passwordAsString = new String(password);
	    boolean isValidLogin = LoginUtilities.checkLogin(login,passwordAsString);
	    if (isValidLogin){
		JOptionPane.showMessageDialog(null,"You may log in");
	    }
	    else{
		JOptionPane.showMessageDialog(null,"Invalid User!");
	    }
	}
	    
    }
}
