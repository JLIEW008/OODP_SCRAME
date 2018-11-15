package entity;

import java.util.ArrayList;
import java.util.List;

public class CourseContainer extends Container implements Findable, Removable {
	private List<Course> courses = new ArrayList<Course>();
	@Override
	public Course findByID(String id) {
		for(Course course : this.courses) {
			if(course.getID().equals(id)) {
				return course;
			}
		}
		return null;
	}

	@Override
	public void removeByID(String id) throws Exception{
		Course course = findByID(id);
		if(course != null) {
			this.courses.remove(course);
		}
		throw new Exception("Course not found");
	}

	@Override
	public void add(Object o) throws Exception{
		Course course = (Course)o;
		if(findByID(course.getID()) == null) {
			this.courses.add(course);
		}
		throw new Exception("Course not found");
		
	}

}
