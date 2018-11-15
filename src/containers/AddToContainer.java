package containers;

public class AddToContainer {
	public void add(Container container, Object o) {
		try {
			container.add(o);
		}catch(Exception e) {
			System.out.println(e); //Should not happen, for debugging purposes
		}
	}
}
