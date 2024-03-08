package org.lerning.departmentservice.adapter.mapper;

import org.lerning.departmentservice.dto.DepartmentDto;
import org.lerning.departmentservice.entity.Department;

public interface DepartmentDtoToDepartmentMapper {
    Department map(DepartmentDto departmentDto);
}
