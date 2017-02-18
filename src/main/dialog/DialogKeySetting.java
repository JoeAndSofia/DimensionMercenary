package main.dialog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JDialog;

import entity.database.keys.KeyAction;
import entity.setting.Setting;

public class DialogKeySetting extends JDialog{
	
	public static List<List<Setting>> originalSettingLists = null;
	public static List<List<Setting>> modifiedSettingLists = null;
	
	public DialogKeySetting(List<List<Setting>> settingLists){
		this.originalSettingLists = settingLists;
		this.modifiedSettingLists = settingLists;
	}
	
}
