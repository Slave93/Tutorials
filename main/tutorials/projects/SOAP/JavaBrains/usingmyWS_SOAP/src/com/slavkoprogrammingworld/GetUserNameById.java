
package com.slavkoprogrammingworld;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getUserNameById complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getUserNameById">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="USERID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUserNameById", propOrder = {
    "userid"
})
public class GetUserNameById {

    @XmlElement(name = "USERID")
    protected int userid;

    /**
     * Gets the value of the userid property.
     * 
     */
    public int getUSERID() {
        return userid;
    }

    /**
     * Sets the value of the userid property.
     * 
     */
    public void setUSERID(int value) {
        this.userid = value;
    }

}
