package com.harpoontech.demo.repository;

import java.util.List;

import com.harpoontech.demo.domain.Author;
import org.joda.time.LocalDate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Spring Data JPA repository for the Author entity.
 */

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(name = "Author.findByBirthDateBetweenDates")
    List<Author> findByBirthDateBetweenDates(
        @Param("startDate") LocalDate start,
        @Param("endDate") LocalDate finish
    );

    @Query(name = "Author.findByBirthDateBetweenDates")
    List<Author> findByBirthDateBetweenDates(
        @Param("startDate") LocalDate start,
        @Param("endDate") LocalDate finish,
        Pageable pageable
    );

}
