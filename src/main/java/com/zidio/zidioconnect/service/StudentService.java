package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.DTO.StudentDto;
import com.zidio.zidioconnect.entity.StudentProfile;
import com.zidio.zidioconnect.repository.StudentRepository;
import com.zidio.zidioconnect.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UsersRepository usersRepository;

    public String createOrUpdate(StudentDto dto){
        StudentProfile student = studentRepository.findByEmail(dto.email).orElse(new StudentProfile());

        student.setSkills(dto.skills);
        student.setEducation(dto.education);
        student.setResumeUrl(dto.resumeUrl);
        student.setEmail(dto.email);
        student.setUsers(usersRepository.findByEmail(dto.email).get());
        studentRepository.save(student);

        return "Student Profile got saved";


    }
    public StudentDto getProfile(String email){
        StudentProfile student = studentRepository.findByEmail(email).orElseThrow();
        StudentDto dto = new StudentDto();

        dto.email = student.getEmail();
        dto.skills = student.getSkills();
        dto.education = student.getEducation();
        dto.resumeUrl = student.getResumeUrl();
        return dto;
    }
}