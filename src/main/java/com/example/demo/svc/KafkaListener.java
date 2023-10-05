package com.example.demo.svc;

import com.example.demo.config.LocalDateTimeDeserializer;
import com.example.demo.domain.UserEntity;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Function;

@Service
public class KafkaListener {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public Function<User, UserEntity> user() {
        return user -> {
            System.out.println("Received: " + user);
            UserEntity u2 = new UserEntity();
            BeanUtils.copyProperties(user, u2);
            return userRepository.save(u2);
        };
    }

    record User(int userId,
                UUID uuid,
                @JsonProperty("first_name")
                String firstName,
                @JsonProperty("last_name")
                String lastName,
                @JsonProperty("date_birth")
                LocalDate dateBirth,
                String city,
                String country,
                @JsonProperty("company_name")
                String companyName,
                String job,
                @JsonProperty("phone_number")
                String phoneNumber,
                @JsonProperty("last_access_time")
                LocalDateTime lastAccessTime,
                @JsonProperty("time_zone")
                String timeZone,
                @JsonProperty("dt_current_timestamp")
                @JsonDeserialize(using = LocalDateTimeDeserializer.class)
                LocalDateTime dtCurrentTimestamp
    ) {}

}
