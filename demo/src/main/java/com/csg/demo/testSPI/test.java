package com.csg.demo.testSPI;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

public class test {

    /**
     * 测试SPI，调用过程(以ServiceLoader<SpiService>为例)
     **/
    public static void main(String[] args) {
        Iterator<SpiService> providers = Service.providers(SpiService.class);
        ServiceLoader<SpiService> load = ServiceLoader.load(SpiService.class);

        while(providers.hasNext()) {
            SpiService ser = providers.next();
            ser.excute();
        }
        System.out.println("--------------------------------");
        Iterator<SpiService> iterator = load.iterator();
        while(iterator.hasNext()) {
            SpiService ser = iterator.next();
            ser.excute();
        }
    }

}
