package social.logos.epubmaker.util;

import java.util.HashMap;
import java.util.Map;

public enum LanguageUtil {


    ABK("abk", "ab"),
    AAR("aar", "aa"),
    AFR("afr", "af"),
    ALB("alb", "sq"),
    AMH("amh", "am"),
    ARA("ara", "ar"),
    ARM("arm", "hy"),
    ASM("asm", "as"),
    AYM("aym", "ay"),
    AZE("aze", "az"),


    BAK("bak", "ba"),
    BAQ("baq", "eu"),
    BEN("ben", "bn"),
    BIH("bih", "bh"),
    BIS("bis", "bi"),

    BRE("bre", "be"),
    BUL("bul", "bg"),
    BUR("bur", "my"),
    BEL("bel", "be"),


    CAT("cat", "ca"),
    CHI("chi", "zh"),
    COS("cos", "co"),
    CUS("cus", "hr"),
    CZE("cze", "cs"),

    DAN("dan", "da"),
    DUT("dut", "nl"),
    DZO("dzo", "dz"),

    ENG("eng", "en"),
    EPO("epo", "eo"),
    EST("est", "et"),


    FAO("fao", "fo"),
    FIJ("fij", "fj"),
    FRE("fre", "fr"),
    FRY("fry", "fy"),


    GLG("glg", "gl"),
    GEO("geo", "ka"),
    GER("ger", "de"),
    GRE("gre", "el"),

    KAL("kal", "kl"),
    GRN("grn", "gn"),
    GUJ("guj", "gu"),


    HAU("hau", "ha"),
    HEB("heb", "he"),
    HIN("hin", "hi"),
    HUN("hun", "hu"),


    ICE("ice", "is"),
    IND("ind", "id"),
    INA("ina", "ia"),
    IKU("iku", "iu"),
    IPK("ipk", "ik"),
    GLE("gle", "ga"),
    ITA("ita", "it"),

    JPN("jpn", "ja"),
    JAV("jav", "jv"),

    KAN("kan", "kn"),
    KAS("kas", "ks"),
    KAZ("kaz", "kk"),
    KHM("khm", "km"),
    KIN("kin", "rw"),
    KIR("kir", "ky"),
    KOR("kor", "ko"),
    KUR("kur", "ku"),


    OCI("oci", "oc"),


    LAO("lao", "lo"),
    LAT("lat", "la"),
    LAV("lav", "lv"),
    LIN("lin", "ln"),
    LIT("lit", "lt"),

    MAC("mac", "mk"),
    MLG("mlg", "mg"),
    MAY("may", "ms"),
    MLT("mlt", "ml"),
    MAO("mao", "mi"),
    MAR("mar", "mr"),
    MOL("mol", "mo"),
    MON("mon", "mn"),

    NAU("nau", "na"),
    NEP("nep", "ne"),
    NOR("nor", "no"),

    ORI("ori", "or"),
    ORM("orm", "om"),

    PAN("pan", "pa"),
    PER("per", "fa"),
    POL("pol", "pl"),
    POR("por", "pt"),
    PUS("pus", "ps"),


    QUE("que", "qu"),
    ROH("roh", "rm"),
    RUM("rum", "ro"),
    RUN("run", "rn"),
    RUS("rus", "ru"),

    SMO("smo", "sm"),
    SAG("sag", "sg"),
    SAN("san", "sa"),
    SEM("sem", "sr"),
    SCR("scr", "sh"),
    SNA("sna", "sn"),
    SND("snd", "sd"),
    SIN("sin", "si"),
    SSW("ssw", "ss"),
    SLK("slk", "sk"),
    SOM("som", "so"),
    SOT("sot", "st"),
    ESL("esl", "es"),
    SUN("sun", "su"),
    SWA("swa", "sw"),
    SVE("sve", "sv"),

    TGL("tgl", "tl"),
    TGK("tgk", "tg"),
    TAM("tam", "ta"),
    TAT("tat", "tt"),
    TEL("tel", "te"),
    THA("tha", "th"),
    BOD("bod", "bo"),
    TIR("tir", "ti"),
    TOG("tog", "to"),
    TSO("tso", "ts"),
    TSN("tsn", "tn"),
    TUR("tur", "tr"),
    TUK("tuk", "tk"),
    TWI("twi", "tw"),

    UIG("uig", "ug"),
    UKR("ukr", "uk"),
    URD("urd", "ur"),
    UZB("uzb", "uz"),

    VIE("vie", "vi"),
    VOL("vol", "vo"),
    CYM("cym", "cy"),

    WOL("wol", "wo"),

    XHO("xho", "xh"),

    YID("yid", "yi"),

    ZHA("zha", "za"),
    ZUL("zul", "zl");


    public final String onixCode;
    public final String epubCode;

    private LanguageUtil(String onixCode, String epubCode) {
        this.onixCode = onixCode;
        this.epubCode = epubCode;
    }

    public String getOnixCode() {
        return onixCode;
    }

    public String getEpubCode() {
        return onixCode;
    }

    private static volatile Map<String, LanguageUtil> map;

    private static Map<String, LanguageUtil> map() {
        Map<String, LanguageUtil> result = map;
        if (result == null) {
            synchronized (LanguageUtil.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (LanguageUtil e : values())
                        result.put(e.epubCode, e);
                    map = result;
                }
            }
        }
        return result;
    }

    public static LanguageUtil byEpubCode(String code) {
        if (code == null || code.isEmpty())
            return null;
        return map().get(code);
    }

}
