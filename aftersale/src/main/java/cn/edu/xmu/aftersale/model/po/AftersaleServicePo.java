package cn.edu.xmu.aftersale.model.po;

import java.time.LocalDateTime;

public class AftersaleServicePo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.order_item_id
     *
     * @mbg.generated
     */
    private Long orderItemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.customer_id
     *
     * @mbg.generated
     */
    private Long customerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.shop_id
     *
     * @mbg.generated
     */
    private Long shopId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.service_sn
     *
     * @mbg.generated
     */
    private String serviceSn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.type
     *
     * @mbg.generated
     */
    private Byte type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.reason
     *
     * @mbg.generated
     */
    private String reason;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.conclusion
     *
     * @mbg.generated
     */
    private String conclusion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.refund
     *
     * @mbg.generated
     */
    private Long refund;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.quantity
     *
     * @mbg.generated
     */
    private Integer quantity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.region_id
     *
     * @mbg.generated
     */
    private Long regionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.detail
     *
     * @mbg.generated
     */
    private String detail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.consignee
     *
     * @mbg.generated
     */
    private String consignee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.mobile
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.customer_log_sn
     *
     * @mbg.generated
     */
    private String customerLogSn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.shop_log_sn
     *
     * @mbg.generated
     */
    private String shopLogSn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.state
     *
     * @mbg.generated
     */
    private Byte state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.be_deleted
     *
     * @mbg.generated
     */
    private Byte beDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.gmt_create
     *
     * @mbg.generated
     */
    private LocalDateTime gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aftersale_service.gmt_modified
     *
     * @mbg.generated
     */
    private LocalDateTime gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.id
     *
     * @return the value of aftersale_service.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.id
     *
     * @param id the value for aftersale_service.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.order_item_id
     *
     * @return the value of aftersale_service.order_item_id
     *
     * @mbg.generated
     */
    public Long getOrderItemId() {
        return orderItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.order_item_id
     *
     * @param orderItemId the value for aftersale_service.order_item_id
     *
     * @mbg.generated
     */
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.customer_id
     *
     * @return the value of aftersale_service.customer_id
     *
     * @mbg.generated
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.customer_id
     *
     * @param customerId the value for aftersale_service.customer_id
     *
     * @mbg.generated
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.shop_id
     *
     * @return the value of aftersale_service.shop_id
     *
     * @mbg.generated
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.shop_id
     *
     * @param shopId the value for aftersale_service.shop_id
     *
     * @mbg.generated
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.service_sn
     *
     * @return the value of aftersale_service.service_sn
     *
     * @mbg.generated
     */
    public String getServiceSn() {
        return serviceSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.service_sn
     *
     * @param serviceSn the value for aftersale_service.service_sn
     *
     * @mbg.generated
     */
    public void setServiceSn(String serviceSn) {
        this.serviceSn = serviceSn == null ? null : serviceSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.type
     *
     * @return the value of aftersale_service.type
     *
     * @mbg.generated
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.type
     *
     * @param type the value for aftersale_service.type
     *
     * @mbg.generated
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.reason
     *
     * @return the value of aftersale_service.reason
     *
     * @mbg.generated
     */
    public String getReason() {
        return reason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.reason
     *
     * @param reason the value for aftersale_service.reason
     *
     * @mbg.generated
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.conclusion
     *
     * @return the value of aftersale_service.conclusion
     *
     * @mbg.generated
     */
    public String getConclusion() {
        return conclusion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.conclusion
     *
     * @param conclusion the value for aftersale_service.conclusion
     *
     * @mbg.generated
     */
    public void setConclusion(String conclusion) {
        this.conclusion = conclusion == null ? null : conclusion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.refund
     *
     * @return the value of aftersale_service.refund
     *
     * @mbg.generated
     */
    public Long getRefund() {
        return refund;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.refund
     *
     * @param refund the value for aftersale_service.refund
     *
     * @mbg.generated
     */
    public void setRefund(Long refund) {
        this.refund = refund;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.quantity
     *
     * @return the value of aftersale_service.quantity
     *
     * @mbg.generated
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.quantity
     *
     * @param quantity the value for aftersale_service.quantity
     *
     * @mbg.generated
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.region_id
     *
     * @return the value of aftersale_service.region_id
     *
     * @mbg.generated
     */
    public Long getRegionId() {
        return regionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.region_id
     *
     * @param regionId the value for aftersale_service.region_id
     *
     * @mbg.generated
     */
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.detail
     *
     * @return the value of aftersale_service.detail
     *
     * @mbg.generated
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.detail
     *
     * @param detail the value for aftersale_service.detail
     *
     * @mbg.generated
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.consignee
     *
     * @return the value of aftersale_service.consignee
     *
     * @mbg.generated
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.consignee
     *
     * @param consignee the value for aftersale_service.consignee
     *
     * @mbg.generated
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.mobile
     *
     * @return the value of aftersale_service.mobile
     *
     * @mbg.generated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.mobile
     *
     * @param mobile the value for aftersale_service.mobile
     *
     * @mbg.generated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.customer_log_sn
     *
     * @return the value of aftersale_service.customer_log_sn
     *
     * @mbg.generated
     */
    public String getCustomerLogSn() {
        return customerLogSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.customer_log_sn
     *
     * @param customerLogSn the value for aftersale_service.customer_log_sn
     *
     * @mbg.generated
     */
    public void setCustomerLogSn(String customerLogSn) {
        this.customerLogSn = customerLogSn == null ? null : customerLogSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.shop_log_sn
     *
     * @return the value of aftersale_service.shop_log_sn
     *
     * @mbg.generated
     */
    public String getShopLogSn() {
        return shopLogSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.shop_log_sn
     *
     * @param shopLogSn the value for aftersale_service.shop_log_sn
     *
     * @mbg.generated
     */
    public void setShopLogSn(String shopLogSn) {
        this.shopLogSn = shopLogSn == null ? null : shopLogSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.state
     *
     * @return the value of aftersale_service.state
     *
     * @mbg.generated
     */
    public Byte getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.state
     *
     * @param state the value for aftersale_service.state
     *
     * @mbg.generated
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.be_deleted
     *
     * @return the value of aftersale_service.be_deleted
     *
     * @mbg.generated
     */
    public Byte getBeDeleted() {
        return beDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.be_deleted
     *
     * @param beDeleted the value for aftersale_service.be_deleted
     *
     * @mbg.generated
     */
    public void setBeDeleted(Byte beDeleted) {
        this.beDeleted = beDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.gmt_create
     *
     * @return the value of aftersale_service.gmt_create
     *
     * @mbg.generated
     */
    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.gmt_create
     *
     * @param gmtCreate the value for aftersale_service.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aftersale_service.gmt_modified
     *
     * @return the value of aftersale_service.gmt_modified
     *
     * @mbg.generated
     */
    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aftersale_service.gmt_modified
     *
     * @param gmtModified the value for aftersale_service.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }
}