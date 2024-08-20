

package com.example.bookstore.controller;



@RestController
@RequestMapping("/api/books")
@Validated
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookModelAssembler bookModelAssembler;

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        Book savedBook = bookService.save(book);
        BookDTO responseDTO = bookModelAssembler.toModel(savedBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public CollectionModel<BookDTO> getAllBooks() {
        List<Book> books = bookService.findAll();
        return bookModelAssembler.toCollectionModel(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        BookDTO responseDTO = bookModelAssembler.toModel(book);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
        Book book = bookService.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        book.setIsbn(bookDTO.getIsbn());

        Book updatedBook = bookService.save(book);
        BookDTO responseDTO = bookModelAssembler.toModel(updatedBook);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Book book = bookService.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        bookService.delete(book);
        return ResponseEntity.noContent().build();
    }
}
