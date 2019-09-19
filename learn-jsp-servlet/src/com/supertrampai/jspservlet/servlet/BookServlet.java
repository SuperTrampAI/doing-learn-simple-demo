package com.supertrampai.jspservlet.servlet;

import com.supertrampai.jspservlet.domain.Book;
import com.supertrampai.jspservlet.service.IBookService;
import com.supertrampai.jspservlet.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 10:41 2019/9/19
 * @Modified By:
 */
@WebServlet("/bookservlet")
public class BookServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    IBookService bookService=new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //解决乱码
        request.setCharacterEncoding("UTF-8");
        String reqtype=request.getParameter("reqtype");
        //新增
        if("insert".equals(reqtype)){
            Insert(request, response);
        }
        else if("update".equals(reqtype)){
            update(request, response);
        }
        else if("queryById".equals(reqtype)){
            queryById(request, response);
        }
        else if("delete".equals(reqtype)){
            delete(request, response);
        }
        else if("queryAll".equals(reqtype)){
            queryAll(request, response);
        }
    }
    //新增
    public void Insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //这里jsp中name专递过来的参数
        // bname,uid,publish,publishdate,page,price,content
        String bname=request.getParameter("bname");
        String uid=request.getParameter("uid");
        String publish=request.getParameter("publish");
        String publishdate=request.getParameter("publishdate");
        String page=request.getParameter("page");
        String price=request.getParameter("price");
        String content=request.getParameter("content");
        //把获取到的这些值放到boot里
        Book book =new Book();

        try {
            //下面两句是把 string 转换为  sql类型的 时间格式
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            book.setPublishdate(new Date(sdf.parse(publishdate).getTime()));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        book.setBname(bname);
        book.setUid(uid);
        book.setPublish(publish);
        book.setPage(Integer.parseInt(page));
        book.setPrice(Integer.parseInt(price));
        book.setContent(content);

        //最后调用服务来添加
        String message=null;
        if (bookService.insertData(book)==true) {
            queryAll(request, response);
        }
        else {
            message="新增失败!!!";
            request.setAttribute("msg", message);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }


    }
    //修改
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bname=request.getParameter("bname");
        String uid=request.getParameter("uid");
        String publish=request.getParameter("publish");
        String publishdate=request.getParameter("publishdate");
        String page=request.getParameter("page");
        String price=request.getParameter("price");
        String content=request.getParameter("content");
        String bid=request.getParameter("bid");
        //把获取到的这些值放到boot里
        Book book =new Book();
        try {
            //下面两句是把 string 转换为  sql类型的 时间格式
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            book.setPublishdate(new Date(sdf.parse(publishdate).getTime()));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        book.setBid(Integer.parseInt(bid));
        book.setBname(bname);
        book.setUid(uid);
        book.setPublish(publish);
        book.setPage(Integer.parseInt(page));
        book.setPrice(Integer.parseInt(price));
        book.setContent(content);
        boolean b=  bookService.update(book);
        if (b==true) {
            queryAll(request, response);
        }
        else {
            request.setAttribute("msg", "修改失败!!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }
    //查询一条数据
    public void queryById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Book book=null;
        String  bid=  request.getParameter("bid");
        System.out.println(bid);
        book=   bookService.queryDataById(Integer.parseInt(bid) );
        request.setAttribute("book", book);
        request.getRequestDispatcher("/jsp/Book.jsp").forward(request, response);
    }
    //删除
    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String  bid= request.getParameter("bid");
        System.out.println(bid);
        boolean  message=bookService.delete(Integer.parseInt(bid));
        if (message==true) {
            queryAll(request, response);
        }
        else {

            request.setAttribute("msg", "删除失败!!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
    //查询所有的数据
    public void queryAll(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        List<Book> bookList=bookService.queryAllData();
        request.setAttribute("books", bookList);
        request.getRequestDispatcher("/jsp/Book.jsp").forward(request, response);
    }

}
