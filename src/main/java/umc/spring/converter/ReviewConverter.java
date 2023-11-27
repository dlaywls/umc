package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static ReviewResponseDTO.ReviewResultDto toReviewResult(Review review){
        return ReviewResponseDTO.ReviewResultDto.builder()
                .reviewId(review.getId())
                .body(review.getBody())
                .score(review.getScore())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewRegistDto request, Member member, Store store) {
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();
    }
}
