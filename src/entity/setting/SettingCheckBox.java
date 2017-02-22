package entity.setting;

public class SettingCheckBox extends Setting{
	
	public Boolean check = null;
	
	public SettingCheckBox(String name, Boolean check){
		this.type = CHECK_BOX;
		this.name = name;
		this.check = check;
	}
	
	
}
