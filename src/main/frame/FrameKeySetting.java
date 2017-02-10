package main.frame;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import entity.database.keys.KeyAction;

public class FrameKeySetting extends JFrame{
	
	public Map<String, KeyAction> savedKeyActions = new HashMap<String, KeyAction>();
	public Map<String, KeyAction> savingKeyActions = new HashMap<String, KeyAction>();
	
	public FrameKeySetting(){
		
	}
	
	public FrameKeySetting(Map<String, KeyAction> savedKeyActions){
		this.savedKeyActions = savedKeyActions;
		this.savingKeyActions = savedKeyActions;
		
	}
}
