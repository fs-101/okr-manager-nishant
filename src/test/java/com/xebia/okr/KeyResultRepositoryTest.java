package com.xebia.okr;

import com.xebia.okr.domain.KeyResult;
import com.xebia.okr.domain.KeyResultStatus;
import com.xebia.okr.repositories.KeyResultRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class KeyResultRepositoryTest {

    @Autowired
    private KeyResultRepository keyResultRepository;

    @Test
    public void should_read_key_result_when_i_provide_valid_data() {
        KeyResult keyResult = new KeyResult("title 1", 5, KeyResultStatus.NOT_STARTED, 0);
        KeyResult saveKeyResult = keyResultRepository.save(keyResult);
        KeyResult readkeyResult = keyResultRepository.getOne(saveKeyResult.getId());
        assertThat(readkeyResult).isNotNull();
    }

    @Test
    public void should_save_key_result_when_i_provide_valid_data() {
        KeyResult keyResult = new KeyResult("title 1", 5, KeyResultStatus.NOT_STARTED, 0);
        KeyResult saveKeyResult = keyResultRepository.save(keyResult);
        //KeyResult saveKeyResult = keyResultRepository.getOne(keyResult.getId());
        assertThat(saveKeyResult).isNotNull();
    }

    @Test
    public void should_update_key_result_when_i_provide_valid_data() {
        KeyResult keyResult = new KeyResult("title 1", 00, KeyResultStatus.NOT_STARTED, 00);
        KeyResult keyResultUpdate = keyResultRepository.save(keyResult);
        keyResultUpdate.setStatus(KeyResultStatus.IN_PROGRESS);
        KeyResult updateObjective = keyResultRepository.save(keyResultUpdate);
        assertThat(keyResult.getStatus()).isEqualTo(keyResultUpdate.getStatus());
    }

    @Test
    public void should_delete_key_result_when_i_delete_valid_data() {
        KeyResult keyResult = new KeyResult("title 1", 00, KeyResultStatus.NOT_STARTED, 00);
        KeyResult keyResultSave = keyResultRepository.save(keyResult);
        keyResultSave.setStatus(KeyResultStatus.IN_PROGRESS);
        keyResultRepository.deleteById(keyResultSave.getId());
        assertThat(keyResultRepository.findById(keyResultSave.getId()).isPresent()).isFalse();
    }
}
