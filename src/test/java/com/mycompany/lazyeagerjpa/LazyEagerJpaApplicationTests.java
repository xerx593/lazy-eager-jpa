package com.mycompany.lazyeagerjpa;

import com.mycompany.lazyeagerjpa.model.Kunde;
import com.mycompany.lazyeagerjpa.repo.KundeRepository;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class LazyEagerJpaApplicationTests {

    @Autowired
    KundeRepository kundeRepository;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(kundeRepository);
    }

    @Test
    public void testEager() {
        final List<Kunde> list = kundeRepository.findCustom();
        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());
        list.forEach((k) -> {
            Assert.assertNotNull(k.getPost());
        });
    }

    @Test(expected = org.hibernate.LazyInitializationException.class)
    public void testLazy() {
        final List<Kunde> list = kundeRepository.findAll();
        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());

        list.forEach((k) -> {
            //expect exeption here!
            System.out.println(k.getPost());
        });
    }
}
