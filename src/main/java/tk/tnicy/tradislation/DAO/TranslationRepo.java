package tk.tnicy.tradislation.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tk.tnicy.tradislation.Entity.Translation;

import java.util.List;

@RepositoryRestResource(
        exported = true, //资源是否暴漏，默认true
        path = "translations"//资源暴漏的path访问路径，默认实体名字+s
)
public interface TranslationRepo extends JpaRepository<Translation,Integer> {
    List<Translation> findAll();

}
