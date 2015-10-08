package com.harpoontech.demo.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import javax.inject.Inject;

import com.harpoontech.demo.Application;
import com.harpoontech.demo.repository.AuthorRepository;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
@Transactional
public class AuthorRepositoryTest {

    @Inject
    private AuthorRepository authorRepository;

    @Test
    public void testFindByBirthDateBetweenDates() {
        List<Author> authors = authorRepository.findByBirthDateBetweenDates(new LocalDate(), new LocalDate());
        assertThat(authors).isNotNull();
        assertThat(authors.size()).isEqualTo(0);
    }


    @Test
    public void testFindByBirthDateBetweenDatesWithPageable() {
        Sort sort = new Sort(
            new Sort.Order(Sort.Direction.ASC, "birthDate"),
            new Sort.Order(Sort.Direction.ASC, "name")
        );
        PageRequest pageRequest = new PageRequest(0, 100, sort);
        List<Author> authors = authorRepository.findByBirthDateBetweenDates(new LocalDate(), new LocalDate(), pageRequest);
        assertThat(authors).isNotNull();
        assertThat(authors.size()).isEqualTo(0);

        authors = authorRepository.findByBirthDateBetweenDates(new LocalDate(), new LocalDate(), null);
        assertThat(authors).isNotNull();
        assertThat(authors.size()).isEqualTo(0);
    }

    @Test
    public void testFindByBirthDateBetweenDatesWithNullPageable() {
        List<Author> authors = authorRepository.findByBirthDateBetweenDates(new LocalDate(), new LocalDate(), null);
        assertThat(authors).isNotNull();
        assertThat(authors.size()).isEqualTo(0);
    }
}
