package com.example.bookmanager.BookReository;

import com.example.bookmanager.BookModel.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Long> {
    // Aqui você pode adicionar consultas personalizadas se necessário
}