package com.bot_telegram;

import com.bot_telegram.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AnswerRepositoryTests {
    @Autowired
    private AnswerRepository repo;

    /*@Test
    public void testCreateQuestion() {
        Answer savedCategory = repo.save(new Answer(""));
        Assertions.assertThat(savedCategory.getId()).isGreaterThan(0);
    }*/
}
