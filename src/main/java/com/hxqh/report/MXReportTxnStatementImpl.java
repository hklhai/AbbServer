 package com.hxqh.report;
 
 import java.util.TreeMap;

 public class MXReportTxnStatementImpl
   implements MXReportTxnStatement
 {
   private String query = null;
   private TreeMap<Integer, Object> queryParametersMap = new TreeMap();
 
   public String getQuery()
   {
     return this.query;
   }
 
   public void setQuery(String query)
   {
     this.query = query;
   }
 
   public Object getQueryParameterValue(int index)
   {
     if (this.queryParametersMap == null)
     {
       return null;
     }
 
     return this.queryParametersMap.get(new Integer(index));
   }
 
   public void setQueryParameterValue(int index, Object value)
   {
     if (this.queryParametersMap == null)
     {
       this.queryParametersMap = new TreeMap();
     }
 
     this.queryParametersMap.put(new Integer(index), value);
   }
 
   public int getQueryParameterSize()
   {
     return this.queryParametersMap.size();
   }
 }

