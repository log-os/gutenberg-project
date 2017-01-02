//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.09 at 07:39:09 PM IST 
//


package onix.social.logos;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}BibleContents" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}BibleVersion" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}StudyBibleType" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}BiblePurpose" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}BibleTextOrganization" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}BibleReferenceLocation" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}BibleTextFeature" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://ns.editeur.org/onix/3.0/reference}generalAttributes"/>
 *       &lt;attribute name="refname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="Bible"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="shortname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="bible"/>
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
    "bibleContents",
    "bibleVersion",
    "studyBibleType",
    "biblePurpose",
    "bibleTextOrganization",
    "bibleReferenceLocation",
    "bibleTextFeature"
})
@XmlRootElement(name = "Bible")
public class Bible {

    @XmlElement(name = "BibleContents", required = true)
    protected List<BibleContents> bibleContents;
    @XmlElement(name = "BibleVersion", required = true)
    protected List<BibleVersion> bibleVersion;
    @XmlElement(name = "StudyBibleType")
    protected StudyBibleType studyBibleType;
    @XmlElement(name = "BiblePurpose")
    protected List<BiblePurpose> biblePurpose;
    @XmlElement(name = "BibleTextOrganization")
    protected BibleTextOrganization bibleTextOrganization;
    @XmlElement(name = "BibleReferenceLocation")
    protected BibleReferenceLocation bibleReferenceLocation;
    @XmlElement(name = "BibleTextFeature")
    protected List<BibleTextFeature> bibleTextFeature;
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
     * Gets the value of the bibleContents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bibleContents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBibleContents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BibleContents }
     * 
     * 
     */
    public List<BibleContents> getBibleContents() {
        if (bibleContents == null) {
            bibleContents = new ArrayList<BibleContents>();
        }
        return this.bibleContents;
    }

    /**
     * Gets the value of the bibleVersion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bibleVersion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBibleVersion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BibleVersion }
     * 
     * 
     */
    public List<BibleVersion> getBibleVersion() {
        if (bibleVersion == null) {
            bibleVersion = new ArrayList<BibleVersion>();
        }
        return this.bibleVersion;
    }

    /**
     * Gets the value of the studyBibleType property.
     * 
     * @return
     *     possible object is
     *     {@link StudyBibleType }
     *     
     */
    public StudyBibleType getStudyBibleType() {
        return studyBibleType;
    }

    /**
     * Sets the value of the studyBibleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudyBibleType }
     *     
     */
    public void setStudyBibleType(StudyBibleType value) {
        this.studyBibleType = value;
    }

    /**
     * Gets the value of the biblePurpose property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the biblePurpose property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBiblePurpose().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BiblePurpose }
     * 
     * 
     */
    public List<BiblePurpose> getBiblePurpose() {
        if (biblePurpose == null) {
            biblePurpose = new ArrayList<BiblePurpose>();
        }
        return this.biblePurpose;
    }

    /**
     * Gets the value of the bibleTextOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link BibleTextOrganization }
     *     
     */
    public BibleTextOrganization getBibleTextOrganization() {
        return bibleTextOrganization;
    }

    /**
     * Sets the value of the bibleTextOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link BibleTextOrganization }
     *     
     */
    public void setBibleTextOrganization(BibleTextOrganization value) {
        this.bibleTextOrganization = value;
    }

    /**
     * Gets the value of the bibleReferenceLocation property.
     * 
     * @return
     *     possible object is
     *     {@link BibleReferenceLocation }
     *     
     */
    public BibleReferenceLocation getBibleReferenceLocation() {
        return bibleReferenceLocation;
    }

    /**
     * Sets the value of the bibleReferenceLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BibleReferenceLocation }
     *     
     */
    public void setBibleReferenceLocation(BibleReferenceLocation value) {
        this.bibleReferenceLocation = value;
    }

    /**
     * Gets the value of the bibleTextFeature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bibleTextFeature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBibleTextFeature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BibleTextFeature }
     * 
     * 
     */
    public List<BibleTextFeature> getBibleTextFeature() {
        if (bibleTextFeature == null) {
            bibleTextFeature = new ArrayList<BibleTextFeature>();
        }
        return this.bibleTextFeature;
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