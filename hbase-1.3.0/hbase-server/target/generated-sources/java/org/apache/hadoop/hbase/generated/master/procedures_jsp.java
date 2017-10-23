package org.apache.hadoop.hbase.generated.master;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import static org.apache.commons.lang.StringEscapeUtils.escapeXml;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.ProcedureInfo;
import org.apache.hadoop.hbase.master.HMaster;
import org.apache.hadoop.hbase.master.procedure.MasterProcedureEnv;
import org.apache.hadoop.hbase.procedure2.ProcedureExecutor;
import org.apache.hadoop.hbase.procedure2.store.wal.ProcedureWALFile;
import org.apache.hadoop.hbase.procedure2.store.wal.WALProcedureStore;
import org.apache.hadoop.hbase.procedure2.util.StringUtils;

public final class procedures_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  ProcedureExecutor<MasterProcedureEnv> procExecutor = master.getMasterProcedureExecutor();
  WALProcedureStore walStore = master.getWalProcedureStore();

  ArrayList<WALProcedureStore.SyncMetrics> syncMetricsBuff = walStore.getSyncMetrics();
  long millisToNextRoll = walStore.getMillisToNextPeriodicRoll();
  long millisFromLastRoll = walStore.getMillisFromLastRoll();
  ArrayList<ProcedureWALFile> procedureWALFiles = walStore.getActiveLogs();
  Set<ProcedureWALFile> corruptedWALFiles = walStore.getCorruptedLogs();
  List<ProcedureInfo> procedures = procExecutor.listProcedures();
  Collections.sort(procedures, new Comparator<ProcedureInfo>() {
    @Override
    public int compare(ProcedureInfo lhs, ProcedureInfo rhs) {
      long cmp = lhs.getParentId() - rhs.getParentId();
      cmp = cmp != 0 ? cmp : lhs.getProcId() - rhs.getProcId();
      return cmp < 0 ? -1 : cmp > 0 ? 1 : 0;
    }
  });

      out.write("\n<!--[if IE]>\n<!DOCTYPE html>\n<![endif]-->\n<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n    <meta charset=\"utf-8\">\n    <title>HBase Master Procedures: ");
      out.print( master.getServerName() );
      out.write("</title>\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <meta name=\"description\" content=\"\">\n    <meta name=\"author\" content=\"\">\n\n    <link href=\"/static/css/bootstrap.min.css\" rel=\"stylesheet\">\n    <link href=\"/static/css/bootstrap-theme.min.css\" rel=\"stylesheet\">\n    <link href=\"/static/css/hbase.css\" rel=\"stylesheet\">\n  </head>\n<body>\n<div class=\"navbar  navbar-fixed-top navbar-default\">\n    <div class=\"container-fluid\">\n        <div class=\"navbar-header\">\n            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n                <span class=\"icon-bar\"></span>\n                <span class=\"icon-bar\"></span>\n                <span class=\"icon-bar\"></span>\n            </button>\n            <a class=\"navbar-brand\" href=\"/master-status\"><img src=\"/static/hbase_logo_small.png\" alt=\"HBase Logo\"/></a>\n        </div>\n        <div class=\"collapse navbar-collapse\">\n            <ul class=\"nav navbar-nav\">\n                <li><a href=\"/master-status\">Home</a></li>\n");
      out.write("                <li><a href=\"/tablesDetailed.jsp\">Table Details</a></li>\n                <li><a href=\"/procedures.jsp\">Procedures</a></li>\n                <li><a href=\"/logs/\">Local Logs</a></li>\n                <li><a href=\"/logLevel\">Log Level</a></li>\n                <li><a href=\"/dump\">Debug Dump</a></li>\n                <li><a href=\"/jmx\">Metrics Dump</a></li>\n                ");
 if (HBaseConfiguration.isShowConfInServlet()) { 
      out.write("\n                <li><a href=\"/conf\">HBase Configuration</a></li>\n                ");
 } 
      out.write("\n            </ul>\n        </div><!--/.nav-collapse -->\n    </div>\n</div>\n<div class=\"container-fluid content\">\n  <div class=\"row\">\n      <div class=\"page-header\">\n          <h1>Procedures</h1>\n      </div>\n  </div>\n  <table class=\"table table-striped\" width=\"90%\" >\n    <tr>\n        <th>Id</th>\n        <th>Parent</th>\n        <th>State</th>\n        <th>Owner</th>\n        <th>Type</th>\n        <th>Start Time</th>\n        <th>Last Update</th>\n        <th>Errors</th>\n    </tr>\n    <tr>\n      ");
 for (ProcedureInfo procInfo : procedures) { 
      out.write("\n      <tr>\n        <td>");
      out.print( procInfo.getProcId() );
      out.write("</a></td>\n        <td>");
      out.print( procInfo.hasParentId() ? procInfo.getParentId() : "" );
      out.write("</a></td>\n        <td>");
      out.print( escapeXml(procInfo.getProcState().toString()) );
      out.write("</a></td>\n        <td>");
      out.print( escapeXml(procInfo.getProcOwner()) );
      out.write("</a></td>\n        <td>");
      out.print( escapeXml(procInfo.getProcName()) );
      out.write("</a></td>\n        <td>");
      out.print( new Date(procInfo.getStartTime()) );
      out.write("</a></td>\n        <td>");
      out.print( new Date(procInfo.getLastUpdate()) );
      out.write("</a></td>\n        <td>");
      out.print( escapeXml(procInfo.isFailed() ? procInfo.getExceptionMessage() : "") );
      out.write("</a></td>\n      </tr>\n    ");
 } 
      out.write("\n  </table>\n</div>\n<br>\n<div class=\"container-fluid content\">\n  <div class=\"row\">\n    <div class=\"page-header\">\n      <h2>Procedure WAL State</h2>\n    </div>\n  </div>\n<div class=\"tabbable\">\n  <ul class=\"nav nav-pills\">\n    <li class=\"active\">\n      <a href=\"#tab_WALFiles\" data-toggle=\"tab\">WAL files</a>\n    </li>\n    <li class=\"\">\n      <a href=\"#tab_WALFilesCorrupted\" data-toggle=\"tab\">Corrupted WAL files</a>\n     </li>\n    <li class=\"\">\n      <a href=\"#tab_WALRollTime\" data-toggle=\"tab\">WAL roll time</a>\n     </li>\n     <li class=\"\">\n       <a href=\"#tab_SyncStats\" data-toggle=\"tab\">Sync stats</a>\n     </li>\n  </ul>\n    <div class=\"tab-content\" style=\"padding-bottom: 9px; border-bottom: 1px solid #ddd;\">\n      <div class=\"tab-pane active\" id=\"tab_WALFiles\">\n        ");
 if (procedureWALFiles != null && procedureWALFiles.size() > 0) { 
      out.write("\n          <table class=\"table table-striped\">\n            <tr>\n              <th>LogID</th>\n              <th>Size</th>\n              <th>Timestamp</th>\n              <th>Path</th>\n            </tr>\n            ");
 for (int i = procedureWALFiles.size() - 1; i >= 0; --i) { 
      out.write("\n            ");
    ProcedureWALFile pwf = procedureWALFiles.get(i); 
      out.write("\n            <tr>\n              <td> ");
      out.print( pwf.getLogId() );
      out.write("</td>\n              <td> ");
      out.print( StringUtils.humanSize(pwf.getSize()) );
      out.write(" </td>\n              <td> ");
      out.print( new Date(pwf.getTimestamp()) );
      out.write("</a></td>\n              <td> ");
      out.print( escapeXml(pwf.toString()) );
      out.write("</t>\n            </tr>\n            ");
 } 
      out.write("\n          </table>\n        ");
 } else {
      out.write("\n          <p> No WAL files</p>\n        ");
 } 
      out.write("\n      </div>\n      <div class=\"tab-pane\" id=\"tab_WALFilesCorrupted\">\n      ");
 if (corruptedWALFiles != null && corruptedWALFiles.size() > 0) { 
      out.write("\n        <table class=\"table table-striped\">\n          <tr>\n            <th>LogID</th>\n            <th>Size</th>\n            <th>Timestamp</th>\n            <th>Path</th>\n          </tr>\n          ");
 for (ProcedureWALFile cwf:corruptedWALFiles) { 
      out.write("\n          <tr>\n            <td> ");
      out.print( cwf.getLogId() );
      out.write("</td>\n            <td> ");
      out.print( StringUtils.humanSize(cwf.getSize()) );
      out.write(" </td>\n            <td> ");
      out.print( new Date(cwf.getTimestamp()) );
      out.write("</a></td>\n            <td> ");
      out.print( escapeXml(cwf.toString()) );
      out.write("</t>\n          </tr>\n          ");
 } 
      out.write("\n          </table>\n      ");
 } else {
      out.write("\n        <p> No corrupted WAL files</p>\n      ");
 } 
      out.write("\n      </div>\n      <div class=\"tab-pane\" id=\"tab_WALRollTime\">\n        <table class=\"table table-striped\">\n          <tr>\n            <th> Milliseconds to next roll</th>\n            <th> Milliseconds from last roll</th>\n          </tr>\n          <tr>\n            <td> ");
      out.print(StringUtils.humanTimeDiff(millisToNextRoll)  );
      out.write("</td>\n            <td> ");
      out.print(StringUtils.humanTimeDiff(millisFromLastRoll) );
      out.write("</td>\n          </tr>\n        </table>\n      </div>\n      <div class=\"tab-pane\" id=\"tab_SyncStats\">\n        <table class=\"table table-striped\">\n          <tr>\n            <th> Time</th>\n            <th> Sync Wait</th>\n            <th> Last num of synced entries</th>\n            <th> Total Synced</th>\n            <th> Synced per second</th>\n          </tr>\n          ");
 for (int i = syncMetricsBuff.size() - 1; i >= 0; --i) { 
      out.write("\n          ");
    WALProcedureStore.SyncMetrics syncMetrics = syncMetricsBuff.get(i); 
      out.write("\n          <tr>\n            <td> ");
      out.print( new Date(syncMetrics.getTimestamp()) );
      out.write("</a></td>\n            <td> ");
      out.print( StringUtils.humanTimeDiff(syncMetrics.getSyncWaitMs()) );
      out.write("</td>\n            <td> ");
      out.print( syncMetrics.getSyncedEntries() );
      out.write("</td>\n            <td> ");
      out.print( StringUtils.humanSize(syncMetrics.getTotalSyncedBytes()) );
      out.write("</td>\n            <td> ");
      out.print( StringUtils.humanSize(syncMetrics.getSyncedPerSec()) );
      out.write("</td>\n          </tr>\n          ");
} 
      out.write("\n        </table>\n        </div>\n      </div>\n  </div>\n</div>\n<script src=\"/static/js/jquery.min.js\" type=\"text/javascript\"></script>\n<script src=\"/static/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n\n</body>\n</html>\n");
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
