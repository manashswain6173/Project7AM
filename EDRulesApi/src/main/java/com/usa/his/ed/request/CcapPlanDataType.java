//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.11 at 01:19:11 PM IST 
//


package com.usa.his.ed.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ccapPlanDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ccapPlanDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kids-count" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kids-age" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="parents-employed" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="family-income" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ccapPlanDataType", propOrder = {
    "kidsCount",
    "kidsAge",
    "parentsEmployed",
    "familyIncome"
})
public class CcapPlanDataType {

    @XmlElement(name = "kids-count")
    protected int kidsCount;
    @XmlElement(name = "kids-age")
    protected int kidsAge;
    @XmlElement(name = "parents-employed", required = true)
    protected String parentsEmployed;
    @XmlElement(name = "family-income")
    protected double familyIncome;

    /**
     * Gets the value of the kidsCount property.
     * 
     */
    public int getKidsCount() {
        return kidsCount;
    }

    /**
     * Sets the value of the kidsCount property.
     * 
     */
    public void setKidsCount(int value) {
        this.kidsCount = value;
    }

    /**
     * Gets the value of the kidsAge property.
     * 
     */
    public int getKidsAge() {
        return kidsAge;
    }

    /**
     * Sets the value of the kidsAge property.
     * 
     */
    public void setKidsAge(int value) {
        this.kidsAge = value;
    }

    /**
     * Gets the value of the parentsEmployed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentsEmployed() {
        return parentsEmployed;
    }

    /**
     * Sets the value of the parentsEmployed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentsEmployed(String value) {
        this.parentsEmployed = value;
    }

    /**
     * Gets the value of the familyIncome property.
     * 
     */
    public double getFamilyIncome() {
        return familyIncome;
    }

    /**
     * Sets the value of the familyIncome property.
     * 
     */
    public void setFamilyIncome(double value) {
        this.familyIncome = value;
    }

}
