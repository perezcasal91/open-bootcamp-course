package com.perezcasal.initspring.repositories;

import com.perezcasal.initspring.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<BookEntity, Long> {
}
