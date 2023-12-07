package com.example.demo.service;

import com.example.demo.model.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    List<BookResponse> findAll();
}
