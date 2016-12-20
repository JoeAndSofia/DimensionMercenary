package entity.basic;

import javax.swing.JComponent;

import util.consts.EntityConsts;

public class GameObject extends JComponent{
	public int type = EntityConsts.TYPE_DEFAULT;
	public int side = EntityConsts.SIDE_NATURE;
	public int sub_type = 0;
	public String name = null;
	public String image = null;
	
	public static void main(String[] args){
		
	}	
}
