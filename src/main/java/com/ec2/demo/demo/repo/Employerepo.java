package com.ec2.demo.demo.repo;


import com.ec2.demo.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import org.springframework.stereotype.Repository;

@Repository
public interface Employerepo extends JpaRepository<Employee,Long> {
}
