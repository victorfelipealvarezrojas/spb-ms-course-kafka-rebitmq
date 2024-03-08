package org.lerning.departmentservice.adapter.input;


import org.lerning.departmentservice.adapter.mapper.DepartmentDtoToDepartmentMapper;
import org.lerning.departmentservice.dto.DepartmentDto;
import org.lerning.departmentservice.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDtoToDepartmentMapperImpl implements DepartmentDtoToDepartmentMapper {
    @Override
    public Department map(DepartmentDto departmentDto) {
        return Department.builder()
                .departmentCode(departmentDto.getDepartmentCode())
                .departmentName(departmentDto.getDepartmentName())
                .departmentDescription(departmentDto.getDepartmentDescription())
                .build();
    }
}
