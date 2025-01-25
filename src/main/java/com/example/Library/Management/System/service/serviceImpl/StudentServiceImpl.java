package com.example.Library.Management.System.service.serviceImpl;

import com.example.Library.Management.System.dto.response.StudentResponse;
import com.example.Library.Management.System.entity.Student;
import com.example.Library.Management.System.exception.NotFoundException;
import com.example.Library.Management.System.mapper.StudentMapper;
import com.example.Library.Management.System.repository.StudentRepository;
import com.example.Library.Management.System.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    @Override
    public List<StudentResponse> getAllStudents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> students = studentRepository.findAll(pageable);
        if (students.isEmpty()) {
            throw new NotFoundException("Student not found");
        }else {
            return studentRepository
                    .findAll()
                    .stream()
                    .map(studentMapper::studentToStudentResponse)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Student not found")
        );
        return studentMapper.studentToStudentResponse(student);
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student, Long id) {
        Student _student = studentRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Student not found")
        );

        _student.setFirstName(student.getFirstName());
        _student.setLastName(student.getLastName());
        _student.setEmail(student.getEmail());
        _student.setPhone(student.getPhone());
        _student.setFIN(student.getFIN());
        _student.setOrders(student.getOrders());
        studentRepository.save(_student);

    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
