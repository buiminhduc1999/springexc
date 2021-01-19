package com.example.demo.models.out;

import java.time.LocalDate;

public class StudentDto extends CommonDto{
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

    public ClassDto getClassDto() {
        return classDto;
    }

    public void setClassDto(ClassDto classDto) {
        this.classDto = classDto;
    }
}
