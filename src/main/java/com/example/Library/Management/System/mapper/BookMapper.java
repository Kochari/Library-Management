package com.example.Library.Management.System.mapper;

import com.example.Library.Management.System.dto.request.BookRequest;
import com.example.Library.Management.System.dto.response.BookResponse;
import com.example.Library.Management.System.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
    BookResponse bookToBookResponse(Book book);

    Book bookRequestToBook(BookRequest bookRequest);
}
