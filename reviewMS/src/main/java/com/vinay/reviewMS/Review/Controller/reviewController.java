package com.vinay.reviewMS.Review.Controller;



import com.vinay.reviewMS.Review.Model.Review;
import com.vinay.reviewMS.Review.Service.reviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class reviewController {
    private reviewService reviewservice;

    public reviewController(reviewService reviewservice) {
        this.reviewservice = reviewservice;
    }
    @GetMapping
   public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId){
        return new ResponseEntity<>(reviewservice.getAllReviews(companyId), HttpStatus.OK);
   }
   @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId,@RequestBody Review review){
     boolean isReviewAddded =reviewservice.addReview(companyId,review);
     if(isReviewAddded)
         return  new ResponseEntity<>("Review Added Successfully",HttpStatus.CREATED);
     else return  new ResponseEntity<>("Review Not added",HttpStatus.NOT_FOUND);
   }
   @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId){
         return  new ResponseEntity<>(reviewservice.getReviewById(reviewId),HttpStatus.OK);
   }
   @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,
                                               @RequestBody Review review){
        boolean isReviewUpdated= reviewservice.updateReview(reviewId,review);
        if(isReviewUpdated)
        return new ResponseEntity<>("Review Updated Successfully ",HttpStatus.OK);
        else return new ResponseEntity<>("Review Not Updated ",HttpStatus.NOT_FOUND);
   }
   @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId){
       boolean isReviewDeleted= reviewservice.deleteReview(reviewId);
       if(isReviewDeleted)
           return new ResponseEntity<>("Review Deleted Successfully",HttpStatus.OK);
       else return new ResponseEntity<>("Review Not deleted",HttpStatus.NOT_FOUND);
   }
}
