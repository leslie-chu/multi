package org.apache.hadoop.hbase.generated.regionserver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import static org.apache.commons.lang.StringEscapeUtils.escapeXml;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HRegionInfo;
import org.apache.hadoop.hbase.regionserver.HRegionServer;
import org.apache.hadoop.hbase.regionserver.Region;
import org.apache.hadoop.hbase.regionserver.Store;
import org.apache.hadoop.hbase.regionserver.StoreFile;

public final class region_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');

  String regionName = request.getParameter("name");
  HRegionServer rs = (HRegionServer) getServletContext().getAttribute(HRegionServer.REGIONSERVER);
  Configuration conf = rs.getConfiguration();

  Region region = rs.getFromOnlineRegions(regionName);
  String displayName = region.getRegionInfo().getRegionNameAsString();

      out.write("\n<!--[if IE]>\n<!DOCTYPE html>\n<![endif]-->\n<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<html lang=\"en\">\n  <head>\n    <meta charset=\"utf-8\">\n    <title>HBase RegionServer: ");
      out.print( rs.getServerName() );
      out.write("</title>\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <meta name=\"description\" content=\"\">\n    <meta name=\"author\" content=\"\">\n\n\n      <link href=\"/static/css/bootstrap.min.css\" rel=\"stylesheet\">\n      <link href=\"/static/css/bootstrap-theme.min.css\" rel=\"stylesheet\">\n      <link href=\"/static/css/hbase.css\" rel=\"stylesheet\">\n  </head>\n\n  <body>\n\n  <div class=\"navbar  navbar-fixed-top navbar-default\">\n      <div class=\"container-fluid\">\n          <div class=\"navbar-header\">\n              <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n                  <span class=\"icon-bar\"></span>\n                  <span class=\"icon-bar\"></span>\n                  <span class=\"icon-bar\"></span>\n              </button>\n              <a class=\"navbar-brand\" href=\"/rs-status\"><img src=\"/static/hbase_logo_small.png\" alt=\"HBase Logo\"/></a>\n          </div>\n          <div class=\"collapse navbar-collapse\">\n              <ul class=\"nav navbar-nav\">\n                  <li class=\"active\"><a href=\"/rs-status\">Home</a></li>\n");
      out.write("                  <li><a href=\"/logs/\">Local Logs</a></li>\n                  <li><a href=\"/logLevel\">Log Level</a></li>\n                  <li><a href=\"/dump\">Debug Dump</a></li>\n                  <li><a href=\"/jmx\">Metrics Dump</a></li>\n                  ");
 if (HBaseConfiguration.isShowConfInServlet()) { 
      out.write("\n                  <li><a href=\"/conf\">HBase Configuration</a></li>\n                  ");
 } 
      out.write("\n              </ul>\n          </div><!--/.nav-collapse -->\n      </div>\n  </div>\n\n  <div class=\"container-fluid content\">\n    <div class=\"row inner_header\">\n        <div class=\"page-header\">\n            <h1>Region: ");
      out.print( displayName );
      out.write("</h1>\n        </div>\n    </div>\n\n");
 if(region != null) { //
     List<Store> stores = region.getStores();
     for (Store store : stores) {
       String cf = store.getColumnFamilyName();
       Collection<StoreFile> storeFiles = store.getStorefiles(); 
      out.write("\n\n       <h3>Column Family: ");
      out.print( cf );
      out.write("</h2>\n\n       <h4>Memstore size (MB): ");
      out.print( (int) (store.getMemStoreSize() / 1024 / 1024) );
      out.write("</h3>\n\n       <h4>Store Files</h3>\n\n       <table class=\"table table-striped\">\n         <tr>\n           <th>Store File</th>\n           <th>Size (MB)</th>\n           <th>Modification time</th>\n         </tr>\n       ");
   for(StoreFile sf : storeFiles) { 
      out.write("\n         <tr>\n           <td><a href=\"storeFile.jsp?name=");
      out.print( sf.getPath() );
      out.write('"');
      out.write('>');
      out.print( sf.getPath() );
      out.write("</a></td>\n           <td>");
      out.print( (int) (rs.getFileSystem().getLength(sf.getPath()) / 1024 / 1024) );
      out.write("</td>\n           <td>");
      out.print( new Date(sf.getModificationTimeStamp()) );
      out.write("</td>\n         </tr>\n         ");
 } 
      out.write("\n\n         <p> ");
      out.print( storeFiles.size() );
      out.write(" StoreFile(s) in set.</p>\n         </table>\n   ");
  }
   }
      out.write("\n</div>\n<script src=\"/static/js/jquery.min.js\" type=\"text/javascript\"></script>\n<script src=\"/static/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n\n</body>\n</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
