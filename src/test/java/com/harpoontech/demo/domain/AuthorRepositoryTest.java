package com.harpoontech.demo.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import javax.inject.Inject;

import com.harpoontech.demo.Application;
import com.harpoontech.demo.repository.AuthorRepository;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
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

    Author kermit;
    Author fozzie;
    Author scooter;
    Author swedishChef;

    @Before
    public void before() {
        kermit = new Author();
        kermit.setName("Kermit the Frog");
        kermit.setBirthDate(new LocalDate().minusYears(20));
        kermit = authorRepository.save(kermit);

        scooter = new Author();
        scooter.setName("Scooter");
        scooter.setBirthDate(new LocalDate().minusYears(15));
        scooter = authorRepository.save(scooter);

        fozzie = new Author();
        fozzie.setName("Fozzie the Bear");
        fozzie.setBirthDate(new LocalDate().minusYears(5));
        fozzie = authorRepository.saveAndFlush(fozzie);

        swedishChef = new Author();
        swedishChef.setName("Swedish Chef");
        swedishChef.setBirthDate(new LocalDate().minusYears(10));
        swedishChef = authorRepository.save(swedishChef);

        authorRepository.flush();
    }

    @Test
    public void testFindByBirthDateBetweenDates() {
        List<Author> authors = authorRepository.findAll();
        assertThat(authors).isNotNull();
        assertThat(authors.size()).isEqualTo(4);
        assertThat(authors.get(0).getName()).isEqualTo(kermit.getName());
    }


    @Test
    public void testFindAllSortingByBirthDate() {
        Sort sort = new Sort(
            new Sort.Order(Sort.Direction.DESC, "birthDate")
        );
        PageRequest pageRequest = new PageRequest(0, 100, sort);
        Page<Author> authors = authorRepository.findAll(
            pageRequest
        );
        assertThat(authors).isNotNull();
        assertThat(authors.getContent().size()).isEqualTo(4);
        assertThat(authors.getContent().get(0).getName()).isEqualTo(fozzie.getName());

        sort = new Sort(
            new Sort.Order(Sort.Direction.ASC, "birthDate")
        );
        pageRequest = new PageRequest(0, 100, sort);
        authors = authorRepository.findAll(
            pageRequest
        );
        assertThat(authors).isNotNull();
        assertThat(authors.getContent().size()).isEqualTo(4);
        assertThat(authors.getContent().get(0).getName()).isEqualTo(kermit.getName());
    }

    @Test
    public void testFindAllSortingByName() {
        Sort sort = new Sort(
            new Sort.Order(Sort.Direction.ASC, "name")
        );
        PageRequest pageRequest = new PageRequest(0, 100, sort);
        Page<Author> authors = authorRepository.findAll(pageRequest);
        assertThat(authors).isNotNull();
        assertThat(authors.getContent().size()).isEqualTo(4);
        assertThat(authors.getContent().get(0).getName()).isEqualTo(fozzie.getName());

        sort = new Sort(
            new Sort.Order(Sort.Direction.DESC, "name")
        );
        pageRequest = new PageRequest(0, 100, sort);
        authors = authorRepository.findAll(pageRequest);
        assertThat(authors).isNotNull();
        assertThat(authors.getContent().size()).isEqualTo(4);
        assertThat(authors.getContent().get(0).getName()).isEqualTo(swedishChef.getName());
    }


    /**
     * Demo of named queries using paging but not sorting
     */
    @Test
    @Ignore
    public void testFindByBirthDateBetweenDatesWithNullPageable() {
        Sort sort = new Sort(
            new Sort.Order(Sort.Direction.ASC, "name")
        );
        PageRequest pageRequest = new PageRequest(0, 100, sort);
        Page<Author> authors = authorRepository.findByBirthDateBetweenDates(
            new LocalDate().minusYears(25),
            new LocalDate(),
            pageRequest
        );
        assertThat(authors).isNotNull();
        assertThat(authors.getContent()).isNotNull();
        assertThat(authors.getContent().size()).isEqualTo(4);
        assertThat(authors.getContent().get(0).getName()).isEqualTo(fozzie.getName());
    }
}
