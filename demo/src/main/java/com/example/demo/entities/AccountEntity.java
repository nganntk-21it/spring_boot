package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Đảm bảo rằng id sẽ tự động tăng
    @Column(name = "account_id") // Đảm bảo rằng tên cột trong cơ sở dữ liệu khớp với tên biến
    private Integer accountId;

    @Column(name = "account", columnDefinition = "varchar(255)", unique = true)
    private String account;

    @Column(name = "email", columnDefinition = "varchar(255)", unique = true)
    private String email;

    @Column(name = "password", columnDefinition = "varchar(255)", nullable = false)
    private String password;

    @Column(name = "status", nullable = true)
    private Integer status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id") // khóa ngoại
    private EmployeeEntity Employeeemployee_id;


}
