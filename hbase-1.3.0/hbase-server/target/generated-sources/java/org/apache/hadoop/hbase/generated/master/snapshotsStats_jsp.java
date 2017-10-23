package org.apache.hadoop.hbase.generated.master;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.master.HMaster;
import org.apache.hadoop.hbase.protobuf.generated.HBaseProtos.SnapshotDescription;
import org.apache.hadoop.hbase.snapshot.SnapshotInfo;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.util.StringUtils;

public final class snapshotsStats_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  AtomicLong totalSharedSize = new AtomicLong();
  AtomicLong totalArchivedSize = new AtomicLong();
  long totalSize = 0;
  long totalUnsharedArchivedSize = 0;

  Map<Path, Integer> filesMap = null;

  List<SnapshotDescription> snapshots = master.isInitialized() ?
    master.getSnapshotManager().getCompletedSnapshots() : null;

  Admin admin = null;
  boolean tableExists = false;

  if (snapshots != null && snapshots.size() > 0) {
    filesMap = SnapshotInfo.getSnapshotsFilesMap(master.getConfiguration(),
                   totalArchivedSize, totalSharedSize);
    totalSize = totalSharedSize.get() + totalArchivedSize.get();
    admin = master.getConnection().getAdmin();
  }


      out.write("\n<!--[if IE]>\n<!DOCTYPE html>\n<![endif]-->\n<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n    <meta charset=\"utf-8\">\n    <title>HBase Master Snapshots: ");
      out.print( master.getServerName() );
      out.write("</title>\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <meta name=\"description\" content=\"\">\n    <meta name=\"author\" content=\"\">\n\n    <link href=\"/static/css/bootstrap.min.css\" rel=\"stylesheet\">\n    <link href=\"/static/css/bootstrap-theme.min.css\" rel=\"stylesheet\">\n    <link href=\"/static/css/hbase.css\" rel=\"stylesheet\">\n  </head>\n<body>\n<div class=\"navbar  navbar-fixed-top navbar-default\">\n    <div class=\"container-fluid\">\n        <div class=\"navbar-header\">\n            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n                <span class=\"icon-bar\"></span>\n                <span class=\"icon-bar\"></span>\n                <span class=\"icon-bar\"></span>\n            </button>\n            <a class=\"navbar-brand\" href=\"/master-status\"><img src=\"/static/hbase_logo_small.png\" alt=\"HBase Logo\"/></a>\n        </div>\n        <div class=\"collapse navbar-collapse\">\n            <ul class=\"nav navbar-nav\">\n                <li><a href=\"/master-status\">Home</a></li>\n");
      out.write("                <li><a href=\"/tablesDetailed.jsp\">Table Details</a></li>\n                <li><a href=\"/procedures.jsp\">Procedures</a></li>\n                <li><a href=\"/logs/\">Local Logs</a></li>\n                <li><a href=\"/logLevel\">Log Level</a></li>\n                <li><a href=\"/dump\">Debug Dump</a></li>\n                <li><a href=\"/jmx\">Metrics Dump</a></li>\n                ");
 if (HBaseConfiguration.isShowConfInServlet()) { 
      out.write("\n                <li><a href=\"/conf\">HBase Configuration</a></li>\n                ");
 } 
      out.write("\n            </ul>\n        </div><!--/.nav-collapse -->\n    </div>\n</div>\n<div class=\"container-fluid content\">\n  <div class=\"row\">\n      <div class=\"page-header\">\n          <h1>Snapshot Storefile Stats</h1>\n      </div>\n  </div>\n  <table class=\"table table-striped\" width=\"90%\" >\n    <tr>\n        <th>Snapshot Name</th>\n        <th>Table</th>\n        <th>Creation Time</th>\n        <th>Shared Storefile Size</th>\n        <th>Archived Storefile Size</th>\n    </tr>\n    ");
for (SnapshotDescription snapshotDesc : snapshots) { 
      out.write("\n    <tr>\n      <td><a href=\"/snapshot.jsp?name=");
      out.print( snapshotDesc.getName() );
      out.write("\">\n        ");
      out.print( snapshotDesc.getName() );
      out.write("</a></td>\n      ");

        TableName snapshotTable = TableName.valueOf(snapshotDesc.getTable());
        SnapshotInfo.SnapshotStats stats = SnapshotInfo.getSnapshotStats(master.getConfiguration(),
          snapshotDesc, filesMap);
        totalUnsharedArchivedSize += stats.getNonSharedArchivedStoreFilesSize();
        tableExists = admin.tableExists(snapshotTable);
      
      out.write("\n      <td>\n      ");
 if (tableExists) { 
      out.write("\n        <a href=\"/table.jsp?name=");
      out.print( snapshotTable.getNameAsString() );
      out.write("\">\n          ");
      out.print( snapshotTable.getNameAsString() );
      out.write("</a>\n      ");
 } else { 
      out.write("\n        ");
      out.print( snapshotTable.getNameAsString() );
      out.write("\n      ");
 } 
      out.write("\n      </td>\n      <td>");
      out.print( new Date(snapshotDesc.getCreationTime()) );
      out.write("</td>\n      <td>");
      out.print( StringUtils.humanReadableInt(stats.getSharedStoreFilesSize()) );
      out.write("</td>\n      <td>");
      out.print( StringUtils.humanReadableInt(stats.getArchivedStoreFileSize()) );
      out.write("\n        (");
      out.print( StringUtils.humanReadableInt(stats.getNonSharedArchivedStoreFilesSize()) );
      out.write(")</td>\n    </tr>\n    ");
 } 
      out.write("\n    <p>");
      out.print( snapshots.size() );
      out.write(" snapshot(s) in set.</p>\n    <p>Total Storefile Size: ");
      out.print( StringUtils.humanReadableInt(totalSize) );
      out.write("</p>\n    <p>Total Shared Storefile Size: ");
      out.print( StringUtils.humanReadableInt(totalSharedSize.get()) );
      out.write(",\n       Total Archived Storefile Size: ");
      out.print( StringUtils.humanReadableInt(totalArchivedSize.get()) );
      out.write("\n       (");
      out.print( StringUtils.humanReadableInt(totalUnsharedArchivedSize) );
      out.write(")</p>\n    <p>Shared Storefile Size is the Storefile size shared between snapshots and active tables.\n       Archived Storefile Size is the Storefile size in Archive.\n       The format of Archived Storefile Size is NNN(MMM). NNN is the total Storefile\n       size in Archive, MMM is the total Storefile size in Archive that is specific\n       to the snapshot (not shared with other snapshots and tables)</p>\n  </table>\n</div>\n\n<script src=\"/static/js/jquery.min.js\" type=\"text/javascript\"></script>\n<script src=\"/static/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n\n</body>\n</html>\n");
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
