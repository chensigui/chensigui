package com.csg.demo.testSPI;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpiServiceImpl2 implements SpiService {

    @Override
    public void excute() {
        log.info("----这是spi实现类2");
    }

}
