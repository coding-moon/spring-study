package com.example.ex00.dependency.qualifier;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Data
public interface Restaurant {
    public int steak = 3000;
    public boolean isSalad();




}
