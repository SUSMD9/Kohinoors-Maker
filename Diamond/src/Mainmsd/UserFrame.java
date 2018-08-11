package Mainmsd;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class UserFrame extends JFrame {

	private JPanel contentPane;
	private JTextField totalDiamondTextField;
	private JTextField OneDiamondCostTextField;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
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
	public UserFrame() {
		setTitle("Kohinoor's Maker");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mehul s dholiya\\eclipse-workspace\\Diamond\\img1.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(102, 0, 102), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" K");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(204, 0, 102));
		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(121, 1, 75, 90);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("ohinoor's ");
		lblNewLabel_2.setBackground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_2.setForeground(new Color(204, 0, 102));
		lblNewLabel_2.setFont(new Font("Lucida Handwriting", Font.ITALIC, 31));
		lblNewLabel_2.setBounds(181, 28, 179, 44);
		contentPane.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setForeground(new Color(153, 0, 102));
		dateChooser.setBorder(new LineBorder(new Color(102, 51, 102), 1, true));
		dateChooser.setBackground(Color.WHITE);
		dateChooser.setBounds(207, 236, 194, 31);
		contentPane.add(dateChooser);
		
		totalDiamondTextField = new JTextField();
		totalDiamondTextField.setHorizontalAlignment(SwingConstants.CENTER);
		totalDiamondTextField.setForeground(new Color(153, 0, 102));
		totalDiamondTextField.setBackground(UIManager.getColor("window"));
		totalDiamondTextField.setBounds(489, 238, 194, 31);
		contentPane.add(totalDiamondTextField);
		totalDiamondTextField.setColumns(10);
		//border
		totalDiamondTextField.setBorder(new LineBorder(new Color(102, 51, 102), 1, true));
		
		OneDiamondCostTextField = new JTextField();
		OneDiamondCostTextField.setForeground(new Color(153, 0, 102));
		OneDiamondCostTextField.setHorizontalAlignment(SwingConstants.CENTER);
		OneDiamondCostTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		OneDiamondCostTextField.setText(" 3.50");
		OneDiamondCostTextField.setColumns(10);
		OneDiamondCostTextField.setBounds(762, 236, 194, 31);
		contentPane.add(OneDiamondCostTextField);
		//border
		OneDiamondCostTextField.setBorder(new LineBorder(new Color(102, 51, 102), 1, true));
		
		JLabel todayTotalLabel = new JLabel("0.0");
		todayTotalLabel.setBackground(UIManager.getColor("Button.light"));
		todayTotalLabel.setForeground(new Color(153, 0, 102));
		todayTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		todayTotalLabel.setLabelFor(todayTotalLabel);
		todayTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		todayTotalLabel.setBounds(207, 345, 194, 31);
		// create a line border with the specified color and width
		todayTotalLabel.setBorder(new LineBorder(new Color(102, 51, 102), 1, true));
		contentPane.add(todayTotalLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\mehul s dholiya\\eclipse-workspace\\Diamond\\img1.png"));
		lblNewLabel_1.setBounds(24, 11, 109, 90);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblSelectDate = new JLabel("Select Date");
		lblSelectDate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSelectDate.setForeground(new Color(102, 51, 102));
		lblSelectDate.setBounds(207, 219, 194, 19);
		contentPane.add(lblSelectDate);
		
		JLabel lblTotalPiece = new JLabel("Total Diamonds");
		lblTotalPiece.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTotalPiece.setForeground(new Color(102, 51, 102));
		lblTotalPiece.setBounds(489, 219, 194, 19);
		contentPane.add(lblTotalPiece);
		
		JLabel lblCostPerDiamond = new JLabel("Cost per Diamond");
		lblCostPerDiamond.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCostPerDiamond.setForeground(new Color(102, 51, 102));
		lblCostPerDiamond.setBounds(762, 219, 194, 19);
		contentPane.add(lblCostPerDiamond);
		
		JLabel thisMonthTotal = new JLabel();
		thisMonthTotal.setForeground(new Color(153, 0, 102));
		thisMonthTotal.setHorizontalAlignment(SwingConstants.CENTER);
		thisMonthTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		thisMonthTotal.setBounds(489, 345, 194, 31);
		//border
		thisMonthTotal.setBorder(new LineBorder(new Color(102, 51, 102), 1, true));
		//set this month total from file
		FileDao fdobj = new FileDao();
		try 
		{
			double amount = fdobj.getTotalPresentMonthAmount();
			thisMonthTotal.setText(Double.toString(amount));
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		contentPane.add(thisMonthTotal);
		
		JLabel lblTodaysTotal = new JLabel("Today");
		lblTodaysTotal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTodaysTotal.setForeground(new Color(102, 51, 102));
		lblTodaysTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTodaysTotal.setBounds(207, 327, 194, 19);
		contentPane.add(lblTodaysTotal);
		
		JLabel lblThisMonthsTotal = new JLabel("Present Month");
		lblThisMonthsTotal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblThisMonthsTotal.setForeground(new Color(102, 51, 102));
		lblThisMonthsTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblThisMonthsTotal.setBounds(489, 327, 186, 19);
		contentPane.add(lblThisMonthsTotal);
		
		JLabel lastUpdatedLabel = new JLabel("");
		lastUpdatedLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lastUpdatedLabel.setForeground(new Color(153, 0, 102));
		lastUpdatedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lastUpdatedLabel.setBounds(489, 453, 194, 31);
		contentPane.add(lastUpdatedLabel);
		//border
		lastUpdatedLabel.setBorder(new LineBorder(new Color(102, 51, 102), 1, true));
		//set last updated details from file
		FileDao lastUpdate = new FileDao();
		try
		{
			String lastUpdateTimeStamp = lastUpdate.lastUpdateDetail();
			lastUpdatedLabel.setText(lastUpdateTimeStamp);
		} 
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		JLabel previousMonthLabel = new JLabel("");
		previousMonthLabel.setForeground(new Color(153, 0, 102));
		previousMonthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		previousMonthLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		previousMonthLabel.setBounds(762, 345, 194, 31);
		contentPane.add(previousMonthLabel);
		//border
		previousMonthLabel.setBorder(new LineBorder(new Color(102, 51, 102), 1, true));
		//set previous month total from Book1 File
		FileDao previousMonthTotal = new FileDao();
		try
		{
			previousMonthLabel.setText(Double.toString(previousMonthTotal.getPreviousMonthTotal()));
			
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}

		
		JLabel lastUpdateHeading = new JLabel("Last Updated");
		lastUpdateHeading.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lastUpdateHeading.setForeground(new Color(102, 51, 102));
		lastUpdateHeading.setHorizontalAlignment(SwingConstants.LEFT);
		lastUpdateHeading.setBounds(489, 435, 194, 19);
		contentPane.add(lastUpdateHeading);
		
		JLabel previousMonthHeading = new JLabel("Previous Month");
		previousMonthHeading.setFont(new Font("Tahoma", Font.PLAIN, 11));
		previousMonthHeading.setForeground(new Color(102, 51, 102));
		previousMonthHeading.setHorizontalAlignment(SwingConstants.LEFT);
		previousMonthHeading.setBounds(762, 327, 194, 19);
		contentPane.add(previousMonthHeading);
		
		JButton totalButton = new JButton("Update");
		totalButton.setBorder(null);//no border
		totalButton.setFocusable(false);//removes the text focus
		totalButton.setForeground(new Color(255, 255, 255));
		totalButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			
				
				//To check if any field is empty -- to avoid null pointer Exception
				if(totalDiamondTextField.getText()==null || OneDiamondCostTextField.getText()==null || dateChooser.getDate()==null)
				{
				    JOptionPane.showMessageDialog(new JFrame(), "Some Data is Empty !\n\nPlease fill all the Data.", "Empty Value",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Date date = dateChooser.getDate();
//					System.out.println(date);
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
					String stringDate = formatter.format(date);
		
					int totalDiamond =Integer.parseInt(totalDiamondTextField.getText());
					double oneDiamondPrice = Double.parseDouble(OneDiamondCostTextField.getText());
					double totalMoney =  totalDiamond*oneDiamondPrice;
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null,  "File Data Will be updated, It can't be undo."
																			+"Please check Details once more.."
																			+"\n\n\nDate : "+stringDate
																			+"\n\n\nTotal Diamond : "+totalDiamond
																			+"\n\n\nTOTAL AMOUNT :"+totalMoney
							                                                +"\n\n\nDo You want to Continue?","Confirmation",dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION)
					    {

							//set Today's Total
							todayTotalLabel.setText(Double.toString(totalMoney));
							
							FileDao fd = new FileDao();
							try {
								
								//checking file monthly
								fd.editMonthlyFile(stringDate,totalDiamond,totalMoney);
								
								fd.totalFileUpdate(totalMoney);
								//set thisMonthsTotal when button is clicked				
								thisMonthTotal.setText(Double.toString(fd.getTotalPresentMonthAmount()));
								
								//update last update timeStamp into file
								fd.changeLastUpdateDetail(stringDate);
								
								//get new(updated) TimeStamp of last update from file and set it to last update label
								lastUpdatedLabel.setText(fd.lastUpdateDetail());
								

							} catch (IOException e) {
								e.printStackTrace();
							}
							
							
					    }
				}

				

			}
		});
		totalButton.setBackground(new Color(204, 0, 102));
		//btnNewButton.setBorderPainted(false);
		totalButton.setBounds(207, 452, 194, 31);
		contentPane.add(totalButton);
		

		
		JButton btnNewButton = new JButton("Setting");
		btnNewButton.setBorder(null);//no border
		btnNewButton.setFocusable(false);//removes the text focus
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//open Setting Frame

				Setting settingFrame = new Setting();
				settingFrame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(204, 0, 102));
		btnNewButton.setBounds(762, 452, 194, 31);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 255, 255));
		label.setBounds(135, 155, 899, 401);
		//border
		label.setBorder(new LineBorder(new Color(204, 51, 102), 2, true));
		contentPane.add(label);
		
		JLabel lblM = new JLabel(" M");
		lblM.setForeground(new Color(204, 0, 102));
		lblM.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 40));
		lblM.setBackground(Color.WHITE);
		lblM.setBounds(345, 1, 75, 90);
		contentPane.add(lblM);
		
		JLabel lblAker = new JLabel("aker");
		lblAker.setForeground(new Color(204, 0, 102));
		lblAker.setFont(new Font("Lucida Handwriting", Font.ITALIC, 31));
		lblAker.setBackground(SystemColor.inactiveCaptionBorder);
		lblAker.setBounds(406, 28, 109, 44);
		contentPane.add(lblAker);
		
		JLabel lblIMakes = new JLabel("The Real Creator");
		lblIMakes.setForeground(new Color(204, 51, 102));
		lblIMakes.setFont(new Font("Monotype Corsiva", Font.ITALIC, 18));
		lblIMakes.setBounds(143, 72, 170, 14);
		contentPane.add(lblIMakes);
		

		

	}
}
