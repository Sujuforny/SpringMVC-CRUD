package com.javatpoint.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.javatpoint.beans.Emp;
import com.javatpoint.beans.Student;

@Component
public class StudentDto {
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	} 
	public Integer createStudent(Student student){  
		Boolean isDeleted = false;
	    String sql="insert into student(name,gender,subject,is_deleted) values('"+student.getName()+"','"+student.getGender()+"','"+student.getSubject()+"',"+isDeleted+")";  
	    return template.update(sql);  
	} 
//  update isDeleted	
	public int updateIsDeleted(int id){  
	    String sql="update Student set is_deleted = true where id="+id+"";  
	    return template.update(sql);  
	}  
//	update student
	public int updateStudent(Student student){  
	    String sql="update Student set name='"+student.getName()+"', gender = '"+student.getGender()+"',subject ='"+student.getSubject()+"' where id = "+student.getId()+" ";  
	    return template.update(sql);  
	}  
//  find student by id	
	public Student getStudentById(int id){  
	    String sql="select * from Student where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));  
	} 
	
//  find all student 
	public List<Student> getStudent(){  
	    return template.query("select * from Student where is_deleted =false",new RowMapper<Student>(){  
	        public Student mapRow(ResultSet rs, int row) throws SQLException {  
	            Student student =new Student();  
	            student.setId(rs.getInt(1));  
	            student.setName(rs.getString(2));  
	            student.setGender(rs.getString(3));  
	            student.setSubject(rs.getString(4));
	            student.setIsDeleted(rs.getBoolean(5));
	            return student;  
	        }  
	    });  
	} 
	public List<Student> getAllStudents(){  
	    return template.query("select * from Student",new RowMapper<Student>(){  
	        public Student mapRow(ResultSet rs, int row) throws SQLException {  
	            Student student =new Student();  
	            student.setId(rs.getInt(1));  
	            student.setName(rs.getString(2));  
	            student.setGender(rs.getString(3));  
	            student.setSubject(rs.getString(4));
	            student.setIsDeleted(rs.getBoolean(5));
	            return student;  
	        }  
	    });  
	} 
	
}
