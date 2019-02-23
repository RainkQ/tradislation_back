package tk.tnicy.tradislation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.tnicy.tradislation.DAO.BigTypeRepo;
import tk.tnicy.tradislation.DAO.SmallTypeRepo;
import tk.tnicy.tradislation.DAO.TranslationRepo;
import tk.tnicy.tradislation.Entity.BigType;
import tk.tnicy.tradislation.Entity.SmallType;
import tk.tnicy.tradislation.Entity.Translation;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TranslationStringController {

    @Autowired
    TranslationRepo translationRepo;

    @Autowired
    BigTypeRepo bigTypeRepo;

    @Autowired
    SmallTypeRepo smallTypeRepo;


    @GetMapping("/")
    public List<Translation> getTranslation() {
        return translationRepo.findAll();
    }

    @GetMapping("/reform")
    public String reformDataTypes() {
        List<Translation> translations = translationRepo.findAll();

        translationRepo.deleteAll();
        bigTypeRepo.deleteAll();
        smallTypeRepo.deleteAll();

        List<BigType> bigTypes = new ArrayList<>();
        List<SmallType> smallTypes = new ArrayList<>();

        for (Translation translation :
                translations) {

            boolean bigFlag = false;
            for (BigType bigType : bigTypes) {
                if (translation.getBigType().equals(bigType.getTypeName())) {
                    bigFlag = true;

                    boolean smallFlag = false;
                    for (SmallType smallType :
                            smallTypes) {
                        if (translation.getSmallType().equals(smallType.getTypeName())) {
                            smallFlag = true;
                        }
                    }
                    if (!smallFlag) {
                        SmallType smallType = new SmallType();
                        smallType.setTypeName(translation.getSmallType());
                        smallType.setBigTypeId(bigType.getBigTypeId());
                        smallTypeRepo.save(smallType);
                        smallTypes.clear();
                        smallTypes = smallTypeRepo.findAll();
                    }


                }
            }
            if (!bigFlag) {
                BigType bigType = new BigType();
                bigType.setTypeName(translation.getBigType());
                bigTypeRepo.save(bigType);
                bigTypes.clear();
                bigTypes = bigTypeRepo.findAll();


                SmallType smallType = new SmallType();
                smallType.setTypeName(translation.getSmallType());
                smallType.setBigTypeId(bigTypeRepo.findByTypeName(translation.getBigType()).get(0).getBigTypeId());
                smallTypeRepo.save(smallType);
                smallTypes.clear();
                smallTypes = smallTypeRepo.findAll();

            }


        }

        bigTypes.clear();
        bigTypes = bigTypeRepo.findAll();
        smallTypes.clear();
        smallTypes = smallTypeRepo.findAll();

        for (Translation translation : translations) {
            boolean bigFlag = false;
            for (BigType bigType :
                    bigTypes) {
                if (bigType.getTypeName().equals(translation.getBigType())) {
                    translation.setBigTypeId(bigType.getBigTypeId());

                    bigFlag = true;


                    boolean smallFlag = false;
                    for (SmallType smallType :
                            smallTypes) {
                        if (translation.getSmallType().equals(smallType.getTypeName())) {
                            translation.setSmallTypeId(smallType.getSmallTypeId());
                            smallFlag = true;

                            translationRepo.save(translation);

                        }
                    }

                    if (!smallFlag) {
                        return "smallFlag wrong!";
                    }
                }
            }

            if (!bigFlag) {
                return "bigFlag wrong!";
            }
        }


        return "Done";
    }

    @GetMapping("/bigType")
    public List<BigType> getBigTypes(){
        return bigTypeRepo.findAll();
    }

    @GetMapping("/smallType")
    public List<SmallType> getSmallTypes(){
        return smallTypeRepo.findAll();
    }
}
