package com.springboot.School_Management_System.controller;

import com.springboot.School_Management_System.Exceptions.UserNotFoundException;
import com.springboot.School_Management_System.entities.Teacher;
import com.springboot.School_Management_System.service.TeacherServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherServiceInterface service;

    @PostMapping("/addTeacher")
    public void addTeacher(@RequestBody Teacher teacher){
        service.addTeacher(teacher);
    }

    @GetMapping("/findTeacher/id/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable String id) throws UserNotFoundException {
        Teacher teacher = service.getTeacherById(id);
        if( teacher != null){
            return new ResponseEntity<>(teacher, HttpStatus.FOUND);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findAllTeachers")
    public ResponseEntity<List<Teacher>> getAllTeachers() throws UserNotFoundException {
        List<Teacher> teachersList = service.getAllTeachers();
        if(teachersList != null){
            return new ResponseEntity<>(teachersList, HttpStatus.FOUND);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/id/{id}")
    public void UpdateTeacher(@RequestBody Teacher teacher, @PathVariable String id) throws UserNotFoundException {
        service.updateTeacherById(teacher, id);
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteTeacherById(@PathVariable String id) throws UserNotFoundException {
        service.deleteTeacherById(id);
    }
}
