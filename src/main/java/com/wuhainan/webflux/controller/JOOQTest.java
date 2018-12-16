package com.wuhainan.webflux.controller;


import com.wuhainan.jooqblog.Tables;
import com.wuhainan.jooqblog.tables.Tag;
import org.jooq.DSLContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class JOOQTest {
    @Resource
    private DSLContext dslContext;


    @GetMapping("test")
    public List find() {

        System.out.println(dslContext.selectFrom(Tables.TAG)
                .where(Tag.TAG.VERSION.eq(3))
                .stream()
                .collect(toList()).get(0).getId());
        return null;
    }

}
