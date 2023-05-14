package com.example.basic.repository;

import com.example.basic.domain.entity.Member;
import com.example.basic.domain.entity.SuperCar;
import com.example.basic.domain.entity.type.SuperCarBrand;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class SuperCarDaoTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SuperCarDAO superCarDAO;

    @Test
    public void saveTest() {
        SuperCar superCar = new SuperCar();
        superCar.setSuperCarName("붕붕이");
        superCar.setSuperCarPrice(1300);
        superCar.setSuperCarColor("blue");
        superCar.setSuperCarBrand(SuperCarBrand.PORSCHE);
        superCar.setSuperCarReleaseDate(LocalDateTime.now());
        //superCar.setSuperCarReleaseDate(LocalDateTime.of(2022, 12, 04, 06, 00 ));

        superCarDAO.save(superCar);

    }

   @Test
    public void findByIdTest() {
       Optional<SuperCar> optionalSuperCar = superCarDAO.findById(1L);

       if(optionalSuperCar.isPresent()){
            optionalSuperCar.get();
        }

        optionalSuperCar.ifPresent(superCar -> assertThat(superCar.getSuperCarColor()).isEqualTo("blue"));


        //optionalSuperCar.map(SuperCar::getSuperCarName).ifPresentOrElse(log::info, () -> {log.info("찾으시는 차량이 없습니다");});

   }

    @Test
    public void setSuperCarColorTest() {
        Optional<SuperCar> optionalSuperCar = superCarDAO.findById(1L);

        if(optionalSuperCar.isPresent()){
            optionalSuperCar.get().setSuperCarColor("purple");
        }

        /*boolean test = optionalSuperCar.isPresent(superCar -> assertThat(superCar.getSuperCarColor().isEqualTo("blue")));*/
//        optionalSuperCar.get().setSuperCarColor("hotPink");

    }

    @Test
    public void deleteTest() {
        Optional<SuperCar> optionalSuperCar = superCarDAO.findById(1L);
        SuperCar superCar = optionalSuperCar.orElse(new SuperCar());
        superCarDAO.delete(superCar);

       // superCarDAO.delete(foundSuperCar.orElseThrow(() -> {throw new NoSuchSuperCarException("찾으시는 차량이 없습니다.");}));

//        optionalSuperCar.ifPresent(superCar -> assertThat(superCar.getSuperCarColor()).isEqualTo("purple"));

    }

    @Test
    public void findAllTest(){
        superCarDAO.findAll().stream().map(SuperCar::getSuperCarName).forEach(log::info);
    }

    @Test
    public void findAllWithPagingTest(){
        superCarDAO.findAllWithPaging(11, 10).stream().map(SuperCar::getSuperCarName).forEach(log::info);
    }

    @Test
    public void findBySuperCarTest(){
//        memberDAO.findByMemberName("user99").stream().map(Member::getMemberName).forEach(log::info);
        Assertions.assertThat(superCarDAO.findAllByNameAndPrice("붕붕이").stream().map(SuperCar::getSuperCarPrice).map(String::valueOf).collect(Collectors.joining())).isEqualTo("99");
    }

    @Test
    public void findAllByReleaseDate() {

    }

}
