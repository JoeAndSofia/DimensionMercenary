package entity.runtime.basic;

import javax.swing.JComponent;

public class GameObject extends JComponent{
	public static final int TYPE_DEFAULT 				= 0;
	
	public static final int TYPE_SCENE 				= 100000000;
	
	public static final int TYPE_SCENE_GATHERING		= 101000000;
	public static final int TYPE_SCENE_VILLAGE 		= 101010000;
	public static final int TYPE_SCENE_TOWN 			= 101020000;
	public static final int TYPE_SCENE_CITY 			= 101030000;
	public static final int TYPE_SCENE_METROPOLIS		= 101040000;
	public static final int TYPE_SCENE_CAPITAL		= 101050000;
	
	public static final int TYPE_SCENE_TEAM 			= 102000000;
	
	public static final int SIDE_NATURE 	= -1;
	public static final int SIDE_NEUTRAL 	= 0;
	public static final int SIDE_MINE 		= 1;
	public static final int SIDE_ALLY 		= 2;
	public static final int SIDE_ENEMY 	= 3;
	
	public int type = TYPE_DEFAULT;
	public int side = SIDE_NATURE;
	public int sub_type = 0;
	public String name = null;
	public String image = null;
	
	public static void main(String[] args){
		
	}	
}
