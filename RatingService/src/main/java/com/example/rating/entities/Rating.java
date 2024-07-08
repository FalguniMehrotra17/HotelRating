package com.example.rating.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ratings") // Ensure this matches your actual table name
public class Rating {
    @Id
    private String ratingId;
    private String userId; // ensure the field name matches in case sensitivity and spelling
    private String hotelId;
    private int rating;
    private String feedback;
}
