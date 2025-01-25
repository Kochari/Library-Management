package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dto.response.StudentResponse;
import com.example.Library.Management.System.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentResponse> getAllStudents(int page, int size);
    StudentResponse getStudentById(Long id);
    void addStudent(Student student);
    void updateStudent(Student student, Long id);
    void deleteStudent(Long id);


}
