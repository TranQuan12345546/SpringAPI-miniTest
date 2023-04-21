package vn.techmaster.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseAdmin {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<Course> data;
}
