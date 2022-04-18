package com.example.demo.excel;

import com.huasheng.fund.common.holding.domain.FundHoldingInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class OfflineHoldingInfoInit {
    // clientId = 0, productId =1, side = 2,date,=3 buyAmount=4, buyFare = 5, buyShares =6, sellAmount = 7, sellShares = 8;
    private static Integer[] colNum = {0,1,2,3,4,5,6,7,8};
    public static void main(String[] args) throws Exception {
        String filePath = "";
        String sheetName = "1";
        Integer rowStartNum = 1; // 起始行号从0开始
        Integer rowEndNum = 10;
        List<FundHoldingInfoPOJO> fundHoldingInfoPOJOList = getFundHoldingInfoList(filePath, sheetName, rowStartNum, rowEndNum);
    }

    public static List<FundHoldingInfoPOJO> getFundHoldingInfoList (String filePath, String sheetName, Integer rowStartNum, Integer rowEndNum) throws Exception {
        List<FundHoldingInfoPOJO> list = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            throw new Exception("文件不存在!");
        }
        InputStream in = new FileInputStream(file);
        // 读取整个Excel
        XSSFWorkbook sheets = new XSSFWorkbook(in);
        // 获取第一个表单Sheet
        XSSFSheet sheetAt = sheets.getSheet(sheetName);
        Map<String, FundHoldingInfoPOJO> map = new HashMap<>();
        for (int i = rowStartNum; i <= rowEndNum; i++) {
            XSSFRow row = sheetAt.getRow(i);
            String clientIdStr = getString(row.getCell(colNum[0]));
            String productIdStr = getString(row.getCell(colNum[1]));
            Long clientId = Long.valueOf(clientIdStr);
            Long productId = Long.valueOf(productIdStr);
            LocalDate date = LocalDate.parse(getString(row.getCell(3)));

            String key = clientIdStr + "_" + productIdStr;
            FundHoldingInfoPOJO fundHoldingInfoPOJO = new FundHoldingInfoPOJO();

            if (map.containsKey(key)) {
                fundHoldingInfoPOJO = map.get(key);
            } else {
                fundHoldingInfoPOJO.setClientId(clientId);
                fundHoldingInfoPOJO.setProductId(productId);
                fundHoldingInfoPOJO.setStartDate(date);
                fundHoldingInfoPOJO.setHoldingShares(BigDecimal.ZERO);
                fundHoldingInfoPOJO.setTotalBuyAmount(BigDecimal.ZERO);
                fundHoldingInfoPOJO.setTotalBuyFare(BigDecimal.ZERO);
                fundHoldingInfoPOJO.setTotalSellAmount(BigDecimal.ZERO);
                fundHoldingInfoPOJO.setTotalSellFare(BigDecimal.ZERO);
                fundHoldingInfoPOJO.setDilutedCost(BigDecimal.ZERO);
                fundHoldingInfoPOJO.setAverageCost(BigDecimal.ZERO);
            }
            String side = getString(row.getCell(colNum[2]));
            if (side.equalsIgnoreCase("BUY")) {
                BigDecimal buyAmount = new BigDecimal(getString(row.getCell(colNum[3]))); // 包含手续费
                BigDecimal buyFare = new BigDecimal(getString(row.getCell(colNum[4])));
                BigDecimal buyShares = new BigDecimal(getString(row.getCell(colNum[5])));
                fundHoldingInfoPOJO.setHoldingShares(fundHoldingInfoPOJO.getHoldingShares().add(buyShares));
                fundHoldingInfoPOJO.setTotalBuyAmount(fundHoldingInfoPOJO.getTotalBuyAmount().add(buyAmount));
                fundHoldingInfoPOJO.setTotalBuyFare(fundHoldingInfoPOJO.getTotalBuyFare().add(buyFare));
                fundHoldingInfoPOJO.setTotalBuyShares(fundHoldingInfoPOJO.getHoldingShares().add(buyShares));
            } else if (side.equalsIgnoreCase("sell")) {
                BigDecimal sellAmount = new BigDecimal(getString(row.getCell(colNum[3]))); // 包含手续费
                BigDecimal sellFare = new BigDecimal(getString(row.getCell(colNum[4])));
                BigDecimal sellShares = new BigDecimal(getString(row.getCell(colNum[5])));
                fundHoldingInfoPOJO.setHoldingShares(fundHoldingInfoPOJO.getHoldingShares().subtract(sellShares));
                fundHoldingInfoPOJO.setTotalSellAmount(fundHoldingInfoPOJO.getTotalSellAmount().add(sellAmount));
                fundHoldingInfoPOJO.setTotalSellFare(fundHoldingInfoPOJO.getTotalSellFare().add(sellFare));
            }
            if (fundHoldingInfoPOJO.getHoldingShares().compareTo(BigDecimal.ZERO) == 0) {
                map.remove(key);
            } else {
                // 平均成本 = （持仓期累计买入净值 + 持仓期买入的交易费用）/（持仓期累计买入数量），累计数据截至T日
            BigDecimal averageCost = fundHoldingInfoPOJO.getTotalBuyAmount().divide(fundHoldingInfoPOJO.getTotalBuyShares(), 6, RoundingMode.HALF_UP);

            // 摊薄成本 = （持仓期累计买入净值- 持仓期累计卖出净值 + 持仓期买入卖出的交易手续费）/持仓份额
            BigDecimal dilutedCost = fundHoldingInfoPOJO.getTotalBuyAmount().subtract(fundHoldingInfoPOJO.getTotalSellAmount()).add(fundHoldingInfoPOJO.getTotalSellFare().multiply(new BigDecimal(2))).divide(fundHoldingInfoPOJO.getHoldingShares(), 6, RoundingMode.HALF_UP);

            fundHoldingInfoPOJO.setAverageCost(averageCost);
            fundHoldingInfoPOJO.setDilutedCost(dilutedCost);

            map.put(key, fundHoldingInfoPOJO);
            }

        }

        return list;
    }


    /**
     * 把单元格的内容转为字符串
     *
     * @param xssfCell 单元格
     * @return String
     */
    public static String getString(XSSFCell xssfCell) {
        if (xssfCell == null) {
            return "";
        }
        if (xssfCell.getCellTypeEnum() == CellType.NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(xssfCell)) {
                Date date = xssfCell.getDateCellValue();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                return formatter.format(date);
            } else {
                return String.valueOf(xssfCell.getNumericCellValue());
            }
        } else if (xssfCell.getCellTypeEnum() == CellType.BOOLEAN) {
            return String.valueOf(xssfCell.getBooleanCellValue());
        } else {
            return xssfCell.getStringCellValue();
        }
    }

    public static void main1(String[] args) {
        int type = 1;
        int types = type = type | 8192;
        System.out.println(types);
    }
}
