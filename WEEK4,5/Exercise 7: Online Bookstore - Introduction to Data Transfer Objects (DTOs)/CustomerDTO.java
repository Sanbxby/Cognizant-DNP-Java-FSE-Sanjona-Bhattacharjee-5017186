// File: src/main/java/com/example/bookstore/dto/CustomerDTO.java

package com.example.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null values from JSON serialization
public class CustomerDTO {

    @JsonProperty("customer_id")
    private Long id;

    @JsonProperty("customer_name")
    private String name;

    @JsonProperty("customer_email")
    private String email;

    // Constructors
    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
