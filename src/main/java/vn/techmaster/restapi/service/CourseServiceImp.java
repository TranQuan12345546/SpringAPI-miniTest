package vn.techmaster.restapi.service;

import org.springframework.stereotype.Component;
import vn.techmaster.restapi.entity.Course;
import vn.techmaster.restapi.entity.CourseAdmin;
import vn.techmaster.restapi.entity.User;
import vn.techmaster.restapi.exception.NotFoundException;
import vn.techmaster.restapi.request.UpsertCourseRequest;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseServiceImp implements CourseService{
    private static ArrayList<Course> courses = new ArrayList<>();
    private static List<CourseAdmin> courseAdmins = new ArrayList<>();
    static {
        List<String> topic = new ArrayList<>();

        topic.add("backend");
        topic.add("java");
        User user1 = new User(1, "Nguyễn Văn A", "a@gmail.com", "0987654321", "");
        User user2 = new User(2, "Nguyễn Văn B", "ab@gmail.com", "0987654431", "");
        User user3 = new User(3, "Nguyễn Văn C", "abc@gmail.com", "0987664321", "");
        courses.add(new Course(1, "Khóa học 1", "Mô tả", "online", topic, "", 1 , user1));
        courses.add(new Course(2, "Khóa học 2", "Mô tả", "offline", topic, "", 2 , user2));
        courses.add(new Course(3, "Khóa học 3", "Mô tả", "online", topic, "", 3, user3));
        courseAdmins.add(new CourseAdmin(1, 10, 2, 19, courses));
    }


    @Override
    public List<Course> getListCourse(String type, String name, List<String> topic) {
        List<Course> courses1 = new ArrayList<>();
        if (!type.isEmpty()) {
            for (Course course : courses) {
                if (type.equals(course.getType())) {
                    courses1.add(course);
                }
            }
        } else if (!name.isEmpty()) {
            for (Course course : courses) {
                if (name.contains(course.getName())) {
                    courses1.add(course);
                }
            }
        } else if (!topic.isEmpty()) {
            for (Course course : courses) {
                if (topic.contains(course.getTopics())) {
                    courses1.add(course);
                }
            }

        } else {
            return courses;
        }
        return courses1;
    }

    @Override
    public List<CourseAdmin> getListCourseAdmin() {
        return courseAdmins;
    }

    @Override
    public Course getCourseInfo(Integer id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        throw new NotFoundException("Khong tim thay khoa hoc");
    }

    @Override
    public Course createCourse(UpsertCourseRequest upsertCourseRequest) {
        Course course = new Course();
        course.setId(courses.size()+1);
        course.setName(upsertCourseRequest.getName());
        course.setDescription(upsertCourseRequest.getDescription());
        course.setType(upsertCourseRequest.getType());
        course.setTopics(upsertCourseRequest.getTopics());
        course.setUserId(upsertCourseRequest.getUserId());
        courses.add(course);
        return course;
    }

    @Override
    public Course updateCourse(UpsertCourseRequest upsertCourseRequest, Integer id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                course.setName(upsertCourseRequest.getName());
                course.setDescription(upsertCourseRequest.getDescription());
                course.setType(upsertCourseRequest.getType());
                course.setTopics(upsertCourseRequest.getTopics());
                course.setUserId(upsertCourseRequest.getUserId());
                return course;
            }
        }
        throw new NotFoundException("No course with id " + id);
    }

    @Override
    public boolean deleteCourse(Integer id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                courses.remove(course);
                return true;
            }
        }
        throw new NotFoundException("No course with id " + id);
    }
}
