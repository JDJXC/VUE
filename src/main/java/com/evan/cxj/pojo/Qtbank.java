package com.evan.cxj.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name = "qtbank")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Qtbank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;



    @ManyToOne
    @JoinColumn(name="qid")
    private QtCategory qtCategory;

    String title;
    String opa;
    String opb;
    String opc;
    String opd;
    String anser;

    public QtCategory getQtCategory() {
        return qtCategory;
    }

    public void setQtCategory(QtCategory qtCategory) {
        this.qtCategory = qtCategory;
    }

    public String getAnser() {
        return anser;
    }

    public void setAnser(String anser) {
        this.anser = anser;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOpa() {
        return opa;
    }

    public void setOpa(String opa) {
        this.opa = opa;
    }

    public String getOpb() {
        return opb;
    }

    public void setOpb(String opb) {
        this.opb = opb;
    }

    public String getOpc() {
        return opc;
    }

    public void setOpc(String opc) {
        this.opc = opc;
    }

    public String getOpd() {
        return opd;
    }

    public void setOpd(String opd) {
        this.opd = opd;
    }


}



