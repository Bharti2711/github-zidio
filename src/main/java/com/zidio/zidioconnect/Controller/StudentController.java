package com.zidio.zidioconnect.Controller;

import com.zidio.zidioconnect.DTO.StudentDto;
import com.zidio.zidioconnect.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/students")
public class StudentController {

@Autowired
private StudentService studentService;

@PostMapping("/profile")
public ResponseEntity<String>save(@RequestBody StudentDto dto){
    return ResponseEntity.ok(studentService.createOrUpdate(dto));
}
@GetMapping("profile/{email}")
public ResponseEntity<StudentDto>get(@PathVariable String email){
    return ResponseEntity.ok(studentService.getProfile(email));
}
}