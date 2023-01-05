package com.perezcasal.initspring.controllers;

import com.perezcasal.initspring.entities.BookEntity;
import com.perezcasal.initspring.services.BooksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@Tag(name = "Books Controller")
public class BooksController {
    @Autowired
    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @Operation(summary = "Add Book", description = "Add a new book to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookEntity.class))),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "405", description = "Invalid input"),
            @ApiResponse(responseCode = "406", description = "Element exists.")
    })
    @PostMapping(value = "books/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BookEntity> save(@RequestBody BookEntity newBook) {
        var bookResponse = booksService.save(newBook);
        if (bookResponse.containsKey("exist")) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        if (bookResponse.containsKey("id-not-null")) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(bookResponse.get("saved"));
    }

    @Operation(summary = "Update Book", description = "Update a book from the database given an id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookEntity.class))),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found."),
            @ApiResponse(responseCode = "405", description = "Invalid input"),
            @ApiResponse(responseCode = "406", description = "Element with different id.")
    })
    @PutMapping(value = "books/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BookEntity> update(@RequestBody BookEntity newBook, @PathVariable Long id) {
        var bookResponse = booksService.update(newBook, id);
        if (bookResponse.containsKey("id-null")) {
            return ResponseEntity.badRequest().build();
        }
        if (bookResponse.containsKey("not-found")) {
            return ResponseEntity.notFound().build();
        }
        if (bookResponse.containsKey("diff-id")) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return ResponseEntity.ok(bookResponse.get("updated"));
    }

    @Operation(summary = "Delete Book", description = "Delete a book from the database given an id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @DeleteMapping(value = "books/{id}")
    public void delete(@PathVariable Long id) {
        booksService.delete(id);
    }

    @Operation(summary = "Delete All Books", description = "Delete all books from the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @DeleteMapping(value = "books")
    public void deleteAll() {
        booksService.deleteAll();
    }

    @Operation(summary = "Find Book", description = "Find a book from the database given an id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookEntity.class))),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found."),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @GetMapping(value = "books/{id}", produces = "application/json")
    public ResponseEntity<BookEntity> get(@PathVariable Long id) {
        var bookResponse = booksService.findOneById(id);
        if (bookResponse.containsKey("not-found")) {
            return ResponseEntity.notFound().build();
        }
        if (bookResponse.containsKey("id-null")) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(bookResponse.get("found"));
    }

    @Operation(summary = "Find All Books", description = "Find all books from the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookEntity.class)))
    })
    @GetMapping(value = "books", produces = "application/json")
    public List<BookEntity> getAll() {
        return booksService.findAll();
    }
}
