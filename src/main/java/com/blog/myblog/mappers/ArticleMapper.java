package com.blog.myblog.mappers;

import com.blog.myblog.domain.Article;
import com.blog.myblog.dto.article.ArticleCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = SpringMapperConfig.class)
public interface ArticleMapper {

//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "version", ignore = true)
//    Product mapProductFromProductCreateDTO(ProductCreateDTO dto);
//
//    List<ProductListDTO> mapProductListToDTO (List<Product> products);


    Article createNewArticle(ArticleCreateDTO dto);



}
