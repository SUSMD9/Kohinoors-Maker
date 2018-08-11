package Mainmsd;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;


public class Setting extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Setting frame = new Setting();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Setting() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Setting");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 333, 416);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBackup = new JButton("BackUp");
		btnBackup.setForeground(Color.WHITE);
		btnBackup.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBackup.setBackground(new Color(204, 0, 102));
		btnBackup.setBorder(null);//no border
		btnBackup.setFocusable(false);//removes the text focus
		//btnBackup.setCursor(new Cursor(Cursor.HAND_CURSOR)); // to change the cursor on mouse hover
		btnBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//calling backUp method
				BackUpDao backUpObj = new BackUpDao();
				try 
				{
					backUpObj.backUpFolders();
				} catch (IOException e)
				{	
					e.printStackTrace();
				}
				
			}
		});
		btnBackup.setBounds(55, 124, 89, 23);
		contentPane.add(btnBackup);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(204, 0, 102));
		btnReset.setBorder(null);//no border
		btnReset.setFocusable(false);//removes the text focus
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//calling reset method
				BackUpDao backUpObj = new BackUpDao();
				try 
				{
					backUpObj.reset();
				} catch (IOException e1)
				{	
					e1.printStackTrace();
				}
			}
		});
		btnReset.setBounds(55, 309, 89, 23);
		contentPane.add(btnReset);
		
		JLabel lblThisOperationWill = new JLabel("<html>\r\nCreates Backup  by copying  all  the  original files <br>\r\non Desktop.\r\n<br><br>\r\nIt will  also overwrite old  files in backup folder if <br>\r\npresent.\r\n</html>\r\n \r\n");
		lblThisOperationWill.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblThisOperationWill.setBounds(55, 29, 231, 84);
		contentPane.add(lblThisOperationWill);
		
		JLabel lblWarningAll = new JLabel("<html>\r\nWarning !<br>\r\n<br>\r\nAll the original files will be 'Deleted' and all<br>\r\nthe settings will be set to default.<br>\r\n<br>\r\nIt is recomanded  to create  Back-Up before<br>\r\nresetting the application. \r\n</html>");
		lblWarningAll.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWarningAll.setBounds(55, 193, 231, 105);
		contentPane.add(lblWarningAll);
		
		JLabel lblNewLabel = new JLabel("");
		//border
		lblNewLabel.setBorder(new LineBorder(new Color(204, 51, 102), 2, true));
		lblNewLabel.setBounds(32, 22, 263, 333);
		contentPane.add(lblNewLabel);
	}
}
