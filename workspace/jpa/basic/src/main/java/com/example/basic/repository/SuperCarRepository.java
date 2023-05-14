package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import com.example.basic.domain.entity.type.MemberType;
import com.example.basic.domain.entity.type.SuperCarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuperCarRepository extends JpaRepository<SuperCar, Long> {
    public List<SuperCar> findBySuperCarNameContaining(String SuperCarName);
    public List<SuperCar> findBySuperCarName(String SuperCarName);
    public List<SuperCar> findBySuperCarNameStartingWith(String SuperCarName);
    public List<SuperCar> findBySuperCarNameEndingWith(String SuperCarName);
    public List<SuperCar> findTop3BySuperCarPriceGreaterThanEqualOrderBySuperCarPriceDesc(int SuperCarPrice);
    public int countAllBySuperCarBrand(SuperCarBrand superCarBrand);
    public void deleteBySuperCarPriceGreaterThanEqual(int SuperCarPrice);
 }
