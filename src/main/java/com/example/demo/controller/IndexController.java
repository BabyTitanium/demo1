package com.example.demo.controller;

import com.aicai.appmodel.domain.result.ModelResult;
import com.example.demo.User;
import com.example.demo.vo.OfficeNavQueryParamVo;
import com.huasheng.fund.common.channel.domain.gaoteng.GaotengNetOfficeNav;
import com.huasheng.fund.common.channel.service.GaotengService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
@Controller
public class IndexController {

    @Autowired
    @Qualifier("gaotengServiceClient")
    GaotengService gaotengService;

    @Value("${hs.fund.srv.dubbo.registry.client}")
    String value;

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);


    @RequestMapping("index")
    @ResponseBody
    public String index(){
        ModelResult<GaotengNetOfficeNav> gaotengNetOfficeNavModelResult = gaotengService.queryNetOfficeNav("10021001",LocalDate.of(2021,10,26));
        System.out.println(gaotengNetOfficeNavModelResult);
        System.out.println(value);
        logger.info(value);
        return "index";
    }


    @RequestMapping("getGaotengOfficeNav")
    @ResponseBody
    public String getGaotengOfficeNav(OfficeNavQueryParamVo officeNavQueryParamVo){
        return "index";
    }

}
