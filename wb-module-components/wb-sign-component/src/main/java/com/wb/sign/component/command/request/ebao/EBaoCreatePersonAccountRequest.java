package com.wb.sign.component.command.request.ebao;

import com.timevale.esign.sdk.tech.impl.constants.LegalAreaType;
import com.wb.sign.component.command.request.SignGenericRequest;
import com.wb.sign.component.command.result.ebao.EBaoCreatePersonAccountResult;
import com.wb.sign.component.utils.SignReqCheckUtils;

/**
 * @ClassName: EBaoCreatePersonAccountRequest
 * @Package: com.wb.sign.component.request.ebao
 * @Description: the e bao create person account request
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public class EBaoCreatePersonAccountRequest extends SignGenericRequest<EBaoCreatePersonAccountResult> {

    //  the name
    private String name;

    //  the person area
    private LegalAreaType personArea;

    //  the id no
    private String idNo;

    //  the mobile
    private String mobile;

    //  the email
    private String email;

    //  the organ
    private String organ;

    //  the title
    private String title;

    //  the address
    private String address;

    //  the country
    private String country;

    //  the province
    private String province;

    //  the city
    private String city;

    //  the department
    private String department;

    @Override
    public void check() {
        SignReqCheckUtils.checkEmpty(name, "name");
        SignReqCheckUtils.checkEmpty(personArea, "personArea");
        SignReqCheckUtils.checkEmpty(idNo, "idNo");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LegalAreaType getPersonArea() {
        return personArea;
    }

    public void setPersonArea(LegalAreaType personArea) {
        this.personArea = personArea;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
