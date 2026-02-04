package com.vinay.reviewMS.Review.Service;



import com.vinay.reviewMS.Review.Model.Review;

import java.util.List;

public interface reviewService {
 List<Review> getAllReviews(Long companyId);
 boolean addReview(Long companyId,Review review);
 Review  getReviewById(Long reviewId );
 boolean updateReview(Long reviewId,Review review);

 boolean deleteReview( Long reviewId);
}
