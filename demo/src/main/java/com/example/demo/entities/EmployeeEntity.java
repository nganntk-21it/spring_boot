package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Đảm bảo rằng id sẽ tự động tăng
    @Column(name = "employee_id") // Đảm bảo rằng tên cột trong cơ sở dữ liệu khớp với tên biến
    private Integer employeeId;

    @Column(name = "first_name", columnDefinition = "varchar(255)", nullable = false)
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(255)", nullable = false)
    private String lastName;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "phone", columnDefinition = "varchar(20)", nullable = false)
    private String phone;

    @Column(name = "address", columnDefinition = "varchar(255)", nullable = true)
    private String address;

    @Column(name = "department_name", columnDefinition = "varchar(255)", nullable = false)
    private String departmentName;

    @Column(name = "remark", columnDefinition = "varchar(1000)", nullable = true)
    private String remark;

    @OneToOne(mappedBy = "Employeeemployee_id", cascade = CascadeType.ALL)
    private AccountEntity account;


}
