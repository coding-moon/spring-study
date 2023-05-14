package com.example.expert.repository.car;

import com.example.expert.entity.registration.Car;
import com.example.expert.entity.registration.CarType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@SpringBootTest
@Slf4j
@Rollback(false)
@Transactional
public class CarRepositoryTests {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarOwnerRepository carOwnerRepository;
    @Autowired
    private CarRegisterationRepository carRegisterationRepository;


    // 자동차 100대 등록

    public void saveTest{
        Random random = new Random();
        for(int i=0; i<100; i++){
            Car.builder().carName("스파이더 588")
                    .carBrand(CarType.FERRARI)
                    .carPrice(7_000_000)
        }
    }
    // 자동차 전체 정보와 차주 전체 정보 조회(페이징 처리)
    

}
