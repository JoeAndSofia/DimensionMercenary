package entity.runtime.scene;


public class Gathering extends SceneObject{
	
	public int population = 0;
	public boolean habitable = true;

	public Gathering(){
		this.type = TYPE_SCENE_GATHERING;
		this.side = SIDE_NATURE;
	}
	
	public static void main(String[] args){
		
	}
}
