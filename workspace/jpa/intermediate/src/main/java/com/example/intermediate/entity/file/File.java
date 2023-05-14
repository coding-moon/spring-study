package com.example.intermediate.entity.file;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

// JOINED(조인 전략)
// 부모 엔티티의 PK를 슈퍼키로 설정하고, 자식 엔티티의 PK를 서브키로 설정하는 전략
// 정규화 방식
// 조회시 조인으로 인해 성능저하가 발생한다
// 복잡한 쿼리 작성 필요
// INSERT시 쿼리 2번 실행


@Entity
@Getter @Setter @ToString
@Table(name = "TBL_FILE")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class File {
    @Id
    @GeneratedValue
    private Integer id;
    //파일이름
    private String name;
    //UUID
    private String uuid;
    //파일경로(연/월/일)
    private String filePath;
    //파일크기
    private Long fileSize;


    public File(String name, String uuid, String filePath, Long fileSize) {
        this.name = name;
        this.uuid = uuid;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }
}