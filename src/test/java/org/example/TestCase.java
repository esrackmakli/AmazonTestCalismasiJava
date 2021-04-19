package org.example;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCase extends BaseTest {

    @Test
    public void step1_load_website() { 
        mainPage.load_main_page();
    }

    @Test
    public void step2_load_login_page() {
        mainPage.load_login_page();
    }

    @Test
    public void step3_login_to_site() {
        loginPage.login(email, password);
    }

    @Test
    public void step4_search_samsung() {
        mainPage.search_the_word();
    }

    @Test
    public void step5_load_second_search_page() { 
        searchPage.load_second_page();
    }

    @Test
    public void step6_click_second_product() {
        searchPage.load_second_product();
    }

    @Test
    public void step7_add_to_product_wishlist() {
        productPage.add_to_product_wishlist();
    }

    @Test
    public void step8_go_to_wishlist() {
        productPage.load_wishlist_page();
    }

    @Test
    public void step9_delete_product() {
        wishlistPage.delete_product_wishlist();
    }
}
