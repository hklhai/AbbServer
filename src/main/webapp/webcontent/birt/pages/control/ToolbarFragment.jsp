<%-----------------------------------------------------------------------------
	Copyright (c) 2004 Actuate Corporation and others.
	All rights reserved. This program and the accompanying materials 
	are made available under the terms of the Eclipse Public License v1.0
	which accompanies this distribution, and is available at
	http://www.eclipse.org/legal/epl-v10.html
	
	Contributors:
		Actuate Corporation - Initial implementation.
-----------------------------------------------------------------------------%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page session="false" buffer="none" %>
<%@ page import="org.eclipse.birt.report.presentation.aggregation.IFragment,
				 org.eclipse.birt.report.resource.BirtResources,
				 org.eclipse.birt.report.utility.ParameterAccessor,
				 org.eclipse.birt.report.servlet.ViewerServlet" %>

<%-----------------------------------------------------------------------------
	Expected java beans
-----------------------------------------------------------------------------%>
<jsp:useBean id="fragment" type="org.eclipse.birt.report.presentation.aggregation.IFragment" scope="request" />
<jsp:useBean id="attributeBean" type="org.eclipse.birt.report.context.BaseAttributeBean" scope="request" />

<%-----------------------------------------------------------------------------
	Toolbar fragment
-----------------------------------------------------------------------------%>
<TR 
	<%
		if( attributeBean.isShowToolbar( ) )
		{
	%>
		HEIGHT="20px"
	<%
		}
		else
		{
	%>
		style="display:none"
	<%
		}
	%>	
>
	<TD COLSPAN='2'>
		<DIV ID="toolbar">
			<TABLE CELLSPACING="1px" CELLPADDING="1px" CLASS="birtviewer_toolbar">
				<TR><TD></TD></TR>
				<TR>
					<TD WIDTH="45">
					   <INPUT TYPE="button" NAME='toc' value="目录" TITLE="<%= BirtResources.getHtmlMessage( "birt.viewer.toolbar.toc" )%>" ALT="<%= BirtResources.getHtmlMessage( "birt.viewer.toolbar.toc" )%>" CLASS="icon-operate-list">
					</TD>
					<%--<TD WIDTH="45">
					   <INPUT TYPE="button" NAME='parameter' value="参数" TITLE="<%= BirtResources.getHtmlMessage( "birt.viewer.toolbar.parameter" )%>" ALT="<%= BirtResources.getHtmlMessage( "birt.viewer.toolbar.parameter" )%>" CLASS="icon-operate-parameters">
					</TD>--%>
					<TD WIDTH="45">
					   <INPUT TYPE="button" NAME='export' value="导出" TITLE="<%= BirtResources.getHtmlMessage( "birt.viewer.toolbar.export" )%>" ALT="<%= BirtResources.getHtmlMessage( "birt.viewer.toolbar.export" )%>" CLASS="icon-operate-export">
					</TD>
					<TD WIDTH="70">
					   <INPUT TYPE="button" NAME='exportReport' value="导出报表" TITLE="<%= BirtResources.getHtmlMessage( "birt.viewer.toolbar.exportreport" )%>" ALT="<%= BirtResources.getHtmlMessage( "birt.viewer.toolbar.exportreport" )%>" CLASS="icon-operate-exportreport">
					</TD>
					<TD WIDTH="45">
					   <INPUT TYPE="button" NAME='print' value="打印" TITLE="<%= BirtResources.getHtmlMessage( "birt.viewer.toolbar.print" )%>" ALT="<%= BirtResources.getHtmlMessage( "birt.viewer.toolbar.print" )%>" CLASS="icon-operate-print">
					</TD>
					<%
					if( ParameterAccessor.isSupportedPrintOnServer )
					{
					%>					
					<%--<TD WIDTH="105">
					   <INPUT TYPE="button" NAME='printServer' value="打印服务器报表" TITLE="<%= BirtResources.getHtmlMessage( "birt.viewer.toolbar.printserver" )%>" ALT="<%= BirtResources.getHtmlMessage( "birt.viewer.toolbar.printserver" )%>" CLASS="icon-operate-printserver">
					</TD>--%>
					<%
					}
					%>										
				</TR>
			</TABLE>
		</DIV>
	</TD>
</TR>
