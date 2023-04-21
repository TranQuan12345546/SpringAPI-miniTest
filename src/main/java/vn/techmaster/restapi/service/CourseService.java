package vn.techmaster.restapi.service;

import org.springframework.stereotype.Service;
import vn.techmaster.restapi.entity.Course;
import vn.techmaster.restapi.entity.CourseAdmin;
import vn.techmaster.restapi.request.UpsertCourseRequest;

import java.util.List;

@Service
public interface CourseService {
    List<Course> getListCourse(String type, String name, List<String> topic);
    List<CourseAdmin> getListCourseAdmin();
    Course getCourseInfo(Integer id);

    Course createCourse(UpsertCourseRequest upsertCourseRequest);

    Course updateCourse(UpsertCourseRequest upsertCourseRequest, Integer id);

    boolean deleteCourse(Integer id);
}
