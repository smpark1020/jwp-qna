package subway.domain;

import javax.persistence.*;

@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Line line;

    protected Station() {

    }

    public Station(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void setLine(Line line) {
        this.line = line;
        line.getStations().add(this);
    }

    public Line getLine() {
        return this.line;
    }
}
