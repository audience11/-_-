package 第一部分;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import 第二部分.Course;
import 第二部分.Student;
import 第二部分.Teacher;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Teacher teacher1 = new Teacher("老师一", 1, "男");
		Teacher teacher2 = new Teacher("老师二", 2, "女");


		Course course1 = teacher1.addCourse(1, "C语言", "教学楼101", "8:00");
		Course course2 = teacher1.addCourse(2, "JAVA", "主楼4203", "10:40");
		Course course3 = teacher2.addCourse(3, "python", "实验楼0901", "13:30");


		Student student1 = new Student("学生一",1111111111, "男");
		Student student2 = new Student("学生二",1111111111, "女");


		student1.selectCourse(course1);
		student1.selectCourse(course2);
		student2.selectCourse(course3);
		List<Course> courseList1 = student1.getCourseList();

		File f = new File("/Users/audience/Desktop/实验六输出.txt");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(courseList1);
		out.close();

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
			List<Course> array = (List<Course>) in.readObject();
			for (int i = 0; i < array.size(); i++) {
				Course course = array.get(i);
				System.out.println("课程" + (i + 1) + course.toString());
			}
			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
			List<Course> array = (List<Course>) in.readObject();
			student1.unSelectCourse(course1);
			System.out.println("学生1退课程1");
			for (int i = 0; i < courseList1.size(); i++) {
				Course course = courseList1.get(i);
				System.out.printf("课程" + (i + 1) + course.toString());
			}
			in.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
