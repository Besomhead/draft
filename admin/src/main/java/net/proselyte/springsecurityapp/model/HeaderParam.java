package net.proselyte.springsecurityapp.model;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "spring_security_app.header_params")
public class HeaderParam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "param")
    private String param;

    @Column(name = "value")
    private String value;

    @Column(name = "display")
    private boolean display;

    public HeaderParam(){

    }

    public int getId() {
        return id;
    }

    public void setId(int pId) {
        id = pId;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String pParam) {
        param = pParam;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String pValue) {
        value = pValue;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean pDisplay) {
        display = pDisplay;
    }
}
