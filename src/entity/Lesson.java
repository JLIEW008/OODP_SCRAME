package entity;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * <code>Lessons</code> is a serializable entity class representing the lessons each course has.
 * Lessons include labs, lectures and tutorials.
 * @author LFM
 * @version 1.0
 * @since 2018-11-07
 */


public class Lesson implements Serializable,Printable {

    private ArrayList<String> studentIDs;

    private String profName, lessonID, lessonType; 

    private int vacancy;

    private enum lessonType {TUTORIAL,LAB,LECTURE};
    
	private Lesson() {
		this.studentIDs= new ArrayList<String>();
	}
	
	

    /**
     * Creates a new Lesson object.
     */
	public Lesson buildLesson(String lessonID, String profName, int vacancy, String lessonType) {
		Lesson lesson = new Lesson(); 
		lesson.vacancy = vacancy; 
		lesson.lessonID = lessonID; 
		lesson.lessonType = lessonType; 
		lesson.profName = profName; 
		return lesson; 
	}

	
	
	
	
	
	
    /**
     * Sets the name of the Professor teaching this Lesson.
     * @param name new name of Professor.
     */
    public void setprofName(String name) {
    	this.profName = name;
    }

    /**
     * Registers a Student for this Lesson.
     * This decreases the remaining vacancies for this Lesson by 1.
     * @param id ID of the <code>Student</code> registering for this Lesson.
     */
    public void addStudent(String id) {
    	this.studentIDs.add(id);
    	this.vacancy--;
    	
    }

    /**
     * Sets the Students registered for this Course with a predetermined list of Students
     * @param studentIDs <code>ArrayList</code> of Student IDs of Students registering for this Lesson.
     */
    public void setStudentIDs(ArrayList<String> studentIDs) {
    	this.studentIDs = studentIDs;
    }

    /**
     * Sets the number of vacancies for this Lesson.
     * @param vacancy the new vacancy number.
     */
    public void setVacancy(int vacancy) {
    	this.vacancy = vacancy;
    }

    /**
     * Gets the lessonID of this Lesson
     * @return a <code>String</code> representing this Lesson's ID.
     */
    public String getLessonID() {
    	return this.lessonID;
    }

    /**
     * Gets the name of the Professor teaching this Lesson.
     * @return the name of the Professor.
     */
    public String getProfName() {
    	return this.profName;
    }

    /**
     * Gets the list of Student ID's of Students registered for this Lesson.
     * @return an <code>ArrayList</code> of Student IDs.
     */
    public ArrayList<String> getstudentIDs() {
    	return this.studentIDs;
    }

    /**
     * Gets the number of vacancies for this Lesson.
     * @return the number of vacancies.
     */
    public int getVacancy() {
    	return this.vacancy;
    }

/**
 * Prints the Lesson Information of this Lesson.
 */
    public void printInfo() {
    	if(!studentIDs.isEmpty()) {
    		System.out.println("Students Registered in Course:");
	    	for(String id : studentIDs) {
				System.out.println(id);
			}
    	}
    }

}