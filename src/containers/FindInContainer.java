package containers;

public class FindInContainer {
	public Object findObject(Container container, String id){
		return container.findByID(id);
	}
	
	public Object findObjectByType(TypeFindableContainer container, String id, int type){
		return container.findByType(id, type);
	}
}
