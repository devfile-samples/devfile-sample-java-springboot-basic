package com.example.demo.service.impl;

import com.example.demo.model.BookResponse;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public List<BookResponse> findAll() {
        List<BookResponse> list = new ArrayList<>();
        list.add(new BookResponse(1L,"O SENHOR DOS ANEIS - A Sociedade do Anel",
                "Em uma terra fantástica e única, " +
                        "um hobbit recebe de presente de seu tio um anel mágico " +
                        "e maligno que precisa ser destruído antes que caia nas mãos do mal. " +
                        "Para isso, o hobbit Frodo tem um caminho árduo pela frente, " +
                        "onde encontra perigo, medo e seres bizarros. " +
                        "Ao seu lado para o cumprimento desta jornada, " +
                        "ele aos poucos pode contar com outros hobbits, " +
                        "um elfo, um anão, dois humanos e um mago, " +
                        "totalizando nove seres que formam a Sociedade do Anel."));
        return list;
    }
}
