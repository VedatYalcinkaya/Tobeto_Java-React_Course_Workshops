package org.example;

public class Main {
    public static void main(String[] args) {
        String message = "Vade oranı";

        Product product1 = new Product();
//        product1.name = "Anker Soundcore Life Q10 Kulaklık";
        product1.setName("Anker Soundcore Life Q10 Kulaklık");
//        product1.unitPrice = 1500;
        product1.setUnitPrice(1500);
//        product1.discount = 7;
        product1.setDiscount(7);
//        product1.unitsInStock = 5;
        product1.setUnitsInStock(5);
//        product1.imageUrl = "image1.jpg";
        product1.setImageUrl("image1.jpg");


        Product product2 = new Product();
        product2.setName("JBL T560BT Kulaklık");
        product2.setUnitPrice(1450);
        product2.setDiscount(8);
        product2.setUnitsInStock(4);
        product2.setImageUrl("image2.jpg");

        Product product3 = new Product();
        product3.setName("Philips Tah4205 Kulaklık");
        product3.setUnitPrice(1280);
        product3.setDiscount(9);
        product3.setUnitsInStock(2);
        product3.setImageUrl("image3.jpg");

        Product[] products = new Product[]{product1, product2, product3};

        System.out.println("<ul>");
        for(Product product : products){
            System.out.println("<li>" + product.getName() + "</li>");
        }
        System.out.println("</ul>");

        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setId(1);
        individualCustomer.setPhone("05222222222");
        individualCustomer.setCustomerNumber("12345");
        individualCustomer.setFirstName("Vedat");
        individualCustomer.setLastName("Yalçınkaya");

        CorporateCustomer corporateCustomer = new CorporateCustomer();
        corporateCustomer.setId(2);
        corporateCustomer.setCompanyName("Tobeto");
        corporateCustomer.setPhone("05333333333");
        corporateCustomer.setTaxNumber("11111111111");
        corporateCustomer.setCustomerNumber("54321");

        Customer[] customers = new Customer[]{individualCustomer,corporateCustomer};
    }
}
