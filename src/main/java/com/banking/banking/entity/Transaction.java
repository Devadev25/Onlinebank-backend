package com.banking.banking.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class  Transaction  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;
    private BigDecimal amount;
    private String transactionType;
    private String toAccountNumber;
    private String fromAccount;
    private  String status;
    @ManyToOne
    private User user;
    @CreationTimestamp
    private LocalDate createdAt;

}
