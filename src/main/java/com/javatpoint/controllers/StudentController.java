package com.javatpoint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatpoint.beans.Emp;
import com.javatpoint.beans.Student;
import com.javatpoint.dao.StudentDto;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentDto studentDto;
	@RequestMapping
	public String student() {
		return "student/student";
	}
	@RequestMapping("/student-form")
	public String studentForm(Model model) {
		model.addAttribute("command", new Student());
		return "student/studentform";
	}
	@RequestMapping("/delete-by-status/{id}")
	public String updateIsDeleted(@PathVariable Integer id) {
		 studentDto.updateIsDeleted(id);
		 return "redirect:/student/student-view";
	}
    @RequestMapping(value="/save-student",method = RequestMethod.POST)  
    public String createStudent(@ModelAttribute("student") Student student){  
        studentDto.createStudent(student);
        return "redirect:/student/student-view";
    } 
    @RequestMapping(value="/editstudent/{id}")  
    public String edit(@PathVariable Integer id, Model m){  
        Student student=studentDto.getStudentById(id);  
        System.out.print("student in edit"+student);
        m.addAttribute("command",student);
        return "student/studenteditform";  
    }  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("student") Student student){  
        studentDto.updateStudent(student); 
        return "redirect:/student/student-view";  
    }
	@RequestMapping("student-view")
	public String viewStudent(Model model) {
		List<Student> student = studentDto.getStudent();
		model.addAttribute("student", student);
		return "student/viewstudent";		
	}
	@RequestMapping("view-all-students")
	public String viewStudents(Model model) {
		List<Student> student = studentDto.getAllStudents();
		model.addAttribute("student", student);
		return "student/viewstudent";		
	}

}
