package ie.gmit.door;

public class SlidingDoor extends AbstractDoor {

	@Override
	public void open() {
		// TODO Auto-generated method stub
		super.open();
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		super.close();
		System.out.println("Closing Sliding door");
		
	}

	public SlidingDoor() {
		// TODO Auto-generated constructor stub
		System.out.println("Opening Sliding door");
		
	}

}
