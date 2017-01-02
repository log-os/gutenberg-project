//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.09 at 07:39:09 PM IST 
//


package onix.social.logos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}SupplierCodeType"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}SupplierCodeTypeName" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}SupplierCodeValue"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://ns.editeur.org/onix/3.0/reference}generalAttributes"/>
 *       &lt;attribute name="refname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="SupplierOwnCoding"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="shortname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="supplierowncoding"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "supplierCodeType",
    "supplierCodeTypeName",
    "supplierCodeValue"
})
@XmlRootElement(name = "SupplierOwnCoding")
public class SupplierOwnCoding {

    @XmlElement(name = "SupplierCodeType", required = true)
    protected SupplierCodeType supplierCodeType;
    @XmlElement(name = "SupplierCodeTypeName")
    protected SupplierCodeTypeName supplierCodeTypeName;
    @XmlElement(name = "SupplierCodeValue", required = true)
    protected SupplierCodeValue supplierCodeValue;
    @XmlAttribute(name = "refname")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String refname;
    @XmlAttribute(name = "shortname")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String shortname;
    @XmlAttribute(name = "datestamp")
    protected String datestamp;
    @XmlAttribute(name = "sourcetype")
    protected String sourcetype;
    @XmlAttribute(name = "sourcename")
    @XmlSchemaType(name = "anySimpleType")
    protected String sourcename;

    /**
     * Gets the value of the supplierCodeType property.
     * 
     * @return
     *     possible object is
     *     {@link SupplierCodeType }
     *     
     */
    public SupplierCodeType getSupplierCodeType() {
        return supplierCodeType;
    }

    /**
     * Sets the value of the supplierCodeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplierCodeType }
     *     
     */
    public void setSupplierCodeType(SupplierCodeType value) {
        this.supplierCodeType = value;
    }

    /**
     * Gets the value of the supplierCodeTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link SupplierCodeTypeName }
     *     
     */
    public SupplierCodeTypeName getSupplierCodeTypeName() {
        return supplierCodeTypeName;
    }

    /**
     * Sets the value of the supplierCodeTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplierCodeTypeName }
     *     
     */
    public void setSupplierCodeTypeName(SupplierCodeTypeName value) {
        this.supplierCodeTypeName = value;
    }

    /**
     * Gets the value of the supplierCodeValue property.
     * 
     * @return
     *     possible object is
     *     {@link SupplierCodeValue }
     *     
     */
    public SupplierCodeValue getSupplierCodeValue() {
        return supplierCodeValue;
    }

    /**
     * Sets the value of the supplierCodeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplierCodeValue }
     *     
     */
    public void setSupplierCodeValue(SupplierCodeValue value) {
        this.supplierCodeValue = value;
    }

    /**
     * Gets the value of the refname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefname() {
        return refname;
    }

    /**
     * Sets the value of the refname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefname(String value) {
        this.refname = value;
    }

    /**
     * Gets the value of the shortname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * Sets the value of the shortname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortname(String value) {
        this.shortname = value;
    }

    /**
     * Gets the value of the datestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatestamp() {
        return datestamp;
    }

    /**
     * Sets the value of the datestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatestamp(String value) {
        this.datestamp = value;
    }

    /**
     * Gets the value of the sourcetype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourcetype() {
        return sourcetype;
    }

    /**
     * Sets the value of the sourcetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourcetype(String value) {
        this.sourcetype = value;
    }

    /**
     * Gets the value of the sourcename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourcename() {
        return sourcename;
    }

    /**
     * Sets the value of the sourcename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourcename(String value) {
        this.sourcename = value;
    }

}
