package com.pioneers.medmartbck.DTO;

public class BagDTO {
    private Long userId;
    private Long productId;
    private int numberOfOrder;

    BagDTO(){}

    public BagDTO(Long userId, Long productId, int numberOfOrder) {
        this.userId = userId;
        this.productId = productId;
        this.numberOfOrder = numberOfOrder;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

}
