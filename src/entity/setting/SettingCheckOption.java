package entity.setting;

import java.util.Map;

public class SettingCheckOption extends Setting{
	
	public Map<String, Boolean> checkOptions = null;
	
	public SettingCheckOption(String name, Map<String, Boolean> checkOptions){
		this.type = CHECK_OPTION;
		this.name = name;
		this.checkOptions = checkOptions;
	}
	
	
}
