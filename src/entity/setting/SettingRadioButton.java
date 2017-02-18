package entity.setting;

import java.util.List;

public class SettingRadioButton extends Setting{
	
	public List<String> options = null;
	public int index = 0;
	
	public SettingRadioButton(String name, List<String> options, int index){
		this.type = RADIO_BUTTON;
		this.name = name;
		this.options = options;
		this.index = index;
	}
	
	
}
