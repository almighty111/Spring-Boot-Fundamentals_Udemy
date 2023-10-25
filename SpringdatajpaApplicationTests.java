package com.krishna.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.krishna.springdatajpa.entities.Student;
import com.krishna.springdatajpa.repos.StudentRepository;

@SpringBootTest
class SpringdatajpaApplicationTests {
	
	@Autowired
	private StudentRepository repo;

	@Test
	void testSaveStudent() {
		Student student = new Student();
		student.setId(1l);
		student.setName("Krishna");
		student.setTestScore(100);
		repo.save(student);
		
		Student savedStudent = repo.findById(1l).get();
		assertNotNull(savedStudent);
	}
	
	@Test
	void testUpdateStudent() {
		Student selectedStudent = repo.findById(1l).get();
        selectedStudent.setName("Yedu");
        selectedStudent.setTestScore(90);
        repo.save(selectedStudent);

        Student savedStudent = repo.findById(1l).get();
        assertNotNull(savedStudent);
        assertEquals("Yedu", savedStudent.getName());
        assertEquals(90, savedStudent.getTestScore());
	}
	
	
	@Test
	void testDeleteStudent() {
		repo.deleteById(1l);
		Optional<Student> deletedStudent = null;
		try {
			deletedStudent = repo.findById(1l);
			} catch (Error error) {
				assertNull(deletedStudent);
	        }
	}
}
