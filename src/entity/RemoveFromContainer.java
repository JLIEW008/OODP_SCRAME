package entity;

public class RemoveFromContainer {
	public void removeObject(Container container, String id){
		container.removeByID(id);
	}
}
