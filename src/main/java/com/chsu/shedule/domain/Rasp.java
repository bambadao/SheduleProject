package com.chsu.shedule.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rasp", catalog="rasp")
public class Rasp  implements Serializable {


     private Integer idRasp;
     private String grp;
     private String DNed;
     private String vrem;
     private String data;
     private String NDis;
     private String nachNed;
     private String chNch;
     private String dol;
     private String aud;
     private Integer vidRas;
     private Integer sem;
     private Integer idVrem;
     private Integer idDNed;

    public Rasp() {
    }

    public Rasp(String grp, String DNed, String vrem, String data, String NDis, String nachNed, String chNch, String dol, String aud, Integer vidRas, Integer sem, Integer idVrem, Integer idDNed) {
       this.grp = grp;
       this.DNed = DNed;
       this.vrem = vrem;
       this.data = data;
       this.NDis = NDis;
       this.nachNed = nachNed;
       this.chNch = chNch;
       this.dol = dol;
       this.aud = aud;
       this.vidRas = vidRas;
       this.sem = sem;
       this.idVrem = idVrem;
       this.idDNed = idDNed;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_rasp", unique=true, nullable=false)
    public Integer getIdRasp() {
        return this.idRasp;
    }
    
    public void setIdRasp(Integer idRasp) {
        this.idRasp = idRasp;
    }

    
    @Column(name="Grp", length=50)
    public String getGrp() {
        return this.grp;
    }
    
    public void setGrp(String grp) {
        this.grp = grp;
    }

    
    @Column(name="D_ned", length=20)
    public String getDNed() {
        return this.DNed;
    }
    
    public void setDNed(String DNed) {
        this.DNed = DNed;
    }

    
    @Column(name="Vrem", length=50)
    public String getVrem() {
        return this.vrem;
    }
    
    public void setVrem(String vrem) {
        this.vrem = vrem;
    }

    
    @Column(name="Data", length=20)
    public String getData() {
        return this.data;
    }
    
    public void setData(String data) {
        this.data = data;
    }

    
    @Column(name="N_Dis")
    public String getNDis() {
        return this.NDis;
    }
    
    public void setNDis(String NDis) {
        this.NDis = NDis;
    }
    
    @Column(name="Nach_Ned", length=10)
    public String getNachNed() {
        return this.nachNed;
    }
    
    public void setNachNed(String nachNed) {
        this.nachNed = nachNed;
    }

    
    @Column(name="CH_NCH", length=10)
    public String getChNch() {
        return this.chNch;
    }
    
    public void setChNch(String chNch) {
        this.chNch = chNch;
    }

    
    @Column(name="Dol", length=65)
    public String getDol() {
        return this.dol;
    }
    
    public void setDol(String dol) {
        this.dol = dol;
    }

    
    @Column(name="Aud", length=45)
    public String getAud() {
        return this.aud;
    }
    
    public void setAud(String aud) {
        this.aud = aud;
    }

    
    @Column(name="vid_ras")
    public Integer getVidRas() {
        return this.vidRas;
    }
    
    public void setVidRas(Integer vidRas) {
        this.vidRas = vidRas;
    }

    
    @Column(name="sem")
    public Integer getSem() {
        return this.sem;
    }
    
    public void setSem(Integer sem) {
        this.sem = sem;
    }

    
    @Column(name="id_vrem")
    public Integer getIdVrem() {
        return this.idVrem;
    }
    
    public void setIdVrem(Integer idVrem) {
        this.idVrem = idVrem;
    }

    
    @Column(name="id_d_ned")
    public Integer getIdDNed() {
        return this.idDNed;
    }
    
    public void setIdDNed(Integer idDNed) {
        this.idDNed = idDNed;
    }
}
