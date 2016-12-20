package entity.scene;

import util.consts.EntityConsts;
import entity.basic.GameObject;

public class SceneObject extends GameObject {
	
	public SceneObject(){
		this.type = EntityConsts.TYPE_SCENE;
		this.side = EntityConsts.SIDE_NATURE;
	}
	
	public static void main(String[] args){
		
	}
}
