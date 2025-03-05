package com.example.bookregister.BookReository;

import com.example.bookregister.BookModel.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Long> {
    // Aqui você pode adicionar consultas personalizadas se necessário
}