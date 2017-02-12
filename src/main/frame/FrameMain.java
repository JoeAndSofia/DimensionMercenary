package main.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import main.panel.PanelMap;
import main.panel.PanelOption;
import entity.database.keys.KeyAction;

public class FrameMain extends JFrame{
	
	private Timer timer = new Timer();
	private boolean saved = false;
	
	public Map<String, Boolean> settingsCheckBox = new HashMap<String, Boolean>();
	public Map<String, String[]> settingsRadio = new HashMap<String, String[]>();
	public Map<String, Map<String, Boolean>> settingsMultiOption = new HashMap<String, Map<String, Boolean>>();
	
	public Map<String, KeyAction> savedKeyActions = new HashMap<String, KeyAction>();
	
	//menu
	public JMenuBar menu = null;
	public JMenu mGame = null;
	public JMenu mOperate = null;
	public JMenu mConfig = null;
	
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
		
		initDefaultKeyActions();
		
		initMenuBar();
		
		
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				saveData(); 
			}
			
			public void windowClosed(WindowEvent e){
				saveData();
			}
		});
	}
	
	private void initDefaultKeyActions(){
		//Battle KeyAction :
		//ctrl O : Battle Option
		savedKeyActions.put("battleOption", new KeyAction("battleOption", null, "Battle Option", "ctrl o") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelOption panelOption = new PanelOption();
			}
		});
		
		//ctrl M : Battle Map
		savedKeyActions.put("battleMap", new KeyAction("battleMap", null, "Battle Map", "ctrl m") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO				
			}
		});
		
		//Global KeyAction :
		//ctrl shirt O : Global Option
		savedKeyActions.put("globalOption", new KeyAction("globalOption", null, "Global Option", "ctrl shirt o") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}
		});		
		
		//ctrl shift m : Global Map
		savedKeyActions.put("globalMap", new KeyAction("globalOption", null, "Global Map", "ctrl shift m") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO	
			}
		});
	}
	
	private void initMenuBar(){
		if(menu==null){
			menu = new JMenuBar();
		}
		
		initMenuGame();
		initMenuOperate();
		initMenuConfig();
		
		this.setJMenuBar(menu);
	}
	
	private void initMenuGame(){
		if(mGame==null){
			mGame = new JMenu("Game");	
		}
		mGame.setMnemonic('g');
		
		JMenuItem mGameExit = new JMenuItem("Exit and Save");
		mGameExit.setMnemonic('x');
		mGameExit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				saveData();
				System.exit(0);
			}
		});
		mGame.add(mGameExit);
		menu.add(mGame);
	}
	
	private void initMenuOperate(){
		if(mOperate==null){
			mOperate = new JMenu("Operate");	
		}
		mOperate.setMnemonic('o');
		menu.add(mOperate);
	}
	
	private void initMenuConfig(){
		if(mConfig==null){
			mConfig = new JMenu("Config");
		}
		mConfig.setMnemonic('c');
		
		JMenuItem mConfigHotkey = new JMenuItem("Hot Key");
		mConfigHotkey.setMnemonic('h');
		mConfigHotkey.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hot Key");
			}
		});
		mConfig.add(mConfigHotkey);
		menu.add(mConfig);
	}
	
	private void initVarietyPanel(){
		if(varietyPanel==null){
			varietyPanel = new JPanel();
		}
	}
	
	private void saveData(){
		if(!saved){
			try{
				saved = true;
				//TODO
				System.out.println("Data Saved");
			}catch(Exception ex){
				saved = false;
				System.out.println("Data Not Saved");
			}
		}
	}
	
	public static void main(String[] args){
		JFrame mainFrame = new FrameMain();
		mainFrame.setVisible(true);
	}
}
