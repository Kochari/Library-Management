package com.example.Library.Management.System.mapper;

import com.example.Library.Management.System.dto.request.StudentRequest;
import com.example.Library.Management.System.dto.response.StudentResponse;
import com.example.Library.Management.System.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    StudentResponse studentToStudentResponse(Student student);
    Student studentRequestToStudent(StudentRequest studentRequest);

}
