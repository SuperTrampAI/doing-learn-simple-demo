package com.supertrampai.springbootsimpleexcel.action;

import com.supertrampai.springbootsimpleexcel.domain.Book;
import com.supertrampai.springbootsimpleexcel.repository.BookRepository;
import com.supertrampai.springbootsimpleexcel.util.ExclUtile.ReportExcel;
import com.supertrampai.springbootsimpleexcel.util.Guid;
import com.supertrampai.springbootsimpleexcel.util.RestResponse;
import com.supertrampai.springbootsimpleexcel.util.ServiceResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/22 15:50
 */

@RestController
@RequestMapping("book")
@Api(description = "book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @ApiOperation(value = "导出excel")
    @RequestMapping(value = "/querybookList", method = RequestMethod.POST)
    public ServiceResponse querybookList(
            Integer uid,
            HttpServletResponse resp,
            HttpServletRequest req
    ) {
        ServiceResponse serviceResponse = new ServiceResponse();
        RestResponse response = serviceResponse.getRsp();
        serviceResponse.setStatus("0000");
        serviceResponse.setMsg("数据处理正确");
        serviceResponse.setTxid(Guid.NewGuid());
        try {
            List<Book> list  = bookRepository.findAll();
            ReportExcel reportExcel = new ReportExcel();
            reportExcel.excelExport(list, "excel name", Book.class, 1, resp, req);

        } catch (Exception ex) {
            serviceResponse.setStatus("0003");
            serviceResponse.setMsg("系统错误");
            response.setCode("0002");
            response.setDescription("业务请求异常：" + ex.getMessage());
        }
        return serviceResponse;
    }

}
