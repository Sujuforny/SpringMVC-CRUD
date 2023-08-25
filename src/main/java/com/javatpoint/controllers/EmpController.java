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
import com.javatpoint.dao.EmpDao;  
@Controller
@RequestMapping("/emp")
public class EmpController {  
    @Autowired  
    EmpDao dao; 
    
    @RequestMapping
    public String emp(){
    	
    	return "emp/emp";
    }
    @RequestMapping("/empform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Emp());
    	return "emp/empform"; 
    }  
  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("emp") Emp emp){  
        dao.save(emp);  
        return "redirect:/emp/viewemp";
    }  

    @RequestMapping("/viewemp")  
    public String viewemp(Model m){  
        List<Emp> list=dao.getEmployees();  
        m.addAttribute("list",list);
        return "emp/viewemp";  
    }  
 
    @RequestMapping(value="/editemp/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Emp emp=dao.getEmpById(id);  
        m.addAttribute("command",emp);
        return "emp/empeditform";  
    }  

 
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("emp") Emp emp){  
        dao.update(emp);  
        return "redirect:/emp/viewemp";  
    }  
    
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/emp/viewemp";  
    }   
}  