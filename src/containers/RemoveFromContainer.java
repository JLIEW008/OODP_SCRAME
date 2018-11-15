package containers;

public class RemoveFromContainer {
	public void removeObject(Container container, String id){
		try {
			container.removeByID(id);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
