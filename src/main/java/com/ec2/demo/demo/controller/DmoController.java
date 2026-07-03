package com.ec2.demo.demo.controller;

import com.ec2.demo.demo.entity.Employee;
import com.ec2.demo.demo.repo.Employerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;

@RestController
@CrossOrigin(origins = "*")
public class DmoController {

    @Autowired
    private Employerepo employeerepo;

    @GetMapping("/healthCheck")
    public String healthCheck() throws UnknownHostException {
        return "Application is up and running Served by: "
                + java.net.InetAddress.getLocalHost().getHostName();
    }

    @GetMapping("/hello")
    public String hello() throws UnknownHostException {
        return "Hey this is first deployment into EC2 : "
                + java.net.InetAddress.getLocalHost().getHostName();
    }

    @GetMapping("/danu")
    public String danu() throws UnknownHostException {
        return "Hey this is Blue green deployment : "
                + java.net.InetAddress.getLocalHost().getHostName();
    }

    // CREATE
    @PostMapping("/save")
    public String save(@RequestBody Employee employee) {
        employeerepo.save(employee);
        return "Employee saved successfullyyyyy";
    }

    // READ
    @GetMapping("/get/{empid}")
    public Object getEmp(@PathVariable long empid) {

        return employeerepo.findById(empid);
    }

    // DELETE
    @DeleteMapping("/delete/{empid}")
    public String delete(@PathVariable long empid) {

        if (employeerepo.existsById(empid)) {
            employeerepo.deleteById(empid);
            return "Deleted successfully";
        }

        return "Employee not found with id: " + empid;
    }
}
