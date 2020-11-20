package com.biz.book.service;

import com.biz.book.domain.BookVO;
import com.biz.book.persistence.BookRepository;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("bookServiceV1")
public class BookServiceV1 implements BookService{

    private final BookRepository bookDAO;

    public BookServiceV1(BookRepository bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<BookVO> selectAll() {
        List<BookVO> bookList = bookDAO.findAll();
        return bookList;
    }

    /*
        Optional
        데이터가 없을을 null이 아닌 어떤 명확한 근거를 바탕으로
        알고싶다 라는 취지에서 새로 생성한 wraper class
        VO클래스를 감싸는 wraper class

        일반적으로 DB핸들링에서 findByID(Long id)를 수행한 후
        id에 해당하는 데이터가 없을경우 return 값이 null이였다.
        if(vo == null)
            log.debug("데이터가 없음");

            Optional은 어떤 객체의 저장된 값이 null인가를 비교하는 것을
            사용하지 않기 위해서 새롭게 등장한 class 이다.
     */
    @Override
    public BookVO findById(Long id) {
        Optional<BookVO> bookVO = bookDAO.findById(id);
        // 만약 findById()를 수행하여 데이터가 없으면
        // 새로운 VO를 만들고 id값을 -1로 세팅하여 리턴하라
        return bookVO.get();
    }

    @Override
    public int insert(BookVO bookVO) {
        bookDAO.save(bookVO);
        return 0;
    }

    @Override
    public int update(BookVO bookVO) {
        bookDAO.save(bookVO);
        return 0;
    }

    @Override
    public int delete(Long id) {
        bookDAO.deleteById(id);
        return 0;
    }
}
