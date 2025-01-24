package com.example.Library.Management.System.mapper;

import com.example.Library.Management.System.dto.response.CategoryResponse;
import com.example.Library.Management.System.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    CategoryResponse categoryToCategoryResponse(Category category);

    Category categoryResponseToCategory(CategoryResponse categoryResponse);
}
