package com.biz.book.controller;

import com.biz.book.domain.BookVO;
import com.biz.book.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping(value="/book")
@Controller
public class BookController {

    @Qualifier("bookServiceV1")
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value="/list")
    public String getList(Model model){

        List<BookVO> bookList = bookService.selectAll();
        model.addAttribute("BOOKS", bookList);
        return "book/list";
    }

    @RequestMapping(value="/view", method = RequestMethod.GET)
    public String view(String id, Model model){
        BookVO bookVO = bookService.findById(Long.valueOf(id));
        model.addAttribute("BOOK", bookVO);
        return "book/view";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") String id){
        bookService.delete(Long.valueOf(id));
        return "redirect:/book/list";
    }
}
