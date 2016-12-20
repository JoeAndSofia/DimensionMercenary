package entity.scene;

import util.consts.EntityConsts;


public class Gathering extends SceneObject{
	
	public int population = 0;

	public Gathering(){
		this.type = EntityConsts.TYPE_SCENE_GATHERING;
		this.side = EntityConsts.SIDE_NATURE;
	}
	
	public static void main(String[] args){
		
	}
}
