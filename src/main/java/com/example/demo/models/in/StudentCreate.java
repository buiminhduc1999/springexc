package com.example.demo.models.in;

import com.example.demo.models.entities.ClassEntity;
import com.example.demo.models.out.ClassDto;

import java.time.LocalDate;

public class StudentCreate extends CommonCreate {
    private LocalDate birthday;
    private String address;
    private long phoneNumber;
    private ClassDto classDto;

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

    public ClassDto getClassEntity() {
        return classDto;
    }

    public void setClassEntity(ClassDto classDto) {
        this.classDto = classDto;
    }
}
