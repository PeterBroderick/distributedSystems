package ie.gmit.door;

public abstract class AbstractDoor implements Doorable {

	private boolean open = false;

	public AbstractDoor() {
		super();
	}

	/* (non-Javadoc)
	 * @see ie.gmit.door.Doorable#open()
	 */
	@Override
	public void open() {
		this.open = true;
		System.out.println("Open. ");
	}

	/* (non-Javadoc)
	 * @see ie.gmit.door.Doorable#close()
	 */
	@Override
	public void close() {
		this.open = false;
		System.out.println("Close");
	}

}