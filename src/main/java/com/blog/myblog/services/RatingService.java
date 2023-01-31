package com.blog.myblog.services;

import com.blog.myblog.domain.Rating;
import com.blog.myblog.dto.rating.RatingCreateDTO;
import com.blog.myblog.dto.rating.RatingListDTO;
import com.blog.myblog.exceptions.ArticleRatedByUserException;
import com.blog.myblog.mappers.RatingMapper;
import com.blog.myblog.repositories.RatingRepository;
import com.blog.myblog.security.AuthenticationContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;
    private final AuthenticationContext authenticationContext;
    private final RatingMapper ratingMapper;

    public Long createRating(RatingCreateDTO dto) {
        var rating = ratingMapper.createRating(dto);
        var reviewer = authenticationContext.getSignedInAdri();
        var article = rating.getArticle();

        if (reviewer.hasRatedThisArticle(article)) {
            throw new ArticleRatedByUserException("You can rate an article only once");
        }

        rating.setReviewer(reviewer);
        return ratingRepository.save(rating).getId();
    }

    public List<RatingListDTO> getAllRatings(){
        var ratings = ratingRepository.findAll();
        return ratingMapper.mapToRatingListDTOList(ratings);
    }

    public void deleteRating(Long id){
        var rating = getRatingById(id);
        ratingRepository.delete(rating);
    }

    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rating not found with id " + id));
    }

}
