package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.base.Code;
import umc.spring.base.ResponseDto;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Review")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ResponseDto<ReviewResponseDTO.ReviewResultDto> regist(@RequestBody @Valid ReviewRequestDTO.ReviewRegistDto request,
                                                                  @RequestParam Long memberId,@RequestParam Long storeId)
     {
        Review review = reviewCommandService.ReviewRegist(request, memberId,storeId);
        ReviewResponseDTO.ReviewResultDto resultDto = ReviewConverter.toReviewResult(review);
        return ResponseDto.onSuccess(resultDto, Code.OK);
    }
}
