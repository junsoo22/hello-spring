package hello2.hello_spring2.domain;

import jakarta.persistence.*;

@Entity

public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //시스템이 정하는 ID
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
