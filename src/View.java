import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import ui.SButton;
import ui.SFileButton;
import ui.SPasswordField;
import ui.STextField;


@SuppressWarnings("serial")
public class View extends JFrame {

	private int X = 0;
	private int Y = 0;
	
	int padding=14;
	
	int windowWidth=800;
	int windowHeight=padding*44;
	
	int frameOffset;
	
	static JPasswordField d;
	
	public final static Color backgroundColor      = new Color(250, 250, 250);
	public final static Color ribbonColor      	= new Color(0, 230,190);

	
	static SButton	closeButton, loginButton;
	
	static JLabel	titleText, label1;
	static JPanel topRibbon;
	
	static SFileButton filesButtons[]=new SFileButton[999];
	
	private ImageIcon closeImageIcon = new ImageIcon("raw/close.png");
	
	public View(Model model){
		
		setBounds(60, 60, windowWidth, windowHeight);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); // An Exit Listener
			}
		});

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				X = e.getX();
				Y = e.getY();
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				setLocation(getLocation().x + (e.getX() - X),
						getLocation().y + (e.getY() - Y));
			}
		});
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(backgroundColor);
		setUndecorated(true);
		
		label1 = new JLabel("Bitte loggen sie sich ein.");
		label1.setForeground(Color.white);
		label1.setFont(new Font("Sans", Font.BOLD, 12));	
		label1.setBounds(padding, padding*5, 450, 36);
		
		//label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setVerticalAlignment(SwingConstants.NORTH);
		add(label1);
		
		titleText = new JLabel("Sharedbox Ultimate");
		titleText.setForeground(Color.white);
		titleText.setFont(new Font("Sans", Font.BOLD, 22));
		titleText.setBounds(0, 0, windowWidth, padding*3);
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleText);
		
		closeButton=new SButton();
		add(closeButton);
		closeButton.setBounds(windowWidth-40, -42+padding*3, 40, 40);
		closeButton.setIcon(closeImageIcon);
		closeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		
		topRibbon=new JPanel();
		topRibbon.setBackground(ribbonColor);
		topRibbon.setBounds(0,0,windowWidth,padding*7);
		add(topRibbon);
	
		
		
		loginButton=new SButton("login");
		loginButton.setBounds(padding, padding*17, windowWidth-padding*2, padding*4);
		loginButton.setBackground(ribbonColor);
		loginButton.setOpaque(true);
		
		loginButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
				}
			});
		
		add(loginButton);
		
		String fileList[]=new String[99];
		
		fileList=model.files();
		
		for(int i=0; i<4; i++)
		{
			filesButtons[i]=new SFileButton(fileList[i]);
			filesButtons[i].setBounds(padding, padding*8+padding*i*2, windowWidth-padding*2, padding*2);
			add(filesButtons[i]);
		}
		
		setVisible(true);
		
	}
	
}