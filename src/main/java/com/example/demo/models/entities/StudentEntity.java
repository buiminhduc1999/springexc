package com.example.demo.models.entities;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class StudentEntity extends CommonEntity {
    @Column
    private LocalDate birthday;

    @Column
    private String address;

    @Column
    private long phoneNumber;

    @ManyToOne
    @JoinColumn(name = "class_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private ClassEntity classEntity;

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

}
