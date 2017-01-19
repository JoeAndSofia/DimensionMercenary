package main.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.util.Timer;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import main.panel.PanelMap;

public class FrameMain extends JFrame{
	
	private Timer timer = new Timer();
	
	//menu
	public JMenuBar menu = null;
	public JMenu mGame = null;
	public JMenu mOperate = null;
	
	//panels
	public JPanel varietyPanel = null;
	
	public FrameMain(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension fullScreen = toolkit.getScreenSize();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(0, 0);
		this.setResizable(false);
		this.setSize(fullScreen);
		this.setTitle("Dimension Mercenary");
		this.setUndecorated(true);
		
		this.add(new PanelMap(timer));
		
		initMenu();
		
		
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.out.println("Data Saving"); 
			}
			
			public void windowClosed(WindowEvent e){
				System.out.println("Data Saved");
			}
		});
	}
	
	private void initMenu(){
		if(menu==null){
			menu = new JMenuBar();
		}
		
		
		
		mGame = new JMenu("Game");
		mGame.setMnemonic('g');
		JMenuItem mGameExit = new JMenuItem("Exit");
		mGameExit.setMnemonic('x');
		mGameExit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mGame.add(mGameExit);
		
		
		
		mOperate = new JMenu("Operate");
		mOperate.setMnemonic('o');
		
		
		menu.add(mGame);
		menu.add(mOperate);
		this.setJMenuBar(menu);
	}
	
	private void initVarietyPanel(){
		if(varietyPanel==null){
			varietyPanel = new JPanel();
		}
	}
	
	public static void main(String[] args){
		JFrame mainFrame = new FrameMain();
		mainFrame.setVisible(true);
	}
}
