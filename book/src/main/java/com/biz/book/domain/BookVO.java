package com.biz.book.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Builder
@Entity
@Table(name="tbl_book")
public class BookVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", columnDefinition = "BIGINT")
    private long id;

    @Column(length = 255) private String str_name;
    @Column(columnDefinition = "VARCHAR(125)") private String title;
    @Column(length = 30) private String author;
    @Column(length = 125) private String comp;
    @Column(nullable = true) private int price;
}
