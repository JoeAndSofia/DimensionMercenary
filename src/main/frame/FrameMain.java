package main.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;

import javax.swing.JFrame;

import main.panel.PanelMap;

public class FrameMain extends JFrame{
	
	private Timer timer = new Timer();
	
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
