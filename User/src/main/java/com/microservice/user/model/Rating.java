package com.microservice.user.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private String feedback;
    private int rating;
}
