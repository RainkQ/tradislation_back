package tk.tnicy.tradislation.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Translation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer translationId;

    private Integer bigTypeId;
    private Integer smallTypeId;
    private String BigType;
    private String SmallType;
    private String chi;
    private String eng;
    private String related;
    private String detail;
    private String spelling;

    public Translation() {
    }

    public Translation(Integer translationId, Integer bigTypeId, Integer smallTypeId, String bigType, String smallType, String chi, String eng, String related, String detail, String spelling) {
        this.translationId = translationId;
        this.bigTypeId = bigTypeId;
        this.smallTypeId = smallTypeId;
        BigType = bigType;
        SmallType = smallType;
        this.chi = chi;
        this.eng = eng;
        this.related = related;
        this.detail = detail;
        this.spelling = spelling;
    }

    public Integer getTranslationId() {
        return translationId;
    }

    public void setTranslationId(Integer translationId) {
        this.translationId = translationId;
    }

    public Integer getBigTypeId() {
        return bigTypeId;
    }

    public void setBigTypeId(Integer bigTypeId) {
        this.bigTypeId = bigTypeId;
    }

    public Integer getSmallTypeId() {
        return smallTypeId;
    }

    public void setSmallTypeId(Integer smallTypeId) {
        this.smallTypeId = smallTypeId;
    }

    public String getBigType() {
        return BigType;
    }

    public void setBigType(String bigType) {
        BigType = bigType;
    }

    public String getSmallType() {
        return SmallType;
    }

    public void setSmallType(String smallType) {
        SmallType = smallType;
    }

    public String getChi() {
        return chi;
    }

    public void setChi(String chi) {
        this.chi = chi;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    //解码String 的 related 返回列表
    public ArrayList<String> geetRelatedString() {

        ArrayList<String> strings = new ArrayList<>();
        String[] rels = related.split(" ");
        for (String s :
                rels) {
            if (!s.isEmpty()) {
                strings.add(s);
            }
        }
        return strings;
    }

    public boolean addRelated(String rel) {
        try {
            ArrayList<String> relate = geetRelatedString();
            relate.add(rel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
