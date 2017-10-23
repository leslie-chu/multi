package org.apache.hadoop.hbase.generated.master;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.HConnectionManager;
import org.apache.hadoop.hbase.master.HMaster;
import org.apache.hadoop.hbase.snapshot.SnapshotInfo;
import org.apache.hadoop.hbase.protobuf.generated.HBaseProtos.SnapshotDescription;
import org.apache.hadoop.util.StringUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.HBaseConfiguration;

public final class snapshot_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  HMaster master = (HMaster)getServletContext().getAttribute(HMaster.MASTER);
  Configuration conf = master.getConfiguration();
  boolean readOnly = conf.getBoolean("hbase.master.ui.readonly", false);
  String snapshotName = request.getParameter("name");
  SnapshotDescription snapshot = null;
  SnapshotInfo.SnapshotStats stats = null;
  TableName snapshotTable = null;
  boolean tableExists = false;
  try (Admin admin = master.getConnection().getAdmin()) {
    for (SnapshotDescription snapshotDesc: admin.listSnapshots()) {
      if (snapshotName.equals(snapshotDesc.getName())) {
        snapshot = snapshotDesc;
        stats = SnapshotInfo.getSnapshotStats(conf, snapshot);
        snapshotTable = TableName.valueOf(snapshot.getTable());
        tableExists = admin.tableExists(snapshotTable);
        break;
      }
    }
  }

  String action = request.getParameter("action");
  String cloneName = request.getParameter("cloneName");
  boolean isActionResultPage = (!readOnly && action != null);

      out.write("\n<!--[if IE]>\n<!DOCTYPE html>\n<![endif]-->\n<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n    <meta charset=\"utf-8\">\n    ");
 if (isActionResultPage) { 
      out.write("\n      <title>HBase Master: ");
      out.print( master.getServerName() );
      out.write("</title>\n    ");
 } else { 
      out.write("\n      <title>Snapshot: ");
      out.print( snapshotName );
      out.write("</title>\n    ");
 } 
      out.write("\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <meta name=\"description\" content=\"\">\n    <meta name=\"author\" content=\"\">\n\n    <link href=\"/static/css/bootstrap.min.css\" rel=\"stylesheet\">\n    <link href=\"/static/css/bootstrap-theme.min.css\" rel=\"stylesheet\">\n    <link href=\"/static/css/hbase.css\" rel=\"stylesheet\">\n    ");
 if (isActionResultPage) { 
      out.write("\n    <script type=\"text/javascript\">\n    <!--\n        setTimeout(\"history.back()\",5000);\n    -->\n    </script>\n    ");
 } 
      out.write("\n  </head>\n<body>\n<div class=\"navbar  navbar-fixed-top navbar-default\">\n    <div class=\"container-fluid\">\n        <div class=\"navbar-header\">\n            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n                <span class=\"icon-bar\"></span>\n                <span class=\"icon-bar\"></span>\n                <span class=\"icon-bar\"></span>\n            </button>\n            <a class=\"navbar-brand\" href=\"/master-status\"><img src=\"/static/hbase_logo_small.png\" alt=\"HBase Logo\"/></a>\n        </div>\n        <div class=\"collapse navbar-collapse\">\n            <ul class=\"nav navbar-nav\">\n                <li><a href=\"/master-status\">Home</a></li>\n                <li><a href=\"/tablesDetailed.jsp\">Table Details</a></li>\n                <li><a href=\"/procedures.jsp\">Procedures</a></li>\n                <li><a href=\"/logs/\">Local Logs</a></li>\n                <li><a href=\"/logLevel\">Log Level</a></li>\n                <li><a href=\"/dump\">Debug Dump</a></li>\n                <li><a href=\"/jmx\">Metrics Dump</a></li>\n");
      out.write("                ");
 if (HBaseConfiguration.isShowConfInServlet()) { 
      out.write("\n                <li><a href=\"/conf\">HBase Configuration</a></li>\n                ");
 } 
      out.write("\n            </ul>\n        </div><!--/.nav-collapse -->\n    </div>\n</div>\n");
 if (snapshot == null) { 
      out.write("\n  <div class=\"container-fluid content\">\n  <div class=\"row inner_header\">\n    <div class=\"page-header\">\n      <h1>Snapshot \"");
      out.print( snapshotName );
      out.write("\" does not exists</h1>\n    </div>\n  </div>\n  <p>Go <a href=\"javascript:history.back()\">Back</a>, or wait for the redirect.\n");
 } else { 
      out.write("\n  <div class=\"container-fluid content\">\n  <div class=\"row\">\n      <div class=\"page-header\">\n          <h1>Snapshot: ");
      out.print( snapshotName );
      out.write("</h1>\n      </div>\n  </div>\n  <h2>Snapshot Attributes</h2>\n  <table class=\"table table-striped\" width=\"90%\" >\n    <tr>\n        <th>Table</th>\n        <th>Creation Time</th>\n        <th>Type</th>\n        <th>Format Version</th>\n        <th>State</th>\n    </tr>\n    <tr>\n\n        <td>\n          ");
 if (tableExists) { 
      out.write("\n            <a href=\"table.jsp?name=");
      out.print( snapshotTable.getNameAsString() );
      out.write("\">\n              ");
      out.print( snapshotTable.getNameAsString() );
      out.write("</a>\n          ");
 } else { 
      out.write("\n            ");
      out.print( snapshotTable.getNameAsString() );
      out.write("\n          ");
 } 
      out.write("\n        </td>\n        <td>");
      out.print( new Date(snapshot.getCreationTime()) );
      out.write("</td>\n        <td>");
      out.print( snapshot.getType() );
      out.write("</td>\n        <td>");
      out.print( snapshot.getVersion() );
      out.write("</td>\n        ");
 if (stats.isSnapshotCorrupted()) { 
      out.write("\n          <td style=\"font-weight: bold; color: #dd0000;\">CORRUPTED</td>\n        ");
 } else { 
      out.write("\n          <td>ok</td>\n        ");
 } 
      out.write("\n    </tr>\n  </table>\n  <div class=\"row\">\n    <div class=\"span12\">\n    ");
      out.print( stats.getStoreFilesCount() );
      out.write(" HFiles (");
      out.print( stats.getArchivedStoreFilesCount() );
      out.write(" in archive),\n    total size ");
      out.print( StringUtils.humanReadableInt(stats.getStoreFilesSize()) );
      out.write("\n    (");
      out.print( stats.getSharedStoreFilePercentage() );
      out.write("&#37;\n    ");
      out.print( StringUtils.humanReadableInt(stats.getSharedStoreFilesSize()) );
      out.write(" shared with the source\n    table)\n    </div>\n    <div class=\"span12\">\n    ");
      out.print( stats.getLogsCount() );
      out.write(" Logs, total size\n    ");
      out.print( StringUtils.humanReadableInt(stats.getLogsSize()) );
      out.write("\n    </div>\n  </div>\n  ");
 if (stats.isSnapshotCorrupted()) { 
      out.write("\n    <div class=\"row\">\n      <div class=\"span12\">\n          <h3>CORRUPTED Snapshot</h3>\n      </div>\n      <div class=\"span12\">\n        ");
      out.print( stats.getMissingStoreFilesCount() );
      out.write(" hfile(s) and\n        ");
      out.print( stats.getMissingLogsCount() );
      out.write(" log(s) missing.\n      </div>\n    </div>\n  ");
 } 
      out.write('\n');

  } // end else

      out.write("\n\n\n<script src=\"/static/js/jquery.min.js\" type=\"text/javascript\"></script>\n<script src=\"/static/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n\n</body>\n</html>\n");
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
