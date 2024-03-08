package org.lerning.departmentservice.adapter.output;

import org.lerning.departmentservice.adapter.mapper.DepartmentToDepartmentDtoMapper;
import org.lerning.departmentservice.dto.DepartmentDto;
import org.lerning.departmentservice.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentToDepartmentDtoMapperImpl implements DepartmentToDepartmentDtoMapper {
    @Override
    public DepartmentDto map(Department department) {
        return DepartmentDto.builder()
                .id(department.getId())
                .departmentCode(department.getDepartmentCode())
                .departmentName(department.getDepartmentName())
                .departmentDescription(department.getDepartmentDescription())
                .build();
    }
}