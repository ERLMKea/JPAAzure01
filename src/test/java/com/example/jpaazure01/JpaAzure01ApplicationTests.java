package com.example.jpaazure01;

import com.example.jpaazure01.model.Student;
import com.example.jpaazure01.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@DataJpaTest
class JpaAzure01ApplicationTests {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void contextLoads() {

    }

    @Test
    void testStudents() {
        List<Student> lstStudent = studentRepository.findAll();
        assertEquals(0, lstStudent.size());
        Student std = new Student();
        std.setBorn(LocalDate.now());
        std.setBornTime(LocalTime.now());
        std.setName("size =" + lstStudent.size()+1);
        studentRepository.save(std);
        lstStudent = studentRepository.findAll();
        assertEquals(1, lstStudent.size());
    }


}
