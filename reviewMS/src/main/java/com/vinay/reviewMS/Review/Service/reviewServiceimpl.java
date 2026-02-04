package com.vinay.reviewMS.Review.Service;



import com.vinay.reviewMS.Review.Model.Review;
import com.vinay.reviewMS.Review.Service.Repository.reviewRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reviewServiceimpl implements reviewService{
   private reviewRepo reviewRepo;


    // single constructor — Spring will autowire both beans
    public reviewServiceimpl(reviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;

    }
    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews= reviewRepo.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
            if(companyId!= null && review!= null){
            review.setCompanyId(companyId);
           reviewRepo.save(review);
           return true;
        }else {
            return false;
        }
    }

    @Override
    public Review getReviewById( Long reviewId) {
       return reviewRepo.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview( Long reviewId, Review updatedReview) {
        if(reviewId != null){
            Review review=reviewRepo.findById(reviewId).orElse(null);
                   review.setTitle(updatedReview.getTitle());
                   review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setCompanyId(updatedReview.getCompanyId());
                   reviewRepo.save(review);
                   return true;
        }else return false;
    }

    @Override
    public boolean deleteReview( Long reviewId) {
        Review review=reviewRepo.findById(reviewId).orElse(null);
        if(review!= null){
            reviewRepo.delete(review);
            return true;
        }
        return false;
    }
}
