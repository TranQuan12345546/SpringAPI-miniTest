package vn.techmaster.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer id;
    private String name;
    private String description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private Integer userId;
    private User user;
}
