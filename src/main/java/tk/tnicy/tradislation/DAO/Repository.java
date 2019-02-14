package tk.tnicy.tradislation.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.tnicy.tradislation.Entity.Translation;

import java.util.List;

public interface Repository extends JpaRepository<Translation,Integer> {
    public List<Translation> findAll();
}
