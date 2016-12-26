package entity.scene;

import java.util.ArrayList;
import java.util.List;

import entity.move.Movement;
import util.consts.EntityConsts;


public class Team extends SceneObject {
	
	public List<Movement> movements = new ArrayList();
	
	public Team(){
		this.type = EntityConsts.TYPE_SCENE_TEAM;
		this.side = EntityConsts.SIDE_NATURE;
	}
	
	public static void main(String[] args){
		
	}
}
