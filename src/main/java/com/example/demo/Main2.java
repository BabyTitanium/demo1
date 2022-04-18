package com.example.demo;

import org.slf4j.Logger;

import java.io.FileNotFoundException;
import java.time.*;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime now = LocalDateTime.of(LocalDate.now(), LocalTime.of(05,30));
        ZonedDateTime zonedDateTime = ZonedDateTime.of(now, ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("Europe/Paris"));

        LocalDate a = zonedDateTime.toLocalDate();
        System.out.println(a);
        Thread.sleep(5000);
        System.out.println("aaaa");
    }
}
