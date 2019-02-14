package tk.tnicy.tradislation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.tnicy.tradislation.DAO.Repository;
import tk.tnicy.tradislation.Entity.Translation;

import java.util.List;

@RestController
public class TranslationStringController {

    @Autowired
    Repository repository;

    @GetMapping("/")
    public List<Translation> getTranslation(){
        return repository.findAll();
    }
}
