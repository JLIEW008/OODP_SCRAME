package containers;

import java.util.List;

import entity.Student;

import java.util.ArrayList;

public class StudentContainer extends Container{
	private List<Student> students = ArrayList<Student>();
	
	@Override
	public Object findByID(String id) {
		for(Student student: this.students) {
			if(student.getID().equals(id)) {
				return student;
			}
		}
		return null;
	}

	@Override
	public void removeByID(String id) {
		Student student = findByID(id);
		if(student != null) {
			this.students.remove(student);
		}
		throw new Exception("Student does not exists");
	}

	@Override
	public void add(Object o) {
		Student student = (Student)o;
		if(findByID(student.getID()) == null) {
			this.students.add(student);
		}
		throw new Exception("Student already exists");
	}	
	
}
