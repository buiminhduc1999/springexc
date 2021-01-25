package com.example.demo.models.in;

import com.example.demo.models.out.ClassDto;
import com.example.demo.services.validators.StudentValidation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@StudentValidation
public class StudentRequest extends CommonRequest {
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
