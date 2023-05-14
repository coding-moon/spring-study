package com.example.intermediate.entity.employee;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PLANNER")
@Getter @Setter @ToString
@DynamicInsert
@DynamicUpdate
@DiscriminatorColumn(name = "pln")
public class Planner extends Employee{
//    @Id
//    @GeneratedValue
//    private  Long id;
//    @NotNull
//    private String name;
//    private LocalDate birth;
//    @NotNull private Integer career;
    private Integer oa_level;
    @ColumnDefault(value = "0")
    private Integer clientCount;


}
