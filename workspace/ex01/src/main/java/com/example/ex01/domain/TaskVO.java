package com.example.ex01.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TaskVO {
        private int num;
        private int kor;
        private int eng;
        private int math;
        private int total;
        private int avg;
        private String name;


        public TaskVO() {
                total = kor + eng + math;
              /*  avg = total / 3.0;*/
        }
}
