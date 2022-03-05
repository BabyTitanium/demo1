package com.example.demo.excel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        String a = "[\n" +
                "    {\n" +
                "        \"id\":72617,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000000225,\n" +
                "        \"memberId\":14292,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"422994005@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/14292-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:22:22\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:58\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"114105\",\n" +
                "        \"name\":\"林羡婷\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72616,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000000579,\n" +
                "        \"memberId\":392705,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1183957779@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/392705-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:22:20\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:56\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"857911\",\n" +
                "        \"name\":\"赵少敏\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72615,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000000698,\n" +
                "        \"memberId\":181,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"306735521@qq.com;306735521@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/181-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:22:18\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:54\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"100002\",\n" +
                "        \"name\":\"朱倩倩\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72614,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000001848,\n" +
                "        \"memberId\":659846,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"ricky.chan@valuable.com.hk;rickycck1993@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/659846-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:22:16\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:52\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1305290\",\n" +
                "        \"name\":\"陳昌楷\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72613,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000005475,\n" +
                "        \"memberId\":856345,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"807261262@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/856345-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:22:14\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:49\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1733877\",\n" +
                "        \"name\":\"陈泰名\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72612,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000006715,\n" +
                "        \"memberId\":572402,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"274264259@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/572402-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:22:12\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:47\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1161330\",\n" +
                "        \"name\":\"李宇\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72611,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000008843,\n" +
                "        \"memberId\":902566,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"3539333717@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/902566-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:58\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:45\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1815233\",\n" +
                "        \"name\":\"王松鹤\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72610,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000010017,\n" +
                "        \"memberId\":1066687,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"292423424@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1066687-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:55\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:43\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2095360\",\n" +
                "        \"name\":\"梅苑\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72609,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000010206,\n" +
                "        \"memberId\":457993,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"aiks_139@139.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/457993-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:53\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:40\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"967500\",\n" +
                "        \"name\":\"夏禹\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72608,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000010336,\n" +
                "        \"memberId\":193108,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"avp711@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/193108-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:51\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:38\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"513655\",\n" +
                "        \"name\":\"陳淑玲\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72607,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000013990,\n" +
                "        \"memberId\":594742,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"89708328@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/594742-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:49\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:35\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1196012\",\n" +
                "        \"name\":\"杨兰萍\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72606,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000019376,\n" +
                "        \"memberId\":584373,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"XF155@126.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/584373-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:46\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:32\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1179811\",\n" +
                "        \"name\":\"谢斐\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72605,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000024997,\n" +
                "        \"memberId\":30628,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1322126332@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/30628-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:44\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:29\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"136790\",\n" +
                "        \"name\":\"张建龙\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72604,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000025135,\n" +
                "        \"memberId\":616080,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"leafyip1980@yahoo.com.hk\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/616080-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:41\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:27\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1228261\",\n" +
                "        \"name\":\"鄭滙業\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72603,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000037937,\n" +
                "        \"memberId\":741,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"yogurt2552@126.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/741-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:38\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:24\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"100561\",\n" +
                "        \"name\":\"李小燕\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72602,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000038893,\n" +
                "        \"memberId\":891790,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"375522679@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/891790-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:36\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:22\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1798530\",\n" +
                "        \"name\":\"丁泽武\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72601,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000039639,\n" +
                "        \"memberId\":461562,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"18328956839@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/461562-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:34\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:20\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"972306\",\n" +
                "        \"name\":\"邓德友\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72600,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000043561,\n" +
                "        \"memberId\":1048799,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"dengfx@hit.edu.cn\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1048799-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:32\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:17\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2067875\",\n" +
                "        \"name\":\"邓凤霞\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72599,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000045957,\n" +
                "        \"memberId\":385373,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"2668801264@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/385373-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:29\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:15\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"836865\",\n" +
                "        \"name\":\"张雪萍\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72598,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000049700,\n" +
                "        \"memberId\":78043,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"2802182264@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/78043-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:27\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:12\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"218816\",\n" +
                "        \"name\":\"尹群\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72597,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000052057,\n" +
                "        \"memberId\":380466,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"565313998@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/380466-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:25\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:10\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"829102\",\n" +
                "        \"name\":\"张晓宏\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72596,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000052479,\n" +
                "        \"memberId\":437434,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"cityudon@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/437434-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:23\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:08\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"926219\",\n" +
                "        \"name\":\"吳志偉\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72595,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000056218,\n" +
                "        \"memberId\":222630,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"edwardchungisme@yahoo.com.hk\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/222630-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:16\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:05\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"569093\",\n" +
                "        \"name\":\"鍾少明\"\n" +
                "    }]";
        JSONArray jsonArray1 = JSON.parseArray(a);
        String b = " [" +
                "{\n" +
                "            \"id\":72594,\n" +
                "            \"sendStatus\":1,\n" +
                "            \"clientId\":10000057168,\n" +
                "            \"memberId\":377781,\n" +
                "            \"currencyCode\":{\n" +
                "                \"code\":\"USD\",\n" +
                "                \"description\":\"美元\"\n" +
                "            },\n" +
                "            \"statementType\":8,\n" +
                "            \"email\":\"kellywong72@yahoo.com.hk\",\n" +
                "            \"netDate\":\"2022-01-31\",\n" +
                "            \"sendDate\":null,\n" +
                "            \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/377781-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "            \"remark\":null,\n" +
                "            \"status\":1,\n" +
                "            \"createdDate\":\"2022-03-04 12:21:14\",\n" +
                "            \"createdBy\":\"System\",\n" +
                "            \"updatedDate\":\"2022-03-04 12:23:03\",\n" +
                "            \"updatedBy\":\"System\",\n" +
                "            \"hsNo\":\"825389\",\n" +
                "            \"name\":\"黃煒如\"\n" +
                "        },{\n" +
                "        \"id\":72593,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000058131,\n" +
                "        \"memberId\":710389,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"wishankle@yahoo.com.hk\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/710389-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:12\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:23:01\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1391690\",\n" +
                "        \"name\":\"吳國倫\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72592,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000065536,\n" +
                "        \"memberId\":817684,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"yaofei5588@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/817684-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:09\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:58\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1675850\",\n" +
                "        \"name\":\"宋要非\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72591,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000074581,\n" +
                "        \"memberId\":580211,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"475840562@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/580211-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:06\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:55\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1173077\",\n" +
                "        \"name\":\"石英胜\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72590,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000076289,\n" +
                "        \"memberId\":83078,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"thq847@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/83078-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:04\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:52\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"226730\",\n" +
                "        \"name\":\"童华强\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72589,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000093213,\n" +
                "        \"memberId\":502058,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"762405626@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/502058-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:21:00\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:48\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1033895\",\n" +
                "        \"name\":\"杨显贞\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72588,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000097703,\n" +
                "        \"memberId\":915905,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"srysyrina@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/915905-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:58\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:46\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1835605\",\n" +
                "        \"name\":\"宋汝渊\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72587,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000097967,\n" +
                "        \"memberId\":525107,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"2414245139@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/525107-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:56\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:43\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1079550\",\n" +
                "        \"name\":\"黄红娃\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72586,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000102494,\n" +
                "        \"memberId\":570859,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"782249213@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/570859-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:53\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:41\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1159226\",\n" +
                "        \"name\":\"戚雅婷\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72585,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000102858,\n" +
                "        \"memberId\":896111,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"4047499@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/896111-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:51\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:39\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1805371\",\n" +
                "        \"name\":\"曾晓斌\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72584,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000121165,\n" +
                "        \"memberId\":89728,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"994054586@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/89728-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:47\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:35\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"236839\",\n" +
                "        \"name\":\"王杰\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72583,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000123080,\n" +
                "        \"memberId\":108196,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"zhaoyunzzl@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/108196-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:45\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:32\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"275135\",\n" +
                "        \"name\":\"杨震宇\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72582,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000136819,\n" +
                "        \"memberId\":524578,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"qianye521@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/524578-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:42\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:28\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1078792\",\n" +
                "        \"name\":\"钱烨\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72581,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000146024,\n" +
                "        \"memberId\":399903,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"z1234153@sina.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/399903-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:39\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:25\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"868799\",\n" +
                "        \"name\":\"钟烨\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72580,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000147302,\n" +
                "        \"memberId\":637654,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"liztam7777@yahoo.com.hk\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/637654-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:37\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:23\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1270892\",\n" +
                "        \"name\":\"譚淑茵\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72579,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000153677,\n" +
                "        \"memberId\":23690,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"327597213@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/23690-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:34\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:20\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"126222\",\n" +
                "        \"name\":\"王艺\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72578,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000155103,\n" +
                "        \"memberId\":1084785,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"xukun2011@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1084785-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:31\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:18\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2122192\",\n" +
                "        \"name\":\"徐坤\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72577,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000171736,\n" +
                "        \"memberId\":419809,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"CYZ74@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/419809-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:28\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:14\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"899071\",\n" +
                "        \"name\":\"陈玉珠\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72576,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000175852,\n" +
                "        \"memberId\":241664,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"peter.candy@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/241664-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:25\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:11\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"598176\",\n" +
                "        \"name\":\"張彼得\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72575,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000180166,\n" +
                "        \"memberId\":1105695,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"solia998@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1105695-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:23\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:09\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2163891\",\n" +
                "        \"name\":\"王雪松\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72574,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000197170,\n" +
                "        \"memberId\":1107760,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"shihyiuching@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1107760-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:19\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:05\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2167736\",\n" +
                "        \"name\":\"施耀程\"\n" +
                "    }]";

        JSONArray jsonArray2 = JSONArray.parseArray(b);
        String c = "[{\n" +
                "        \"id\":72573,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000204903,\n" +
                "        \"memberId\":440084,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"zzlgl87107@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/440084-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:17\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:22:02\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"929893\",\n" +
                "        \"name\":\"葉浩晴\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72572,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000217338,\n" +
                "        \"memberId\":882944,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1912227077@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/882944-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:13\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:59\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1785311\",\n" +
                "        \"name\":\"何连芳\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72571,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000222057,\n" +
                "        \"memberId\":630367,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"jacky.ccy@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/630367-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:11\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:56\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1259896\",\n" +
                "        \"name\":\"陳頌賢\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72570,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000244791,\n" +
                "        \"memberId\":46929,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"hexin71731@hotmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/46929-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:07\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:51\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"171105\",\n" +
                "        \"name\":\"贺信\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72569,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000258636,\n" +
                "        \"memberId\":1105090,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"yingwan2828@yahoo.com.hk\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1105090-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:03\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:48\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2163039\",\n" +
                "        \"name\":\"許孆尹\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72568,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000263105,\n" +
                "        \"memberId\":111577,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"iwantip@hotmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/111577-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:20:00\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:45\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"279811\",\n" +
                "        \"name\":\"胡小东\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72567,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000271519,\n" +
                "        \"memberId\":938898,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"cyh_anthony@naver.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/938898-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:57\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:35\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1880092\",\n" +
                "        \"name\":\"譚玉華\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72566,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000273596,\n" +
                "        \"memberId\":1116365,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"378677434@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1116365-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:55\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:33\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2180566\",\n" +
                "        \"name\":\"陈海花\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72565,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000277402,\n" +
                "        \"memberId\":1125374,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"81817988@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1125374-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:52\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:30\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2193886\",\n" +
                "        \"name\":\"杨唐丽\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72564,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000278148,\n" +
                "        \"memberId\":393130,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"133774270@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/393130-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:50\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:27\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"858533\",\n" +
                "        \"name\":\"周治涛\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72563,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000279448,\n" +
                "        \"memberId\":886640,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"18629234828@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/886640-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:48\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:24\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1790378\",\n" +
                "        \"name\":\"王浪涛\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72562,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000285616,\n" +
                "        \"memberId\":1119343,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"bbboris01@yahoo.com.hk\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1119343-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:46\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:21\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2185635\",\n" +
                "        \"name\":\"黃達彬\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72561,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000290058,\n" +
                "        \"memberId\":735430,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"15947589229@139.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/735430-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:43\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:18\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1530007\",\n" +
                "        \"name\":\"阿拉腾宝\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72560,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000301044,\n" +
                "        \"memberId\":575264,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"12665959@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/575264-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:40\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:15\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1166270\",\n" +
                "        \"name\":\"夏慧佳\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72559,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000304207,\n" +
                "        \"memberId\":132867,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"sf.way@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/132867-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:37\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:12\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"311997\",\n" +
                "        \"name\":\"韦顺凡\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72558,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000305237,\n" +
                "        \"memberId\":514372,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"wayyet@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/514372-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:35\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:10\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1062792\",\n" +
                "        \"name\":\"黎伟业\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72557,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000313012,\n" +
                "        \"memberId\":534689,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"xuecheng.shi@139.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/534689-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:32\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:07\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1093677\",\n" +
                "        \"name\":\"史学成\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72556,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000327875,\n" +
                "        \"memberId\":1133872,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"zhangliwei2013@aliyun.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1133872-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:29\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:03\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2207578\",\n" +
                "        \"name\":\"张立为\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72555,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000328282,\n" +
                "        \"memberId\":1141241,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"cilinda628@hotmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1141241-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:27\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:21:01\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2218676\",\n" +
                "        \"name\":\"陈婷\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72554,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000332253,\n" +
                "        \"memberId\":884464,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"zt_grape@126.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/884464-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:24\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:59\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1787390\",\n" +
                "        \"name\":\"郑利伟\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72553,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000352640,\n" +
                "        \"memberId\":909592,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"wshmed@sina.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/909592-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:20\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:55\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1825910\",\n" +
                "        \"name\":\"王菁\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72552,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000368258,\n" +
                "        \"memberId\":1117942,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"seanlee1683@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1117942-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:16\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:51\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2182708\",\n" +
                "        \"name\":\"李寶宏\"\n" +
                "    }]";
        JSONArray jsonArray3 = JSONArray.parseArray(c);

        String d =" [ {\n" +
                "        \"id\":72551,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000376786,\n" +
                "        \"memberId\":1165567,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"kinlamyuen@yahoo.com.hk\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1165567-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:13\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:48\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2265997\",\n" +
                "        \"name\":\"阮建林\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72550,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000382103,\n" +
                "        \"memberId\":1080619,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"sabearcher@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1080619-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:11\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:45\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2116555\",\n" +
                "        \"name\":\"段理\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72549,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000383157,\n" +
                "        \"memberId\":442993,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"15366216858@126.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/442993-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:09\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:43\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"933885\",\n" +
                "        \"name\":\"杨宇翔\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72548,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000398667,\n" +
                "        \"memberId\":868494,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"653913216@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/868494-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:05\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:39\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1762576\",\n" +
                "        \"name\":\"李金泉\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72547,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000399093,\n" +
                "        \"memberId\":1154591,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"15908922283@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1154591-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:03\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:37\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2238959\",\n" +
                "        \"name\":\"张桂玲\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72546,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000408002,\n" +
                "        \"memberId\":1141025,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"ccqwer@sina.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1141025-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:19:00\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:34\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2218306\",\n" +
                "        \"name\":\"吴信成\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72545,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000412085,\n" +
                "        \"memberId\":409012,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"karen_567@live.hk\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/409012-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:57\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:31\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"882250\",\n" +
                "        \"name\":\"吳嘉恩\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72544,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000424879,\n" +
                "        \"memberId\":1177630,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"kin102200@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1177630-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:54\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:28\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2283588\",\n" +
                "        \"name\":\"彭澤堅\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72543,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000450855,\n" +
                "        \"memberId\":1179326,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"nashlai@foxmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1179326-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:50\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:23\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2286882\",\n" +
                "        \"name\":\"赖峥嵘\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72542,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000459111,\n" +
                "        \"memberId\":999031,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"liang_evan@hotmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/999031-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:47\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:20\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1981627\",\n" +
                "        \"name\":\"梁一帆\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72541,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000468547,\n" +
                "        \"memberId\":495051,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"2833659624@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/495051-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:44\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:17\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1023255\",\n" +
                "        \"name\":\"麦多多\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72540,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000493450,\n" +
                "        \"memberId\":1197337,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1036574661@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1197337-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:39\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:12\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2313615\",\n" +
                "        \"name\":\"殷铭琪\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72539,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000500629,\n" +
                "        \"memberId\":50359,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"liyandi007@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/50359-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:36\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:08\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"176836\",\n" +
                "        \"name\":\"李言迪\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72538,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000509471,\n" +
                "        \"memberId\":1007876,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"qiqiz@126.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1007876-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:33\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:20:05\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1995755\",\n" +
                "        \"name\":\"张辉\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72537,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000549892,\n" +
                "        \"memberId\":1135068,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"122238058@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1135068-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:27\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:59\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2209157\",\n" +
                "        \"name\":\"刘嘉德\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72536,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000563903,\n" +
                "        \"memberId\":1215376,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"liang_1130@126.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1215376-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:24\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:55\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2351286\",\n" +
                "        \"name\":\"梁田\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72535,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000590596,\n" +
                "        \"memberId\":1211663,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"zhaoant@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1211663-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:19\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:50\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2336200\",\n" +
                "        \"name\":\"赵文君\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72534,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000599510,\n" +
                "        \"memberId\":1196674,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"tting_d@hotmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1196674-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:16\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:47\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2312698\",\n" +
                "        \"name\":\"丁婷婷\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72533,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000615983,\n" +
                "        \"memberId\":387275,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1023194486@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/387275-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:13\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:43\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"839508\",\n" +
                "        \"name\":\"彭贵烽\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72532,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000654460,\n" +
                "        \"memberId\":1152903,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"chanelle.chen@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1152903-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:06\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:36\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2236673\",\n" +
                "        \"name\":\"陳思\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72531,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000657350,\n" +
                "        \"memberId\":580439,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"18283845@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/580439-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:03\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:34\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1173360\",\n" +
                "        \"name\":\"罗世刚\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72530,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000666342,\n" +
                "        \"memberId\":76036,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"353805552@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/76036-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:18:00\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:31\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"216036\",\n" +
                "        \"name\":\"祝英\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72529,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000706349,\n" +
                "        \"memberId\":453025,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"35766999@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/453025-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:54\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:24\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"959670\",\n" +
                "        \"name\":\"曾健\"\n" +
                "    }]";
        JSONArray jsonArray4 = JSONArray.parseArray(d);

        String f =" [ {\n" +
                "        \"id\":72528,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000717094,\n" +
                "        \"memberId\":1265043,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"40315295@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1265043-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:51\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:21\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2527501\",\n" +
                "        \"name\":\"鹿广志\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72527,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000739949,\n" +
                "        \"memberId\":622465,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"49520389@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/622465-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:47\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:16\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1238036\",\n" +
                "        \"name\":\"王文娟\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72526,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000744571,\n" +
                "        \"memberId\":696121,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"965659@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/696121-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:45\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:14\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1370076\",\n" +
                "        \"name\":\"吴坚\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72525,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000749141,\n" +
                "        \"memberId\":1245548,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1422943391@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1245548-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:42\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:11\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2397730\",\n" +
                "        \"name\":\"姜娜\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72524,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000771136,\n" +
                "        \"memberId\":1091626,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1073488856@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1091626-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:38\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:07\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2132619\",\n" +
                "        \"name\":\"扶大翠\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72523,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000774342,\n" +
                "        \"memberId\":1282706,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"8897977@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1282706-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:35\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:04\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2563707\",\n" +
                "        \"name\":\"任海波\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72522,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000777611,\n" +
                "        \"memberId\":1272212,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"cinsonkwong@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1272212-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:33\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:19:02\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2538257\",\n" +
                "        \"name\":\"鄺禮銓\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72521,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000782527,\n" +
                "        \"memberId\":1275151,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"2548678281@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1275151-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:30\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:59\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2552282\",\n" +
                "        \"name\":\"杨鑫\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72520,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000786953,\n" +
                "        \"memberId\":1286968,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"anan_china@hotmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1286968-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:27\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:57\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2570572\",\n" +
                "        \"name\":\"王楠\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72519,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000814315,\n" +
                "        \"memberId\":532081,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1336575620@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/532081-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:22\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:51\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1090059\",\n" +
                "        \"name\":\"孙硕\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72518,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000815065,\n" +
                "        \"memberId\":50896,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"wangxd99@sohu.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/50896-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:20\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:49\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"177602\",\n" +
                "        \"name\":\"王向东\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72517,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000820533,\n" +
                "        \"memberId\":977659,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"932128506@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/977659-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:18\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:47\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1939250\",\n" +
                "        \"name\":\"江嘉庆\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72516,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000822038,\n" +
                "        \"memberId\":1279453,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"249741132@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1279453-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:16\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:44\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2559192\",\n" +
                "        \"name\":\"杨洋\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72515,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000885448,\n" +
                "        \"memberId\":1112361,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"xumhua@aliyun.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1112361-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:07\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:35\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2175018\",\n" +
                "        \"name\":\"华戌明\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72514,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000887120,\n" +
                "        \"memberId\":372704,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"erik.yeung@yahoo.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/372704-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:05\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:33\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"817518\",\n" +
                "        \"name\":\"楊俊偉\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72513,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000887514,\n" +
                "        \"memberId\":1114249,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1049316809@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1114249-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:03\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:31\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2177655\",\n" +
                "        \"name\":\"林秋艳\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72512,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000891185,\n" +
                "        \"memberId\":578617,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"hongying66923@126.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/578617-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:17:00\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:29\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1170906\",\n" +
                "        \"name\":\"张红英\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72511,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000897287,\n" +
                "        \"memberId\":375418,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"tkq1990@sina.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/375418-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:58\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:26\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"821173\",\n" +
                "        \"name\":\"陶克清\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72510,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000917203,\n" +
                "        \"memberId\":796520,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"candysweet223@yahoo.com.hk\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/796520-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:54\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:21\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1632825\",\n" +
                "        \"name\":\"梁靜賢\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72509,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000921105,\n" +
                "        \"memberId\":46912,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"283751806@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/46912-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:51\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:19\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"171086\",\n" +
                "        \"name\":\"潘逾\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72508,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000926632,\n" +
                "        \"memberId\":226926,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"marinejin@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/226926-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:49\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:16\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"575997\",\n" +
                "        \"name\":\"金磊\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72507,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000928156,\n" +
                "        \"memberId\":177374,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"530266081@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/177374-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:46\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:14\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"390023\",\n" +
                "        \"name\":\"蔡丽丝\"\n" +
                "    }]";
        JSONArray jsonArray5 = JSONArray.parseArray(f);

        String g ="  [{\n" +
                "        \"id\":72506,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000928379,\n" +
                "        \"memberId\":1238714,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"namieamurogd@hotmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1238714-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:44\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:12\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2387297\",\n" +
                "        \"name\":\"熊苡涵\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72505,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000945812,\n" +
                "        \"memberId\":467047,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"chenxudongdragon@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/467047-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:40\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:08\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"980880\",\n" +
                "        \"name\":\"陈旭东\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72504,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000951336,\n" +
                "        \"memberId\":992204,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"13826576512@139.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/992204-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:36\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:05\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1971201\",\n" +
                "        \"name\":\"李青松\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72503,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000953635,\n" +
                "        \"memberId\":1272465,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"3232974453@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1272465-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:33\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:18:03\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2538668\",\n" +
                "        \"name\":\"曹婷婷\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72502,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000968354,\n" +
                "        \"memberId\":1048173,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"chyu202@126.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1048173-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:30\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:59\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2066999\",\n" +
                "        \"name\":\"陈媛\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72501,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000969681,\n" +
                "        \"memberId\":134724,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"blackboomo@hotmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/134724-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:28\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:57\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"315590\",\n" +
                "        \"name\":\"张林其\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72500,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000980746,\n" +
                "        \"memberId\":1362601,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"alexyuen1210@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1362601-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:25\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:54\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2696239\",\n" +
                "        \"name\":\"袁宏泰\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72499,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10000991405,\n" +
                "        \"memberId\":1333618,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1520414789@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1333618-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:22\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:51\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2651566\",\n" +
                "        \"name\":\"陈泽伟\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72498,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001011226,\n" +
                "        \"memberId\":1338170,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"18289554932@139.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1338170-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:17\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:47\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2658783\",\n" +
                "        \"name\":\"朱明艳\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72497,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001019911,\n" +
                "        \"memberId\":639110,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"shuikanwong@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/639110-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:15\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:44\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1272890\",\n" +
                "        \"name\":\"黃瑞芹\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72496,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001023636,\n" +
                "        \"memberId\":1316945,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"eling222000@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1316945-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:12\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:41\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2616680\",\n" +
                "        \"name\":\"易凌\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72495,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001026910,\n" +
                "        \"memberId\":427519,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"xcc770@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/427519-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:10\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:39\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"910688\",\n" +
                "        \"name\":\"徐程程\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72494,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001029730,\n" +
                "        \"memberId\":1353797,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"slcs04@yahoo.com.hk\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1353797-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:08\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:37\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2682177\",\n" +
                "        \"name\":\"羅美蓮\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72493,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001031534,\n" +
                "        \"memberId\":1302536,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"3371700980@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1302536-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:06\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:34\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2593890\",\n" +
                "        \"name\":\"易开梅\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72492,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001037838,\n" +
                "        \"memberId\":1070353,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"lccjt5825@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1070353-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:03\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:31\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2100383\",\n" +
                "        \"name\":\"陈积涛\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72491,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001042186,\n" +
                "        \"memberId\":1356498,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1499347168@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1356498-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:16:00\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:29\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2686908\",\n" +
                "        \"name\":\"纪文兰\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72490,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001056595,\n" +
                "        \"memberId\":654942,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"yaochakhei@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/654942-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:57\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:25\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1297631\",\n" +
                "        \"name\":\"姚澤曦\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72489,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001069355,\n" +
                "        \"memberId\":85253,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"menyeerlan@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/85253-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:54\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:22\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"229717\",\n" +
                "        \"name\":\"叶尔兰·木勒达拜\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72488,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001071511,\n" +
                "        \"memberId\":1326668,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"gqhonda_david@126.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1326668-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:51\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:19\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2630983\",\n" +
                "        \"name\":\"刘子欣\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72487,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001080086,\n" +
                "        \"memberId\":1377103,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"51372382@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1377103-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:49\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:17\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2718152\",\n" +
                "        \"name\":\"戴雅琦\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72486,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001122206,\n" +
                "        \"memberId\":1379548,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"wayizh@126.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1379548-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:42\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:10\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2721569\",\n" +
                "        \"name\":\"王一中\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72485,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001124983,\n" +
                "        \"memberId\":1413815,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"mashandan@sina.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1413815-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:40\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:07\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2783573\",\n" +
                "        \"name\":\"马珊丹\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72484,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001154953,\n" +
                "        \"memberId\":588338,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"www.1335619352@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/588338-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:35\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:17:02\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1186207\",\n" +
                "        \"name\":\"周化东\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72483,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001164920,\n" +
                "        \"memberId\":459738,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"gary_samsung2007@yahoo.com.hk\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/459738-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:32\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:58\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"969859\",\n" +
                "        \"name\":\"馮宇文\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72482,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001172147,\n" +
                "        \"memberId\":95305,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"cctimber@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/95305-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:29\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:56\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"255522\",\n" +
                "        \"name\":\"寇志强\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72481,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001184844,\n" +
                "        \"memberId\":1396488,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"lzx525@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1396488-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:26\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:52\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2757781\",\n" +
                "        \"name\":\"廖子萱\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72480,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001197540,\n" +
                "        \"memberId\":1431068,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1580197875@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1431068-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:22\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:49\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2810173\",\n" +
                "        \"name\":\"陈才\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72479,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001210310,\n" +
                "        \"memberId\":1434044,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"chifaing@yahoo.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1434044-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:19\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:45\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2815250\",\n" +
                "        \"name\":\"吳志輝\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72478,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001233406,\n" +
                "        \"memberId\":921444,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"kwanylin@hotmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/921444-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:15\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:41\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1853139\",\n" +
                "        \"name\":\"練鈞耀\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72477,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001252466,\n" +
                "        \"memberId\":618759,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1512122847@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/618759-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:11\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:37\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1231968\",\n" +
                "        \"name\":\"彭大基\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72476,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001273707,\n" +
                "        \"memberId\":587201,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"15832600590@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/587201-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:07\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:32\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1183703\",\n" +
                "        \"name\":\"张连富\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72475,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001293974,\n" +
                "        \"memberId\":931400,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"fonglois27@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/931400-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:15:03\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:28\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"1868831\",\n" +
                "        \"name\":\"方靜虹\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72474,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001366075,\n" +
                "        \"memberId\":1381736,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"zulu03272004@yahoo.com.hk\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1381736-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:53\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:18\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2725570\",\n" +
                "        \"name\":\"李偉中\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72473,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001366105,\n" +
                "        \"memberId\":1242949,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1035456325@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1242949-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:51\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:15\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2393122\",\n" +
                "        \"name\":\"张波兴\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72472,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001378532,\n" +
                "        \"memberId\":441248,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"13987139496@139.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/441248-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:48\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:11\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"931526\",\n" +
                "        \"name\":\"何兴武\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72471,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001380807,\n" +
                "        \"memberId\":1495124,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"chenxiaohu_kwrc@163.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1495124-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:46\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:09\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2918058\",\n" +
                "        \"name\":\"陈小虎\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72470,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001383527,\n" +
                "        \"memberId\":1177600,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"ofeming@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1177600-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:43\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:07\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2283555\",\n" +
                "        \"name\":\"区凤鸣\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72469,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001386909,\n" +
                "        \"memberId\":1487009,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"625167475@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1487009-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:41\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:04\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2905931\",\n" +
                "        \"name\":\"艾瑞波\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72468,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001393586,\n" +
                "        \"memberId\":1351670,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1750447987@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1351670-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:38\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:16:01\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2679253\",\n" +
                "        \"name\":\"黄桐杰\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72467,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001404693,\n" +
                "        \"memberId\":1390632,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"bellalo615@yahoo.com.hk\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1390632-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:35\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:15:57\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2738755\",\n" +
                "        \"name\":\"盧芷妍\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72466,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001416691,\n" +
                "        \"memberId\":1491888,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"s.chenchi@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1491888-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:32\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:15:54\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2912662\",\n" +
                "        \"name\":\"陈池澍\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72465,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001421254,\n" +
                "        \"memberId\":1405189,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"chaoran7@126.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1405189-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:29\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:15:51\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2770719\",\n" +
                "        \"name\":\"程文超\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72464,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001422197,\n" +
                "        \"memberId\":1355057,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"570083676@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1355057-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:27\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:15:48\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2683927\",\n" +
                "        \"name\":\"黄达元\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72463,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001423958,\n" +
                "        \"memberId\":1512968,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"wslinhk@hotmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1512968-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:25\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:15:46\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2955585\",\n" +
                "        \"name\":\"連偉迅\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72462,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001426902,\n" +
                "        \"memberId\":1113047,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"sun.fei@ufh.com.cn\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1113047-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:23\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:15:44\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2175970\",\n" +
                "        \"name\":\"孙芾\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72461,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001433937,\n" +
                "        \"memberId\":1495638,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"1246990156@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1495638-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:20\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:15:41\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2918789\",\n" +
                "        \"name\":\"赵于涵\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72460,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001451542,\n" +
                "        \"memberId\":1525669,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"157721128@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1525669-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:16\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:15:37\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2973967\",\n" +
                "        \"name\":\"杜瑛\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72459,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001462828,\n" +
                "        \"memberId\":1375589,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"12414755@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1375589-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:13\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:15:33\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2716080\",\n" +
                "        \"name\":\"胡华杰\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72458,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001463725,\n" +
                "        \"memberId\":1342293,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"warrenchf@outlook.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1342293-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:11\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:15:31\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2665375\",\n" +
                "        \"name\":\"陳雄輝\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72457,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001464060,\n" +
                "        \"memberId\":1527643,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"xtoi@me.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1527643-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:09\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:15:29\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2977700\",\n" +
                "        \"name\":\"廖麗瑩\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72456,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001473258,\n" +
                "        \"memberId\":1529458,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"9288ming@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1529458-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:06\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:15:26\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2980137\",\n" +
                "        \"name\":\"鄧耀明\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72455,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001500655,\n" +
                "        \"memberId\":1424684,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"chongchong999@hotmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1424684-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:14:01\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:15:21\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2800390\",\n" +
                "        \"name\":\"高裕聰\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72454,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10001885083,\n" +
                "        \"memberId\":420682,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"lidaobing@gmail.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/420682-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:13:19\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:14:34\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"900251\",\n" +
                "        \"name\":\"李道兵\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72453,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10002145038,\n" +
                "        \"memberId\":1608335,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"MINGLAM1992@HOTMAIL.COM\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1608335-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:12:51\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:14:02\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"3110319\",\n" +
                "        \"name\":\"林明生\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72452,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10002527682,\n" +
                "        \"memberId\":1435905,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"383273055@qq.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1435905-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:12:12\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:13:18\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2817838\",\n" +
                "        \"name\":\"柴依琳\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72451,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10002826933,\n" +
                "        \"memberId\":1629280,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"fjyddaj_zrr@126.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1629280-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:11:40\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:12:43\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"3152081\",\n" +
                "        \"name\":\"钟日荣\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72450,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10003324681,\n" +
                "        \"memberId\":1175216,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"oliverqueen09@outlook.com\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1175216-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:10:50\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:11:46\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"2280207\",\n" +
                "        \"name\":\"葛楠林\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\":72449,\n" +
                "        \"sendStatus\":1,\n" +
                "        \"clientId\":10003360132,\n" +
                "        \"memberId\":1663949,\n" +
                "        \"currencyCode\":{\n" +
                "            \"code\":\"USD\",\n" +
                "            \"description\":\"美元\"\n" +
                "        },\n" +
                "        \"statementType\":8,\n" +
                "        \"email\":\"DAWNFAN18@HOTMAIL.COM\",\n" +
                "        \"netDate\":\"2022-01-31\",\n" +
                "        \"sendDate\":null,\n" +
                "        \"statementPath\":\"/hs-funds/month-statement/pdf/2022/01/31/1663949-2022-01-31-monthly-usd-statement-v4.pdf\",\n" +
                "        \"remark\":null,\n" +
                "        \"status\":1,\n" +
                "        \"createdDate\":\"2022-03-04 12:10:41\",\n" +
                "        \"createdBy\":\"System\",\n" +
                "        \"updatedDate\":\"2022-03-04 12:11:39\",\n" +
                "        \"updatedBy\":\"System\",\n" +
                "        \"hsNo\":\"3205683\",\n" +
                "        \"name\":\"樊偉良\"\n" +
                "    }\n" +
                "]";
        JSONArray jsonArray6 = JSONArray.parseArray(g);

        jsonArray1.addAll(jsonArray2);
        jsonArray1.addAll(jsonArray3);
        jsonArray1.addAll(jsonArray4);
        jsonArray1.addAll(jsonArray5);
        jsonArray1.addAll(jsonArray6);

        for (int i =0;i<jsonArray1.size();i++) {
            JSONObject jsonObject = jsonArray1.getJSONObject(i);

            System.out.println(jsonObject.getString("hsNo") + " " + jsonObject.getString("clientId") + " " + jsonObject.getString("name") + " " + "美元月结单" + " " + jsonObject.getString("netDate"));
        }
    }
}
