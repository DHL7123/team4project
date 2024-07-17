package com.evo.evoproject.domain.product;

import com.evo.evoproject.domain.image.Image;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RetrieveProduct {
    private int productNo;
    private String productName;
    private String productDes;
    private int categoryId;
    private int price;
    private int stock;
    private LocalDateTime date;
    private int viewCount;
    private int shipping;
    private boolean soldout;

    private Image mainImage;
    private List<Image> existingImages;
    private List<MultipartFile> images;

    public void setExistingImages(List<Image> existingImages) {
        this.existingImages = existingImages;
    }
}
