package entity.database.keys;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;

public abstract class KeyAction extends AbstractAction{

	public String defaultKeys = null;
	
	public KeyAction(String name, Icon icon, String shortDescription, String defaultKeys){
		putValue(Action.NAME, name);
		putValue(Action.SMALL_ICON, icon);
		putValue(Action.SHORT_DESCRIPTION, shortDescription);
		this.defaultKeys = defaultKeys;
	}
	
}
