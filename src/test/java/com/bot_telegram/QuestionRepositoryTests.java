package com.bot_telegram;

import com.bot_telegram.model.Question;
import com.bot_telegram.repository.QuestionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class QuestionRepositoryTests {

    @Autowired
    private QuestionRepository repo;

    /*@Test
    public void testCreateQuestion() {
        Question savedCategory = repo.save(new Question("Чем отличается DROP от TRUNCATE?", "", true));
        Assertions.assertThat(savedCategory.getId()).isGreaterThan(0);
    }*/

    @Test
    public void testListAllQuestion() {
        Iterable<Question> questions = repo.findAll();
        Assertions.assertThat(questions).hasSizeGreaterThan(0);

        for (Question question : questions) {
            System.out.println(question);
        }
    }

}
