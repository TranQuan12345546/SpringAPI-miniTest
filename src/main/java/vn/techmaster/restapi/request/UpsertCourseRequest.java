package vn.techmaster.restapi.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpsertCourseRequest {
    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    private String name;

    @NotNull(message = "description is required")
    @NotEmpty(message = "description is required")
    @Size(min = 50, message = "description must be larger than 50 characters")
    private String description;
    @NotNull(message = "type is required")
    @NotEmpty(message = "type is required")
    private String type;
    private List<String> topics;
    private String thumbnail;
    @NotNull(message = "userId is required")
    @NotEmpty(message = "userId is required")
    private Integer userId;
}
