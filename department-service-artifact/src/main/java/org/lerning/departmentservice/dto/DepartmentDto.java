package org.lerning.departmentservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private Long id;

    @NotEmpty(message = "departmentName cannot be empty")
    @Size(min = 3, max = 50, message = "departmentName must be between 3 and 50 characters")
    private String departmentName;

    @NotEmpty(message = "departmentDescription cannot be empty")
    @Size(min = 10, max = 100, message = "departmentDescription must be between 10 and 100 characters")
    private String departmentDescription;

    @NotEmpty(message = "departmentCode cannot be empty")
    @Size(min = 3, max = 20, message = "departmentCode must be between 3 and 20 characters")
    private String departmentCode;
}