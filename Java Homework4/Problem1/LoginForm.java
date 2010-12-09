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
	submitBut.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			String login = tf.getText();
		    char[] password = pf.getPassword();
		    String passwordAsString = new String(password);
			boolean isValidLogin = false;

			if(passwordAsString.equals("CSPP") && login.equals("CSPP")){
				isValidLogin = true;
			}
			if (isValidLogin){
				JOptionPane.showMessageDialog(null,"You may log in");
		    }
		    else{
				JOptionPane.showMessageDialog(null,"Invalid User!");
		    }
		}
	});
	
	clearBut.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			tf.setText(null);
		    pf.setText(null);
		    return;
		}
	});
	
	exitBut.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			System.exit(1);
		}
	});
	
	setSize(200,200);
	show();

    }
    
    public static void main(String[] args){
	new LoginForm();
    }

}