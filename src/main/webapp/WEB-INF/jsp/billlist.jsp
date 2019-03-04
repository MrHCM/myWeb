<%@page import="myWeb.qn215.entity.Bill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>
<style type="text/css">
.part_page{
    width: 60%;
    margin: 0 auto;
    margin-top: 20px;
    text-align: center;
    font-size: 12px;
}
.part_page a{
    text-decoration: none;
    color: #333;
    padding-top: 2px;
    padding-bottom: 3px;
    padding-left: 5px;
    padding-right: 5px;
    display: inline-block;
    border:1px solid #cccccc;
    margin-right: 8px;
}
</style>
<div class="right">
       <div class="location">
           <strong>你现在所在的位置是:</strong>
           <span>订单管理页面</span>
       </div>
       <form method="get"  action="${pageContext.request.contextPath }/Orde/cx">
       <div class="search">
       
			<input name="method" value="query" class="input-text" type="hidden">
			<input name="pags" value="1" class="input-text" type="hidden">
			<span>商品名称：</span>
			<input name="queryProductName" type="text" value="${queryProductName }">
			 
			<span>供应商：</span>
			<select name="queryProviderId">
				<c:if test="${providerList != null }">
				   <option value="0">--请选择--</option>
				   <c:forEach var="provider" items="${providerList}">
				   		<option <c:if test="${provider.id == queryProviderId }">selected="selected"</c:if>
				   		value="${provider.id}">${provider.proName}</option>
				   </c:forEach>
				</c:if>
       		</select>
			 
			<span>是否付款：</span>
			<select name="queryIsPayment">
				<option value="0">--请选择--</option>
				<option value="1" ${queryIsPayment == 1 ? "selected=\"selected\"":"" }>未付款</option>
				<option value="2" ${queryIsPayment == 2 ? "selected=\"selected\"":"" }>已付款</option>
       		</select>

			 <input	value="查 询" type="submit" id="searchbutton">
			 <a href="${pageContext.request.contextPath }/Orde/add">添加订单</a>
			  </div>
			 
			 <div class="part_page">
      <c:if test="${requestScope.pag != 1}">
      <a href="${pageContext.request.contextPath }/Orde/cx?pags=1">首页</a>
      <a href="${pageContext.request.contextPath }/Orde/cx?pags=${requestScope.pag-1}" class="page_none">上一页</a>
      </c:if>
      <a href="#" class="page_active">1</a>
      <a href="#">2</a>
      <a href="#">3</a>
      <a href="#">4</a>
      <a href="#">5</a>
      <a href="#">6</a>
      <a href="#">...</a>
      <c:if test="${requestScope.pag != 3}">
      <a href="${pageContext.request.contextPath }/Orde/cx?pags=${requestScope.pag+1}" class="page_none">下一页</a>
      <a href="#">尾页</a>
      </c:if>
      
      </div>
	</form>
      
       <!--账单表格 样式和供应商公用-->
      <form id="billForm">
      <table class="providerTable" cellpadding="0" cellspacing="0">
          <tr class="firstTr">
              <th width="10%">订单编码</th>
              <th width="20%">商品名称</th>
              <th width="10%">供应商</th>
              <th width="10%">订单金额</th>
              <th width="10%">是否付款</th>
              <th width="10%">创建时间</th>
              <th width="30%">操作</th>
          </tr>
          <c:forEach var="bill" items="${billList }" varStatus="status">
				<tr>
					<td>
					
					<span>${bill.billCode }</span>
					</td>
					<td>
					<span>${bill.productName }</span>
					</td>
					<td>
					<span>${bill.provider.proName}</span>
					</td>
					<td>
					<span>${bill.totalPrice}</span>
					</td>
					<td>
					<span>
						<c:if test="${bill.isPayment == 1}">未付款</c:if>
						<c:if test="${bill.isPayment == 2}">已付款</c:if>
					</span>
					</td>
					<td>
					<span>
					<fmt:formatDate value="${bill.creationDate}" pattern="yyyy-MM-dd"/>
					</span>
					</td>
					<td>
					<span><a  href="${pageContext.request.contextPath }/Orde/view?id=${bill.id}" ><img src="${pageContext.request.contextPath }/static/images/read.png" alt="查看" title="查看"/></a></span>
					<span><a class="modifyBill" href="javascript:;" billid=${bill.id } billcc=${bill.billCode }><img src="${pageContext.request.contextPath }/static/images/xiugai.png" alt="修改" title="修改"/></a></span>
					<span><a class="deleteBill" href="javascript:;" billid=${bill.id } billcc=${bill.billCode }><img src="${pageContext.request.contextPath }/static/images/schu.png" alt="删除" title="删除"/></a></span>
					</td>
				</tr>
				
			</c:forEach>
      </table>

      </form>
       
  </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/billlist.js"></script>