package main.panel;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import entity.runtime.basic.GameObject;

public class PanelMap extends JPanel{
	
	private boolean doDraw = false;
	
	private Map<Point, GameObject> scene = new HashMap<Point, GameObject>();
	private Map<Point, GameObject> vary = new HashMap<Point, GameObject>();
	
	public PanelMap(Timer timer){
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if(doDraw){
					PanelMap.this.repaint();	
				}
			}
		}, 0, 10);
	}
}
