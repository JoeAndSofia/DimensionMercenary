package entity.runtime.scene;

import java.util.ArrayList;
import java.util.List;


public class Team extends SceneObject {
	
	public static void main(String[] args){
		
	}
	
	
	public List<Movement> movements = new ArrayList<Movement>();
	
	public Team(){
		this.type = TYPE_SCENE_TEAM;
		this.side = SIDE_NATURE;
	}
	
	static class Movement{
		public double start_x = 0.0;
		public double start_y = 0.0;
		public double end_x = 0.0;
		public double end_y = 0.0;
		public double speed = 0.0;
		public double acceleration = 0.0;
		
		public Movement(){
			
		}

		public Movement(
			double start_x, double start_y,
			double end_x, double end_y,
			double speed, double acceleration
		) {
			super();
			this.start_x = start_x;
			this.start_y = start_y;
			this.end_x = end_x;
			this.end_y = end_y;
			this.speed = speed;
			this.acceleration = acceleration;
		}
	}
}
