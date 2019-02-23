package tk.tnicy.tradislation.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.tnicy.tradislation.Entity.SmallType;

import java.util.List;

public interface SmallTypeRepo extends JpaRepository<SmallType, Integer> {

    public List<SmallType> findAll();

    public List<SmallType> findByTypeName(String typeName);
}
