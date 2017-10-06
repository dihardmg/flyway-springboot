package com.otorus.dihardmg.flyway.dao;


import com.otorus.dihardmg.flyway.entity.Peserta;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PesertaDaoTest {

    @Autowired
    PesertaDao pd;

    @Test
    public void testCariById(){
        Peserta p = pd.findOne("aa1");
        Assert.assertNotNull(p);
        Assert.assertEquals("naruto", p.getNama());
        Assert.assertEquals("naruto@gmail.com", p.getEmail());

        Peserta px = pd.findOne("xx");
        Assert.assertNull(px);
    }

}
