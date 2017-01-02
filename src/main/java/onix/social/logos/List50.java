//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.09 at 07:39:09 PM IST 
//


package onix.social.logos;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for List50.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="List50">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="cm"/>
 *     &lt;enumeration value="gr"/>
 *     &lt;enumeration value="in"/>
 *     &lt;enumeration value="kg"/>
 *     &lt;enumeration value="lb"/>
 *     &lt;enumeration value="mm"/>
 *     &lt;enumeration value="oz"/>
 *     &lt;enumeration value="px"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "List50")
@XmlEnum
public enum List50 {


    /**
     * Millimeters are the preferred metric unit of length
     * 
     */
    @XmlEnumValue("cm")
    CM("cm"),
    @XmlEnumValue("gr")
    GR("gr"),
    @XmlEnumValue("in")
    IN("in"),

    /**
     * Grams are the preferred metric unit of weight
     * 
     */
    @XmlEnumValue("kg")
    KG("kg"),
    @XmlEnumValue("lb")
    LB("lb"),
    @XmlEnumValue("mm")
    MM("mm"),
    @XmlEnumValue("oz")
    OZ("oz"),
    @XmlEnumValue("px")
    PX("px");
    private final String value;

    List50(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static List50 fromValue(String v) {
        for (List50 c: List50 .values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
