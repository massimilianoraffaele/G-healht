package GUI;
import client.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.LoggingOut.LogOutListener;
import client.LoginControl;

import javax.swing.JTextField;

import java.awt.Window.Type;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Label;


/**
 * @author G5 lab group
 * The Class DoctorGUI.
 */
public class DoctorGUI extends LoggingOut {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3233126342207430542L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The find patient. */
	private JButton findPatient;
	
	/** The lblwarning message. */
	//private JButton btnCrtPt;
	private JLabel lblwarningMessage = null;
	
	/** The Insert patient id. */
	private JTextField InsertPatientId;
	
	/**
	 * Create the frame.
	 */
	public DoctorGUI() {
		setResizable(false);
		setTitle("G-Health");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DoctorGUI.class.getResource("/images/logo2.PNG")));
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setBounds(0, 0, 0, 0);
		contentPane.add(label);
		JLabel lblLogo;
		if(LoginControl.getUser_full_name() == null)
			lblLogo = new JLabel("Welcome DOCTOR!");
		else lblLogo = new JLabel("Hi "+LoginControl.getUser_full_name()+"!");
		lblLogo.setIcon(new ImageIcon(DoctorGUI.class.getResource("/images/logo2.png")));
		lblLogo.setBounds(0, 0, 794, 79);
		contentPane.add(lblLogo);
		
		findPatient = new JButton("Search Patient");
		
		findPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		findPatient.setBounds(254, 171, 140, 23);
		contentPane.add(findPatient);
		
		InsertPatientId = new JTextField();
		InsertPatientId.setText("Insert ID here...");
		InsertPatientId.setBounds(270, 126, 137, 20);
		
		/* MouseListener for clear JTextField when mouse clicks */
		InsertPatientId.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	InsertPatientId.setText("");
            }
        });
		
		contentPane.add(InsertPatientId);
		InsertPatientId.setColumns(10);
		
		Label label_1 = new Label("Patient ID");
		label_1.setBounds(202, 126, 62, 22);
		contentPane.add(label_1);
		
		
		
		JButton LogOut = new JButton("Log Out");
		LogOut.setBounds(138, 400, 245, 68);
		LogOut.addActionListener(new LogOutListener());
		contentPane.add(LogOut);
		
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		System.out.println("END OF DOC GUI CONSTRUCTOR");
	
	}
	
	/**
	 * Sets the warning message visible true.
	 */
	public void setWarningMessageVisibleTrue() {
		lblwarningMessage.setVisible(true);	
	}
	
	/**
	 * Sets the warning message visible true.
	 *
	 * @param st the new warning message visible true
	 */
	public void setWarningMessageVisibleTrue(String st) {
		lblwarningMessage.setText(st);
		lblwarningMessage.setForeground(Color.RED);
		lblwarningMessage.setBounds(10, 165, 245, 30);
		lblwarningMessage.setVisible(true);	
		
	}
	
	
	
	/**
	 * Undisplay warning message.
	 */
	public void undisplayWarningMessage() {
		lblwarningMessage.setVisible(false);
		
	}
	
	
	/**
	 * Find patient action listener.
	 *
	 * @param e the event
	 */
	public void findPatientActionListener(ActionListener e)
	{
		findPatient.addActionListener(e);
	}
	
	
	/**
	 * Gets the patient id.
	 *
	 * @return the patient id
	 */
	public String getPtID() {
		return InsertPatientId.getText();
	}

	/**
	* Cancell listener of the button.
	*/
	public class CancelListener implements ActionListener 
    {
    	
	    /** 
	     * closes the current frame of the class
	     */
	    @Override
    	public void actionPerformed(ActionEvent e)
    	{
    		dispose();
    	}	
    }//CancelListener
}
