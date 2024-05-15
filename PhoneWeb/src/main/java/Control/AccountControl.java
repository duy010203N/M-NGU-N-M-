package Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AccountControl")
public class AccountControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AccountControl() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_app2", "root", "1234567890");

            String searchUID = req.getParameter("searchuID");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
            out.println("<title>Product Management</title>");
            out.println("<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto|Varela+Round'>");
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css'>");
            out.println("<link rel='stylesheet' href='https://fonts.googleapis.com/icon?family=Material+Icons'>");
            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>");
            out.println("<script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js'></script>");
            out.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js'></script>");
            out.println("<style>");
            // CSS styles from pasted 1
            out.println("</style>");
            out.println("<script>");
            // JavaScript from pasted 1
            out.println("</script>");
            out.println("</head>");

            out.println("<body>");
            out.println("<div class='container-xl'>");
            out.println("<div class='table-responsive'>");
            out.println("<div class='table-wrapper'>");
            out.println("<div class='table-title'>");
            out.println("<div class='table-title' style='background-color: #435d7d; color: #fff; padding: 16px 30px; border-radius: 3px 3px 0 0;'>");
            out.println("<div class='row'>");
            out.println("<div class='col-sm-6'>");
            out.println("<h2>Manage <b>Account</b></h2>");
            out.println("</div>");
            out.println("<div class='d-flex justify-content-end col-sm-6'>"); // Sử dụng Flexbox để đẩy nút ra xa
            out.println("<a href='#addEmployeeModal' class='btn btn-success mr-2' data-toggle='modal' data-target='#addEmployeeModal'><i class='material-icons'>&#xE147;</i> Add New Product</a>");
            out.println("<a href='#deleteEmployeeModal' class='btn btn-danger'><i class='material-icons'>&#xE872;</i> Delete</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            
            
            out.println("<table class='table table-striped table-hover'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th><span class='custom-checkbox'><input type='checkbox' id='selectAll'><label for='selectAll'></label></span></th>");
            out.println("<th>uID</th>");           
            out.println("<th>user</th>");
            out.println("<th>pass</th>");
            out.println("<th>isSell</th>");
            out.println("<th>isAdmin</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            Statement stmt = con.createStatement();
            String sql1 = "SELECT * FROM account";
            String sql2 = "SELECT * FROM product WHERE uID LIKE '%" + searchUID + "%'";
            ResultSet rs;
            if (searchUID != null && !searchUID.isEmpty()) {
                rs = stmt.executeQuery(sql2);
            } else {
                rs = stmt.executeQuery(sql1);
            }

            while (rs.next()) {
                String UID = rs.getString("uID");
                String U = rs.getString("user");
                String P = rs.getString("pass");
                String IS = rs.getString("isSell");
                String IA = rs.getString("isAdmin");


                out.println("<tr>");
                out.println("<td><span class='custom-checkbox'><input type='checkbox' id='checkbox" + UID + "' name='options[]' value='" + UID + "'><label for='checkbox" + UID + "'></label></span></td>");
                out.println("<td>" + UID + "</td>");
                out.println("<td>" + U + "</td>");
                out.println("<td>" + P + "</td>"); 
                out.println("<td>" + IS + "</td>"); 
                out.println("<td>" + IA + "</td>"); 

                out.println("<td>");
                out.println("<a href='#editEmployeeModal' class='edit' data-toggle='modal'><i class='material-icons' data-toggle='tooltip' title='Edit'>&#xE254;</i></a>");
                out.println("<a href='AccountControlAcction?action=delete&uID=" + UID + "' class='delete' data-toggle='modal'><i class='material-icons' data-toggle='tooltip' title='Delete'>&#xE872;</i></a>");
                out.println("</td>");
                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");

            // Phần hiển thị phân trang...

            out.println("</div>");
            out.println("</div>");
            out.println("</div>");

            // Thêm các modal như trong pasted 1
            out.println("<div id='addEmployeeModal' class='modal fade'>");
            out.println("    <div class='modal-dialog'>");
            out.println("        <div class='modal-content'>");
            out.println("            <form action='AccountControlAcction?action=add' method='post' enctype=\"multipart/form-data\">");
            out.println("                <div class='modal-header'>");
            out.println("                    <h4 class='modal-title'>Add Account</h4>");
            out.println("                    <button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button>");
            out.println("                </div>");
            out.println("                <div class='modal-body'>");
            out.println("                    <div class='form-group'>");
            out.println("                        <div class='form-group'>");
            out.println("                            <label>UID</label>");
            out.println("                            <input type='text' name='uID' class='form-control' required>");
            out.println("                        </div>");
            out.println("                        <label>User</label>");
            out.println("                        <input type='text' name='user' class='form-control' required>");
            out.println("                    </div>");
            out.println("                    <div class='form-group'>");
            out.println("                        <label>PassWord</label>");
            out.println("                        <input type='text' name='pass' class='form-control' required>");
            out.println("                    </div>");
            out.println("                    <div class='form-group'>");
            out.println("                        <label>IS SELL</label>");
            out.println("                        <input type='text' name='isSell' class='form-control' required>");
            out.println("                    </div>");
            out.println("                    <div class='form-group'>");
            out.println("                        <label>IS ADMIN</label>");
            out.println("                        <input type='text' name='isAdmin' class='form-control' required>");
            out.println("                    </div>");
            out.println("                </div>");
            out.println("                <div class='modal-footer'>");
            out.println("                    <input type='button' class='btn btn-default' data-dismiss='modal' value='Cancel'>");
            out.println("                    <input type='submit' class='btn btn-success' value='Add'>");
            out.println("                </div>");
            out.println("            </form>");
            out.println("        </div>");
            out.println("    </div>");
            out.println("</div>");

            
            
            
            out.println("<!-- Edit Modal HTML -->");
            out.println("<div id='editAccountModal' class='modal fade'>");
            out.println("<div class='modal-dialog'>");
            out.println("<div class='modal-content'>");
            out.println("<form action='AccountControlAcction' method='post'>");
            out.println("<input type='hidden' name='action' value='edit'>");
            out.println("<input type='hidden' name='uID' id='editUID'>");
            out.println("<div class='modal-header'>");
            out.println("<h4 class='modal-title'>Edit Account</h4>");
            out.println("<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button>");
            out.println("</div>");
            out.println("<div class='modal-body'>");
            out.println("<div class='form-group'>");
            out.println("<label>User</label>");
            out.println("<input type='text' name='user' id='editUser' class='form-control' required>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label>Password</label>");
            out.println("<input type='text' name='pass' id='editPass' class='form-control' required>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label>Is Sell</label>");
            out.println("<input type='text' name='isSell' id='editIsSell' class='form-control' required>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label>Is Admin</label>");
            out.println("<input type='text' name='isAdmin' id='editIsAdmin' class='form-control' required>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='modal-footer'>");
            out.println("<input type='button' class='btn btn-default' data-dismiss='modal' value='Cancel'>");
            out.println("<input type='submit' class='btn btn-info' value='Save'>");
            out.println("</div>");
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");

            out.println("<script>");
            out.println("$(document).ready(function() {");
            out.println("    $('.edit').on('click', function() {");
            out.println("        var uID = $(this).closest('tr').find('td:nth-child(2)').text();");
            out.println("        var user = $(this).closest('tr').find('td:nth-child(3)').text();");
            out.println("        var pass = $(this).closest('tr').find('td:nth-child(4)').text();");
            out.println("        var isSell = $(this).closest('tr').find('td:nth-child(5)').text();");
            out.println("        var isAdmin = $(this).closest('tr').find('td:nth-child(6)').text();");
            out.println("        $('#editUID').val(uID);");
            out.println("        $('#editUser').val(user);");
            out.println("        $('#editPass').val(pass);");
            out.println("        $('#editIsSell').val(isSell);");
            out.println("        $('#editIsAdmin').val(isAdmin);");
            out.println("        $('#editAccountModal').modal('show');");
            out.println("    });");
            out.println("});");
            out.println("</script>");


            out.println("<!-- Delete Modal HTML -->");
            out.println("<div id='deleteEmployeeModal' class='modal fade'>");
            out.println("<div class='modal-dialog'>");
            out.println("<div class='modal-content'>");
            out.println("<form action='AccountControlAcction' method='post'>");
            out.println("<input type='hidden' name='action' value='delete'>");
            out.println("<input type='hidden' name='uID' id='deleteUID'>"); // Sửa tên id thành deleteUID
            out.println("<div class='modal-header'>");
            out.println("<h4 class='modal-title'>Delete Account</h4>");
            out.println("<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button>");
            out.println("</div>");
            out.println("<div class='modal-body'>");
            out.println("<p>Are you sure you want to delete this account?</p>");
            out.println("<p class='text-warning'><small>This action cannot be undone.</small></p>");
            out.println("</div>");
            out.println("<div class='modal-footer'>");
            out.println("<input type='button' class='btn btn-default' data-dismiss='modal' value='Cancel'>");
            out.println("<input type='submit' class='btn btn-danger' value='Delete'>");
            out.println("</div>");
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");

            out.println("<script>");
            out.println("$(document).ready(function() {");
            out.println("    $('.delete').on('click', function() {");
            out.println("        var accountUID = $(this).closest('tr').find('td:nth-child(2)').text();");
            out.println("        $('#deleteUID').val(accountUID);"); // Sử dụng id deleteUID
            out.println("        $('#deleteEmployeeModal').modal('show');");
            out.println("    });");
            out.println("});");
            out.println("</script>");


            out.println("</body>");
            out.println("</html>");

                        stmt.close();
                        con.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                        out.println("Error: " + e.getMessage());
                    }
                }

                protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                    doGet(request, response);
                }
            }