package 第二部分;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends People {
	private List<Course> courseList;

	public Teacher(String name, int number, String sex) {
		super(name, number, sex);
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	
	public Course addCourse(int number, String classname, String spot, String time) {
		Course course = new Course(number, classname, spot, time, name);
		if (this.courseList == null) {
			this.courseList = new ArrayList<>();
		}
		this.courseList.add(course);
		return course;
	}
}
