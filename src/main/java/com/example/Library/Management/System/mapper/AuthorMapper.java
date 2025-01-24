package com.example.Library.Management.System.mapper;

import com.example.Library.Management.System.dto.request.AuthorRequest;
import com.example.Library.Management.System.dto.response.AuthorResponse;
import com.example.Library.Management.System.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorMapper {
    AuthorResponse authorToResponse(Author author);


    @Mappings(value = {
            @Mapping(target = "books", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    Author requestToAuthor(AuthorRequest authorRequest);

}
