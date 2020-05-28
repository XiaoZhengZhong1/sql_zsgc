package com.sql_zsgc.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "STUDENT", catalog = "orcl")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mseq")
    @SequenceGenerator(name = "mseq", sequenceName = "seq_student", allocationSize = 1)
    @Column(name = "STU_ID")
    private int stuId;

    @Column(name = "SNAME")
    private String sname;

    @Column(name = "SIX")
    private String six;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "SCORE")
    private Integer score;

    @Column(name = "CLA_ID")
    private Integer claId;


    @Column(name = "BIRTHDAY")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
   @JsonFormat(pattern = "yyyy-mm-dd",timezone = "GMT + 8")
    private Date birthday;

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getClaId() {
        return claId;
    }

    public void setClaId(Integer claId) {
        this.claId = claId;
    }

  @JsonFormat(pattern = "yyyy-mm-dd",timezone = "GMT + 8")
    public Date getBirthday() {
        return birthday;
    }

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}