package com.evo.evoproject.domain.product;

import com.evo.evoproject.domain.image.Image;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RetrieveProduct {
    private int productNo;
    private String productName;
    private String productDes;
    private int categoryId;
    private String price; // 자료형 수정
    private int stock;
    private LocalDateTime date;
    private int viewCount;
    private int shipping;
    private boolean soldout;


    private Image mainImage;
    private List<Image> images;
}