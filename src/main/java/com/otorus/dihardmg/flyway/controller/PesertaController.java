package com.otorus.dihardmg.flyway.controller;

import com.otorus.dihardmg.flyway.dao.PesertaDao;
import com.otorus.dihardmg.flyway.entity.Peserta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class PesertaController {


    @Autowired
    private PesertaDao pd;

    //untuk menampilkan semua data
    @RequestMapping(value = "/peserta", method = RequestMethod.GET )
    public Page<Peserta> cariPeserta(Pageable page){
        return pd.findAll(page);
    }

    //untuk insert peserta baru
    @RequestMapping(value = "/peserta", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void  instertPesertaBaru(@RequestBody @Valid Peserta p){
        pd.save(p);
    }

    //untuk update data peserta
    @RequestMapping(value = "/peserta/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updatePeserta(@PathVariable("id") String id, @RequestBody @Valid Peserta p){
        p.setId(id);
        pd.save(p);

    }

    //cari peserta berdasarkan id dan respon code 404
    @RequestMapping(value = "/peserta/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Peserta> cariPesertaById(@PathVariable("id") String id){
        Peserta hasil = pd.findOne(id);
        if (hasil == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hasil, HttpStatus.OK);
    }

    //untuk delete data peserta
    @RequestMapping(value = "/peserta/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void hapusPeserta(@PathVariable("id") String id){
        pd.delete(id);

    }

}
