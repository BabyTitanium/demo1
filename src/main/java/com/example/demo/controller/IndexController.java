package com.example.demo.controller;

import com.aicai.appmodel.domain.result.ModelResult;
import com.example.demo.User;
import com.example.demo.vo.OfficeNavQueryParamVo;
import com.huasheng.fund.common.channel.domain.gaoteng.GaotengNetOfficeNav;
import com.huasheng.fund.common.channel.domain.gaoteng.SevenDayIncome;
import com.huasheng.fund.common.channel.service.GaotengService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        logger.info(value);
        return "index";
    }


    @RequestMapping("getGaotengOfficeNav")
    @ResponseBody
    public String getGaotengOfficeNav(@RequestParam String navDate, @RequestParam String classId, @RequestParam Long productId){
        DecimalFormat decimalFormat = new DecimalFormat("###0.########");
        LocalDate date = LocalDate.parse(navDate);
        ModelResult<GaotengNetOfficeNav> gaotengNetOfficeNavModelResult = gaotengService.queryNetOfficeNav(classId, date);
        if (gaotengNetOfficeNavModelResult.isSuccess()) {
            GaotengNetOfficeNav gaotengNetOfficeNav = gaotengNetOfficeNavModelResult.getModel();
            System.out.println("navDate="+ gaotengNetOfficeNav.getNavDate() +",tradeDate="+ gaotengNetOfficeNav.getTradeDate());
            ModelResult<SevenDayIncome> sevenDayIncomeModelResult = gaotengService.querySevenDayIncome(classId,date);
            SevenDayIncome sevenDayIncome = sevenDayIncomeModelResult.getModel();
            ModelResult<GaotengNetOfficeNav> gaotengPreNetOfficeNavModelResult = gaotengService.queryNetOfficeNav(classId,date.minusDays(1));
            GaotengNetOfficeNav gaotengPreNetOfficeNav = gaotengPreNetOfficeNavModelResult.getModel();
            BigDecimal officeNav = gaotengNetOfficeNav.getOfficeNav();
            BigDecimal preOfficeNav = gaotengPreNetOfficeNav.getOfficeNav();
            BigDecimal rate = sevenDayIncome.getRate();
            String insertRecord = "INSERT INTO `office_nav`( `product_id`, `pre_office_nav`, `office_nav`, `nav_date`, `seven_day_income`, `updated_date`, `created_date`, `updated_by`, `created_by`)" +
                    " VALUES ( " + productId + ", " + preOfficeNav + ", " + officeNav + ", '" + date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "', " + decimalFormat.format(rate) + ", now(),now(), 'system', 'system');\n";
            String current = "INSERT INTO `office_nav_current_data`( `product_id`, `pre_office_nav`, `office_nav`, `nav_date`, `seven_day_income`, `updated_date`, `created_date`, `updated_by`, `created_by`)" +
                    " VALUES ( " + productId + ", " + preOfficeNav + ", " + officeNav + ", '" + date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "', " + decimalFormat.format(rate) + ", now(),now(), 'system', 'system');\n";
            String updateCurrent = "UPDATE  `office_nav_current_data` SET  `nav_date` ='" + date + "', `office_nav`=" + officeNav + ", `pre_office_nav`=" + preOfficeNav + ",`seven_day_income`=" + rate + ", `updated_date`=now() WHERE product_id=" + productId + ";\n";
            System.out.println(insertRecord);
            System.out.println(current);
            System.out.println(updateCurrent);
        }
        return "index";
    }

    @RequestMapping("getGaotengOfficeNavFor1Year")
    @ResponseBody
    public String getGaotengOfficeNavFor1Year(@RequestParam String startDate, @RequestParam String classId, @RequestParam Long productId){
        DecimalFormat decimalFormat = new DecimalFormat("###0.########");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                LocalDate startNavDate = LocalDate.parse(startDate);
                LocalDate now = LocalDate.now();
                LocalDate date = LocalDate.now();
                do {
                    ModelResult<GaotengNetOfficeNav> gaotengNetOfficeNavModelResult = gaotengService.queryNetOfficeNav(classId, date);
                    if (gaotengNetOfficeNavModelResult.isSuccess()) {
                        GaotengNetOfficeNav gaotengNetOfficeNav = gaotengNetOfficeNavModelResult.getModel();
                        LocalDate navDate = gaotengNetOfficeNav.getNavDate();
                        LocalDate tradeDate = gaotengNetOfficeNav.getTradeDate();
                        if (!navDate.isEqual(tradeDate)) {
                            date = navDate;
                        }
                        LocalDate preDate = date.minusDays(1L);
                        ModelResult<SevenDayIncome> sevenDayIncomeModelResult = gaotengService.querySevenDayIncome(classId,date);
                        ModelResult<GaotengNetOfficeNav> gaotengPreNetOfficeNavModelResult = gaotengService.queryNetOfficeNav(classId, preDate);
                        BigDecimal officeNav = gaotengNetOfficeNav.getOfficeNav();
                        BigDecimal preOfficeNav = officeNav;
                        if (gaotengPreNetOfficeNavModelResult.isSuccess()) {
                            GaotengNetOfficeNav gaotengPreNetOfficeNav = gaotengPreNetOfficeNavModelResult.getModel();
                            preOfficeNav = gaotengPreNetOfficeNav.getOfficeNav();
                        } else {
                            logger.error("查询昨日净值失败 navDate="+preDate);
                        }
                        BigDecimal rate = BigDecimal.ZERO;
                        if (sevenDayIncomeModelResult.isSuccess()) {
                            SevenDayIncome sevenDayIncome = sevenDayIncomeModelResult.getModel();
                            rate = sevenDayIncome.getRate();
                        }else {
                            logger.error("查询七日年化失败 navDate="+date);
                        }
                        String insertRecord = "INSERT INTO `office_nav`( `product_id`, `pre_office_nav`, `office_nav`, `nav_date`, `seven_day_income`, `updated_date`, `created_date`, `updated_by`, `created_by`)" +
                                " VALUES ( " + productId + ", " + preOfficeNav + ", " + officeNav + ", '" + date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "', " + decimalFormat.format(rate) + ", now(),now(), 'system', 'system');\n";
                        System.out.println(insertRecord);
                    }else {
                        logger.error("净值日期不存在 navDate=" + date);
                    }
                    date = date.minusDays(1L);
                }while (!date.isBefore(startNavDate));
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        return "index";
    }

}
