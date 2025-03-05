package com.example.bookregister.BookController;


import com.example.bookregister.BookModel.BookModel;
import com.example.bookregister.BookReository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Método que redireciona para a lista de livros
    @GetMapping("/")
    public String redirectToBook() {
        return "redirect:/livros";  // Redireciona para a lista de livros
    }

    // Método para listar todos os livros
    @GetMapping("/livros")
    public String listBook(Model model, @RequestParam(required = false) String success, @RequestParam(required = false) String error) {
        List<BookModel> books = bookRepository.findAll();  // Busca todos os livros
        model.addAttribute("books", books);  // Adiciona os livros ao modelo para a visualização
        model.addAttribute("success", success);  // Passa a mensagem de sucesso
        model.addAttribute("error", error);  // Passa a mensagem de erro (se houver)
        return "book-list";  // Retorna o nome do template Thymeleaf que será renderizado
    }

    // Método que exibe o formulário para adicionar um novo livro
    @GetMapping("/addLivro")
    public String addBookForm(Model model) {
        model.addAttribute("book", new BookModel());  // Adiciona um novo objeto BookModel ao modelo
        return "book-form";  // Retorna o nome do template para o formulário de adição
    }

    // Método que recebe o livro enviado do formulário e o salva no banco de dados
    @PostMapping("/addLivro")
    public String addBook(@ModelAttribute("book") BookModel book) {
        bookRepository.save(book);  // Salva o livro no banco de dados
        return "redirect:/livros?success=LivroAdicionado";  // Redireciona para a lista de livros após salvar e passa uma mensagem de sucesso
    }

    // Método que exclui um livro com base no seu ID
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        if (bookRepository.existsById(id)) {  // Verifica se o livro existe no banco
            bookRepository.deleteById(id);  // Deleta o livro com o ID fornecido
            return "redirect:/livros?success=LivroExcluido";  // Redireciona para a lista de livros após excluir e passa uma mensagem de sucesso
        }
        return "redirect:/livros?error=LivroNaoEncontrado";  // Se o livro não for encontrado, redireciona com um erro
    }

    // Método que exibe o formulário de edição de um livro existente
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<BookModel> book = bookRepository.findById(id);  // Busca o livro pelo ID
        if (book.isPresent()) {  // Verifica se o livro foi encontrado
            model.addAttribute("book", book.get());  // Adiciona o livro ao modelo
            return "book-form";  // Retorna o formulário para edição
        } else {
            return "redirect:/livros?error=LivroNaoEncontrado";  // Se o livro não for encontrado, redireciona com um erro
        }
    }

    // Método que recebe o livro editado do formulário e atualiza no banco de dados
    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, @ModelAttribute("book") BookModel book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);  // Garante que o ID do livro não será perdido
            bookRepository.save(book);  // Atualiza o livro no banco de dados
            return "redirect:/livros?success=LivroAtualizado";  // Redireciona para a lista de livros após atualizar e passa uma mensagem de sucesso
        }
        return "redirect:/livros?error=LivroNaoEncontrado";  // Se o livro não for encontrado, redireciona com um erro
    }
}