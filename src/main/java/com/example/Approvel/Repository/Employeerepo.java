package com.example.Approvel.Repository;

import com.example.Approvel.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepo extends JpaRepository<Employee, Long> {
}
