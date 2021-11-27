package com.book.bookshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
@TableName(value = "bs_address")
public class Address extends Model<Address> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String province;
    private String city;
    private String area;
    private String detailAddress;
    private String emailCode;
    private String receiver;
    private String tel;
    private String isDefault;  //是否是默认收货地址

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public String getProvince() {
        return province;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getTel() {
        return tel;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
