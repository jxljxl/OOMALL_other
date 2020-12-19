package cn.edu.xmu.aftersale.model.bo;

import cn.edu.xmu.aftersale.model.*;
import cn.edu.xmu.ooad.model.VoObject;
import cn.edu.xmu.ooad.util.Common;
import cn.edu.xmu.ooad.util.encript.AES;
import cn.edu.xmu.ooad.util.encript.SHA256;
import cn.edu.xmu.aftersale.model.po.AftersaleServicePo;
import cn.edu.xmu.aftersale.model.vo.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
public class Aftersale implements VoObject {

    public static String AESPASS = "OOAD2020-11-01";

    /**
     * 售后状态
     */
    public enum State {
        CHECK(0, "待管理员审核"),
        SENDBACKWAIT(1, "待买家发货"),
        SENDBACKING(2, "买家已发货"),
        REFUNDWAIT(3, "待店家退款"),
        DILIVERWAIT(4, "待店家发货"),
        DELIVERING(5, "店家已发货"),
        DISAGREE(6, "审核不通过"),
        CANCEL(7, "已取消"),
        SUCESS(8, "已结束");

        private static final Map<Integer, State> stateMap;

        static { //由类加载机制，静态块初始加载对应的枚举属性到map中，而不用每次取属性时，遍历一次所有枚举值
            stateMap = new HashMap();
            for (State enum1 : values()) {
                stateMap.put(enum1.code, enum1);
            }
        }

        private int code;
        private String description;

        State(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public static State getTypeByCode(Integer code) {
            return stateMap.get(code);
        }

        public Integer getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }

    private Long id;

    private Long orderItemId;

    private Long customerId;

    private Long shopId;

    private String serviceSn;

    private Byte type;

    private String reason;

    private String conclusion;

    private Long refund;

    private Integer quantity;

    private Long regionId;

    private String detail;

    private String consignee;

    private String mobile;

    private String customerLogSn;

    private String shopLogSn;

    private Byte state;

    private Byte beDeleted;

    private LocalDateTime gmtCreated;

    private LocalDateTime gmtModified;


    private Long orderId;

    private String orderSn;

    private Long skuId;

    private String skuName;


    public Aftersale(){

    }


    public Aftersale(AftersaleServicePo po){
        this.id=po.getId();
        this.orderId=po.getOrderId();
        this.orderItemId=po.getOrderItemId();
        this.customerId=po.getCustomerId();
        this.shopId=po.getShopId();
        this.serviceSn=po.getServiceSn();
        this.type=po.getType();
        this.reason=po.getReason();
        this.conclusion=po.getConclusion();
        this.refund=po.getRefund();
        this.quantity=po.getQuantity();
        this.regionId=po.getRegionId();
        this.detail=po.getDetail();
        this.consignee=po.getConsignee();
        this.mobile = po.getMobile();
        this.customerLogSn=po.getCustomerLogSn();
        this.shopLogSn=po.getShopLogSn();
        this.state=po.getState();
        this.beDeleted=po.getBeDeleted();
        this.gmtCreated=po.getGmtCreate();
        this.gmtModified=po.getGmtModified();
    }

    public AftersaleServicePo createUpdatePo(AftersaleVo vo) {

        AftersaleServicePo po = new AftersaleServicePo();
        po.setId(id);
        po.setReason(vo.getReason());
        po.setConclusion("");
        po.setRefund(refund);
        po.setQuantity(vo.getQuantity());
        po.setRegionId(vo.getRegionId());
        po.setDetail(vo.getDetail());
        po.setConsignee(vo.getConsignee());
        po.setMobile(vo.getMobile());
        po.setState(State.CHECK.getCode().byteValue());
        po.setGmtCreate(null);
        po.setGmtModified(LocalDateTime.now());

        return po;
    }

    public AftersaleServicePo createSendbackPo(AftersaleSendbackVo vo){
        AftersaleServicePo po = new AftersaleServicePo();

        po.setId(id);
        po.setCustomerLogSn(vo.getLogSn());
        po.setState(State.SENDBACKING.getCode().byteValue());
        po.setGmtCreate(null);
        po.setGmtModified(LocalDateTime.now());

        return po;
    }

    public AftersaleServicePo createConfirmPo(){
        AftersaleServicePo po = new AftersaleServicePo();

        po.setId(id);
        po.setState(State.SUCESS.getCode().byteValue());
        po.setGmtCreate(null);
        po.setGmtModified(LocalDateTime.now());

        return po;
    }

    public AftersaleServicePo createDeliverPo(AftersaleDeliverVo vo,Long orderId){
        AftersaleServicePo po = new AftersaleServicePo();

        po.setId(id);
        po.setShopLogSn(vo.getShopLogSn());
        po.setState(State.DELIVERING.getCode().byteValue());
        po.setOrderId(orderId);
        po.setGmtCreate(null);
        po.setGmtModified(LocalDateTime.now());

        return po;
    }

    public AftersaleServicePo createCancelOrDeletePo(){
        AftersaleServicePo po=new AftersaleServicePo();

        po.setId(id);
        if(State.getTypeByCode(state.intValue()) == State.SENDBACKWAIT || State.getTypeByCode(state.intValue()) == State.CHECK) {
            po.setState(State.CANCEL.getCode().byteValue());
        }
        if(State.getTypeByCode(state.intValue())== State.SUCESS || State.getTypeByCode(state.intValue())==State.CANCEL){
            po.setBeDeleted((byte)1);
        }
        po.setGmtCreate(null);
        po.setGmtModified(LocalDateTime.now());

        return po;
    }

    public AftersaleServicePo createConfirmPo(AftersaleConfirmVo vo){
        AftersaleServicePo po=new AftersaleServicePo();

        po.setId(id);
        po.setConclusion(vo.getConclusion());
        if(vo.getConfirm().equals(true)){
            po.setState(State.SENDBACKWAIT.getCode().byteValue());
            po.setRefund(vo.getPrice().longValue());
            po.setType(vo.getType().byteValue());
        }
        else {
            po.setState(State.DISAGREE.getCode().byteValue());
        }
        po.setGmtCreate(null);
        po.setGmtModified(LocalDateTime.now());

        return po;
    }

    public AftersaleServicePo createRecievePo(AftersaleConfirmVo vo){
        AftersaleServicePo po=new AftersaleServicePo();

        po.setId(id);
        po.setConclusion(vo.getConclusion());
        if(vo.getConfirm().equals(true) && (type.intValue()==0 || type.intValue()==2)){
            po.setState(State.DILIVERWAIT.getCode().byteValue());
        }
        else if(vo.getConfirm().equals(true) && (type.intValue()==1)){
            po.setState(State.REFUNDWAIT.getCode().byteValue());
        }
        else {
            po.setState(State.SENDBACKWAIT.getCode().byteValue());
        }
        po.setGmtCreate(null);
        po.setGmtModified(LocalDateTime.now());

        return po;
    }

    public AftersaleServicePo createInsertPo(){
        AftersaleServicePo po=new AftersaleServicePo();

        po.setId(id);
        po.setOrderItemId(orderItemId);
        po.setCustomerId(customerId);
        po.setShopId(shopId);
        po.setServiceSn(serviceSn);
        po.setType(type);
        po.setReason(reason);
        po.setConclusion(null);
        po.setRefund(refund);
        po.setQuantity(quantity);
        po.setRegionId(regionId);
        po.setDetail(detail);
        po.setConsignee(consignee);
        po.setMobile(mobile);
        po.setCustomerLogSn(null);
        po.setShopLogSn(null);
        po.setBeDeleted((byte)0);
        po.setState(State.CHECK.getCode().byteValue());
        po.setGmtCreate(LocalDateTime.now());
        po.setGmtModified(null);

        return po;
    }


    @Override
    public AftersaleRetVo createVo() {
        AftersaleRetVo vo=new AftersaleRetVo();

        vo.setId(id);
        vo.setOrderId(orderId);
        vo.setOrderSn(orderSn);
        vo.setOrderItemId(orderItemId);
        vo.setSkuId(skuId);
        vo.setSkuName(skuName);
        vo.setCustomerId(customerId);
        vo.setShopId(shopId);
        vo.setServiceSn(serviceSn);
        vo.setType(type.intValue());
        vo.setReason(reason);
        vo.setConclusion(conclusion);
        vo.setRefund(refund);
        vo.setQuantity(quantity);
        vo.setRegionId(regionId);
        vo.setDetail(detail);
        vo.setConsignee(consignee);
        vo.setMobile(mobile);
        vo.setCustomerLogSn(customerLogSn);
        vo.setShopLogSn(shopLogSn);
        vo.setState(state);

        return vo;
    }

    @Override
    public AftersaleRetSimpleVo createSimpleVo() {

        AftersaleRetSimpleVo vo=new AftersaleRetSimpleVo();

        vo.setId(id);
        vo.setOrderId(orderId);
        vo.setOrderItemId(orderItemId);
        vo.setCustomerId(customerId);
        vo.setShopId(shopId);
        vo.setServiceSn(serviceSn);
        vo.setType(type);
        vo.setReason(reason);
        vo.setConclusion(conclusion);
        vo.setRefund(refund);
        vo.setQuantity(quantity);
        vo.setRegionId(regionId);
        vo.setDetail(detail);
        vo.setConsignee(consignee);
        vo.setMobile(mobile);
        vo.setCustomerLogSn(customerLogSn);
        vo.setShopLogSn(shopLogSn);
        vo.setState(state);

        return vo;
    }
}
