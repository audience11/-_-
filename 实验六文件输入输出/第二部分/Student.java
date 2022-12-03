package 第二部分;

import java.util.ArrayList;
import java.util.List;

public class Student extends People {
	private List<Course> courseList;

	public Student(String name, int number, String sex) {
		super(name, number, sex);
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public void selectCourse(Course course) {
		if (this.courseList == null) {
			this.courseList = new ArrayList<>();
		}
		this.courseList.add(course);
	}

	public void unSelectCourse(Course course) {
		if (this.courseList != null) {
			if (this.courseList.contains(course)) {
				this.courseList.remove(course);
			}
		}
	}
}
