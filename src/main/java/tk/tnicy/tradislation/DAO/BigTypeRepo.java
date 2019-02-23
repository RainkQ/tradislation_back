package tk.tnicy.tradislation.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.tnicy.tradislation.Entity.BigType;

import java.util.List;

public interface BigTypeRepo extends JpaRepository<BigType, Integer> {
    public List<BigType> findAll();

    public List<BigType> findByTypeName(String typeName);
}
