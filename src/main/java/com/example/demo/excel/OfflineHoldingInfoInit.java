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
    public static void main(String[] args) throws Exception {
        String filePath = "F:\\fund\\基金2.5\\ALLTXN_AS_AT_Peter(test) (1)_01.xlsx";
        String sheetName = "TX";
        Integer rowStartNum = 1; // 起始行号从0开始
        Integer rowEndNum = 18;
        Collection<FundHoldingInfoPOJO> fundHoldingInfoPOJOList = getFundHoldingInfoList(filePath, sheetName, rowStartNum, rowEndNum);

        for (FundHoldingInfoPOJO info : fundHoldingInfoPOJOList) {
            String sql = "insert into fund_holding_info (client_id, product_id, currency_code, start_date, holding_shares," +
                    "total_buy_amount, total_buy_shares, total_buy_fare, total_sell_amount, total_sell_fare," +
                    "diluted_cost, average_cost, updated_date, created_date, created_by, updated_by)" +
                    "values (" +
                    info.getClientId() + "," +
                    info.getProductId() + "," +
                    "'"+info.getCurrencyCode() + "'," +
                    "'"+info.getStartDate() + "'," +
                    info.getHoldingShares() + "," +
                    info.getTotalBuyAmount() + "," +
                    info.getTotalBuyShares() + "," +
                    info.getTotalBuyFare() + "," +
                    info.getTotalSellAmount() + "," +
                    info.getTotalSellFare() + "," +
                    info.getDilutedCost() + "," +
                    info.getAverageCost() + "," +
                      "NOW(),NOW(),'SYSTEM','SYSTEM'" +
                    ");";
            System.out.println(sql);
        }
    }

    public static Collection<FundHoldingInfoPOJO> getFundHoldingInfoList (String filePath, String sheetName, Integer rowStartNum, Integer rowEndNum) throws Exception {
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
            String clientIdStr = getRawString(row.getCell(6));
            String productIdStr = getRawString(row.getCell(7));
            Long clientId = Long.valueOf(clientIdStr);
            Long productId = Long.valueOf(productIdStr);
            LocalDate date = LocalDate.parse(getString(row.getCell(16))); // 清算日期
            String currencyCode = getString(row.getCell(8)); // 币种

            String key = clientIdStr + "_" + productIdStr;
            FundHoldingInfoPOJO fundHoldingInfoPOJO = new FundHoldingInfoPOJO();

            if (map.containsKey(key)) {
                fundHoldingInfoPOJO = map.get(key);
            } else {
                fundHoldingInfoPOJO.setClientId(clientId);
                fundHoldingInfoPOJO.setProductId(productId);
                fundHoldingInfoPOJO.setStartDate(date);
                fundHoldingInfoPOJO.setCurrencyCode(currencyCode);
                fundHoldingInfoPOJO.setHoldingShares(BigDecimal.ZERO);
                fundHoldingInfoPOJO.setTotalBuyAmount(BigDecimal.ZERO);
                fundHoldingInfoPOJO.setTotalBuyFare(BigDecimal.ZERO);
                fundHoldingInfoPOJO.setTotalBuyShares(BigDecimal.ZERO);
                fundHoldingInfoPOJO.setTotalSellAmount(BigDecimal.ZERO);
                fundHoldingInfoPOJO.setTotalSellFare(BigDecimal.ZERO);
                fundHoldingInfoPOJO.setDilutedCost(BigDecimal.ZERO);
                fundHoldingInfoPOJO.setAverageCost(BigDecimal.ZERO);
            }
            String side = getString(row.getCell(9));
            if (side.equalsIgnoreCase("申购")) {
                BigDecimal buyAmount = new BigDecimal(getString(row.getCell(10))); // 申购金额包含手续费
                BigDecimal buyFare = new BigDecimal(getString(row.getCell(11))); //申购手续费
                BigDecimal buyShares = new BigDecimal(getString(row.getCell(14))); // 申购份额
                fundHoldingInfoPOJO.setHoldingShares(fundHoldingInfoPOJO.getHoldingShares().add(buyShares));
                fundHoldingInfoPOJO.setTotalBuyAmount(fundHoldingInfoPOJO.getTotalBuyAmount().add(buyAmount));
                fundHoldingInfoPOJO.setTotalBuyFare(fundHoldingInfoPOJO.getTotalBuyFare().add(buyFare));
                fundHoldingInfoPOJO.setTotalBuyShares(fundHoldingInfoPOJO.getTotalBuyShares().add(buyShares));
            } else if (side.equalsIgnoreCase("转换入")) {
//                BigDecimal buyAmount = BigDecimal.ZERO; // 申购金额包含手续费
//                BigDecimal buyFare = BigDecimal.ZERO; //申购手续费
                BigDecimal transferInShares = new BigDecimal(getString(row.getCell(14))); // 申购份额
                fundHoldingInfoPOJO.setHoldingShares(fundHoldingInfoPOJO.getHoldingShares().add(transferInShares));
//                fundHoldingInfoPOJO.setTotalBuyAmount(fundHoldingInfoPOJO.getTotalBuyAmount().add(buyAmount));
//                fundHoldingInfoPOJO.setTotalBuyFare(fundHoldingInfoPOJO.getTotalBuyFare().add(buyFare));
//                fundHoldingInfoPOJO.setTotalBuyShares(fundHoldingInfoPOJO.getHoldingShares().add(buyShares));
            } else if (side.equalsIgnoreCase("转换出")) {
//                BigDecimal sellAmount = BigDecimal.ZERO; // 赎回金额包含手续费
//                BigDecimal sellFare = BigDecimal.ZERO; // 赎回手续费
                BigDecimal transferOutShares = new BigDecimal(getString(row.getCell(14))); // 赎回份额
                fundHoldingInfoPOJO.setHoldingShares(fundHoldingInfoPOJO.getHoldingShares().add(transferOutShares));
//                fundHoldingInfoPOJO.setTotalSellAmount(fundHoldingInfoPOJO.getTotalSellAmount().add(sellAmount));
//                fundHoldingInfoPOJO.setTotalSellFare(fundHoldingInfoPOJO.getTotalSellFare().add(sellFare));
            }else if (side.equalsIgnoreCase("赎回")) {
                BigDecimal sellAmount = new BigDecimal(getString(row.getCell(10))); // 赎回金额包含手续费
                BigDecimal sellFare = BigDecimal.ZERO; // 赎回手续费
                BigDecimal sellShares = new BigDecimal(getString(row.getCell(14))); // 赎回份额
                fundHoldingInfoPOJO.setHoldingShares(fundHoldingInfoPOJO.getHoldingShares().add(sellShares));
                fundHoldingInfoPOJO.setTotalSellAmount(fundHoldingInfoPOJO.getTotalSellAmount().add(sellAmount.abs()));
                fundHoldingInfoPOJO.setTotalSellFare(fundHoldingInfoPOJO.getTotalSellFare().add(sellFare));
            }
            if (fundHoldingInfoPOJO.getHoldingShares().compareTo(BigDecimal.ZERO) == 0) {
                map.remove(key);
            } else {
                // 平均成本 = （持仓期累计买入净值 + 持仓期买入的交易费用）/（持仓期累计买入数量），累计数据截至T日
                BigDecimal averageCost = BigDecimal.ZERO;
                if (fundHoldingInfoPOJO.getTotalBuyShares().compareTo(BigDecimal.ZERO)>0) {
                    averageCost = fundHoldingInfoPOJO.getTotalBuyAmount().divide(fundHoldingInfoPOJO.getTotalBuyShares(), 6, RoundingMode.HALF_UP);
                }

                // 摊薄成本 = （持仓期累计买入净值- 持仓期累计卖出净值 + 持仓期买入卖出的交易手续费）/持仓份额
                BigDecimal dilutedCost = BigDecimal.ZERO;
                if (fundHoldingInfoPOJO.getHoldingShares().compareTo(BigDecimal.ZERO)>0) {
                    dilutedCost = fundHoldingInfoPOJO.getTotalBuyAmount().subtract(fundHoldingInfoPOJO.getTotalSellAmount()).add(fundHoldingInfoPOJO.getTotalSellFare().multiply(new BigDecimal(2))).divide(fundHoldingInfoPOJO.getHoldingShares(), 6, RoundingMode.HALF_UP);
                }
                fundHoldingInfoPOJO.setAverageCost(averageCost);
                fundHoldingInfoPOJO.setDilutedCost(dilutedCost);

                map.put(key, fundHoldingInfoPOJO);
            }

        }

        return map.values();
    }

    public static String getRawString(XSSFCell xssfCell) {
        return xssfCell.getRawValue();

    }

        /**
         * 把单元格的内容转为字符串
         *
         * @param xssfCell 单元格
         * @return String
         */
    public static String getString(XSSFCell xssfCell) {
        if (xssfCell == null) {
            return BigDecimal.ZERO.toPlainString();
        }
        if (StringUtils.isEmpty(xssfCell.getRawValue())) {
            return BigDecimal.ZERO.toPlainString();

        } else if (xssfCell.getCellTypeEnum() == CellType.NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(xssfCell)) {
                Date date = xssfCell.getDateCellValue();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                return formatter.format(date);
            } else {
                return String.valueOf(xssfCell.getNumericCellValue());
            }
        } else if (xssfCell.getCellTypeEnum() == CellType.FORMULA) {
            return String.valueOf(xssfCell.getNumericCellValue());
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
