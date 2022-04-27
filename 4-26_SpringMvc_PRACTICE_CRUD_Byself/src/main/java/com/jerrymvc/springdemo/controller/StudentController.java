package com.jerrymvc.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jerrymvc.springdemo.model.Students;
import com.jerrymvc.springdemo.service.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("list") // 在student/list下面，有沒有斜線/都沒差，但依據穩健原則還是寫一下比較好
	public String listStudent(Model model) {
		List<Students> allStudents = studentService.getAllStudent();
		// 回傳一個addAttribute的cookie
		model.addAttribute("studentlist", allStudents);
		return "student/listStudent";
		// 搜尋資料夾student底下的listStudent.jsp

	}

	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("id") Integer id) {
		studentService.deleteStudent(id);
		return "redirect:list";
	}

}
