package com.krishna.springdatajpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krishna.springdatajpa.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
