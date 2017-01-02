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
 * <p>Java class for List138.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="List138">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SFS4900"/>
 *     &lt;enumeration value="SFS5807"/>
 *     &lt;enumeration value="SFS5755"/>
 *     &lt;enumeration value="SFS3602"/>
 *     &lt;enumeration value="ISO3602"/>
 *     &lt;enumeration value="ISO7098"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "List138")
@XmlEnum
public enum List138 {


    /**
     * Transliteration of Cyrillic characters – Slavic languages
     * 
     */
    @XmlEnumValue("SFS4900")
    SFS_4900("SFS4900"),

    /**
     * Transliteration and transcription of Greek characters
     * 
     */
    @XmlEnumValue("SFS5807")
    SFS_5807("SFS5807"),

    /**
     * Transliteration of Arabic characters
     * 
     */
    @XmlEnumValue("SFS5755")
    SFS_5755("SFS5755"),

    /**
     * Transliteration of Hebrew characters
     * 
     */
    @XmlEnumValue("SFS3602")
    SFS_3602("SFS3602"),

    /**
     * Documentation – Romanization of Japanese (kana script)
     * 
     */
    @XmlEnumValue("ISO3602")
    ISO_3602("ISO3602"),

    /**
     * Information and documentation – Romanization of Chinese
     * 
     */
    @XmlEnumValue("ISO7098")
    ISO_7098("ISO7098");
    private final String value;

    List138(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static List138 fromValue(String v) {
        for (List138 c: List138 .values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
