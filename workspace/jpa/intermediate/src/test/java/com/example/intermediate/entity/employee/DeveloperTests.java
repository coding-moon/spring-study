package com.example.intermediate.entity.employee;


import com.example.intermediate.repository.employee.DeveloperRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class DeveloperTests {
    @Autowired
    private DeveloperRepository developerRepository;

    @Test
    public  void saveTest() {
        for (int i=0; i<100; i++) {
            Developer.builder()

        }
    }

    @Test
    public  void FindAllPagingTest() {
        PageRequest pageRequest = PageRequest.of(0,5, Sort.Direction.DESC)
        Page<Developer>
    }
}
