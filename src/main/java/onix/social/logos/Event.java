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
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}EventRole"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}EventName" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}EventAcronym" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}EventNumber" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}EventTheme" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}EventDate" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}EventPlace" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}EventSponsor" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}Website" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://ns.editeur.org/onix/3.0/reference}generalAttributes"/>
 *       &lt;attribute name="refname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="Event"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="shortname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="event"/>
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
    "eventRole",
    "eventName",
    "eventAcronym",
    "eventNumber",
    "eventTheme",
    "eventDate",
    "eventPlace",
    "eventSponsor",
    "website"
})
@XmlRootElement(name = "Event")
public class Event {

    @XmlElement(name = "EventRole", required = true)
    protected EventRole eventRole;
    @XmlElement(name = "EventName", required = true)
    protected List<EventName> eventName;
    @XmlElement(name = "EventAcronym")
    protected List<EventAcronym> eventAcronym;
    @XmlElement(name = "EventNumber")
    protected EventNumber eventNumber;
    @XmlElement(name = "EventTheme")
    protected List<EventTheme> eventTheme;
    @XmlElement(name = "EventDate")
    protected EventDate eventDate;
    @XmlElement(name = "EventPlace")
    protected List<EventPlace> eventPlace;
    @XmlElement(name = "EventSponsor")
    protected List<EventSponsor> eventSponsor;
    @XmlElement(name = "Website")
    protected List<Website> website;
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
     * Gets the value of the eventRole property.
     * 
     * @return
     *     possible object is
     *     {@link EventRole }
     *     
     */
    public EventRole getEventRole() {
        return eventRole;
    }

    /**
     * Sets the value of the eventRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventRole }
     *     
     */
    public void setEventRole(EventRole value) {
        this.eventRole = value;
    }

    /**
     * Gets the value of the eventName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventName }
     * 
     * 
     */
    public List<EventName> getEventName() {
        if (eventName == null) {
            eventName = new ArrayList<EventName>();
        }
        return this.eventName;
    }

    /**
     * Gets the value of the eventAcronym property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventAcronym property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventAcronym().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventAcronym }
     * 
     * 
     */
    public List<EventAcronym> getEventAcronym() {
        if (eventAcronym == null) {
            eventAcronym = new ArrayList<EventAcronym>();
        }
        return this.eventAcronym;
    }

    /**
     * Gets the value of the eventNumber property.
     * 
     * @return
     *     possible object is
     *     {@link EventNumber }
     *     
     */
    public EventNumber getEventNumber() {
        return eventNumber;
    }

    /**
     * Sets the value of the eventNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventNumber }
     *     
     */
    public void setEventNumber(EventNumber value) {
        this.eventNumber = value;
    }

    /**
     * Gets the value of the eventTheme property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventTheme property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventTheme().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventTheme }
     * 
     * 
     */
    public List<EventTheme> getEventTheme() {
        if (eventTheme == null) {
            eventTheme = new ArrayList<EventTheme>();
        }
        return this.eventTheme;
    }

    /**
     * Gets the value of the eventDate property.
     * 
     * @return
     *     possible object is
     *     {@link EventDate }
     *     
     */
    public EventDate getEventDate() {
        return eventDate;
    }

    /**
     * Sets the value of the eventDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventDate }
     *     
     */
    public void setEventDate(EventDate value) {
        this.eventDate = value;
    }

    /**
     * Gets the value of the eventPlace property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventPlace property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventPlace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventPlace }
     * 
     * 
     */
    public List<EventPlace> getEventPlace() {
        if (eventPlace == null) {
            eventPlace = new ArrayList<EventPlace>();
        }
        return this.eventPlace;
    }

    /**
     * Gets the value of the eventSponsor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventSponsor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventSponsor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventSponsor }
     * 
     * 
     */
    public List<EventSponsor> getEventSponsor() {
        if (eventSponsor == null) {
            eventSponsor = new ArrayList<EventSponsor>();
        }
        return this.eventSponsor;
    }

    /**
     * Gets the value of the website property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the website property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWebsite().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Website }
     * 
     * 
     */
    public List<Website> getWebsite() {
        if (website == null) {
            website = new ArrayList<Website>();
        }
        return this.website;
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