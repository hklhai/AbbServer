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
				 org.eclipse.birt.report.context.BaseAttributeBean,
				 org.eclipse.birt.report.resource.BirtResources" %>

<%-----------------------------------------------------------------------------
	Expected java beans
-----------------------------------------------------------------------------%>
<jsp:useBean id="fragment" type="org.eclipse.birt.report.presentation.aggregation.IFragment" scope="request" />
<jsp:useBean id="attributeBean" type="org.eclipse.birt.report.context.BaseAttributeBean" scope="request" />

<%-----------------------------------------------------------------------------
	Navigation bar fragment
-----------------------------------------------------------------------------%>
<TR 
	<%	
		String imagesPath = "birt/images/";
	
		if( attributeBean.isShowNavigationbar( ) )
		{
	%>
		HEIGHT="25px"
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
	<TD>
		<DIV id="navigationBar">
			<TABLE CELLSPACING="0" CELLPADDING="0" WIDTH="100%" HEIGHT="25px" CLASS="birtviewer_navbar">
				<TR><TD></TD></TR>
				<TR>
					<TD WIDTH="6px">&nbsp;</TD>
					<TD WIDTH="100%" NOWRAP>
						<B>
						<%
							if ( attributeBean.getBookmark( ) != null )
							{
						%>
							<%= 
								BirtResources.getMessage( "birt.viewer.navbar.prompt.one" )
							%>&nbsp;
							<SPAN ID='pageNumber'></SPAN>&nbsp;
							<%= BirtResources.getMessage( "birt.viewer.navbar.prompt.two" )%>&nbsp;
							<SPAN ID='totalPage'></SPAN>
						<%
							}
							else
							{
						%>
							<%= BirtResources.getMessage( "birt.viewer.navbar.prompt.one" )%>&nbsp;
							<SPAN ID='pageNumber'><%= ""+attributeBean.getReportPage( ) %></SPAN>&nbsp;
							<%= BirtResources.getMessage( "birt.viewer.navbar.prompt.two" )%>&nbsp;
							<SPAN ID='totalPage'></SPAN>
						<%
							}
						%>
						</B>
					</TD>
					<TD WIDTH="15px">
						<INPUT TYPE="button" CLASS="<%= (attributeBean.isRtl()?"LastPage":"icon-double-angle-left") + "_disabled" %> birtviewer_clickable pagebg" NAME='first'
							ALT="<%= BirtResources.getHtmlMessage( "birt.viewer.navbar.first" )%>" 
							TITLE="<%= BirtResources.getHtmlMessage( "birt.viewer.navbar.first" )%>">
					</TD>
					<TD WIDTH="2px">&nbsp;</TD>
					<TD WIDTH="15px">
						<INPUT TYPE="button" CLASS="<%= (attributeBean.isRtl()?"NextPage":"icon-angle-left") + "_disabled" %> birtviewer_clickable pagebg" NAME='previous' 
							ALT="<%= BirtResources.getHtmlMessage( "birt.viewer.navbar.previous" )%>" 
							TITLE="<%= BirtResources.getHtmlMessage( "birt.viewer.navbar.previous" )%>">
					</TD>
					<TD WIDTH="2px">&nbsp;</TD>
					<TD WIDTH="15px">
						<INPUT TYPE="button" CLASS="<%= (attributeBean.isRtl()?"PreviousPage":"icon-angle-right") + "_disabled" %> birtviewer_clickable pagebg" NAME='next'
						    ALT="<%= BirtResources.getHtmlMessage( "birt.viewer.navbar.next" )%>" 
							TITLE="<%= BirtResources.getHtmlMessage( "birt.viewer.navbar.next" )%>">
					</TD>
					<TD WIDTH="2px">&nbsp;</TD>
					<TD WIDTH="15px">
						<INPUT TYPE="button" CLASS="<%= (attributeBean.isRtl()?"FirstPage":"icon-double-angle-right") + "_disabled" %> birtviewer_clickable pagebg" NAME='last'
						    ALT="<%= BirtResources.getHtmlMessage( "birt.viewer.navbar.last" )%>"
							TITLE="<%= BirtResources.getHtmlMessage( "birt.viewer.navbar.last" )%>">
					</TD>
					
					<TD WIDTH="8px">&nbsp;&nbsp;</TD>
					
					<TD ALIGN="right" NOWRAP><LABEL for="gotoPage"><b><%= BirtResources.getMessage( "birt.viewer.navbar.lable.goto" )%></b></LABEL></TD>
					<TD WIDTH="2px">&nbsp;</TD>
					<TD ALIGN="right" WIDTH="50px">
						<INPUT ID='gotoPage' TYPE='text' VALUE='' MAXLENGTH="8" SIZE='5' CLASS="birtviewer_navbar_input">
					</TD>
					<TD WIDTH="4px">&nbsp;</TD>
					<TD ALIGN="right" WIDTH="10px" class="colourful">
						<INPUT TYPE="submit" NAME='goto' VALUE='Go' ALT="<%= BirtResources.getHtmlMessage( "birt.viewer.navbar.goto" )%>" TITLE="<%= BirtResources.getHtmlMessage( "birt.viewer.navbar.goto" )%>" CLASS="btn btn-primary">
					</TD>
					<TD WIDTH="6px">&nbsp;</TD>
				</TR>
			</TABLE>
		</DIV>
	</TD>
</TR>
