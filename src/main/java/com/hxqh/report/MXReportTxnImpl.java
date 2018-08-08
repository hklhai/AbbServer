 package com.hxqh.report;

 import com.hxqh.report.logging.ReportLogger;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.util.ArrayList;


 public class MXReportTxnImpl implements MXReportTxn
 {
   private ArrayList statements = new ArrayList();
   private MXReportDataSourceImpl dataSource = null;
   private ReportLogger logger = null;
   private ReportLogger sqlLogger = null;

   public MXReportTxnImpl(MXReportDataSourceImpl dataSource)
   {
     this.dataSource = dataSource;

     MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
     this.logger = mxReportScriptContext.getReportScriptLogger();
     this.sqlLogger = mxReportScriptContext.getReportScriptSqlLogger();
   }

   public MXReportTxnStatement createStatement()
   {
     MXReportTxnStatementImpl statement = new MXReportTxnStatementImpl();
     this.statements.add(statement);

     return statement;
   }

   public void save()
   {
     Connection connection = null;
     try
     {
       int noOfStatements = this.statements.size();
       for (int i = 0; i < noOfStatements; i++)
       {
         MXReportTxnStatementImpl statement = (MXReportTxnStatementImpl)this.statements.get(i);

         String query = statement.getQuery();

         if (this.sqlLogger.isInfoEnabled())
         {
           this.sqlLogger.info("executing SQL: " + query);
         }

         connection = this.dataSource.getConnection();

         PreparedStatement pStatement = connection.prepareStatement(query);

         int currentIndex = 1;
         int noOfParameters = statement.getQueryParameterSize();
         for (int j = 0; j < noOfParameters; j++)
         {
           if (this.sqlLogger.isInfoEnabled())
           {
             this.sqlLogger.info("Txn Bind index [" + currentIndex + "] = " + statement.getQueryParameterValue(currentIndex));
           }

           pStatement.setObject(currentIndex, statement.getQueryParameterValue(currentIndex));
           currentIndex++;
         }

         pStatement.executeUpdate();
         pStatement.close();
       }

       connection.commit();
       if (this.sqlLogger.isInfoEnabled())
       {
         this.sqlLogger.info("Txn commit called.");
       }
     }
     catch (Throwable t)
     {
       try
       {
         if (connection != null)
         {
           connection.rollback();
         }
         if (this.sqlLogger.isInfoEnabled())
         {
           this.sqlLogger.info("Txn rollback called.");
         }
       } catch (Throwable t1) {
       }
       if (this.logger.isErrorEnabled())
       {
         this.logger.error("failed to save transaction.", t);
       }

       MXReportScriptContext mxReportScriptContext = MXReportScriptContext.get();
       mxReportScriptContext.markReportFailed();
       throw new MXReportRuntimeException(t);
     }
   }
 }


