package tk.tnicy.tradislation.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;

@Entity
public class Translation {
    @Id
    private int id;
    private String BigType;
    private String SmallType;
    private String chi;
    private String eng;
    private String related;
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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



    //解码String 的 related 返回列表
    public ArrayList<String> getRelatedString(){

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
            ArrayList<String> relate = getRelatedString();
            relate.add(rel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
