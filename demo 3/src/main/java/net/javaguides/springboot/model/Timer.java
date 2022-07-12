package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "timer")
public class Timer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "flow_name")
    private String flowName;


    @Column(name = "down_time_from")
    private String downTimeFrom;

    @Column(name = "down_time_to")
    private String downTimeTo;

    public Timer() {

    }

    public Timer(String name, String flowName, String downTimeFrom, String downTimeTo) {
        super();
        this.name = name;
        this.flowName = flowName;
        this.downTimeFrom = downTimeFrom;
        this.downTimeTo = downTimeTo;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getDownTimeFrom() {
        return downTimeFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDownTimeFrom(String downTimeFrom) {
        this.downTimeFrom = downTimeFrom;
    }

    public String getDownTimeTo() {
        return downTimeTo;
    }

    public void setDownTimeTo(String downTimeTo) {
        this.downTimeTo = downTimeTo;
    }
}
