package dao;

import java.util.List;

import entity.Student;

public interface StudentDao {

	public Student selectStudentById(int sid);
	
	public List<Student> selectStudentList();
}
