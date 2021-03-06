package com.litle.sdk.samples;
import com.litle.sdk.*;
import com.litle.sdk.generate.*;
 
public class SaleWithTokenExample {
    public static void main(String[] args) {
        Sale sale = new Sale();
        sale.setOrderId("1");
        sale.setAmount(10010L);
        sale.setOrderSource(OrderSourceType.ECOMMERCE);
        CardTokenType token = new CardTokenType();
        token.setCardValidationNum("349");
        token.setExpDate("1214");
        token.setLitleToken("1111222233334000");
        token.setType(MethodOfPaymentTypeEnum.VI);
	sale.setToken(token);
 
        SaleResponse response = new LitleOnline().sale(sale);
        //Display Results
        System.out.println("Response: " + response.getResponse());
        System.out.println("Message: " + response.getMessage());
        System.out.println("Litle Transaction ID: " + response.getLitleTxnId());
        if(!response.getMessage().equals("Approved"))
        throw new RuntimeException(" The SaleWithTokenExample does not give the right response");
    }
}
