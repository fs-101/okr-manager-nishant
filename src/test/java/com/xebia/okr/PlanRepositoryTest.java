package com.xebia.okr;

import com.xebia.okr.domain.Plan;
import com.xebia.okr.repositories.PlanRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlanRepositoryTest {

    @Autowired
    private PlanRepository planRepository;

    @Test
    public void should_read_plan_when_i_provide_valid_data() {
        LocalDate futureDate = LocalDate.now().plusMonths(1);
        Plan plan = new Plan("title 1", new Date(), Date.from(futureDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Plan save = planRepository.save(plan);
        Plan planRead = planRepository.getOne(save.getId());
        assertThat(planRead).isNotNull();
    }


    @Test
    public void should_save_plan_when_i_provide_valid_data() {
        LocalDate futureDate = LocalDate.now().plusMonths(1);
        Plan plan = new Plan("title 1", new Date(), Date.from(futureDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Plan save = planRepository.save(plan);
        assertThat(save).isNotNull();
    }

    @Test
    public void should_updated_plan_when_i_provide_valid_data() {
        LocalDate futureDate = LocalDate.now().plusMonths(1);
        Plan plan = new Plan("title 1", new Date(), Date.from(futureDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Plan planSave = planRepository.save(plan);
        planSave.setTitle("Title 2");
        Plan updatedPlan = planRepository.save(planSave);
        assertThat(updatedPlan.getTitle()).isEqualTo(planSave.getTitle());
    }

    @Test
    public void should_delete_plan_when_i_delete_valid_data() {
        LocalDate futureDate = LocalDate.now().plusMonths(1);
        Plan plan = new Plan("title 1", new Date(), Date.from(futureDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Plan planSave = planRepository.save(plan);
        planRepository.deleteById(planSave.getId());
        assertThat(planRepository.findById(planSave.getId()).isPresent()).isFalse();
    }

}
