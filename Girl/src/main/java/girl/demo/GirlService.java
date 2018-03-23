package girl.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(19);
        girlB.setCupSize("B");
        girlRepository.save(girlB);
    }
}
