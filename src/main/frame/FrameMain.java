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

import com.sun.corba.se.spi.orbutil.fsm.FSM;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import main.panel.PanelMap;

public class FrameMain extends JFrame{
	
	private Timer timer = new Timer();
	
	private JMenuBar menu = null;
	private JMenu mGame = null;
	private JMenu mOperate = null;
	
	
	
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
		
		menu = new JMenuBar();
		mGame = new JMenu("Game");
		JMenuItem mGameExit = new JMenuItem("Exit");
		mGameExit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mGame.add(mGameExit);
		
		mOperate = new JMenu("Operate");
		
		menu.add(mGame);
		menu.add(mOperate);
		this.setJMenuBar(menu);
		
		
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.out.println("Data Saving"); 
			}
			
			public void windowClosed(WindowEvent e){
				System.out.println("Data Saved");
			}
		});
	}
	

	public static void main(String[] args){
		JFrame main = new FrameMain();
		main.setVisible(true);
	}
}
