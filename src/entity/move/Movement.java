package entity.move;

import entity.exception.IllegalArgumentException;

public class Movement {
	double start_x = 0.0;
	double start_y = 0.0;
	
	double end_x = 0.0;
	double end_y = 0.0;
	
	double velocity = 0.0;
	double acceleration = 0.0;
	
	public Movement(double velocity, double acceleration, double[] start_end) throws IllegalArgumentException{
		if(start_end.length!=4){
			throw new IllegalArgumentException("Argument start_end should be an array with length of 4.");
		}
	}
}
