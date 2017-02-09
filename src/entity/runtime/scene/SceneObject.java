package entity.runtime.scene;

import entity.runtime.basic.GameObject;
import util.consts.EntityConsts;

public class SceneObject extends GameObject {
	
	public SceneObject(){
		this.type = EntityConsts.TYPE_SCENE;
		this.side = EntityConsts.SIDE_NATURE;
	}
	
	public static void main(String[] args){
		
	}
}
