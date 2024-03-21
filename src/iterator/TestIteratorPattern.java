package iterator;

import java.util.ArrayList;
import java.util.List;

class Student {				// Aggregate
	private int rollNo;
	private String name;
	
	public Student(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + "]";
	}
}


class Students {											// ConcreteAggregate
	private List<Student> students = new ArrayList<>();
	
//	public void addStudent(Student student) {
//		students.add(student);
//	}
	public void addStudent(int rollNo, String name) {
		students.add(new Student(rollNo,name));
	}
	public List<Student> getStudents() {
		return students;
	}
	public Iterator iterator() {
		return new StudentsIterator(students);
	}
}

interface Iterator {				// Iterator
	boolean hasNext();
	Student next();
}

class StudentsIterator implements Iterator {		// Concrete Iterator
	
	private List<Student> students;
	private int index;
	
	public StudentsIterator(List<Student> students) {
		this.students = students;
	}
	
	@Override
	public boolean hasNext() {
		return index < students.size();
	}

	@Override
	public Student next() {
		return students.get(index++);
	}
	
}


public class TestIteratorPattern {

	public static void main(String[] args) {
		
		Students students = new Students();
		students.addStudent(1,"Sathish");
		students.addStudent(2,"Kumar");
		students.addStudent(3,"Mrsk");
		
		Iterator studentsItr = students.iterator(); 
		while(studentsItr.hasNext()) {
			System.out.println(studentsItr.next());
		}
		
//		Iterator studentsItr2 = students.iterator(); 
//		while(studentsItr2.hasNext()) {
//			System.out.println(studentsItr2.next());
//		}
		
	}

}
