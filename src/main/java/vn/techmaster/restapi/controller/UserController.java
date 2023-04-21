package vn.techmaster.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.restapi.entity.Course;
import vn.techmaster.restapi.service.CourseService;
import vn.techmaster.restapi.service.CourseServiceImp;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/courses")
    public ResponseEntity<?> getListCourse(@RequestParam(required=false) String type,
                                           @RequestParam(required=false) String name,
                                           @RequestParam(required=false) List<String> topic) {
        List<Course> courses = courseService.getListCourse(type, name, topic);
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<?> getCourseInfo(@PathVariable Integer id) {
        Course course = courseService.getCourseInfo(id);
        return ResponseEntity.ok(course);
    }

}
