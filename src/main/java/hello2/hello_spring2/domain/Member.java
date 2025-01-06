package hello2.hello_spring2.domain;

public class Member {
    private String name;
    private Long id;    //시스템이 정하는 ID

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
