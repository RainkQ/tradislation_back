package tk.tnicy.tradislation.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BigType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bigTypeId;

    private String typeName;

    public Integer getBigTypeId() {
        return bigTypeId;
    }

    public void setBigTypeId(Integer bigTypeId) {
        this.bigTypeId = bigTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public BigType() {
    }

    public BigType(int bigTypeId, String typeName) {
        this.bigTypeId = bigTypeId;
        this.typeName = typeName;
    }
}
