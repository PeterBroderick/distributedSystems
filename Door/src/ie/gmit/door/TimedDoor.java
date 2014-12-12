package ie.gmit.door;

public class TimedDoor implements Doorable, Timer {
	private Doorable door = null;
	private Timer t = null;
	
	

	public TimedDoor(Doorable d, Timer t) {
		// TODO Auto-generated constructor stub
		this.door = d;
		this.t = t;
	}



	public void open() {
		door.open();
	}



	public void close() {
		door.close();
	}



	public void setTimeout(int time) {
		t.setTimeout(time);
	}

}
