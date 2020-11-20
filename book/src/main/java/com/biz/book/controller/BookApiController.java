package com.biz.book.controller;

import com.biz.book.domain.BookVO;
import com.biz.book.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value="/api")
@RestController
public class BookApiController {

    @Qualifier("bookServiceV1")
    private final BookService bookService;

    public BookApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseBody
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List<BookVO> getList(){
        List<BookVO> bookList = bookService.selectAll();
        return bookList;
    }
}
