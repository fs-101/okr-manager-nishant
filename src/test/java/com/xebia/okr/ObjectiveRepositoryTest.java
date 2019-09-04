package com.xebia.okr;

import com.xebia.okr.domain.Objective;
import com.xebia.okr.repositories.ObjectiveRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ObjectiveRepositoryTest {

    @Autowired
    private ObjectiveRepository objectiveRepository;

    @Test
    public void should_read_objective_when_i_provide_valid_data() {
        Objective objective = new Objective("title 1", "Started");
        Objective save = objectiveRepository.save(objective);
        Objective objectiveRead = objectiveRepository.getOne(save.getId());
        assertThat(objectiveRead).isNotNull();
    }

    @Test
    public void should_save_objective_when_i_provide_valid_data() {
        Objective objective = new Objective("title 1", "Started");
        Objective objectiveSave = objectiveRepository.save(objective);
        assertThat(objectiveSave).isNotNull();
    }

    @Test
    public void should_update_objective_when_i_provide_valid_data() {
        Objective objective = new Objective("title 1", "Started");
        Objective objectiveSave = objectiveRepository.save(objective);
        objectiveSave.setStatus("In Progress");
        Objective updateObjective = objectiveRepository.save(objectiveSave);
        assertThat(updateObjective.getStatus()).isEqualTo(objectiveSave.getStatus());
    }

    @Test
    public void should_delte_objective_when_i_delete_valid_data() {
        Objective objective = new Objective("title 1", "Started");
        Objective objectiveSave = objectiveRepository.save(objective);
        objectiveRepository.deleteById(objectiveSave.getId());
        assertThat(objectiveRepository.findById(objectiveSave.getId()).isPresent()).isFalse();
    }
}
