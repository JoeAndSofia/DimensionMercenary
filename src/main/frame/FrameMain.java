package main.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import main.dialog.DialogKeySetting;
import main.panel.PanelMain;
import main.panel.PanelMap;
import main.panel.PanelSetting;
import entity.database.keys.KeyAction;
import entity.setting.Setting;

public class FrameMain extends JFrame{
	
	private Timer timer = new Timer();
	private boolean saved = false;
	
	//actions
	public Map<String, KeyAction> savedKeyActions = new HashMap<String, KeyAction>();
	
	//battle settings
	public List<Setting> displaySettings = new ArrayList<Setting>();
	public List<Setting> processSettings = new ArrayList<Setting>();
	public JDialog battleSettingDialog = null;
	
	//global settings
	public List<Setting> notifySettings = new ArrayList<Setting>();
	public List<Setting> dataLoadSettings = new ArrayList<Setting>();
	public List<Setting> dataSaveSettings = new ArrayList<Setting>();
	public JDialog globalSettingDialog = null;
	
	//system settings
	public JDialog keySettingDialog = null;
	
	//menus
	public JMenuBar menu = null;
	public JMenu mMain = null;
	public JMenu mOperate = null;
	public JMenu mConfig = null;
	
	//panels
	public JPanel mainPanel = null;
	public JPanel varietyPanel = null;
	
	public FrameMain(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension fullScreen = toolkit.getScreenSize();
		Dimension testDimension = new Dimension(200, 200);
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setResizable(false);
//		this.setSize(fullScreen);
		this.setSize(testDimension);
		this.setTitle("Dimension Mercenary");
		this.setUndecorated(true);
		
//		this.add(mainPanel = new PanelMain(timer));
		this.add(mainPanel = new PanelMain());
		
		initDefaultKeyActions();
		initInputMapAndActionMap();
		initMenuBar();
		
		initDialogSetting();
		
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
		//ctrl T : Battle Setting
		savedKeyActions.put("battleSetting", new KeyAction("battleSetting", null, "Battle Setting", "ctrl T") {
			@Override
			public void actionPerformed(ActionEvent ae) {
				PanelSetting panelSetting = new PanelSetting();
				add(panelSetting);
				pl("battleSetting");
			}
		});
		
		//ctrl M : Battle Map
		savedKeyActions.put("battleMap", new KeyAction("battleMap", null, "Battle Map", "ctrl M") {
			@Override
			public void actionPerformed(ActionEvent ae) {
				PanelMap panelMap = new PanelMap();
				add(panelMap);
				pl("battleMap");
			}
		});
		
		//Global KeyAction :
		//ctrl shirt T : Global Setting
		savedKeyActions.put("globalSetting", new KeyAction("globalSetting", null, "Global Setting", "ctrl shift T") {
			@Override
			public void actionPerformed(ActionEvent ae) {
				PanelSetting panelSetting = new PanelSetting();
				add(panelSetting);
				pl("globalSetting");
			}
		});		
		
		//ctrl shift M : Global Map
		savedKeyActions.put("globalMap", new KeyAction("globalOption", null, "Global Map", "ctrl shift M") {
			@Override
			public void actionPerformed(ActionEvent ae) {
				PanelMap panelMap = new PanelMap();
				add(panelMap);
				pl("globalMap");
			}
		});
		
		//ctrl K : Key Setting
		savedKeyActions.put("keySetting", new KeyAction("keySetting", null, "Key Setting", "ctrl K"){
			@Override
			public void actionPerformed(ActionEvent ae) {
				keySettingDialog = new DialogKeySetting(null);
				pl("keySetting");
			}
		});
	}
	
	private void initInputMapAndActionMap(){
		InputMap im = mainPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		ActionMap am = mainPanel.getActionMap();
		for(Map.Entry<String, KeyAction> entry : savedKeyActions.entrySet()){
			pl(entry.getKey() + " ---- " + entry.getValue().defaultKeys);

			im.put(KeyStroke.getKeyStroke(entry.getValue().defaultKeys), entry.getKey());
			am.put(entry.getKey(), entry.getValue());
		}
	}
	
	private void initMenuBar(){
		if(menu==null){
			menu = new JMenuBar();
		}
		
		initMenuMain();
		initMenuOperate();
		initMenuConfig();
		
		this.setJMenuBar(menu);
	}
	
	private void initMenuMain(){
		if(mMain==null){
			mMain = new JMenu("Main");	
		}
		mMain.setMnemonic('m');
		
		JMenuItem miMainExit = new JMenuItem("Exit and Save");
		miMainExit.setMnemonic('x');
		miMainExit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				saveData();
				System.exit(0);
			}
		});
		mMain.add(miMainExit);
		menu.add(mMain);
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
		
		JMenu mConfigBattle = new JMenu("Battle");
		mConfigBattle.setMnemonic('b');
		
		JMenuItem miConfigBattleSetting = new JMenuItem("Setting");
		miConfigBattleSetting.setMnemonic('t');
		miConfigBattleSetting.addActionListener(savedKeyActions.get("battleSetting"));
		mConfigBattle.add(miConfigBattleSetting);
		
		JMenuItem miConfigBattleMap = new JMenuItem("Map");
		miConfigBattleMap.setMnemonic('m');
		miConfigBattleMap.addActionListener(savedKeyActions.get("battleMap"));
		mConfigBattle.add(miConfigBattleMap);
		
		JMenu mConfigGlobal = new JMenu("Global");
		mConfigGlobal.setMnemonic('g');
		
		JMenuItem miConfigGlobalSetting = new JMenuItem("Setting");
		miConfigGlobalSetting.setMnemonic('t');
		miConfigGlobalSetting.addActionListener(savedKeyActions.get("battleSetting"));
		mConfigGlobal.add(miConfigGlobalSetting);
		
		JMenuItem miConfigGlobalMap = new JMenuItem("Map");
		miConfigGlobalMap.setMnemonic('m');
		miConfigGlobalMap.addActionListener(savedKeyActions.get("battleMap"));
		mConfigGlobal.add(miConfigGlobalMap);
		
		JMenuItem miConfigHotkey = new JMenuItem("Hot Key");
		miConfigHotkey.setMnemonic('h');
		miConfigHotkey.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hot Key");
			}
		});
		mConfig.add(miConfigHotkey);
		mConfig.add(mConfigBattle);
		mConfig.add(mConfigGlobal);
		menu.add(mConfig);
	}
	
	private void initDialogSetting(){
		if(battleSettingDialog==null){
			List<List<Setting>> settingList = new ArrayList<List<Setting>>();
			settingList.add(displaySettings);
			settingList.add(processSettings);
			battleSettingDialog = new DialogKeySetting(settingList);
//			battleSettingDialog
		}
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
	
	public static void pl(Object o){
		System.out.println(o);
	}
	public static void p(Object o){
		System.out.print(o);
	}
}
