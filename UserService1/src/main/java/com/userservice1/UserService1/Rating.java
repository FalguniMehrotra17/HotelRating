package com.userservice1.UserService1;

//import com.userservice1.UserService1.User;
//import java.util.List;

//import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
 private String ratingId;
 private String UserId;
 private String hotelId;
 private int rating;
 private String feedback;
 private Hotel hotel;
 
}
