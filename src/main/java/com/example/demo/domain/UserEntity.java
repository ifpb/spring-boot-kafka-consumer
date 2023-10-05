package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // You can keep tUserEntityhe id field for database primary key

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("uuid")
    private UUID uuid;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("date_birth")
    private LocalDate dateBirth;

    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    @JsonProperty("company_name")
    private String companyName;

    @JsonProperty("job")
    private String job;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("last_access_time")
    private LocalDateTime lastAccessTime;

    @JsonProperty("time_zone")
    private String timeZone;

    @JsonProperty("dt_current_timestamp")
    private LocalDateTime dtCurrentTimestamp;

}
