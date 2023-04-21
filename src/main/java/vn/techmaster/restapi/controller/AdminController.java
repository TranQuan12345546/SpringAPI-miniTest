package vn.techmaster.restapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.restapi.entity.Course;
import vn.techmaster.restapi.entity.CourseAdmin;
import vn.techmaster.restapi.request.UpsertCourseRequest;
import vn.techmaster.restapi.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AdminController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/admin/courses")
    public ResponseEntity<?> getListCourseAdmin(@RequestParam(required=false, defaultValue = "1") int page,
                                           @RequestParam(required=false, defaultValue = "10") int pageSize) {
        List<CourseAdmin> result = courseService.getListCourseAdmin();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/admin/courses")
    public ResponseEntity<?> createCourse(@Valid @RequestBody UpsertCourseRequest upsertCourseRequest) {
        Course result = courseService.createCourse(upsertCourseRequest);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/admin/courses/{id}")
    public ResponseEntity<?> getCourseInfo(@PathVariable Integer id) {
        Course course = courseService.getCourseInfo(id);
        return ResponseEntity.ok(course);
    }

    @PutMapping("/admin/courses/{id}")
    public ResponseEntity<?> updateCourse(@Valid @RequestBody UpsertCourseRequest upsertCourseRequest, @PathVariable Integer id) {
        Course course = courseService.updateCourse(upsertCourseRequest, id);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/admin/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        Boolean result = courseService.deleteCourse(id);
        return ResponseEntity.ok(result);
    }
}
