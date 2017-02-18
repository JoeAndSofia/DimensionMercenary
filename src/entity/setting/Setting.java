package entity.setting;

public class Setting {
	public static final int UNDEFINED = 0;
	public static final int CHECK_BOX = 1;
	public static final int RADIO_BUTTON = 2;
	public static final int CHECK_OPTION = 3;
	
	public int type = UNDEFINED;
	public String name = null;
	public String description = null;
}
