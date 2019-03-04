<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>
<div class="right">
     <div class="location">
         <strong>你现在所在的位置是:</strong>
         <span>订单管理页面 >> 信息查看</span>
     </div>
     <div class="providerView">
     <c:forEach var="obj" items="${bbbb }" >
         <p><strong>订单编号：</strong><span>${obj.billCode }</span></p>
         <p><strong>商品名称：</strong><span>${obj.productName }</span></p>
         <p><strong>商品单位：</strong><span>${obj.productUnit }</span></p>
         <p><strong>商品数量：</strong><span>${obj.productCount }</span></p>
         <p><strong>总金额：</strong><span>${obj.totalPrice }</span></p>
         <p><strong>供应商：</strong><span>${obj.provider.proName }</span></p>
         <p><strong>是否付款：</strong>
         	<span>
         		<c:if test="${obj.isPayment == 1}">未付款</c:if>
				<c:if test="${obj.isPayment == 2}">已付款</c:if>
			</span>
		</p>
		<div class="providerAddBtn">
         	<input type="button" id="back" name="back" value="返回" >
        </div>
        </c:forEach>
     </div>
 </div>
</section>
<%@include file="common/foot.jsp" %>
