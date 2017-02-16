package main.dialog;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JDialog;

import entity.database.keys.KeyAction;

public class DialogKeySetting extends JDialog{
	
	public Map<String, KeyAction> savedKeyActions = new HashMap<String, KeyAction>();
	public Map<String, KeyAction> savingKeyActions = new HashMap<String, KeyAction>();
	
	public DialogKeySetting(){
		
	}
	
	public DialogKeySetting(Map<String, KeyAction> savedKeyActions){
		this.savedKeyActions = savedKeyActions;
		this.savingKeyActions = savedKeyActions;
		
	}
}
